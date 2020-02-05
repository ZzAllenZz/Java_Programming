import java.io.*;
class Io{
    public static void main(String[] args) {
        String fileName="D:"+File.separator;
        File f=new File(fileName);
        String[] str=f.list();
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
    }
}