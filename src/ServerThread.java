package communicatetest;

import java.net.Socket;
import java.io.*;

public class ServerThread implements Runnable {         // �Կͻ��˵���Ϣ���н��շ��ͣ��൱����תվ
    private Socket client;     // �߳��д���Ķ���
    private OutputStream ous; // ���������

    ServerThread(Socket client) {
        this.client = client;
    }

    public void sendMsg(String msg) throws IOException {
        msg += "\r\n";
        ous.write(msg.getBytes());
        ous.flush();
    }

    public void run() {
        try {
            processSocket();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processSocket() throws IOException {
        try {
            BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintStream pout = new PrintStream(client.getOutputStream());
            ous = client.getOutputStream();
            ChatTools.addClient(this);
            String str = buf.readLine();
            boolean temp = true;
            while (temp) {
                ChatTools.castMsg(str);
                str = buf.readLine();
            }
            pout.close();
            client.close();
        } catch (Exception e) {
        }

    }
}


