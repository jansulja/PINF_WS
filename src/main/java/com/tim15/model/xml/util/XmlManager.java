package com.tim15.model.xml.util;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.tim15.model.AnalitikaIzvoda;
import com.tim15.model.DnevnoStanjeRacuna;
import com.tim15.model.Klijent;
import com.tim15.model.Kliring;
import com.tim15.model.Rtgs;
import com.tim15.model.StavkaKliringa;
import com.tim15.model.xml.izvod.Izvod;
import com.tim15.model.xml.izvod.StavkaIzvoda;
import com.tim15.model.xml.mt102.MT102;
import com.tim15.model.xml.mt102.ZaglavljeMT102;
import com.tim15.model.xml.mt103.MT103;

public class XmlManager {

	public static void generateMT102(Kliring kliring) {

		Set<StavkaKliringa> stavkeKliringa = kliring.getStavkaKliringa();
		List<MT102> listaMT102 = new ArrayList<MT102>();

		for (StavkaKliringa stavka : stavkeKliringa) {

			MT102 mt102 = findMT102(stavka, listaMT102);

			if (mt102 == null) {

				ZaglavljeMT102 zaglavljeMT102 = new ZaglavljeMT102();
				zaglavljeMT102.setIdKliringa(kliring.getKliringId());
				zaglavljeMT102.setDatumKliringa(timeStampToXmlGrgorianCalendar(kliring.getDatumKliringa()));
				zaglavljeMT102.setDatumValute(dateToXmlGrgorianCalendar(stavka.getDatumValute()));
				zaglavljeMT102.setRacunBankeDuznika(stavka.getRacunBankeDuznika());
				zaglavljeMT102.setRacunBankePoverioca(stavka.getRacunBankePoverioca());
				zaglavljeMT102.setSifraValute(stavka.getSifraValute());
				zaglavljeMT102.setSwiftKodBankeDuznika(stavka.getSwiftBankeDuznika());
				zaglavljeMT102.setSwiftKodBankePrimaoca(stavka.getSwiftBankePoverioca());
				zaglavljeMT102.setUkupanIznos(BigDecimal.valueOf(stavka.getUkupanIznos()));

				AnalitikaIzvoda analitikaIzvoda = stavka.getAnalitikaIzvoda();

				com.tim15.model.xml.mt102.StavkaKliringa stavkaKliringaMT102 = new com.tim15.model.xml.mt102.StavkaKliringa();
				stavkaKliringaMT102.setDatumPrijema(dateToXmlGrgorianCalendar(analitikaIzvoda.getDatumPrijema()));
				stavkaKliringaMT102.setDuznik(analitikaIzvoda.getDuznikNalogodavac());
				stavkaKliringaMT102.setIdStavke(String.valueOf(stavka.getStavkaKliringaId()));
				stavkaKliringaMT102.setIznos(BigDecimal.valueOf(analitikaIzvoda.getIznos()));
				stavkaKliringaMT102.setModelOdobrenja(BigInteger.valueOf(analitikaIzvoda.getModelOdobrenja()));
				stavkaKliringaMT102.setModelZaduzenja(BigInteger.valueOf(analitikaIzvoda.getModelZaduzenja()));
				stavkaKliringaMT102.setPozivNaBrojOdobrenja(analitikaIzvoda.getPozivNaBrojOdobrenja());
				stavkaKliringaMT102.setPozivNaBrojZaduzenja(analitikaIzvoda.getPozivNaProjZaduzenja());
				stavkaKliringaMT102.setPrimalac(analitikaIzvoda.getPoverilacPrimalac());
				stavkaKliringaMT102.setRacunDuznika(analitikaIzvoda.getRacunDuznika());
				stavkaKliringaMT102.setRacunPrimaoca(analitikaIzvoda.getRacunPoverioca());
				stavkaKliringaMT102.setSifraValute(stavka.getSifraValute());
				stavkaKliringaMT102.setSvrhaPlacanja(analitikaIzvoda.getSvrhaPlacanja());

				mt102 = new MT102();
				mt102.setZaglavljeKliringa(zaglavljeMT102);
				mt102.getStavkeKliringa().add(stavkaKliringaMT102);
			} else {

				AnalitikaIzvoda analitikaIzvoda = stavka.getAnalitikaIzvoda();

				com.tim15.model.xml.mt102.StavkaKliringa stavkaKliringaMT102 = new com.tim15.model.xml.mt102.StavkaKliringa();
				stavkaKliringaMT102.setDatumPrijema(dateToXmlGrgorianCalendar(analitikaIzvoda.getDatumPrijema()));
				stavkaKliringaMT102.setDuznik(analitikaIzvoda.getDuznikNalogodavac());
				stavkaKliringaMT102.setIdStavke(String.valueOf(stavka.getStavkaKliringaId()));
				stavkaKliringaMT102.setIznos(BigDecimal.valueOf(analitikaIzvoda.getIznos()));
				stavkaKliringaMT102.setModelOdobrenja(BigInteger.valueOf(analitikaIzvoda.getModelOdobrenja()));
				stavkaKliringaMT102.setModelZaduzenja(BigInteger.valueOf(analitikaIzvoda.getModelZaduzenja()));
				stavkaKliringaMT102.setPozivNaBrojOdobrenja(analitikaIzvoda.getPozivNaBrojOdobrenja());
				stavkaKliringaMT102.setPozivNaBrojZaduzenja(analitikaIzvoda.getPozivNaProjZaduzenja());
				stavkaKliringaMT102.setPrimalac(analitikaIzvoda.getPoverilacPrimalac());
				stavkaKliringaMT102.setRacunDuznika(analitikaIzvoda.getRacunDuznika());
				stavkaKliringaMT102.setRacunPrimaoca(analitikaIzvoda.getRacunPoverioca());
				stavkaKliringaMT102.setSifraValute(stavka.getSifraValute());
				stavkaKliringaMT102.setSvrhaPlacanja(analitikaIzvoda.getSvrhaPlacanja());

				double ukupno = mt102.getZaglavljeKliringa().getUkupanIznos().doubleValue()
						+ analitikaIzvoda.getIznos();

				mt102.getZaglavljeKliringa().setUkupanIznos(BigDecimal.valueOf(ukupno));
				mt102.getStavkeKliringa().add(stavkaKliringaMT102);
			}

			listaMT102.add(mt102);
		}

		for (MT102 mt102 : listaMT102) {

			// objectToXmlFile(mt102,"MT102_"+mt102.getZaglavljeKliringa().getDatumKliringa().toString().split("T")[0]);
			objectToXmlFile(mt102,
					"MT102_" + mt102.getZaglavljeKliringa().getSwiftKodBankePrimaoca() + "_" + getFormatedDateTimeForKliring(mt102.getZaglavljeKliringa().getDatumKliringa()));

		}

	}


