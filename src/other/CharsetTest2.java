package other;

import util.StringUtils;

/**
 * @author chenlei
 * @since 2017 - 11 - 07 18:24
 */
public class CharsetTest2 {

    public static void main(String[] args) throws Exception {
        String s = "君山";
        //JVM运行时采用UTF-16，打印出来占用4个字节
        StringUtils.printStrToHex(s);
        byte[] utf16 = s.getBytes("UTF-16");
        for(byte b : utf16) {
            System.out.print(Integer.toHexString(b & 0xff));  //feff为utf-16编码前缀，表示大小端
        }
        System.out.println();
        byte[] utf8 = s.getBytes("UTF-8");
        for(byte b : utf8) {
            System.out.print(Integer.toHexString(b & 0xff));
        }
    }
}
