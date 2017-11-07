package other;

import java.net.URLEncoder;

/**
 * @author chenlei
 * @since 2017 - 11 - 07 21:42
 */
public class URLEncoderTest {

    public static void main(String[] args) throws Exception {
        String s = "君山";
        System.out.println(URLEncoder.encode(s, "utf-16"));
    }

}
