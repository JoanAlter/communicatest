package communicatetest;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import static java.lang.System.*;    // 向其他客户端输出信息

public class OutputTread extends Thread {
    public void run(){
        try{
            String str;
            Socket client = new Socket("localhost", 8888);
            while (true) {
                BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
                PrintStream out = new PrintStream(client.getOutputStream());
                str = buf.readLine();
                out.flush();
                out.println(str);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
