package com.tim15.obrade.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;

import org.apache.log4j.Logger;

import com.tim15.model.AnalitikaIzvoda;
import com.tim15.model.Banka;
import com.tim15.model.DnevnoStanjeRacuna;
import com.tim15.model.Kliring;
import com.tim15.model.NaseljenoMesto;
import com.tim15.model.Racuni;
import com.tim15.model.Rtgs;
import com.tim15.model.StavkaKliringa;
import com.tim15.model.Valuta;
import com.tim15.model.VrstePlacanja;
import com.tim15.model.obrade.Nalog;
import com.tim15.model.xml.util.XmlManager;
import com.tim15.sessionbeans.AnalitikaIzvodaDaoLocal;
import com.tim15.sessionbeans.BankaDaoLocal;
import com.tim15.sessionbeans.DnevnoStanjeRacunaDaoLocal;
import com.tim15.sessionbeans.KliringDaoLocal;
import com.tim15.sessionbeans.NaseljenoMestoDaoLocal;
import com.tim15.sessionbeans.RacuniDaoLocal;
import com.tim15.sessionbeans.RtgsDaoLocal;
import com.tim15.sessionbeans.StavkaKliringaDaoLocal;
import com.tim15.sessionbeans.ValutaDaoLocal;
import com.tim15.sessionbeans.VrstePlacanjaDaoLocal;

@Path("/nalog")
public class NalogService {

	private static Logger log = Logger.getLogger(NalogService.class);

	@EJB
	private DnevnoStanjeRacunaDaoLocal dnevnoStanjeRacunaDao;

	@EJB
	private RacuniDaoLocal racuniDao;

	@EJB
	private ValutaDaoLocal valutaDao;

	@EJB
	private BankaDaoLocal bankaDao;

	@EJB
	private KliringDaoLocal kliringDao;

	@EJB
	private RtgsDaoLocal rtgsDao;

	@EJB
	private StavkaKliringaDaoLocal stavkaKliringaDao;

	@EJB
	private NaseljenoMestoDaoLocal naseljenoMestoDao;

	@EJB
	private VrstePlacanjaDaoLocal vrstePlacanjaDao;

