/**
* <p>Title: Question2_7.java</p>
* <p>Description: </p>
* @author chenshiyang
* @date Feb 18, 2016
* @version version 1.0
*/
package chapter2;

import java.util.Stack;

/**
 * <p>Title: Question2_7</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Feb 18, 2016
 * @time 4:40:58 PM
 */
public class Question2_7 {
	public boolean isPalindrome(ListNode head){
		if(null == head){
			return false;
		}
		
		Stack<ListNode> stack = new Stack<ListNode>();
		
		//get the middle of the list.
		ListNode fast = head.next;
		ListNode slow = head;
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		
		//odd
		if(null == fast){
			ListNode pointer = head;
			while(pointer != slow){
				stack.push(pointer);
				pointer = pointer.next;
			}
		}
		//even
		else{
			ListNode pointer = head;
			while(pointer != slow){
				stack.push(pointer);
				pointer = pointer.next;
			}
			stack.push(pointer);
		}
		
		//start to compare
		slow = slow.next;
		while(!stack.isEmpty()){
			if(slow.val != stack.pop().val){
				return false;
			}
			slow = slow.next;
		}
		
		return true;
	}
	
	public static void main(String[] args){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(4);
		ListNode n7 = new ListNode(3);
		ListNode n8 = new ListNode(2);
		ListNode n9 = new ListNode(3);
		ListNode n10 = new ListNode(10);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		
		n9.next = null;
		n10.next = null;
		
		Question2_7 so = new Question2_7();
		System.out.println(so.isPalindrome(null));
		System.out.println(so.isPalindrome(n1));
	}
}
