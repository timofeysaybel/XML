package XML;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class Parser
{
    private static String data = new String();

    public static String parse(String filename) throws IOException, SAXException, ParserConfigurationException
    {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        AdvancedXMLHandler handler = new AdvancedXMLHandler();
        parser.parse(new File(filename), handler);

        return data;
    }

    /*                     Parses XML file                       */
    private static class AdvancedXMLHandler extends DefaultHandler
    {
        private static final String XML_TAG =  "ce:para";

        private String name, lastElementName;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
        {
            lastElementName = qName;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException
        {
            String information = new String(ch, start, length);

            information = information.replace("\n", "").trim();

            if (!information.isEmpty())
            {
                if (lastElementName.equals(XML_TAG))
                    name = information;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException
        {
            if ( (name != null && !name.isEmpty())  )
            {
                data = name;
                name = null;
            }
        }

    }
}
