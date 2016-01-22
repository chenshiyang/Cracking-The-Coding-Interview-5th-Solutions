/**
* <p>Title: Question1_1.java</p>
* <p>Description: </p>
* @author chenshiyang
* @date Jan 21, 2016
* @version jdk8.0
*/
package chapter1;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>Title: Question1_1</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Jan 21, 2016
 * @time 4:45:43 PM
 */
public class Question1_1 {
	/**
	* <p>Description: 
	* Use a array to record characters.</p>
	* @param str
	* @return
	*/
	public boolean isUniqueChar(String str){
		if(null == str || str.length() > 128){
			return false;
		}
		
		boolean[] char_table = new boolean[128];
		for(int i = 0; i < str.length(); i ++){
			if(char_table[str.charAt(i)]){
				return false;
			}
			char_table[str.charAt(i)] = true;
		}
		
		return true;
	}
	
	/**
	* <p>Description: Use a set. If all the characters are unique.
	* Then the size of the set should be equal to the length of str.</p>
	* @param str
	* @return
	*/
	public boolean isUniqueChar2(String str){
		if(null == str || str.length() > 128){
			return false;
		}
		
		Set<Character> charSet = new HashSet<Character>();
		for(int i = 0; i < str.length(); i ++){
			charSet.add(str.charAt(i));
		}
		return charSet.size() == str.length();
		
	}
	
	/**
	* <p>Description: The idea is almost the same as method 1.
	* Except that this method use bit to track each character.
	* NOTICE! This method can only solve the problem that the size of character
	* space is at most 31. because int is 32bit long and we can only move left 31 times.</p>
	* @param str
	* @return
	*/
	public boolean isUniqueChar3(String str) {
		if (null == str || str.length() > 128) {
			return false;
		}
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
//			System.out.println("val:" + val);
//			System.out.println("checker & (1 << val)" + (checker & (1 << val)));
			if ((checker & (1 << val)) > 0) return false;
			checker |= (1 << val);//1 move left val bit.
//			System.out.println("checker " + checker);
		}
		return true;
	}
	
	//Another method is to use a map.
	
	public static void main(String[] args){
		String[] tests = {
				"hello",
				"world",
				"abcdefghijklmnopqrstuvwxyz{|}~",
				"abcdefghijklmnopqrstuvwxyz{|}~~"
		};
		
		Question1_1 so = new Question1_1();
		for(String s : tests){
//			System.out.println(s);
			System.out.println(so.isUniqueChar3(s));
		}
	}
}
