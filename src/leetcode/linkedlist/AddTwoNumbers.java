package leetcode.linkedlist;
import leetcode.util.ListNode;

/*

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

 */


public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {



       /* if (l1.next == null && l2.next == null) {
            ListNode sum = l1.val + l2.val;
            sum.next = null;
            return sum;
        }

*/
        ListNode ptr1 = l1;
        ListNode ptr2 = l2;

        ListNode temp = new ListNode(0);
        ListNode copy = temp;
        int carry = 0;
        int unitSum = 0; int x, y;

        while (ptr1 != null || ptr2 != null) {

            if (ptr1 != null) {
                x = ptr1.val;
            } else {
                x = 0;
            }

            if (ptr2 != null) {
                y = ptr2.val;
            } else {
                y = 0;
            }

            unitSum = x + y + carry;

            if (unitSum < 10) {
                temp.next = new ListNode(unitSum);
                carry = 0;
            } else {
                temp.next = new ListNode(unitSum - 10);
                carry = 1;
            }

            temp = temp.next;

            if (ptr1 != null) {
                ptr1 = ptr1.next;
            }

            if(ptr2 != null) {
                ptr2 = ptr2.next;
            }
        }

        if (carry > 0) {
            temp.next = new ListNode(carry);
        }

        return copy.next;
    }
}
