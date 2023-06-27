/**
 * Definition for singly-linked list.
 * class ListNode {
 *     val: number
 *     next: ListNode | null
 *     constructor(val?: number, next?: ListNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.next = (next===undefined ? null : next)
 *     }
 * }
 */

function partition(head: ListNode | null, x: number): ListNode | null {
    const smallerHead = new ListNode(0);
    let smallerTail = smallerHead;
    const greaterHead = new ListNode(0);
    let greaterTail = greaterHead;
    
    while (head) {
        if (head.val < x) {
            smallerTail.next = head;
            smallerTail = smallerTail.next;
        } else {
            greaterTail.next = head;
            greaterTail = greaterTail.next;
        }
        head = head.next;
    }
    
    greaterTail.next = null;
    
    smallerTail.next = greaterHead.next;
    
    return smallerHead.next;
};
