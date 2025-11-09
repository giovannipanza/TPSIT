import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ClientMulticast {
    public static void main(String[] args) throws IOException {
        //creo l'oggetto che permette di registrarmi a un ip di Multicast
        MulticastSocket socket=new MulticastSocket(12345);
        socket.joinGroup(InetAddress.getByName("224.0.0.10"));

        //preparo l'oggetto DatagramPacket in modo che lo riempo con i dati che ricevo
        byte[] buf=new byte[1024];
        DatagramPacket packet=new DatagramPacket(buf,buf.length);
        socket.receive(packet);

        //estrapolo il contenuto del datagramma e lo visualizzo su console
        String msg=new String(packet.getData(),0,packet.getLength());
        System.out.println(msg);

    }
}
