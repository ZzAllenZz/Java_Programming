package nio;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class BufferTest1 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        System.out.println("-----------allocate()--------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        byte[] b_gbk = "中".getBytes("GBK");
        byte[] b_utf8 = "中".getBytes("UTF-8");
        byte[] b_iso88591 = "中".getBytes("ISO8859-1");
        byte[] b_unicode = "中".getBytes("unicode");//java默认编码方式 //英文 1个字节,中文3个字节
        byte[] b_default = "中".getBytes();
        System.out.println(b_gbk.length);
        System.out.println(b_iso88591.length);
        System.out.println(b_unicode.length);
        System.out.println(b_utf8.length);
        System.out.println(b_default.length);
        System.out.println(b_default);
        System.out.println(b_unicode);
        System.out.println(b_gbk);


        String str = "中";
        System.out.println(str.getBytes());
        byteBuffer.put(str.getBytes());
        System.out.println("-----------put()--------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

    }
}
