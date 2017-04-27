package cn.linjs.learn;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by pine on 2016/6/13.
 */
public class CommonTest {

    private static String readFile(String dir,String childFile) throws Exception {
        File dataFile = new File(dir,childFile);
        FileInputStream fi = new FileInputStream(dataFile);
        byte[] buffer = new byte[2048];
        StringBuilder sb = new StringBuilder();
        int read = 0;
        while ((read = fi.read(buffer)) != -1){
            sb.append(new String(buffer,0,read));
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
//        System.out.println(readFile("C:\\Users\\linjs\\Desktop","../../../Windows/System32/drivers/etc/hosts"));
        System.out.println(Integer.MIN_VALUE == Integer.MIN_VALUE);
    }
}
