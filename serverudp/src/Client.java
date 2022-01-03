import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args) throws IOException {
        InetAddress ipServeur = Inet4Address.getLocalHost();
        int portSrv = 9876;
        DatagramSocket cltSock = new DatagramSocket();
        while (true) {
            System.out.println("this is input");
            BufferedReader inClavier = new BufferedReader(new InputStreamReader(System.in));

          //  InetAddress ipServeur = InetAddress.getByName(hostServeur);
            byte[] dataRcv = new byte[1024];
            byte[] dataSnd = new byte[1024];
            String message = inClavier.readLine();
            dataSnd = message.getBytes();
            DatagramPacket pkSend = new DatagramPacket(dataSnd, dataSnd.length, ipServeur, portSrv);
            cltSock.send(pkSend);
            DatagramPacket pkRcv = new DatagramPacket(dataRcv, dataRcv.length);
            cltSock.receive(pkRcv);
            String messageRecu = new String(pkRcv.getData(),0, pkRcv.getLength()).trim();
            System.out.println("message du serveur:" + messageRecu);
        }
    }
}