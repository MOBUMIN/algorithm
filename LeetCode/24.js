/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
 var swapPairs = function(head) {
    const temp = new ListNode(0);
    temp.next = head;
    let index = temp;

    while(index.next && index.next.next) {
        let a = index.next;
        let b = index.next.next;
        a.next = b?.next;

        index.next = b;
        index.next.next = a;
        index = index?.next?.next;
    }
    return temp.next;
};
