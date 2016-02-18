/**
* <p>Title: Question2_6.java</p>
* <p>Description: </p>
* @author chenshiyang
* @date Feb 18, 2016
* @version jdk8.0
*/
package chapter2;

/**
 * <p>Title: Question2_6</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Feb 18, 2016
 * @time 3:23:55 PM
 */
public class Question2_6 {
	
	/**
	* <p>Description: Detect if a linked list has a loop.</p>
	* @param head
	* @return
	*/
	public boolean hasLoop(ListNode head){
		ListNode fastRunner = head;
		ListNode slowRunner = head;
		
		while(fastRunner != null && fastRunner.next != null){
			fastRunner = fastRunner.next.next;
			slowRunner = slowRunner.next;
			
			if(fastRunner == slowRunner){
				return true;
			}
		}
		
		return false;
	}
	
	/**
	* <p>Description: If a linked list has a loop, return the first node of the loop,
	* else return null.</p>
	* @param head
	* @return
	*/
	public ListNode getLoopBegining(ListNode head){
		if(! hasLoop(head)){
			return null;
		}
		
		ListNode fastRunner = head.next.next;
		ListNode slowRunner = head.next;
		
		while(fastRunner != slowRunner){
			fastRunner = fastRunner.next.next;
			slowRunner = slowRunner.next;
		}
		
		fastRunner = head;
		while(fastRunner != slowRunner){
			fastRunner = fastRunner.next;
			slowRunner = slowRunner.next;
		}
		
		return fastRunner;
	}
	
	public static void main(String[] args){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		ListNode n8 = new ListNode(8);
		ListNode n9 = new ListNode(9);
		ListNode n10 = new ListNode(10);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n1;
		
		n9.next = n10;
		n10.next = null;
		
		Question2_6 so = new Question2_6();
		System.out.println(so.hasLoop(n1));
		System.out.println(so.getLoopBegining(n1).val);
		n8.next = n9;
		System.out.println(so.hasLoop(n1));
	}
}
