package com.common;


/**
 * @auther liuyiming
 * @date 2021/3/27 10:39
 * @description LeetCode ListNode
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int[] nums){
        this.val = nums[0];
        ListNode temp = this;
        for (int i = 1; i < nums.length; i++) {
            temp.next = new ListNode(nums[i]);
            temp = temp.next;
        }

    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString(){
        String str = val+",";
        ListNode temp = this.next;
        while (temp!=null){
            str+=temp.val+(temp.next == null?"":",");
            temp = temp.next;
        }
        return str;
    }

}
