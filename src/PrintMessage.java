package communicatetest;

import java.io.*;
import java.net.Socket;

public class PrintMessage extends Thread {              // ��ӡ�������ͻ��˵õ�����Ϣ
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
                System.out.println("\n\r" + buf1.readLine());          // ��ӡ�����ͻ����������Ϣ
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}




