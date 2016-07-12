package com.tim15.model.xml.util;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;
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

import org.apache.openejb.loader.Files;

import com.tim15.model.AnalitikaIzvoda;
import com.tim15.model.Kliring;
import com.tim15.model.StavkaKliringa;
import com.tim15.model.xml.mt102.MT102;
import com.tim15.model.xml.mt102.ZaglavljeMT102;

public class XmlManager {


	public static void generateMT102(Kliring kliring){

		Set<StavkaKliringa> stavkeKliringa = kliring.getStavkaKliringa();
		List<MT102> listaMT102 = new ArrayList<MT102>();


		for(StavkaKliringa stavka : stavkeKliringa){

			MT102 mt102 = findMT102(stavka,listaMT102);

			if(mt102 == null){

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
				stavkaKliringaMT102.setIznos(BigDecimal.valueOf( analitikaIzvoda.getIznos()));
				stavkaKliringaMT102.setModelOdobrenja(BigInteger.valueOf( analitikaIzvoda.getModelOdobrenja()));
				stavkaKliringaMT102.setModelZaduzenja(BigInteger.valueOf( analitikaIzvoda.getModelZaduzenja()));
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
			}else{


				AnalitikaIzvoda analitikaIzvoda = stavka.getAnalitikaIzvoda();

				com.tim15.model.xml.mt102.StavkaKliringa stavkaKliringaMT102 = new com.tim15.model.xml.mt102.StavkaKliringa();
				stavkaKliringaMT102.setDatumPrijema(dateToXmlGrgorianCalendar(analitikaIzvoda.getDatumPrijema()));
				stavkaKliringaMT102.setDuznik(analitikaIzvoda.getDuznikNalogodavac());
				stavkaKliringaMT102.setIdStavke(String.valueOf(stavka.getStavkaKliringaId()));
				stavkaKliringaMT102.setIznos(BigDecimal.valueOf( analitikaIzvoda.getIznos()));
				stavkaKliringaMT102.setModelOdobrenja(BigInteger.valueOf( analitikaIzvoda.getModelOdobrenja()));
				stavkaKliringaMT102.setModelZaduzenja(BigInteger.valueOf( analitikaIzvoda.getModelZaduzenja()));
				stavkaKliringaMT102.setPozivNaBrojOdobrenja(analitikaIzvoda.getPozivNaBrojOdobrenja());
				stavkaKliringaMT102.setPozivNaBrojZaduzenja(analitikaIzvoda.getPozivNaProjZaduzenja());
				stavkaKliringaMT102.setPrimalac(analitikaIzvoda.getPoverilacPrimalac());
				stavkaKliringaMT102.setRacunDuznika(analitikaIzvoda.getRacunDuznika());
				stavkaKliringaMT102.setRacunPrimaoca(analitikaIzvoda.getRacunPoverioca());
				stavkaKliringaMT102.setSifraValute(stavka.getSifraValute());
				stavkaKliringaMT102.setSvrhaPlacanja(analitikaIzvoda.getSvrhaPlacanja());

				double ukupno = mt102.getZaglavljeKliringa().getUkupanIznos().doubleValue() + analitikaIzvoda.getIznos();

				mt102.getZaglavljeKliringa().setUkupanIznos(BigDecimal.valueOf(ukupno));
				mt102.getStavkeKliringa().add(stavkaKliringaMT102);
			}


			listaMT102.add(mt102);
		}


		for(MT102 mt102 : listaMT102){

			//objectToXmlFile(mt102,"MT102_"+mt102.getZaglavljeKliringa().getDatumKliringa().toString().split("T")[0]);
			objectToXmlFile(mt102,"MT102_"+getFormatedDateTimeForKliring(mt102.getZaglavljeKliringa().getDatumKliringa()));

		}






	}

	private static String getFormatedDateTimeForKliring(XMLGregorianCalendar datumKliringa) {

		String formatedDate = datumKliringa.getDay() + "_" + datumKliringa.getMonth() + "_" + datumKliringa.getYear() + "_" + datumKliringa.getHour() + "_" + datumKliringa.getMinute();

		return formatedDate;
	}

	private static MT102 findMT102(StavkaKliringa stavka, List<MT102> listaMT102) {
		MT102 mt102ret = null;

		for(MT102 mt102 : listaMT102){

			if(mt102.getZaglavljeKliringa().getSwiftKodBankePrimaoca().equals(stavka.getSwiftBankePoverioca())){

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

	public static void objectToXmlFile(Object object,String fileName){

		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(object.getClass());
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);



			File xmlFile = new File(System.getProperty("user.home") + "/Desktop/" +fileName+".xml" );



			jaxbMarshaller.marshal(object, xmlFile);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
