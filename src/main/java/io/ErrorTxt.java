package io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ErrorTxt {
    static private FileWriter fileHandler = null;
    static private String filePath = null;
    static private ErrorTxt instance = null;

    private ErrorTxt(){
        File newFile = new File(filePath);
        try {
            if (!newFile.exists() || newFile.delete()) {
                if (newFile.createNewFile()) {
                    fileHandler = new FileWriter(filePath);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean initFilePath(){
        if (instance == null) {
            if (filePath != null) {
                instance = new ErrorTxt();
            }
            else {
                System.out.println("Error: filePath is not set!");
                return false;
            }
        }
        return true;
    }

    public static synchronized void write(String customerName, String reason) {
        if (initFilePath()) {
            try {
                fileHandler.write("Please enter correct booking details for " +
                        customerName + ": " + reason + "\n");
                fileHandler.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void setFilePath(String filePath) {
        ErrorTxt.filePath = filePath;
    }
}
