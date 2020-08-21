package com.sso.utils;


import java.io.File;
import java.nio.file.Files;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * @author yangzx
 */
public class RsaUtils {

    public static final int DEFAULT_KEY_SIZE=2048;

    /**
     * 从文件中读取公钥对象
     * @param filename 公钥保存路径，相对于classpath
     * @return 公钥对象
     */
    public static PublicKey getPublicKey(String filename) throws Exception {
        byte[] bytes = readFile(filename);
        return getPublicKey(bytes);
    }

    public static PrivateKey getPrivateKey(String filename)throws Exception{
        byte[] bytes = readFile(filename);
        return getPrivateKey(bytes);
    }

    /**
     *  获取公钥
     * @param bytes 公钥字节形式
     * @return 公钥对象
     * @throws Exception
     */
    public static PublicKey getPublicKey(byte[] bytes) throws Exception {
        bytes = Base64.getDecoder().decode(bytes);
        X509EncodedKeySpec spec = new X509EncodedKeySpec(bytes);
        KeyFactory factory = KeyFactory.getInstance("RSA");
        return factory.generatePublic(spec);

    }

    /**
     * 获取私钥
     * @param bytes 私钥字节
     * @return 私钥对象
     * @throws Exception
     */
    public static PrivateKey getPrivateKey(byte[] bytes) throws Exception {
        bytes = Base64.getDecoder().decode(bytes);
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(bytes);
        KeyFactory factory = KeyFactory.getInstance("RSA");
        return factory.generatePrivate(spec);

    }

    /**
     * 生成RSA公钥和私钥并写入文件
     * @param publicKeyFilename 公钥文件存储路劲
     * @param privateKeyFilename 私钥文件存储路径
     * @param secret 生成密钥的密文
     * @param keySize 密钥长度
     */
    public static void generateKey(String publicKeyFilename,String privateKeyFilename,String secret,int keySize) throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        SecureRandom secureRandom = new SecureRandom();
        keyPairGenerator.initialize(Math.max(keySize,DEFAULT_KEY_SIZE),secureRandom);
        KeyPair keyPair = keyPairGenerator.genKeyPair();
        //获取工业与并写入
        byte[] publicKeyBytes = keyPair.getPublic().getEncoded();
        publicKeyBytes = Base64.getEncoder().encode(publicKeyBytes);
        writeFile(publicKeyFilename,publicKeyBytes);
        //获取私钥并写入
        byte[] privateKeyBytes = keyPair.getPrivate().getEncoded();
        privateKeyBytes = Base64.getEncoder().encode(privateKeyBytes);
        writeFile(privateKeyFilename,privateKeyBytes);
    }



    private  static byte[] readFile(String filename) throws Exception{
        return Files.readAllBytes(new File(filename).toPath());
    }

    private static void writeFile(String destPath,byte[] bytes)throws Exception{
        File dest = new File(destPath);
        if (dest.exists()){
            dest.createNewFile();
        }
        Files.write(dest.toPath(),bytes);
    }

}
