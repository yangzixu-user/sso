package com.sso.controller;

import com.sso.utils.RsaUtils;

/**
 * @author yangzx
 */
public class Test {

    private String privateFilePath = "C:\\Users\\admin\\auth_key\\id_key_rsa";
    private String publicFilePath = "C:\\Users\\admin\\auth_key\\id_key_rsa.pub";

    public void generateKey() throws Exception {
        RsaUtils.generateKey(publicFilePath,privateFilePath,"RobodLee",2048);
    }


    public void getPublicKey() throws Exception {
        System.out.println(RsaUtils.getPublicKey(publicFilePath));
    }


    public void getPrivateKey() throws Exception {
        System.out.println(RsaUtils.getPrivateKey(privateFilePath));
    }

    public static void main(String[] args) throws Exception{
         String privateFilePath = "C:\\Users\\admin\\auth_key\\id_key_rsa";
         String publicFilePath = "C:\\Users\\admin\\auth_key\\id_key_rsa.pub";

            RsaUtils.generateKey(publicFilePath,privateFilePath,"RobodLee",2048);

            System.out.println(RsaUtils.getPublicKey(publicFilePath));

            System.out.println(RsaUtils.getPrivateKey(privateFilePath));

    }
}
