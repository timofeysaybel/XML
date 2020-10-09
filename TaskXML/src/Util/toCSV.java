package Util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import org.supercsv.io.*;
import org.supercsv.prefs.CsvPreference;

public class toCSV
{
    public static void writeHashMapToCsv(Map<String,String> map) throws Exception
    {
        String eol = System.getProperty("line.separator");
        System.out.println("Size of map = " + map.size());
        try (Writer writer = new FileWriter("fromXML1.csv"))
        {
            for (Map.Entry<String, String> entry : map.entrySet())
            {
                writer.append(entry.getKey()).append(',').append(entry.getValue()).append(eol);
            }
        }
        catch (IOException ex)
        {
            ex.printStackTrace(System.err);
        }
    }

    public static void writeCsv(Map<String,String> map) throws IOException
    {
        FileWriter output = new FileWriter("fromXML.csv");
        try (ICsvListWriter listWriter = new CsvListWriter(output, CsvPreference.STANDARD_PREFERENCE))
        {
            for (Map.Entry<String, String> entry : map.entrySet())
            {
                listWriter.write(entry.getKey(), entry.getValue());
            }
        }
    }


    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String FILE_HEADER = "filename,ce:para";
    private static final String FILENAME = "fromXML1.csv";

    public static void writeCsvFile(Map<String,String> map)
    {

        FileWriter fileWriter = null;
        try
        {
            fileWriter = new FileWriter(FILENAME);

            //Write the CSV file header
            fileWriter.append(FILE_HEADER.toString());

            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);

            //Write a new student object list to the CSV file
            for (Map.Entry<String, String> entry : map.entrySet())
            {
                fileWriter.append(entry.getKey());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(entry.getValue());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }

            System.out.println("CSV file was created successfully !!!");

        }
        catch (Exception e)
        {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        }
        finally
        {

            try
            {
                fileWriter.flush();
                fileWriter.close();
            }
            catch (IOException e)
            {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }
}