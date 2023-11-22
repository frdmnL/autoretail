import java.io.*; import java.net.Socket;
import java.net.UnknownHostException;
//通过socket通信发送消息，在条件满足时调用发送函数
public class SocketClient {
    final String serverHost = "localhost";
    Socket socketOfClient = null;
    BufferedReader is = null;
    BufferedWriter os = null;

    /**
     * Describe 发送数量不足函数
     * @param Sno 商品名
     * @param num 剩余数量
     */
    public void sendinfo(int Sno, int num)
    {
        try {
            socketOfClient = new Socket(serverHost,9999);
            os = new BufferedWriter(new OutputStreamWriter(socketOfClient.getOutputStream()));
            is = new BufferedReader(new InputStreamReader(socketOfClient.getInputStream()));
        } catch (UnknownHostException e) {
            System.out.println("Don't know Host");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + serverHost);
            e.printStackTrace();
        }

        try{
            os.write("商品"+Sno+"数量不足！请尽快补货");
            os.newLine();
            os.flush();
            os.write("剩余数量"+':'+num);
            os.newLine();
            os.flush();


            os.close();
            is.close();
            socketOfClient.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
