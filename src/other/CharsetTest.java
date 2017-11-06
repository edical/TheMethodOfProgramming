package other;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * 文件储存为GBK编码，字节流读取时被转为UTF-8编码
 * @author chenlei
 * @since 2017 - 11 - 06 14:31
 */
public class CharsetTest {


    public static void main(String[] args) throws Exception {
        String filePath = "CharsetTest.txt";
        File file = new File(filePath);
        InputStreamReader reader = new InputStreamReader(new FileInputStream(file), Charset.forName("GBK"));
        char c = (char) reader.read();
        System.out.println(c);
    }
}
