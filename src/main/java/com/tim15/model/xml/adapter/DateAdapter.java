package com.tim15.model.xml.adapter;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.datatype.XMLGregorianCalendar;

import com.tim15.model.xml.util.XmlManager;

public class DateAdapter extends XmlAdapter<String, XMLGregorianCalendar> {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public XMLGregorianCalendar unmarshal(String v) throws Exception {
		synchronized (dateFormat) {
            return XmlManager.dateToXmlGrgorianCalendar(dateFormat.parse(v)) ;
        }
	}

	@Override
	public String marshal(XMLGregorianCalendar v) throws Exception {
		synchronized (dateFormat) {
            return dateFormat.format(v);
        }
	}



}