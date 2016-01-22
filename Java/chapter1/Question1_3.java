/**
* <p>Title: Question1_3.java</p>
* <p>Description: </p>
* @author chenshiyang
* @date Jan 21, 2016
* @version jdk8.0
*/
package chapter1;

import java.util.Arrays;

/**
 * <p>Title: Question1_3</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Jan 21, 2016
 * @time 7:26:15 PM
 */
public class Question1_3 {
	/**
	* <p>Description: Use a array to record the frequency of characters.</p>
	* @param str1
	* @param str2
	* @return
	*/
	public boolean isPermutation(String str1, String str2){
		if(null == str1 && null == str2){
			return true;
		}
		if(null == str1 || null == str2 || str1.length() != str2.length()){
			return false;
		}
		
		//Assume that  there are only 256 unique characters.
		int[] charArray = new int[256];
		for(int i = 0; i < str1.length(); i ++){
			charArray[str1.charAt(i)] += 1;
		}
		for(int i = 0; i < str2.length(); i ++){
			charArray[str2.charAt(i)] -= 1;
			if(charArray[str2.charAt(i)] < 0){
				return false;
			}
		}
		for(int i : charArray){
			if(i != 0){
				return false;
			}
		}
		
		return true;
	}
	
	/**
	* <p>Description: Sort the two char array, then compare.</p>
	* @param str1
	* @param str2
	* @return
	*/
	public boolean isPermutation2(String str1, String str2){
		if(null == str1 && null == str2){
			return true;
		}
		
		if(null == str1 || null == str2 || str1.length() != str2.length()){
			return false;
		}
		
		char[] cstr1 = str1.toCharArray();
		Arrays.sort(cstr1);
		char[] cstr2 = str2.toCharArray();
		Arrays.sort(cstr2);
		for(int i = 0; i < cstr1.length; i ++){
			if(cstr1[i] != cstr2[i]){
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args){
		Question1_3 so = new Question1_3();
		String[] test1 = {
				"hello",
				"world"
		};
		String[] test2 = {
				"lehlo",
				"wardl"
		};
		for(int i = 0; i < test1.length; i ++){
			System.out.println(so.isPermutation2(test1[i], test2[i]));
		}
		System.out.println(so.isPermutation2(null, null));
	}
}
