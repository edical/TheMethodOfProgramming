package other;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
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
