package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.regex.Pattern;

public class NonBlockingNIO_Client {


    public static void main(String[] args) throws IOException {
        //1.获取Channel
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",8888));
        //2.切换为非阻塞模式
        sChannel.configureBlocking(false);

        FileChannel fileChannel = FileChannel.open(Paths.get("./src/nio/1.jpg"), StandardOpenOption.READ);
        fileChannel.transferTo(0,fileChannel.size(),sChannel);

        //友好的断开连接
        sChannel.shutdownOutput();
    }
}
