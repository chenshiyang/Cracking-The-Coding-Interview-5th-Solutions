/**
* <p>Title: Question1_5.java</p>
* <p>Description: </p>
* @author chenshiyang
* @date Jan 22, 2016
* @version jdk8.0
*/
package chapter1;

/**
 * <p>Title: Question1_5</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Jan 22, 2016
 * @time 10:04:20 AM
 */
public class Question1_5 {
	/**
	* <p>Description: Compression string using the counts of repeated characters.
	* For example "aabcccccaaa" should be compressed as "a2b1c5a3".</p>
	* @param str
	* @return
	*/
	public String stringCompression(String str){
		if(null == str || str.length() < 1){
			return str;
		}
		
		StringBuilder sb = new StringBuilder();
		char prev = str.charAt(0);
		int count = 1;
		for(int i = 1; i < str.length(); i ++){
			if(str.charAt(i) == prev){
				count ++;
			}
			else{
				sb.append(prev).append(count);
				prev = str.charAt(i);
				count = 1;
			}
		}
		sb.append(prev).append(count);
		
		return str.length() > sb.length() ? sb.toString() : str;
	}
	
	/**
	* <p>Description: Compression string. If a char has only consecutively occured
	* 1 times, then the '1' can be omitted.
	* For example. "aabcccccaaa" should be compressed as "a2bc5a3".</p>
	* @param str
	* @return
	*/
	public String stringCompression2(String str){
		if(null == str || str.length() < 2){
			return str;
		}
		
		StringBuilder sb = new StringBuilder();
		char prev = str.charAt(0);
		int count = 1;
		for(int i = 1; i < str.length(); i ++){
			if(str.charAt(i) == prev){
				count ++;
			}
			else{
				sb.append(prev);
				if(count >1){
					sb.append(count);
				}
				prev = str.charAt(i);
				count = 1;
			}
		}
		sb.append(prev);
		if(count >1){
			sb.append(count);
		}
		
		return str.length() > sb.length() ? sb.toString() : str;
	}
	
	public static void main(String[] args){
		Question1_5 so = new Question1_5();
		String[] tests = {
				"aabcccccaaa",
				"hello",
				"java"
		};
		
		for(String s : tests){
			System.out.println(so.stringCompression(s));
			System.out.println(so.stringCompression2(s));
		}
	}
}
