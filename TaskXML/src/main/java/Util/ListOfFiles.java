package Util;

import java.io.File;

public class ListOfFiles
{
    public static String[] getFiles(String dir)
    {
        //Creating a File object for directory
        File directoryPath = new File(dir);
        //List of all files and directories
        String contents[] = directoryPath.list();
        return contents;
    }
}
