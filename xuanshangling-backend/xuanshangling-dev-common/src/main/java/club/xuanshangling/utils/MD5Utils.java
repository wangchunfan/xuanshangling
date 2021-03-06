package club.xuanshangling.utils;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Base64;

/**
 * @Author: wangcf
 * @Date: 2019/6/16 0:10
 * @Description 对用户密码进行加密保存
 */
public class MD5Utils {

    public static String getMD5Str(String strValue) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        String newStr = Base64.encodeBase64String(md5.digest(strValue.getBytes()));
        return newStr;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(MD5Utils.getMD5Str("wangchunfan"));
        System.out.println(MD5Utils.getMD5Str("wangchunfan1"));
    }
}
