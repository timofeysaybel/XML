package main.java;

import XML.Parser;

import java.util.HashMap;
import java.util.Map;

public class Main
{
    private static final String XML_DIR = "C:\\XML_items_recent";

    private static Map<String,String> data = new HashMap<>();

    public static void main(String[] args) throws Exception
    {
        String[] files = Util.ListOfFiles.getFiles(XML_DIR);
        System.out.println("Files count = " + files.length);
        for (String file : files)
        {
            String tmp = Parser.parse(XML_DIR + "\\" + file);

            data.put(file,tmp);
        }
        System.out.println("Map size = " + data.size());
        Util.toCSV.writeCsv(data);
    }
}
