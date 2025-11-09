import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client_UDP {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        DatagramPacket packet;

        String msg="Server di prova";
        byte[] buf=new byte[1024];

        buf=msg.getBytes();
        InetAddress ipDest = InetAddress.getByName("127.0.0.1");

        packet=new DatagramPacket(buf,buf.length,ipDest,9000);
        socket.send(packet);
        System.out.println("Pacchetto inviato...");

        System.out.println("Risposta ricevuta:");
        socket.receive(packet);
        msg=new String(packet.getData(),0,packet.getLength());
        System.out.println(msg);

        //solo per non fare terminare il client
        socket.receive(packet);



    }

}
