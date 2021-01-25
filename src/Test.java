import sun.misc.BASE64Decoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.IOException;
import java.security.SecureRandom;


public class Test {
        public static void main(String[] args) {


//        Random random = new Random();
//        String[] b = {"饭", "面", "麦当劳"};
//        int a = random.nextInt(b.length);
//        System.out.println(b[a]);

//        String test = "1,2,3,4,";
////
////        String[] StrArr = test.split(",");
////
////        for (int i = 0; i <StrArr.length ; i++) {
////            System.out.println(StrArr[i]);
////
////        }

//        BigDecimal  bigDecimal = new BigDecimal(10) ;
//
//
//        System.out.println(bigDecimal+"");

//        if(null !=1){
//
//        }


        BASE64Decoder decoder = new BASE64Decoder();
        try {
            byte[] buf = decoder.decodeBuffer("ZTHZL6sakf83VJenQzVPiA==");

            byte[] bt = new byte[0];
            try {
                bt = decrypt(buf, "aiways2019".getBytes("GBK"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            String  a = new String(bt, "GBK");
            System.out.println(a);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();

        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);

        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey securekey = keyFactory.generateSecret(dks);

        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance("DES");

        // 用密钥初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);

        return cipher.doFinal(data);
    }
}
