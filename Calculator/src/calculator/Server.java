package calculator;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class Server {

    public static void main(String args[]) {
        boolean autorization = false;
        String Login = " ";
        try {
            ServerSocket server = new ServerSocket(12345);
            Socket socket = server.accept();

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            System.out.println("Ready");

            while (!autorization) {
                Login = in.readUTF();
                String Password = in.readUTF();
                Welcome welcome = new Welcome(Login, Password);
                autorization = welcome.verification();
                out.writeBoolean(autorization);
            }
            System.out.println("Сorrectly!");

            boolean work = in.readBoolean();
            while (work) {
                double operand1 = in.readDouble();
                double operand2 = in.readDouble();
                char operation = in.readChar();
                
                String ResultLog = operand1 + " " + operation + " " + operand2;
                System.out.println("Your input: " + ResultLog);
                CalculationThread thread = new CalculationThread(Login, ResultLog);
                thread.start();
                
                Operation serveroperation = new Operation(operand1, operand2, operation);
                out.writeDouble(serveroperation.result);
                System.out.println("Operation is executed: " + serveroperation.result);
                work = in.readBoolean();
            }

            socket.close();
            System.out.println("Server Socket close!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
