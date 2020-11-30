import com.capstone9.coin_singer.support.PasswordEncoderUtil;
import org.junit.Test;

public class PasswordEncodeTest {

    final String pwd = "123123123";

    @Test
    public void getBcrpr(){
        PasswordEncoderUtil pwdu = new PasswordEncoderUtil();
        System.out.println(pwdu.encode(pwd));
    }
}