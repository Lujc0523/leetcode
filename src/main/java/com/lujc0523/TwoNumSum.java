package com.lujc0523;

import java.util.List;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 *
 * <p>
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 */
public class TwoNumSum {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(4, l1);
        ListNode l3 = new ListNode(2, l2);

        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(6, l4);
        ListNode l6 = new ListNode(5, l5);
        ListNode listNode = addTwoNumbers(l3, l6);
        ListNode temp = listNode;
        do {
            System.out.println(temp.val);
            temp = temp.next;
        } while (temp != null);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode next1 = l1;
//        ListNode next2 = l2;
//        List<Integer> resultTemp = new ArrayList<>();
//        resultTemp.add(0);
//        int index = 0;
//        do {
//            int val1 = next1 == null ? 0 : next1.val;
//            int val2 = next2 == null ? 0 : next2.val;
//            next1 = next1 == null ? null : next1.next;
//            next2 = next2 == null ? null : next2.next;
//            String temp = val1 + val2 + resultTemp.get(index) + "";
//            char[] chars = temp.toCharArray();
//            if (chars.length==1) {
//                resultTemp.remove(index);
//                resultTemp.add(Integer.parseInt(chars[0] + ""));
//            }else {
//                int tempInt = Integer.parseInt(chars[1] + "");
//                resultTemp.remove(index);
//                resultTemp.add(index, tempInt);
//                resultTemp.add(Integer.parseInt(chars[0] + ""));
//            }
//            index++;
//        } while (next1 != null || next2 != null);
//        Collections.reverse(resultTemp);
//        ListNode listNode = new ListNode(resultTemp.get(0));
//        ListNode node = createNode(resultTemp, 1, listNode);
//        return node;
        if (l1 == null && l2 == null) return null;
        if (l1 == null) l1 = new ListNode(0);
        if (l2 == null) l2 = new ListNode(0);

        int sum = l1.val + l2.val;
        if (sum > 9) {
            if (l1.next == null) l1.next = new ListNode(0);
            l1.next.val++;
            return new ListNode(sum % 10, addTwoNumbers(l1.next, l2.next));
        }
        return new ListNode(sum, addTwoNumbers(l1.next, l2.next));
    }

    public static ListNode createNode(List<Integer> source, int index, ListNode listNode) {
        if (index == source.size()) {
            return listNode;
        }
        ListNode temp = new ListNode(source.get(index), listNode);
        return createNode(source, index + 1, temp);
    }

    public static class ListNode {
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
}
