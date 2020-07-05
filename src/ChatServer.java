package communicatetest;;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

public class ChatServer {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8888);
        boolean flag = true;
        while(flag){
           ServerThread st = new ServerThread(server.accept());
           Thread t = new Thread(st);
           t.start();
        }
    }
}
