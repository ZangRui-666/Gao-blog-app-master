import org.apache.commons.codec.digest.DigestUtils;

public class Test {
    public static void main(String[] args) {
        String s = DigestUtils.md5Hex("admin" + "Kanfei1!#$");
        System.out.println(s);
    }

    @org.junit.jupiter.api.Test
    public void testDate(){

    }
}
