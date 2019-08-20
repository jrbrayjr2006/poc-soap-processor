package com.jrbrayjr.poc.soap;

import lombok.extern.slf4j.Slf4j;
import org.jdom2.JDOMException;
import org.jdom2.input.DOMBuilder;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.DOMOutputter;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

@Slf4j
@Component
public class SOAPProcessor {

    private static final String TAG = "SOAPProcessor";

    SAXBuilder saxBuilder;

    public SOAPProcessor(SAXBuilder saxBuilder) {
        this.saxBuilder = saxBuilder;
    }

    public Document xmlStringToW3cDocument(String xml) {
        Reader reader = new StringReader(xml);
        org.w3c.dom.Document doc = null;
        org.jdom2.Document jdomDoc = null;
        try {
            jdomDoc = saxBuilder.build(reader);
            doc = convertJDOMToDOM(jdomDoc);
        } catch(IOException ioe) {
            log.error(TAG, ioe.getMessage());
        } catch(JDOMException jdome) {
            log.error(TAG, jdome.getMessage());
        }
        return doc;
    }

    public org.jdom2.Document convertDOMtoJDOM(org.w3c.dom.Document input) {
        DOMBuilder builder = new DOMBuilder();
        org.jdom2.Document output = builder.build(input);
        return output;
    }

    public org.w3c.dom.Document convertJDOMToDOM(org.jdom2.Document jdomDoc) throws JDOMException {

        DOMOutputter outputter = new DOMOutputter();
        return outputter.output(jdomDoc);
    }
}
