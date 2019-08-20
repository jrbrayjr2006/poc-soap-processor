package com.jrbrayjr.poc.soap;

import org.jdom2.input.SAXBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class SOAPProcessorTest {

    private SOAPProcessor soapProcessor;
    private SAXBuilder mockSAXBuilder;

    @BeforeEach
    void setUp() {
        mockSAXBuilder = mock(SAXBuilder.class);
        SAXBuilder saxBuilder = new SAXBuilder();
        this.soapProcessor = new SOAPProcessor(saxBuilder);
    }

    @Test
    void shouldProcessSOAPString() {
        // Given
        String soapString = createSoapString();
        // When
        Document doc = soapProcessor.xmlStringToW3cDocument(soapString);
        // Then
        assertNotNull(doc);
    }

    private String createSoapString() {
        String soapString = "<?xml version='1.0' encoding='UTF-8'?>"
                + "<S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\">"
                + "<S:Body>"
                + "<ns2:processResponse xmlns:ns2=\"http://ws.xxxxx.com/\">"
                + "<response><direction>response</direction>"
                + "<reference>09FG10021008111306320</reference>"
                + "<amount>0.0</amount>"
                + "<totalFailed>0</totalFailed>"
                + "<totalSuccess>0</totalSuccess>"
                + "<error>1</error>"
                + "<message>Invalid</message>"
                + "<otherReference>6360e28990c743a3b3234</otherReference>"
                + "<action>FT</action>"
                + "<openingBalance>0.0</openingBalance>"
                + "<closingBalance>0.0</closingBalance>"
                + "</response>"
                + "</ns2:processResponse>"
                + "</S:Body>"
                + "</S:Envelope>\n";

        return soapString;
    }

}