package service;

import java.io.*;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WriteAudit {
    private static File file = new File("/home/bogdan/IdeaProjects/Food Delivery Platform/src/files/Audit.csv");
    private static  FileWriter writer;


    public static void openFile() throws Exception{
        writer = new FileWriter(file);
    }

    public void writeInAudit(String action) throws Exception {

        //StringBuilder sb = new StringBuilder();
        writer.append(action);
        writer.append(',');

        SimpleDateFormat date = new SimpleDateFormat("yyyy.MM.dd.HH:mm:ss");
        String timeStamp = date.format(new Date());

        writer.append(timeStamp);
        writer.append('\n');

        //writer.write(sb.toString());
        writer.flush();
        System.out.println("done!");
    }
}
