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

function deleteDuplicates(head: ListNode | null): ListNode | null {
    let node = head;
    let before = {val: null, next: head};
    while(node?.next) {
        let flag = false;
        while(node.val === node.next?.val) {
            node.next = node.next?.next;
            flag = true;
        }
        if(flag){
            if(node == head) head = head.next;
            before.next = node.next;
            node = node.next;
        }else {
            before = node;
            node = node.next;
        }
    }
    return head;
};
