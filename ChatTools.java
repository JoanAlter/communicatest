package communicatetest;
import java.io.*;
import java.util.ArrayList;

public class ChatTools {

    private static ArrayList<ServerThread> stList = new ArrayList<>();

    public static void addClient(ServerThread st) throws  IOException {
        stList.add(st);
        System.out.println("加入成功");
    }
    public static void castMsg(String msg) throws IOException {
        for (int i = 0; i < stList.size(); i++) {
            ServerThread st = stList.get(i);
            st.sendMsg(msg);
        }
    }
}


