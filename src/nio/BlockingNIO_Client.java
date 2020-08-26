package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class BlockingNIO_Client {
    public static void main(String[] args) throws IOException {
        BlockingNIO_Client client = new BlockingNIO_Client();
        client.client();
    }

    public void client() throws IOException {
        SocketChannel sc = SocketChannel.open(new InetSocketAddress("127.0.0.1",8888));
        FileChannel inChannel = FileChannel.open(Paths.get("./src/nio/1.jpg"), StandardOpenOption.READ);
        inChannel.transferTo(0,inChannel.size(),sc);
        sc.shutdownOutput();
    }
}
