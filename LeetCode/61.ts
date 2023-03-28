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

function rotateRight(head: ListNode | null, k: number): ListNode | null {
    if(head === null) return head;
    let length = 1;
    let lastNode = head;
    while(lastNode.next !== null) {
        lastNode = lastNode.next;
        length++;
    }
    k = k % length;
    if(k === 0) return head;

    let targetNode = head;
    for(let i=0; i<length-k-1; i++) {
        targetNode = targetNode.next;
    }
    const next = targetNode.next;
    lastNode.next = head;
    targetNode.next = null;

    return next;
}