	@EJB
	private AnalitikaIzvodaDaoLocal analitikaIzvodaDao;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(Nalog entity) {
		Response response = null;


		XmlManager.objectToXmlFile(entity, "NALOG_" + XmlManager.getFormatedDateTimeNow());

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date now = null;
		try {
			now = sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date sqlNow = new java.sql.Date(now.getTime());

		List<DnevnoStanjeRacuna> lista = dnevnoStanjeRacunaDao
				.findBy("select distinct dsr from DnevnoStanjeRacuna dsr where dsr.racuni.brojRacuna = '"
						+ entity.getRacunDuznika() + "' and dsr.datumPrometa = '" + new java.sql.Date(now.getTime())
						+ "'");

		Racuni racunDuznika = racuniDao.findByNumber(entity.getRacunDuznika());
		DnevnoStanjeRacuna poslednjeDnevnoStanje = null;
		DnevnoStanjeRacuna dnevnoStanjeRacuna = null;
		AnalitikaIzvoda analitikaIzvoda = null;
		// nema danas
		if (lista.isEmpty()) {
			poslednjeDnevnoStanje = dnevnoStanjeRacunaDao.getPoslednjeStanje(entity.getRacunDuznika());

			// postoji nesto od pre
			if (poslednjeDnevnoStanje != null) {

				dnevnoStanjeRacuna = new DnevnoStanjeRacuna(new java.sql.Date(now.getTime()),
						poslednjeDnevnoStanje.getNovoStanje(), 0, entity.getIznos().doubleValue(),
						poslednjeDnevnoStanje.getNovoStanje() - entity.getIznos().doubleValue(), racunDuznika, null);

				analitikaIzvoda = nalogToAnalitikaIzvoda(entity, sqlNow, 1, "Uspesno", dnevnoStanjeRacuna);

				try {

					dnevnoStanjeRacunaDao.persist(dnevnoStanjeRacuna);
					analitikaIzvodaDao.persist(analitikaIzvoda);
				} catch (NoSuchFieldException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			// ima danas
		} else {
			poslednjeDnevnoStanje = lista.get(0);

			if (poslednjeDnevnoStanje.getNovoStanje() - entity.getIznos().doubleValue() >= 0) {

				double staro = poslednjeDnevnoStanje.getPrethodnoStanje();
				double novo = poslednjeDnevnoStanje.getNovoStanje();
				double teret = poslednjeDnevnoStanje.getPrometNaTeret();
				double korist = poslednjeDnevnoStanje.getPrometUKorist();

				double novoStaro = novo;
				double novoNovo = novo - entity.getIznos().doubleValue();
				double novoTeret = teret + entity.getIznos().doubleValue();
				double novoKorist = korist;

				poslednjeDnevnoStanje.setPrethodnoStanje(novoStaro);
				poslednjeDnevnoStanje.setNovoStanje(novoNovo);
				poslednjeDnevnoStanje.setPrometNaTeret(novoTeret);
				poslednjeDnevnoStanje.setPrometUKorist(novoKorist);

				analitikaIzvoda = nalogToAnalitikaIzvoda(entity, sqlNow, 1, "Uspesno", poslednjeDnevnoStanje);

				try {
					dnevnoStanjeRacunaDao.merge(poslednjeDnevnoStanje);
					analitikaIzvodaDao.persist(analitikaIzvoda);
				} catch (NoSuchFieldException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				log.info("nemate dovoljno para na racunu.");

			}

		}

		Racuni racunPrimaoca = racuniDao.findByNumber(entity.getRacunPrimaoca());
		if (racunPrimaoca == null) {
			log.info("nepostojeci racun primaoca");
		} else {

			// ista banka
			if (racunDuznika.getBanka().getBankaId() == racunPrimaoca.getBanka().getBankaId()) {

				lista = dnevnoStanjeRacunaDao
						.findBy("select distinct dsr from DnevnoStanjeRacuna dsr where dsr.racuni.brojRacuna = '"
								+ entity.getRacunPrimaoca() + "' and dsr.datumPrometa = '"
								+ new java.sql.Date(now.getTime()) + "'");
				// nema danas
				if (lista.isEmpty()) {
					poslednjeDnevnoStanje = dnevnoStanjeRacunaDao.getPoslednjeStanje(entity.getRacunPrimaoca());

					// postoji nesto od pre
					if (poslednjeDnevnoStanje != null) {

						dnevnoStanjeRacuna = new DnevnoStanjeRacuna(new java.sql.Date(now.getTime()),
								poslednjeDnevnoStanje.getNovoStanje(), entity.getIznos().doubleValue(), 0,
								poslednjeDnevnoStanje.getNovoStanje() + entity.getIznos().doubleValue(), racunPrimaoca,
								null);
					} else {
						dnevnoStanjeRacuna = new DnevnoStanjeRacuna(new java.sql.Date(now.getTime()), 0,
								entity.getIznos().doubleValue(), 0, entity.getIznos().doubleValue(), racunPrimaoca,
								null);

					}

					analitikaIzvoda = nalogToAnalitikaIzvoda(entity, sqlNow, 1, "Uspesno", dnevnoStanjeRacuna);

					try {
						dnevnoStanjeRacunaDao.persist(dnevnoStanjeRacuna);
						analitikaIzvodaDao.persist(analitikaIzvoda);
					} catch (NoSuchFieldException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					// ima danas
				} else {
					poslednjeDnevnoStanje = lista.get(0);

					double staro = poslednjeDnevnoStanje.getPrethodnoStanje();
					double novo = poslednjeDnevnoStanje.getNovoStanje();
					double teret = poslednjeDnevnoStanje.getPrometNaTeret();
					double korist = poslednjeDnevnoStanje.getPrometUKorist();

					double novoStaro = novo;
					double novoNovo = novo + entity.getIznos().doubleValue();
					double novoTeret = teret;
					double novoKorist = korist + entity.getIznos().doubleValue();

					poslednjeDnevnoStanje.setPrethodnoStanje(novoStaro);
					poslednjeDnevnoStanje.setNovoStanje(novoNovo);
					poslednjeDnevnoStanje.setPrometNaTeret(novoTeret);
					poslednjeDnevnoStanje.setPrometUKorist(novoKorist);

					analitikaIzvoda = nalogToAnalitikaIzvoda(entity, sqlNow, 1, "Uspesno", poslednjeDnevnoStanje);

					try {
						dnevnoStanjeRacunaDao.merge(poslednjeDnevnoStanje);
						analitikaIzvodaDao.persist(analitikaIzvoda);
					} catch (NoSuchFieldException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

				// nije ista banka
			} else {

				// --- RTGS ---
				if (entity.isHitno() || entity.getIznos().doubleValue() >= 300000.00) {

					Rtgs rtgs = null;

					lista = dnevnoStanjeRacunaDao
							.findBy("select distinct dsr from DnevnoStanjeRacuna dsr where dsr.racuni.brojRacuna = '"
									+ entity.getRacunPrimaoca() + "' and dsr.datumPrometa = '"
									+ new java.sql.Date(now.getTime()) + "'");
					// nema danas
					if (lista.isEmpty()) {
						poslednjeDnevnoStanje = dnevnoStanjeRacunaDao.getPoslednjeStanje(entity.getRacunPrimaoca());

						// postoji nesto od pre
						if (poslednjeDnevnoStanje != null) {

							dnevnoStanjeRacuna = new DnevnoStanjeRacuna(new java.sql.Date(now.getTime()),
									poslednjeDnevnoStanje.getPrethodnoStanje(), entity.getIznos().doubleValue(), 0,
									poslednjeDnevnoStanje.getNovoStanje(),
									racunPrimaoca, null);
						} else {
							dnevnoStanjeRacuna = new DnevnoStanjeRacuna(new java.sql.Date(now.getTime()), 0,
									0, 0, 0, racunPrimaoca,
									null);

						}

						analitikaIzvoda = nalogToAnalitikaIzvoda(entity, sqlNow, 1, "RTGS", dnevnoStanjeRacuna);
						rtgs = analitikaIzvodaToRtgs(analitikaIzvoda);



						try {
							dnevnoStanjeRacunaDao.persist(dnevnoStanjeRacuna);
							analitikaIzvodaDao.persist(analitikaIzvoda);
							rtgsDao.persist(rtgs);

							XmlManager.generateMT103(rtgs, analitikaIzvoda);

						} catch (NoSuchFieldException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						// ima danas
					} else {
						poslednjeDnevnoStanje = lista.get(0);
						analitikaIzvoda = nalogToAnalitikaIzvoda(entity, sqlNow, 1, "RTGS", poslednjeDnevnoStanje);
						rtgs = analitikaIzvodaToRtgs(analitikaIzvoda);
						try {

							analitikaIzvodaDao.persist(analitikaIzvoda);
							rtgsDao.persist(rtgs);

							XmlManager.generateMT103(rtgs, analitikaIzvoda);


						} catch (NoSuchFieldException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}








					// --- Kliring ---
				} else {

					Kliring kliring = kliringDao.getNext();
					StavkaKliringa stavkaKliringa = null;

					lista = dnevnoStanjeRacunaDao
							.findBy("select distinct dsr from DnevnoStanjeRacuna dsr where dsr.racuni.brojRacuna = '"
									+ entity.getRacunPrimaoca() + "' and dsr.datumPrometa = '"
									+ new java.sql.Date(now.getTime()) + "'");
					// nema danas
					if (lista.isEmpty()) {
						poslednjeDnevnoStanje = dnevnoStanjeRacunaDao.getPoslednjeStanje(entity.getRacunPrimaoca());

						// postoji nesto od pre
						if (poslednjeDnevnoStanje != null) {

							dnevnoStanjeRacuna = new DnevnoStanjeRacuna(new java.sql.Date(now.getTime()),
									poslednjeDnevnoStanje.getPrethodnoStanje(), entity.getIznos().doubleValue(), 0,
									poslednjeDnevnoStanje.getNovoStanje(),
									racunPrimaoca, null);
						} else {
							dnevnoStanjeRacuna = new DnevnoStanjeRacuna(new java.sql.Date(now.getTime()), 0,
									0, 0, 0, racunPrimaoca,
									null);

						}

						analitikaIzvoda = nalogToAnalitikaIzvoda(entity, sqlNow, 1, "Kliring", dnevnoStanjeRacuna);
						stavkaKliringa = analitikaIzvodaToStavkaKliringa(analitikaIzvoda, sqlNow, kliring);



						try {
							dnevnoStanjeRacunaDao.persist(dnevnoStanjeRacuna);
							analitikaIzvodaDao.persist(analitikaIzvoda);
							stavkaKliringaDao.persist(stavkaKliringa);
						} catch (NoSuchFieldException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						// ima danas
					} else {
						poslednjeDnevnoStanje = lista.get(0);
						analitikaIzvoda = nalogToAnalitikaIzvoda(entity, sqlNow, 1, "Kliring", poslednjeDnevnoStanje);
						stavkaKliringa = analitikaIzvodaToStavkaKliringa(analitikaIzvoda, sqlNow, kliring);
						try {

							analitikaIzvodaDao.persist(analitikaIzvoda);
							stavkaKliringaDao.persist(stavkaKliringa);
						} catch (NoSuchFieldException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}

				}

			}

		}

		return response;
	}

	@GET
	@Path("{filename}")
    @Produces(MediaType.APPLICATION_JSON)
    public Object importNalog(@PathParam("filename") String filename) {

		Nalog n = null;
		try {
			n = XmlManager.xmlFileToObject(Nalog.class, filename);
		} catch (JAXBException e) {

		}



		return n;

	}


	private Rtgs analitikaIzvodaToRtgs(AnalitikaIzvoda analitikaIzvoda) {
		Banka bankaDuznik = racuniDao.findByNumber(analitikaIzvoda.getRacunDuznika()).getBanka();
		Banka bankaPoverilac = racuniDao.findByNumber(analitikaIzvoda.getRacunPoverioca()).getBanka();

		Rtgs rtgs = new  Rtgs(0, bankaDuznik.getSwift(), bankaDuznik.getObracunskiRacun(), bankaPoverilac.getSwift(), bankaPoverilac.getObracunskiRacun(), analitikaIzvoda);

		return rtgs;
	}

	private StavkaKliringa analitikaIzvodaToStavkaKliringa(AnalitikaIzvoda analitikaIzvoda,java.sql.Date datumValute,Kliring kliring) {

		Banka bankaDuznik = racuniDao.findByNumber(analitikaIzvoda.getRacunDuznika()).getBanka();
		Banka bankaPoverilac = racuniDao.findByNumber(analitikaIzvoda.getRacunPoverioca()).getBanka();

		StavkaKliringa stavkaKliringa = new StavkaKliringa(0, bankaDuznik.getSwift(), bankaDuznik.getObracunskiRacun(), bankaPoverilac.getSwift(), bankaPoverilac.getObracunskiRacun(), analitikaIzvoda.getIznos(), analitikaIzvoda.getValuta().getZvanicnaSifra(), datumValute, analitikaIzvoda, kliring);

		return stavkaKliringa;

	}



	public AnalitikaIzvoda nalogToAnalitikaIzvoda(Nalog entity, java.sql.Date datumPrijema, int tipGreske,
			String status, DnevnoStanjeRacuna dnevnoStanjeRacuna) {

		Valuta valuta = valutaDao.findByZvanicnaSifra(entity.getOznakaValute());

		NaseljenoMesto naseljenoMesto = naseljenoMestoDao.findByNaziv(entity.getMestoPrijema());

		VrstePlacanja vrstePlacanja = vrstePlacanjaDao.findByOznaka(entity.getSifraPlacanja().intValue());

		AnalitikaIzvoda analitikaIzvoda = new AnalitikaIzvoda(0, entity.getDuznik(), entity.getSvrhaPlacanja(),
				entity.getPrimalac(), datumPrijema, datumPrijema, entity.getRacunDuznika(),
				entity.getModelZaduzenja().intValue(), entity.getPozivNaBrojZaduzenja(), entity.getRacunPrimaoca(),
				entity.getModelOdobrenja().intValue(), entity.getPozivNaBrojOdobrenja(), entity.isHitno(),
				entity.getIznos().doubleValue(), tipGreske, status, dnevnoStanjeRacuna, valuta, naseljenoMesto,
				vrstePlacanja);

		return analitikaIzvoda;
	}

}
