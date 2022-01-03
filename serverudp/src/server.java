import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class server {
    public static void main(String[] args) throws IOException {
        int port = 9876;
        DatagramSocket serverSocket = new DatagramSocket(port);
       try {
           while (true) {

               byte[] dataRcv = new byte[1024];
               byte[] dataSnd = new byte[1024];
               DatagramPacket pkRcv = new DatagramPacket(dataRcv, dataRcv.length);
               serverSocket.receive(pkRcv);
               System.out.println(pkRcv.getData());
               String msg = new String(pkRcv.getData()).trim();
               InetAddress IPAddress = pkRcv.getAddress();
               int portClt = pkRcv.getPort();
               System.out.println(portClt);
               String msgrep = msg.toUpperCase()+"wassim";
               System.out.println(msgrep);
               dataSnd = msgrep.getBytes();
               DatagramPacket pkSend = new DatagramPacket(dataSnd, dataSnd.length, IPAddress, portClt);
             //  serverSocket.send(pkSend);
           }
       }catch (Exception e){
           e.printStackTrace();
       }
    }

}