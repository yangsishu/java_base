package util;

import java.util.regex.Pattern;

/**
 * 
 * @author sishu.yss
 * 贪婪模式的正则转化为非贪婪模式
 *
 */
public class PatternUtil {

	   private static Pattern pa = Pattern.compile("^\\d+,*\\d*");
   
	   public static String greedyToReluctant(String pattern){
		   StringBuffer sb = new StringBuffer();
		   char[] cs = pattern.toCharArray();
		   boolean flag = true;
		   int start = 0;
		   for(int i=0;i<cs.length;i++){
			   char c = cs[i];
			   sb.append(c);
			   if((i-1)>=0&&(i+1)<cs.length&&(c == '*'||c=='+')&&cs[i-1]!='\\'&&cs[i+1]!='?'){
				   sb.append("?");
			   }else if(c=='?'&&questionMark(cs,i)){
				   sb.append("?");
			   }else if((i-1)>=0&&c =='{'&&cs[i-1]!='\\'){
				   flag = !flag;
				   start = i+1;
			   }else if((i-1)>=0&&c =='}'&&cs[i-1] != '\\'&&!flag){
				   if(find(pattern.substring(start, i))){
					   sb.append("?");
				   }
				   flag = !flag;
				   start = 0;
			   }
		   }
		   return sb.toString();
	   }
	   
	   private static boolean questionMark(char[] cs, int i){
		   if((i-1)>=0&&(i+1)<cs.length){
			   if(cs[i+1]!='<'&&cs[i+1]!='?'&& cs[i+1]!=':'&&cs[i+1]!='='&&cs[i+1]!='!'){
				   if(cs[i-1]!='\\'&&cs[i-1]!='+'&&cs[i-1]!='*'&&cs[i-1]!='?'){
					   return true;
				   }else if((cs[i-1]=='+'||cs[i-1]=='*'||cs[i-1]=='?')&&(i-2)>=0&&cs[i-2]=='\\'){
					   return true;
				   }
			   }
		   }
		   return false;
	   }
	   
	   private static boolean find(String source){
		  return pa.matcher(source).find();
	   }
}
