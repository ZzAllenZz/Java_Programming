package nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ChannelTest1 {
    public static void main(String[] args) throws IOException {
        //Paths.get(),会从src的上一级开始.
        FileChannel inChannel = FileChannel.open(Paths.get("./src/nio/1.jpg"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("./src/nio/2.jpg"),StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);

        //利用直接缓冲区
        //内存映射文件 通过 map()方法
        MappedByteBuffer inMappedBuf = inChannel.map(FileChannel.MapMode.READ_ONLY,0,inChannel.size());
        MappedByteBuffer outMappedBuf = outChannel.map(FileChannel.MapMode.READ_WRITE,0,inChannel.size());

        //直接对缓冲区进行文件的读写
        byte[] dst = new byte[inMappedBuf.limit()];
        inMappedBuf.get(dst);
        outMappedBuf.put(dst);

        inChannel.close();
        outChannel.close();

//        test2();
//        test3();
    }

    static public void test2() throws IOException {
        //利用非直接缓冲区
        FileInputStream fileInputStream = new FileInputStream("./src/nio/1.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("./src/nio/2.jpg");
        FileChannel inChannel = fileInputStream.getChannel();
        FileChannel outChannel = fileOutputStream.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(1024);
        while(inChannel.read(buf)!=-1){
            buf.flip();
            outChannel.write(buf);
            buf.clear();
        }
        fileInputStream.close();
        fileOutputStream.close();
        inChannel.close();
        outChannel.close();
    }

    //通道之间的数据传输(直接缓冲区) 通过transferTo()和 transaferFrom()
    static public void test3() throws IOException{
        FileChannel inChannel = FileChannel.open(Paths.get("./src/nio/1.jpg"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("./src/nio/2.jpg"),StandardOpenOption.READ,StandardOpenOption.WRITE,StandardOpenOption.CREATE);

        //inChannel.transferTo(0,inChannel.size(),outChannel);
        //一样
        outChannel.transferFrom(inChannel,0,inChannel.size());
        inChannel.close();
        outChannel.close();





    }
}
