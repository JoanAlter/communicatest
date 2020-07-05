package communicatetest;


public class Client4 {
    public static void main(String[] args) {
        new Thread(new OutputTread()).start();
        new Thread(new PrintMessage()).start();
    }
}