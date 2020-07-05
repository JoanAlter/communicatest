package communicatetest;

import java.io.*;
import java.net.Socket;

public class PrintMessage extends Thread {              // 打印从其他客户端得到的信息
    public void run() {
        Socket client = null;
        try{
            client = new Socket("localhost", 8888);
        }catch (IOException e1){
            e1.printStackTrace();
        }
        while (true) {
            try {
                BufferedReader buf1 = new BufferedReader(new InputStreamReader(client.getInputStream()));
                System.out.println("\n\r" + buf1.readLine());          // 打印其他客户端输入的信息
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}