	public static void generateMT103(Rtgs rtgs,AnalitikaIzvoda analitikaIzvoda){

		MT103 mt103 = new MT103();
		mt103.setDatumNaloga(dateToXmlGrgorianCalendar(analitikaIzvoda.getDatumPrijema()));
		mt103.setDatumValute(dateToXmlGrgorianCalendar(analitikaIzvoda.getDatumValute()));
		mt103.setDuznik(analitikaIzvoda.getDuznikNalogodavac());
		mt103.setIdPoruke(String.valueOf(rtgs.getRtgsId()));
		mt103.setIznos(BigDecimal.valueOf(analitikaIzvoda.getIznos()));
		mt103.setModelOdobrenja(BigInteger.valueOf(analitikaIzvoda.getModelOdobrenja()));
		mt103.setModelZaduzenja(BigInteger.valueOf(analitikaIzvoda.getModelZaduzenja()));
		mt103.setPozivNaBrojOdobrenja(analitikaIzvoda.getPozivNaBrojOdobrenja());
		mt103.setPozivNaBrojZaduzenja(analitikaIzvoda.getPozivNaProjZaduzenja());
		mt103.setPrimalac(analitikaIzvoda.getPoverilacPrimalac());
		mt103.setRacunBankeDuznika(rtgs.getRacunBankeDuznika());
		mt103.setRacunBankePoverioca(rtgs.getRacunBankePoverioca());
		mt103.setRacunDuznika(analitikaIzvoda.getRacunDuznika());
		mt103.setRacunPrimaoca(analitikaIzvoda.getRacunPoverioca());
		mt103.setSifraValute(analitikaIzvoda.getValuta().getZvanicnaSifra());
		mt103.setSvrhaPlacanja(analitikaIzvoda.getSvrhaPlacanja());
		mt103.setSwiftKodBankeDuznika(rtgs.getSwiftBankeDuznika());
		mt103.setSwiftKodBankePrimaoca(rtgs.getSwiftBankePoverioca());


		objectToXmlFile(mt103, "MT103_" + getFormatedDateTimeNow() );

	}


