package util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class CheckUtil {
	private static final String token="12030lmc";
   public static boolean checkSignature(String signature,String timestamp,String nonce) throws UnsupportedEncodingException, NoSuchAlgorithmException {
	   String[] arr=new String[] {token,timestamp,nonce};
	   //
	   Arrays.sort(arr);
	   
	   StringBuffer content =new StringBuffer();
	   for(int i=0;i<arr.length;i++) {
		   content.append(arr[i]);
	   }
	   //sha1 ¼ÓÃÜ
		String temp =getSha1(content.toString());
	   return temp.equals(signature);
   }
   public static String getSha1(String str) throws UnsupportedEncodingException, NoSuchAlgorithmException {
	    if (null == str || str.length() == 0){
	        return null;
	    }
	    char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
	            'a', 'b', 'c', 'd', 'e', 'f'};
	    try {
	        MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
	        mdTemp.update(str.getBytes("UTF-8"));

	        byte[] md = mdTemp.digest();
	        int j = md.length;
	        char[] buf = new char[j * 2];
	        int k = 0;
	        for (int i = 0; i < j; i++) {
	            byte byte0 = md[i];
	            buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
	            buf[k++] = hexDigits[byte0 & 0xf];
	        }
	        return new String(buf); 
	    }
	    catch(Exception e) {
	    	e.printStackTrace();
	    	return null;
	    }
	}
}
