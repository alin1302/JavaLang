package calculator;

import java.io.*;
import javax.swing.*;

/**
 *
 * @author Admin
 */
public class Welcome {

    public String Log;
    public String Pass;

    public Welcome(String Log, String Pass) {
        this.Log = Log;
        this.Pass = Pass;
    }

    public void verification() {
        try {
            File Txt = new File("G:\\GitProjects\\Java\\Calculator\\LogPass.txt");
            FileReader FR = new FileReader(Txt);
            BufferedReader reader = new BufferedReader(FR);
            String LogTxt = reader.readLine();
            String PassTxt = reader.readLine();
            if (LogTxt.equals(Log) && PassTxt.equals(Pass)) {
                new calculatorUI().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Incorrectly! Please try again.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