	public static void generateIzvod(String brojRacuna, Klijent klijent,DnevnoStanjeRacuna dnevnoStanjeRacuna){

		Izvod izvod = new Izvod();
		izvod.setBrojRacuna(brojRacuna);
		izvod.setDatumPrometa(dateToXmlGrgorianCalendar(new java.util.Date()));
		izvod.setKlijentId(String.valueOf(klijent.getKlijentId()));
		izvod.setNovoStanje(BigDecimal.valueOf(dnevnoStanjeRacuna.getNovoStanje()));
		izvod.setPrethodnoStanje(BigDecimal.valueOf(dnevnoStanjeRacuna.getPrethodnoStanje()));
		izvod.setPrometNaTeret(BigDecimal.valueOf(dnevnoStanjeRacuna.getPrometNaTeret()));
		izvod.setPrometUkorist(BigDecimal.valueOf(dnevnoStanjeRacuna.getPrometUKorist()));

		
		for(AnalitikaIzvoda analitikaIzvoda : dnevnoStanjeRacuna.getAnalitikaIzvoda()){
			
			StavkaIzvoda stavkaIzvoda = new StavkaIzvoda();
			stavkaIzvoda.setDatumPrijema(dateToXmlGrgorianCalendar( analitikaIzvoda.getDatumPrijema()));
			stavkaIzvoda.setDatumValute(dateToXmlGrgorianCalendar(analitikaIzvoda.getDatumValute()));
			stavkaIzvoda.setDuznik(analitikaIzvoda.getDuznikNalogodavac());
			stavkaIzvoda.setIznos(BigDecimal.valueOf( analitikaIzvoda.getIznos()));
			stavkaIzvoda.setModelOdobrenja(BigInteger.valueOf(analitikaIzvoda.getModelOdobrenja()));
			stavkaIzvoda.setModelZaduzenja(BigInteger.valueOf(analitikaIzvoda.getModelZaduzenja()));
			stavkaIzvoda.setPozivNaBrojOdobrenja(analitikaIzvoda.getPozivNaBrojOdobrenja());
			stavkaIzvoda.setPozivNaBrojZaduzenja(analitikaIzvoda.getPozivNaProjZaduzenja());
			stavkaIzvoda.setPrimalac(analitikaIzvoda.getPoverilacPrimalac());
			stavkaIzvoda.setRacunDuznika(analitikaIzvoda.getRacunDuznika());
			stavkaIzvoda.setRacunPrimaoca(analitikaIzvoda.getRacunPoverioca());
			stavkaIzvoda.setSifraValute(analitikaIzvoda.getValuta().getZvanicnaSifra());
			stavkaIzvoda.setSvrhaPlacanja(analitikaIzvoda.getSvrhaPlacanja());
		
			izvod.getStavka().add(stavkaIzvoda);
		}
		
		objectToXmlFile(izvod, "IZVOD_" + brojRacuna + getFormatedDateTimeNow());

	}


	private static String getFormatedDateTimeForKliring(XMLGregorianCalendar datumKliringa) {

		String formatedDate = datumKliringa.getDay() + "_" + datumKliringa.getMonth() + "_" + datumKliringa.getYear()
				+ "_" + datumKliringa.getHour() + "_" + datumKliringa.getMinute();

		return formatedDate;
	}

	private static String getFormatedDateTimeNow() {
		java.util.Date date = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_HH_mm");
		return sdf.format(date);
	}

	private static MT102 findMT102(StavkaKliringa stavka, List<MT102> listaMT102) {
		MT102 mt102ret = null;

		for (MT102 mt102 : listaMT102) {

			if (mt102.getZaglavljeKliringa().getSwiftKodBankePrimaoca().equals(stavka.getSwiftBankePoverioca())) {

				mt102ret = mt102;
				break;

			}

		}

		return mt102ret;

	}

	private static XMLGregorianCalendar dateToXmlGrgorianCalendar(Date datumKliringa) {
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(datumKliringa);
		XMLGregorianCalendar date2 = null;
		try {
			date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return date2;
	}
	private static XMLGregorianCalendar dateToXmlGrgorianCalendar(java.util.Date datum) {
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(datum);
		XMLGregorianCalendar date2 = null;
		try {
			date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return date2;
	}

	private static XMLGregorianCalendar timeStampToXmlGrgorianCalendar(Timestamp datumKliringa) {
		GregorianCalendar c = new GregorianCalendar();

		c.setTimeInMillis(datumKliringa.getTime());

		XMLGregorianCalendar date2 = null;
		try {
			date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return date2;
	}

	public static void objectToXmlFile(Object object, String fileName) {

		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(object.getClass());
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			File xmlFile = new File(System.getProperty("user.home") + "/Desktop/" + fileName + ".xml");

			jaxbMarshaller.marshal(object, xmlFile);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args){

		System.out.println(XmlManager.getFormatedDateTimeNow());

	}

}
