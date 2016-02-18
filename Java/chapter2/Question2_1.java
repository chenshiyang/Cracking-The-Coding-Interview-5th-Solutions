/**
* <p>Title: Question2_1.java</p>
* <p>Description: </p>
* @author chenshiyang
* @date Jan 22, 2016
* @version jdk8.0
*/
package chapter2;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Title: Question2_1</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Jan 22, 2016
 * @time 8:42:54 PM
 */
public class Question2_1 {
	class ListNode{
		ListNode next = null;
		int val;
		
		public ListNode(int val){
			this.val = val;
		}
		
		public String display(){
			StringBuilder sb = new StringBuilder();
			ListNode head = this;
			while(head != null){
				sb.append(head.val + "->");
				head = head.next;
			}
			sb.append("\n");
			return sb.toString();
		}
	}
	
	/**
	* <p>Description: Use a hashmap to remove duplicates.</p>
	* @param head
	* @return
	*/
	public ListNode removeDuplicates(ListNode head){
		if(null == head){
			return head;
		}
		
		ListNode start = head;
		Map<Integer, Integer> table = new HashMap<Integer, Integer>();
		ListNode prev = head;
		head = head.next;
		while(head != null){
			if(table.get(head.val) != null){
				head = head.next;
			}
			else{
				table.put(head.val, 0);
				prev.next = head;
				prev = head;
				head = head.next;
			}
		}
		prev.next = null;//very important.
		
		return start;
	}
	
	public static void main(String[] args){
		Question2_1 so = new Question2_1();
		Question2_1.ListNode n1 = so.new ListNode(1);
		Question2_1.ListNode n2 = so.new ListNode(2);
		Question2_1.ListNode n3 = so.new ListNode(3);
		Question2_1.ListNode n4 = so.new ListNode(4);
		Question2_1.ListNode n5 = so.new ListNode(2);
		Question2_1.ListNode n6 = so.new ListNode(4);
		Question2_1.ListNode n7 = so.new ListNode(4);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		
		System.out.println(n1.display());
		System.out.println(so.removeDuplicates(n1).display());
	}
	
}
