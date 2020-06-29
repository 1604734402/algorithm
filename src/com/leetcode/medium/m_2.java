package com.leetcode.medium;


public class m_2 {
	public static void main(String[] args) {
		ListNode node11 = new ListNode(2);
		ListNode node12 = new ListNode(4);
		ListNode node13 = new ListNode(3);
		node11.next = node12;
		node12.next = node13;
		ListNode node21 = new ListNode(5);
		ListNode node22 = new ListNode(6);
		ListNode node23 = new ListNode(4);
		node21.next = node22;
		node22.next = node23;
		ListNode node = addTwoNumbers(node11,node21);
		while(true) {
			if (node.next == null) {
				break;
			}
			
			node = node.next;
			
		}
	}
	
public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        
        int l1sum = 1;
        int l2sum = 1;
        ListNode l1node1 = l1;
        ListNode l2node1 = l2;
        while(true){
            if(l1node1.next == null && l2node1.next ==null){
                break;
            }
            if(l1node1.next != null){
                
            	l1node1 = l1node1.next;
                l1sum++;
            }
            if(l2node1.next != null){
                
            	l2node1 = l2node1.next;
                l2sum++;
            }
        }
        
        ListNode l1node2 = l1;
        ListNode l2node2 = l2;
        int l11 = 0;
        int l22 = 0;
        int array1[] = new int[l1sum];
        int array2[] = new int[l2sum];
        array1[l11] = l1node2.val;
        array2[l22] = l2node2.val;
        while(true){
            if(l1node2.next == null && l2node2.next ==null){
                break;
            }
            if(l1node2!= null){
                l11++;
                l1node2 = l1node2.next;
                array1[l11] = l1node2.val;

            }
            if(l2node2.next != null){
                l22++;
                l2node2 = l2node2.next;
                array2[l22] = l2node2.val;
            }
        }

        
        int sum1 = 0;
        int num1  =0;
        for(int i = 0;i<=l11;i++){
            if(i == 0){
                num1 += array1[i];
            }else{
            	int cheng = 1;
            	for(int ii = 1;ii<=i;ii++) {
            		cheng *= 10;
            	}
                num1 += array1[i]*cheng;
            }
        }
        
        int sum2 = 0;
        int num2  =0;
        for(int i = 0;i<=l22;i++){
            if(i == 0){
                num2 += array2[i];
            }else{
            	int cheng = 1;
            	for(int ii = 1;ii<=i;ii++) {
            		cheng *= 10;
            	}
            	
                num2 += array2[i]*cheng;
            }
            
        }
        	
        
        String sum = (num1+num2)+"";
        String arraysum[] = sum.split("");
        ListNode headnode = new ListNode(0);
        ListNode cur = headnode;
        ListNode next = null;
        for(int i = arraysum.length-1;i>=0;i--){
            ListNode sumnode = new ListNode(Integer.valueOf(arraysum[i]));
            cur.next = sumnode;
            headnode.next = cur.next.next;
            cur = headnode;
            next = headnode;
        }
        
        System.out.println("``````````````````````");
        
        return next;
    }
        
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}