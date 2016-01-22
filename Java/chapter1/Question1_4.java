/**
* <p>Title: Question1_4.java</p>
* <p>Description: </p>
* @author chenshiyang
* @date Jan 21, 2016
* @version jdk8.0
*/
package chapter1;

/**
 * <p>Title: Question1_4</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Jan 21, 2016
 * @time 10:53:51 PM
 */
public class Question1_4 {
	/**
	* <p>Description: 
	* First traverse, count the number of valid space
	* second traverse, traverse the array from the actual end, copy the
	* character to the new place.</p>
	* @param carray
	* @param len
	* @return
	*/
	public char[] replaceSpaces(char[] carray, int len){
		//count the valid space.
		int spaceCount = 0;
		for(int i = 0; i < len; i ++){
			if(' ' == carray[i]){
				spaceCount ++;
			}
		}
		int newLen = len + spaceCount * 2;
		int newIdx = newLen - 1;
		for(int i = len - 1; i >=0; i --){
			if(' ' != carray[i]){
				carray[newIdx] = carray[i];
				newIdx --;
			}
			else{
				carray[newIdx -- ] = '0';
				carray[newIdx -- ] = '2';
				carray[newIdx -- ] = '%';
			}
		}
		
		return carray;
	}
	
	public static void main(String[] args){
		Question1_4 so = new Question1_4();
		char[][] tests = {
				"I am csy    ".toCharArray(),
				"Hi ,  L J        ".toCharArray()
		};
		int[] len = {8, 9};
		for(int i = 0; i < tests.length; i ++){
			System.out.println(so.replaceSpaces(tests[i], len[i]));
		}
	}
}
