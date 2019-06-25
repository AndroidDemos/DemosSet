package org.cmkj.juanworld.common.utils;
import org.cmkj.juanworld.common.vo.SignVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.*;
/**
 * Rsa签名工具
 * @author hanjie.l
 */
public class RSASignUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(RSASignUtils.class);

    /**
     * 签名算法
     */
    public static final String SIGN_ALGORITHMS = "SHA1WithRSA";

    public static void main(String[] args)  throws Exception{
    	/*String privateKey="MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKcXojG4iWxgxWE6dKX+6Ug/w5oGiIr98MmPCjW88mf38VRmIhY15ZfHn0Ehq+bODIx+tnYsQmy6A8M6L6smkOiY/dT4yoT7ZAAV9q4PNodLhyJKuscHn6t+IMpCjaZpCds36DuqaRXO/ARn6wuD+pz3Oqtq0V617v0AT7Xn3FwTAgMBAAECgYAIA2sk5Uu55d4xboM/nr0DWQOBdITB3bHZiMGdmCUr9UkemhNSa11KbSlnDz1WQVV6u2z2t+KrojQh/b1hgOT8HsMZObUM52ldo405pN8n8B5KEQ/krAQ/nkZbAbulztMrSCfS+DG5DRLSY5k4NjPDKq8li8ZdjbUS7f+bDq+UKQJBAOQ56kWAiAxsBVGPmgBs4o1hg0P/f+QpYYmsYccK761Rj2wyeMD0LiquSyzDDrBf9L6joxso478JtscEYsP4mBcCQQC7bSwz4J9PDwaqbk/A2wIQJkH7FlyRQ6f87YCqiS+RXgozjRtykECaS6ZM3OfHJO47fyYMD6bcSqD0QwMhuF1lAkBQe1fxEIVplAJAI9rUAZHW96c5qHUqOamKyj5k2adxwExKhHXu3W0WYgZij5qzefMt8zjGkCHYMY3CGvrVTuobAkBr4G11uo7XOUXT6MQ8s5Gfa/XEKF3FOpTBDo5lGaroV6E1hL1MllyosmwYh3lcdRQt6IQkowmed9HmZX+y8+PFAkEAibH0ItvqTMsbf/lS4a7C+A3V/vJvuwbKZzZjkugLfuPwpGihxwQo+TXekGxEhLOw0rBRq8rhwuKNWqMtgy8Xdw==";
    	String publicKey="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnF6IxuIlsYMVhOnSl/ulIP8OaBoiK/fDJjwo1vPJn9/FUZiIWNeWXx59BIavmzgyMfrZ2LEJsugPDOi+rJpDomP3U+MqE+2QAFfauDzaHS4ciSrrHB5+rfiDKQo2maQnbN+g7qmkVzvwEZ+sLg/qc9zqratFete79AE+159xcEwIDAQAB";
    	String s="4111111111111111";
    	String encryptAccountNum = encryptByPublicKey(publicKey, s);
    	System.out.println(encryptAccountNum);
    	String accountNum=decryptByPrivateKey(privateKey, encryptAccountNum);
        System.out.println(accountNum);*/
    	String publicKey="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCS8SwNAMiHWNk6mOT2DZ5ZKsuYsk/hKQ71QOgXxh6JNj11NoDg783M0tE+jSMb04Mo73raMrkoXhyDLRH25xzahMaMK3zwV3Y59NTcMUilu1WMfS3+WTeooxqT7Qs3GMFjbWKVIPjWNgq+QLJVyeSz8Yt2tFi3KLzX0j+QF7CkiQIDAQAB";
    	String enContent="CqsQpxc59+XpWiwaR7OmHRpzwQLXlZL9LUenIS7Z+SwSvZvyZ2cBHGpG9c8hribG++QxsCB190TR3Yrheod61EpzhNWrRJY2xd3waHM5G6HgZ/OZSJtOOwhrTvn1FdxUvBw8xZc7taQK6xnUi+kB6TneCLv5rKG5QUvMpeI+5/s=";
    	System.out.println(decryptByPublicKey(publicKey, enContent));
    	/*KeyPairValue keyPairValue = genKeyPair();
        System.out.println(keyPairValue.getPrivateKey());
        System.out.println(keyPairValue.getPrivateKey().length());
        System.out.println(keyPairValue.getPublicKey());
        String encryptByPublicKey = encryptByPublicKey(keyPairValue.getPublicKey(), "1234");
        String content = decryptByPrivateKey(keyPairValue.getPrivateKey(), encryptByPublicKey);
        System.out.println(content);
        String encryptByprivateKey = encryptByprivateKey(keyPairValue.getPrivateKey(), content);
        String content2 = decryptByPublicKey(keyPairValue.getPublicKey(), encryptByprivateKey);
        System.out.println(content2);*/
    }


    /**
     * 验证请求合法性
     * @param request
     * @param publicKey
     * @param <T>
     * @return
     */
    public static <T extends SignVO> boolean checkReq(T request, String publicKey){
        String content = buildStringContent(request);
        boolean success = doCheck(content, request.getSign(), publicKey, "UTF-8");
        return success;
    }


    /**
     * 对对象进行签名
     * @param response
     * @param privateKey
     * @param <T>
     * @return
     */
    public static <T extends SignVO> T sign(T response, String privateKey){
        String content = buildStringContent(response);
        String sign = sign(content, privateKey, "UTF-8");
        response.setSign(sign);
        return response;
    }


    /**
     * 将对象属性转换成字符串。
     *
     * @param bean 对象
     * @return Map
     */
    public static String buildStringContent(Object bean) {
        List<Field> fields = RSASignUtils.getFieldList(bean.getClass(), true);
        Map<String, Object> map = new TreeMap<>();
        try {
            for (Field field : fields) {
                if(field.getName().equals("sign")){
                    continue;
                }
                field.setAccessible(true);
                Object val = field.get(bean);
                //跳过静态变量和空值
                if(val == null || Modifier.isStatic(field.getModifiers())){
                    continue;
                }
                if(field.getType().isEnum()){
                    if(val != null){
                        val = ((Enum<?>)val).name();
                    }
                    map.put(field.getName(), val);

                } else if(field.getType() == Date.class){//防止是Timestamp
                    map.put(field.getName(),  ((Date)val).getTime());
                }else{
                    map.put(field.getName(), val.toString());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(Map.Entry<String, Object> entry : map.entrySet()){
            if(stringBuilder.length() > 0){
                stringBuilder.append("&");
            }
            stringBuilder.append(entry.getKey()).append("=").append(entry.getValue());
        }
        return stringBuilder.toString();
    }

    /**
     * 反射获取对象属性列表。
     *
     * @param cls    类名
     * @param deepth 是否查找父级属性
     * @return List<Field> 属性列表
     */
    public static final List<Field> getFieldList(Class<?> cls, boolean deepth) {
        final List<Field> allFields = new ArrayList<>();
        Class<?> currentClass = cls;

        while (currentClass != null) {
            Field[] declaredFields = currentClass.getDeclaredFields();
            allFields.addAll(Arrays.asList(declaredFields));

            if (deepth && !currentClass.getSuperclass().equals(Object.class)) {
                currentClass = currentClass.getSuperclass();
            } else {
                currentClass = null;
            }
        }

        return allFields;
    }

    /** 
     * 随机生成一个密钥对
     */  
    public static KeyPairValue genKeyPair() {
        // KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象  
        KeyPairGenerator keyPairGen = null;  
        try {  
            keyPairGen = KeyPairGenerator.getInstance("RSA");  
        } catch (NoSuchAlgorithmException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        // 初始化密钥对生成器，密钥大小为96-1024位  
        keyPairGen.initialize(1024,new SecureRandom());  
        // 生成一个密钥对，保存在keyPair中  
        KeyPair keyPair = keyPairGen.generateKeyPair();  
        // 得到私钥  
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();  
        // 得到公钥  
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();

        // 得到公钥字符串
        String publicKeyString = new String(Base64.getEncoder().encode(publicKey.getEncoded()));
        // 得到私钥字符串
        String privateKeyString = new String(Base64.getEncoder().encode(privateKey.getEncoded()));

        KeyPairValue keyPairValue = new KeyPairValue();
        keyPairValue.setPrivateKey(privateKeyString);
        keyPairValue.setPublicKey(publicKeyString);
        return keyPairValue;
    }

    /**
     * RSA签名
     *
     * @param content    待签名数据
     * @param privateKey 商户私钥
     * @param encode     字符集编码
     * @return 签名值
     */
    public static String sign(String content, String privateKey, String encode) {
        try {
            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey));

            KeyFactory keyf = KeyFactory.getInstance("RSA");
            PrivateKey priKey = keyf.generatePrivate(priPKCS8);

            java.security.Signature signature = java.security.Signature.getInstance(SIGN_ALGORITHMS);

            signature.initSign(priKey);
            signature.update(content.getBytes(encode));

            byte[] signed = signature.sign();

            return new String(Base64.getEncoder().encode(signed));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * RSA验签名检查
     *
     * @param content   待签名数据
     * @param sign      签名值
     * @param publicKey 分配给开发商公钥
     * @param encode    字符集编码
     * @return 布尔值
     */
    public static boolean doCheck(String content, String sign, String publicKey, String encode) {

        if(sign == null || sign.trim().equals("")){
            return false;
        }

        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] encodedKey = Base64.getDecoder().decode(publicKey);
            PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));


            java.security.Signature signature = java.security.Signature
                    .getInstance(SIGN_ALGORITHMS);

            signature.initVerify(pubKey);
            signature.update(content.getBytes(encode));

            boolean bverify = signature.verify(Base64.getDecoder().decode(sign));
            return bverify;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * RSA最大加密明文大小
     */
    private static final int MAX_ENCRYPT_BLOCK = 117;

    /** *//**
     * <p>
     * 公钥加密
     * </p>
     *
     * @param plainTextData 源数据
     * @param publicKey 公钥(BASE64编码)
     * @return
     * @throws Exception
     */
    public static String encryptByPublicKey(String publicKey, String plainTextData) {
        if(plainTextData ==null){
            throw new RuntimeException("加密数据为空, 请设置");
        }

        if ( publicKey == null || publicKey.isEmpty()) {
            throw new RuntimeException("加密公钥为空, 请设置");
        }


        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            byte[] data = plainTextData.getBytes("UTF-8");
            RSAPublicKey publicK = loadPublicKeyByStr(publicKey);
            // 使用默认RSA
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicK);

            int inputLen = data.length;

            int offSet = 0;
            byte[] cache;
            int i = 0;
            // 对数据分段加密
            while (inputLen - offSet > 0) {
                if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                    cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
                } else {
                    cache = cipher.doFinal(data, offSet, inputLen - offSet);
                }
                out.write(cache, 0, cache.length);
                i++;
                offSet = i * MAX_ENCRYPT_BLOCK;
            }
            byte[] encryptedData = out.toByteArray();
            return new String(Base64.getEncoder().encode(encryptedData));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("无此加密算法");
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException("秘钥可能不对称");
        } catch (InvalidKeyException e) {
            throw new RuntimeException("加密公钥非法,请检查");
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException("明文长度非法");
        } catch (BadPaddingException e) {
            throw new RuntimeException("明文数据已损坏");
        } catch (Exception e){
            LOGGER.error("加密异常", e);
        }finally {
            if(out != null){
                try {
                    out.close();
                }catch (Exception e){
                    //ignore
                }
            }
        }

        return null;
    }

    /**
     * RSA最大解密密文大小
     */
    private static final int MAX_DECRYPT_BLOCK = 128;

    /**
     * <P>
     * 私钥解密
     * </p>
     *
     * @param cipherData 已加密数据
     * @param privateKey 私钥(BASE64编码)
     * @return
     * @throws Exception
     */
    public static String decryptByPrivateKey(String privateKey, String cipherData) {
        if(cipherData ==null){
            throw new RuntimeException("解密数据为空, 请设置");
        }

        if (privateKey == null || privateKey.isEmpty()) {
            throw new RuntimeException("解密私钥为空, 请设置");
        }



        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            RSAPrivateKey privateK = loadPrivateKeyByStr(privateKey);
            // 使用默认RSA
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateK);
            byte[] encryptedData = Base64.getDecoder().decode(cipherData.getBytes("UTF-8"));
            int inputLen = encryptedData.length;

            int offSet = 0;
            byte[] cache;
            int i = 0;
            // 对数据分段解密
            while (inputLen - offSet > 0) {
                if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                    cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
                } else {
                    cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
                }
                out.write(cache, 0, cache.length);
                i++;
                offSet = i * MAX_DECRYPT_BLOCK;
            }
            byte[] decryptedData = out.toByteArray();
            return new String(decryptedData, "UTF-8");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("无此解密算法");
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
            return null;
        } catch (InvalidKeyException e) {
            throw new RuntimeException("解密私钥非法,请检查");
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException("密文长度非法");
        } catch (BadPaddingException e) {
            throw new RuntimeException("密文数据已损坏");
        } catch (Exception e){
            LOGGER.error("加密异常", e);
        }finally {
            if(out != null){
                try {
                    out.close();
                }catch (Exception e){
                    //ignore
                }
            }
        }

        return null;
    }

    /**
     * 从字符串中加载公钥
     *
     * @param publicKeyStr
     *            公钥数据字符串
     * @throws Exception
     */
    public static RSAPublicKey loadPublicKeyByStr(String publicKeyStr){
        try {
            byte[] buffer = Base64.getDecoder().decode(publicKeyStr);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(buffer);
            return (RSAPublicKey) keyFactory.generatePublic(keySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("无此算法");
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException("公钥非法");
        } catch (NullPointerException e) {
            throw new RuntimeException("公钥数据为空");
        }
    }

    /**
     * 从字符串中加载私钥
     *
     * @param privateKeyStr
     *            私钥数据字符串
     * @throws Exception
     */
    public static RSAPrivateKey loadPrivateKeyByStr(String privateKeyStr){
        try {
            byte[] buffer = Base64.getDecoder().decode(privateKeyStr);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(buffer);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("无此算法");
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException("私钥非法");
        } catch (NullPointerException e) {
            throw new RuntimeException("私钥数据为空");
        }
    }

    
    /**
     * 私钥加密过程
     *
     * @param privateKey    私钥
     * @param plainTextData 明文数据
     * @return
     * @throws Exception 加密过程中的异常信息
     */
    public static String encryptByprivateKey(String privateKeyStr, String plainTextData){
    	if(plainTextData ==null){
            throw new RuntimeException("加密数据为空, 请设置");
        }

        if ( privateKeyStr == null || privateKeyStr.isEmpty()) {
            throw new RuntimeException("加密公钥为空, 请设置");
        }


        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            byte[] data = plainTextData.getBytes("UTF-8");
            RSAPrivateKey privateKey = loadPrivateKeyByStr(privateKeyStr);
            // 使用默认RSA
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, privateKey);

            int inputLen = data.length;

            int offSet = 0;
            byte[] cache;
            int i = 0;
            // 对数据分段加密
            while (inputLen - offSet > 0) {
                if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                    cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
                } else {
                    cache = cipher.doFinal(data, offSet, inputLen - offSet);
                }
                out.write(cache, 0, cache.length);
                i++;
                offSet = i * MAX_ENCRYPT_BLOCK;
            }
            byte[] encryptedData = out.toByteArray();
            return new String(Base64.getEncoder().encode(encryptedData));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("无此加密算法");
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException("秘钥可能不对称");
        } catch (InvalidKeyException e) {
            throw new RuntimeException("加密公钥非法,请检查");
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException("明文长度非法");
        } catch (BadPaddingException e) {
            throw new RuntimeException("明文数据已损坏");
        } catch (Exception e){
            LOGGER.error("加密异常", e);
        }finally {
            if(out != null){
                try {
                    out.close();
                }catch (Exception e){
                    //ignore
                }
            }
        }

        return null;
    }


    
    /**
     * 公钥解密过程
     *
     * @param publicKey  公钥
     * @param cipherData 密文数据
     * @return 明文
     * @throws Exception 解密过程中的异常信息
     */
    public static String decryptByPublicKey(String publicKeyStr, String cipherData) {
    	 if(cipherData ==null){
             throw new RuntimeException("解密数据为空, 请设置");
         }

         if (publicKeyStr == null || publicKeyStr.isEmpty()) {
             throw new RuntimeException("解密公钥为空, 请设置");
         }

         ByteArrayOutputStream out = new ByteArrayOutputStream();
         try {
            RSAPublicKey publicKey = loadPublicKeyByStr(publicKeyStr);
             // 使用默认RSA
             Cipher cipher = Cipher.getInstance("RSA");
             cipher.init(Cipher.DECRYPT_MODE, publicKey);
             byte[] encryptedData = Base64.getDecoder().decode(cipherData.getBytes("UTF-8"));
             int inputLen = encryptedData.length;

             int offSet = 0;
             byte[] cache;
             int i = 0;
             // 对数据分段解密
             while (inputLen - offSet > 0) {
                 if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                     cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
                 } else {
                     cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
                 }
                 out.write(cache, 0, cache.length);
                 i++;
                 offSet = i * MAX_DECRYPT_BLOCK;
             }
             byte[] decryptedData = out.toByteArray();
             return new String(decryptedData, "UTF-8");
         } catch (NoSuchAlgorithmException e) {
             throw new RuntimeException("无此解密算法");
         } catch (NoSuchPaddingException e) {
             e.printStackTrace();
             return null;
         } catch (InvalidKeyException e) {
             throw new RuntimeException("解密私钥非法,请检查");
         } catch (IllegalBlockSizeException e) {
             throw new RuntimeException("密文长度非法");
         } catch (BadPaddingException e) {
             throw new RuntimeException("密文数据已损坏");
         } catch (Exception e){
             LOGGER.error("加密异常", e);
         }finally {
             if(out != null){
                 try {
                     out.close();
                 }catch (Exception e){
                     //ignore
                 }
             }
         }

         return null;
    }

    
    /**
     * 密码对
     */
    public static class KeyPairValue{
        /**私钥*/
        private String privateKey;
        /**公钥*/
        private String publicKey;

        public String getPrivateKey() {
            return privateKey;
        }

        public void setPrivateKey(String privateKey) {
            this.privateKey = privateKey;
        }

        public String getPublicKey() {
            return publicKey;
        }

        public void setPublicKey(String publicKey) {
            this.publicKey = publicKey;
        }
    }



}