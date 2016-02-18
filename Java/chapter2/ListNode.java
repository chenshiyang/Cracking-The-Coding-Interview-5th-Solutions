/**
* <p>Title: ListNode.java</p>
* <p>Description: </p>
* @author chenshiyang
* @date 2015年10月16日
* @version jdk8.0
*/
package chapter2;

/**
 * <p>Title: ListNode</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月16日
 * @time 下午4:31:13
 */
public class ListNode {
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
	
    public static void display(ListNode node){
    	while(null != node){
    		System.out.print(node.val + "->");
    		node = node.next;
    	}
    	System.out.println();
    }
    
    public String toString(){
    	return this.val + "";
    }
}
