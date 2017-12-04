package calculator;

import java.io.*;
import java.util.*;

/**
 *
 * @author Admin
 */
public class CalculationThread   extends Thread  {

    public String Log;
    public File file;
    FileWriter fr;
    public int count;
    public int numFile;
    public String PesultOperation;

    public CalculationThread(String Log, String ResultOperation) {
        this.Log = Log;
        this.numFile = 1;
        this.PesultOperation = ResultOperation;
        newFile();
    }

    
    @Override
    public void run() {
        writeInFile(PesultOperation);
    }
    
    public void newFile() {
        count = 0;
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
            String string = count + ") Login - " + Log + "; " + "Date - " + gcalendar.get(Calendar.MONTH) + "." + gcalendar.get(Calendar.DATE) + "." + gcalendar.get(Calendar.YEAR) + "; " + "Time - " + gcalendar.get(Calendar.HOUR) + ":" + gcalendar.get(Calendar.MINUTE) + ":" + gcalendar.get(Calendar.SECOND) + "; " + "Operation " + ResultOperation + System.getProperty("line.separator");
            FileWriter fr = new FileWriter(file.getPath(), true);
            fr.write(string);
            fr.close();
            if (count == 10) {
                file.renameTo(new File("G:\\GitProjects\\Java\\Calculator\\calclog" + numFile + ".txt"));
                numFile++;
                newFile();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
