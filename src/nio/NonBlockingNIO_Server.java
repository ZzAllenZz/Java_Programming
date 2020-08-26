package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;

public class NonBlockingNIO_Server {
    public static void main(String[] args) throws IOException {
        //1.获取通道
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        //2.切换为非阻塞
        ssChannel.configureBlocking(false);
        //3.绑定连接
        ssChannel.bind(new InetSocketAddress(8888));
        //4.获取选择器
        Selector selector = Selector.open();
        //5.将通道注册到选择器上，并指定“监听接受事件”
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);
        //6.轮询式的获取选择器上“准备就绪”的事件
        System.out.println("111");
        System.gc();
        while(selector.select()>0){
            System.out.println("222");

            //7.获取当前选择器中所有注册的“选择键（已就绪的监听事件）”
            Iterator<SelectionKey> itr = selector.selectedKeys().iterator();
            while(itr.hasNext()){
                //8.获取准备就绪的事件
                SelectionKey selectionKey = itr.next();
                //9.判断具体是什么事件准备就绪
                if(selectionKey.isValid()&&selectionKey.isAcceptable()){
                    //10.若“接收就绪”， 获取客户端连接
                    SocketChannel sChannel = ssChannel.accept();
                    //11.切换非阻塞模式
                    sChannel.configureBlocking(false);
                    //12.将该通道注册到选择器中
                    sChannel.register(selector,SelectionKey.OP_READ);
                }else if(selectionKey.isValid()&&selectionKey.isReadable()) {
                    //13.获取当前选择器上“读就绪”状态的通道。
                    SocketChannel sChannel = (SocketChannel) selectionKey.channel();
                    FileChannel outChannel = FileChannel.open(Paths.get("./src/nio/2.jpg"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);
                    //14. 将读取数据
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    while (sChannel.read(byteBuffer)!=-1) {
                        byteBuffer.flip();
                        outChannel.write(byteBuffer);
                        byteBuffer.clear();
                    }
                    sChannel.close();
                    outChannel.close();

                }
                //15. 取消选择键SelectionKey
                itr.remove();
            }
        }
        //不会走到，一直在selector.select()>0这个循环中
        System.out.println("333");

    }
}
