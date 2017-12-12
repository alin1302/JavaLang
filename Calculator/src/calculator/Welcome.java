package calculator;

import java.io.*;

/**
 *
 * @author Admin
 */
public class Welcome {

    public String Login;
    public String Password;

    public Welcome(String Login, String Password) {
        this.Login = Login;
        this.Password = Password;
    }

    public boolean verification() {
        try {
            File Txt = new File("G:\\GitProjects\\Java\\Calculator\\LogPass.txt");
            FileReader FR = new FileReader(Txt);
            BufferedReader reader = new BufferedReader(FR);
            String LoginTxt = reader.readLine();
            String PasswordTxt = reader.readLine();
            if (LoginTxt.equals(Login) && PasswordTxt.equals(Password)) {
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
