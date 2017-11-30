package calculator;

import java.io.*;
import java.util.*;

/**
 *
 * @author Admin
 */
public class History {

    public String Log;
    public File file;
    public int lineCount = 0;
    public int fileCount = 0;
    FileWriter fr;

    public History(String Log) {
        this.Log = Log;
        this.fr = null;
        try {
            file = new File("G:\\GitProjects\\Java\\Calculator\\calclog.txt");
            this.fr = new FileWriter(file.getPath(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void writeInFile(String ResultOperation) {

        GregorianCalendar gcalendar = new GregorianCalendar();
        try {
            String string = "Login - " + Log + "; " + "Date - " + gcalendar.get(Calendar.MONTH) + "." + gcalendar.get(Calendar.DATE) + "." + gcalendar.get(Calendar.YEAR) + "; " + "Time - " + gcalendar.get(Calendar.HOUR) + ":" + gcalendar.get(Calendar.MINUTE) + ":" + gcalendar.get(Calendar.SECOND) + "; " + "Operation " + ResultOperation + System.getProperty("line.separator");
            FileWriter fr = new FileWriter(file.getPath(), true);
            fr.write(string);
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
