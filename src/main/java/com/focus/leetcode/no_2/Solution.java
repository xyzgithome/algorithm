package com.focus.leetcode.no_2;

import java.util.Objects;

/**
 * https://leetcode.cn/problems/add-two-numbers/submissions/518652579/
 */
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

public class Solution {
    public static void main(String[] args) {
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);

        l11.next = l12;
        l12.next = l13;

        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);

        l21.next = l22;
        l22.next = l23;

        new Solution().addTwoNumbers(l11, l21);
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode currentNode = new ListNode();
        ListNode resultNode = currentNode;
        int carry = 0;
        while (Objects.nonNull(l1) || Objects.nonNull(l2)) {
            int val1;
            int val2;

            if (Objects.nonNull(l1)) {
                val1 = l1.val;
                l1 = l1.next;
            } else {
                val1 = 0;
            }

            if (Objects.nonNull(l2)) {
                val2 = l2.val;
                l2 = l2.next;
            } else {
                val2 = 0;
            }

            int add = val1 + val2 + carry;

            currentNode.next = new ListNode(add % 10);
            carry = add / 10;

            currentNode = currentNode.next;
        }

        if (carry > 0) {
            currentNode.next = new ListNode(carry);
        }

        return resultNode.next;
    }
}