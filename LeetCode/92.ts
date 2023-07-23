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

class ListNode {
	val: number
	next: ListNode | null
	constructor(val?: number, next?: ListNode | null) {
		this.val = (val===undefined ? 0 : val)
		this.next = (next===undefined ? null : next)
	}
}

function reverseBetween(head: ListNode | null, left: number, right: number): ListNode | null {
    if(!head) return head;

    const headPtr = new ListNode(0, head);
    let prev: ListNode = headPtr;
    for(let i=0; i<left-1; i++) prev = prev.next!;

    let current: ListNode  | null = prev.next;
    let next: ListNode | null = null;
    let end: ListNode | null = current;

    for (let i = 0; i <= right - left; i++) {
        next = current!.next;
        current!.next = prev.next;
        prev.next = current;
        current = next;
    }

    if(end) end.next = current;

    return headPtr.next;
};