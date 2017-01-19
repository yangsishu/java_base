package util;

import java.nio.ByteBuffer;


public class HexStringUtil {
	  public static String toHexStr(byte[] bytes,int size) { 
	    StringBuffer sb = new StringBuffer(3*size);
	    for (int idx = 0; idx < size; idx++) {
	      // if not the first, put a blank separator in
	      if (idx != 0) {
	        sb.append(' ');
	      }
	      String num = Integer.toHexString(0xff & bytes[idx]);
	      // if it is only one digit, add a leading 0.
	      if (num.length() < 2) {
	        sb.append('0');
	      }
	      sb.append(num);
	    }
	    return sb.toString();
	  }
	  
	  public static  byte[] fromHexStr(String  hexString) { 
		if (hexString == null)
			return null;
		
		ByteBuffer  buffer=ByteBuffer.allocate((hexString.length()+1)/3);

		//try{
		for (String hexByte : hexString.split(" ")) {
			buffer.put(Integer.valueOf(hexByte, 16).byteValue());
		}
	
		
		return buffer.array();  
		}
	  
	  
	  public static void main(String[] args) {
		byte[] aa={(byte)5,(byte)123,(byte)255,(byte)87,(byte)-2};
		String hexString=toHexStr(aa,aa.length);
		System.out.println(hexString);
		byte[] bb=fromHexStr(hexString);
		
		System.out.println(bb);
	}
}