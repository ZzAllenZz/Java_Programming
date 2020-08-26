package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class BlockingNIO_Server {
    public static void main(String[] args) throws IOException {
        BlockingNIO_Server s = new BlockingNIO_Server();
        s.server();
    }

    public void server() throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        FileChannel outChannel = FileChannel.open(Paths.get("./src/nio/2.jpg"), StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);
        ssc.bind(new InetSocketAddress(8888));

        //仍然是阻塞式的
        SocketChannel socketChannel = ssc.accept();


        //因为不知道socketChannel 传来的size;
        //outChannel.transferFrom(socketChannel,0,1024);
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while(socketChannel.read(byteBuffer)!=-1){
            byteBuffer.flip();
            outChannel.write(byteBuffer);
            byteBuffer.clear();
        }


        ssc.close();
        socketChannel.close();
        outChannel.close();


    }
}
