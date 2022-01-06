package leetCode;

/* 2. 两数相加
 * 示例 1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 
 * 示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * */

public class Q2 {
	class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// declare the head and tail of the result list
		ListNode head = null, tail = null;

		int carry = 0;

		while (l1 != null || l2 != null) // while one of the list is not end
		{
			// if one of the lists ends regard its value as 0
			int n1 = l1 != null ? l1.val : 0;
			int n2 = l2 != null ? l2.val : 0;

			int sum = n1 + n2 + carry;
			carry = sum / 10; // new carry

			// update head and tail
			if (head == null) // initialize both head and tail as the same node
				head = tail = new ListNode(sum % 10); // sum % 10 is the value stored inside the node
			else {
				tail.next = new ListNode(sum % 10); // create new node to store the value
				tail = tail.next; // update tail to be the last node
			}

			// increment the position in two input lists
			// update l1, l2 to be the next node for next iteration
			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;
		}
		if (carry > 0) // create a new node to store the extra carry
			tail.next = new ListNode(carry);

		return head; // return the first node of the sum list
	}
}
