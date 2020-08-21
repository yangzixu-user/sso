package utils;

import com.sso.utils.RsaUtils;
import org.junit.Test;

/**
 * @author yangzx
 */

public class GenKeyTest {
    public class RsaUtilsTest {

        private String privateFilePath = "C:\\Users\\admin\\auth_key\\id_key_rsa";
        private String publicFilePath = "C:\\Users\\admin\\auth_key\\id_key_rsa.pub";

       @Test
        public void generateKey() throws Exception {
            RsaUtils.generateKey(publicFilePath,privateFilePath,"RobodLee",2048);
        }

        @Test
        public void getPublicKey() throws Exception {
            System.out.println(RsaUtils.getPublicKey(publicFilePath));
        }

        @Test
        public void getPrivateKey() throws Exception {
            System.out.println(RsaUtils.getPrivateKey(privateFilePath));
        }


    }
}
