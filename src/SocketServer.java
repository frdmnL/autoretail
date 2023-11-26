import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
//监听客户端发来的信息
public class SocketServer {
    public static void main(String[] args){
        ServerSocket listener = null;
        String line=null;
        BufferedReader is;
        BufferedWriter os;
        Socket socketOfServer = null;

        try {
            listener = new ServerSocket(9999);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        try {
            System.out.println("Server is waiting to accept user...");
            socketOfServer = listener.accept();
            System.out.println("accept client");
            is = new BufferedReader(new InputStreamReader(socketOfServer.getInputStream()));
            //os = new BufferedWriter(new OutputStreamWriter(socketOfServer.getOutputStream()));

            while (true){
                while((line = is.readLine()) != null){
                    //将监听到的内容打印
                    System.out.println(line);
                }
                break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
