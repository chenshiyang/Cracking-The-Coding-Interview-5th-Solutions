/**
* <p>Title: Question1_8.java</p>
* <p>Description: </p>
* @author chenshiyang
* @date Jan 22, 2016
* @version jdk8.0
*/
package chapter1;

/**
 * <p>Title: Question1_8</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Jan 22, 2016
 * @time 4:41:09 PM
 */
public class Question1_8 {
	/**
	* <p>Description: </p>
	* @param str1
	* @param str2
	* @return
	*/
	public boolean isRotation(String str1, String str2){
		if(null == str1 && null == str2){
			return true;
		}
		
		if(null == str1 || null == str2 || str1.length() != str2.length()){
			return false;
		}
		
		String doubleStr1 = str1 + str1;		
		return isSubstring(doubleStr1, str2);
	}
	
	/**
	* <p>Description: A temporary substring checker. </p>
	* @param father
	* @param son
	* @return
	*/
	public boolean isSubstring(String father, String son){
		if(father.indexOf(son) > 0){
			return true;
		}
		else{
			return false;
		}
	}
	
	public static void main(String[] args){
		Question1_8 so = new Question1_8();
		String[] fathers = {
				"hello",
				"world",
				"world",
				"csy"
		};
		String[] sons = {
				"llohe",
				"warl",
				"wrold",
				null
		};
		
		System.out.println(so.isRotation(null, null));
		for(int i = 0; i < fathers.length; i ++){
			System.out.println(so.isRotation(fathers[i], sons[i]));
		}
	}
}
