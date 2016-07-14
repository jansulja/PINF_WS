package com.tim15.model.xml.util;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.io.IOUtils;
import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.apache.openjpa.jdbc.sql.FoxProDictionary;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;






public class XSLFOTransformer {

	public XSLFOTransformer() {
		super();
		// TODO Auto-generated constructor stub
	}



	public void domToPDF(Document document, String xmlName, String xslFileName) {
		FopFactory fopFactory;
		TransformerFactory transformerFactory;

		try {
			InputStream is = this.getClass().getClassLoader().getResourceAsStream("/fop.xconf");
			// Initialize FOP factory object
			File f = File.createTempFile("fop", "xconf");

		    f.deleteOnExit();
		    FileOutputStream fout = new FileOutputStream(f);
		    IOUtils.copy(is, fout);


		    //"izvestaj-klijenta-fo"

			fopFactory = FopFactory.newInstance();

			// Setup the XSLT transformer factory
			transformerFactory = new org.apache.xalan.xsltc.trax.TransformerFactoryImpl();
			// Point to the XSL-FO file

			is = this.getClass().getClassLoader().getResourceAsStream("/xsl/" + xslFileName);
			File xsltFile = File.createTempFile(xslFileName, "xsl");
			xsltFile.deleteOnExit();
		    fout = new FileOutputStream(xsltFile);
		    IOUtils.copy(is, fout);


			// Create transformation source
			StreamSource transformSource = new StreamSource(xsltFile);
			// Initialize the transformation subject
			Source source = new DOMSource(document);
			// Initialize user agent needed for the transformation
			FOUserAgent userAgent = fopFactory.newFOUserAgent();
			// Create the output stream to store the results
			ByteArrayOutputStream outStream = new ByteArrayOutputStream();
			// Initialize the XSL-FO transformer object
			Transformer xslFoTransformer = transformerFactory.newTransformer(transformSource);
			// Construct FOP instance with desired output format
			Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, userAgent, outStream);
			// Resulting SAX events
			Result res = new SAXResult(fop.getDefaultHandler());
			// Start XSLT transformation and FOP processing
			xslFoTransformer.transform(source, res);
			// Generate PDF file
			//File pdfFile = new File(System.getProperty( "catalina.base" ) + "/webapps/xws/gen/pdf/"+xmlName+".pdf");
			File pdfFile = new File(System.getProperty("user.home") + "/Desktop/" +xmlName+".pdf" );
			OutputStream out = new BufferedOutputStream(new FileOutputStream(pdfFile));
			out.write(outStream.toByteArray());
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (FOPException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}

		System.out.println("Uspesno zavrsena transformacija "+xmlName+ " u pdf, na putanji: Desktop/"+xmlName+".pdf");
	}


}
