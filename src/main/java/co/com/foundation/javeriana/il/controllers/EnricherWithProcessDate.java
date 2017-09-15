package co.com.foundation.javeriana.il.controllers;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.StringWriter;

import static util.UtilDate.getNow;

/**
 * Created by AHernandezS on 15/09/2017.
 */
@Component
public class EnricherWithProcessDate implements Processor {

    Logger LOGGER = LoggerFactory.getLogger(EnricherWithProcessDate.class);

    private final static DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    private static DocumentBuilder dBuilder = null;

    private final String ROOT_NODE = "tns:aircratline-message";
    private final String FIELD_PROCESS_DATE_NAME = "tns:process-date";
    private final String FORMAT_PROCESS_DATE_TIME = "yyyy-MM-dd'T'HH:mm:ss";

    static {
        try {
            dBuilder = dbFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        Document document = exchange.getIn().getBody(Document.class);
        NodeList nodeList = document.getElementsByTagName(ROOT_NODE);
        addProcessDate(nodeList);
        writeToLog(document);
        exchange.getIn().setBody(document);
    }

    private void addProcessDate(NodeList nodeList) {
        ((Element)nodeList.item(0) ).setAttribute(FIELD_PROCESS_DATE_NAME, getNow(FORMAT_PROCESS_DATE_TIME));
    };

    private void writeToLog (Document doc) throws TransformerException {

        DOMSource domSource = new DOMSource(doc);
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.transform(domSource, result);
        LOGGER.info("XML IN String format is: \n:" + writer.toString());
    }
}
