package calculator;

import java.io.*;
import java.util.*;

/**
 *
 * @author Admin
 */
public class CalculationThread extends Thread {

    public String Login;
    public File file;
    FileWriter fr;
    public static int count = 0;
    public static int numFile = 1;
    public String ResultOperation;

    public CalculationThread(String Login, String ResultOperation) {
        this.Login = Login;
        this.ResultOperation = ResultOperation;
        newFile();
    }

    @Override
    public void run() {
        writeInFile(ResultOperation);
    }

    public void newFile() {
        try {
            file = new File("G:\\GitProjects\\Java\\Calculator\\calclog.txt");
            this.fr = new FileWriter(file.getPath(), true);
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeInFile(String ResultOperation) {
        GregorianCalendar gcalendar = new GregorianCalendar();
        try {
            count++;
            String string = count + ") Login - " + Login + "; " + "Date - " + gcalendar.get(Calendar.MONTH) + "." + gcalendar.get(Calendar.DATE) + "." + gcalendar.get(Calendar.YEAR) + "; " + "Time - " + gcalendar.get(Calendar.HOUR) + ":" + gcalendar.get(Calendar.MINUTE) + ":" + gcalendar.get(Calendar.SECOND) + "; " + "Operation " + ResultOperation + System.getProperty("line.separator");
            FileWriter fr = new FileWriter(file.getPath(), true);
            fr.write(string);
            fr.close();
            if (count == 10) {
                file.renameTo(new File("G:\\GitProjects\\Java\\Calculator\\calclog" + numFile + ".txt"));
                numFile++;
                count = 0;
                newFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
