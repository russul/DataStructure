package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: test
 * @date:2018/11/21 0021
 */
public class Test2 {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        ListNode node1 = l1;
        List<Integer> data1 = new ArrayList();
        while (node1 != null) {
            data1.add(node1.val);
            node1 = node1.next;

        }


        ListNode node2 = l2;
        List<Integer> data2 = new ArrayList();
        while (node2 != null) {
            data2.add(node2.val);
            node2 = node2.next;

        }


        List<Integer> sum = new ArrayList<Integer>();
        int plusFlag = 0;

        int length = max(data1.size(), data2.size());
        int length1 = data1.size();
        int length2 = data2.size();

        if (length == length1) {
            int diff = length - data2.size();
            for (int i = 0; i < diff; i++) {
                data2.add(0);
            }

        } else {
            int diff = length - data1.size();
            for (int i = 0; i < diff; i++) {
                data1.add(0);
            }
        }


        for (int i = 0; i < max(data1.size(), data2.size()); i++) {
            int bitSum = 0;
            if (data1.get(i) + data2.get(i) + plusFlag >= 10) {
                bitSum = data1.get(i) + data2.get(i) + plusFlag - 10;
                plusFlag = 1;
            } else {
                bitSum = data1.get(i) + data2.get(i) + plusFlag;
                plusFlag = 0;
            }
            sum.add(bitSum);
        }


        if (plusFlag == 1) {
            sum.add(1);
        }


        List<ListNode> nodes = new ArrayList();
        for (int n = 0; n < sum.size(); n++) {

            ListNode reVal = new ListNode(((Integer) sum.get(n)));
            nodes.add(reVal);
        }


        if (nodes.size() == 1) {
            return nodes.get(0);
        } else if (nodes.size() > 1) {
            ListNode node3 = nodes.get(nodes.size() - 1);

            ListNode node4 = nodes.get(nodes.size() - 2);

            if (nodes.size() == 2) {
                node4.next = node3;
                return node4;
            } else {
                node4.next = node3;
                node3 = node4;
                for (int n = nodes.size() - 3; n >= 0; n--) {

                    node4 = nodes.get(n);
                    node4.next = node3;
                    node3 = node4;


                }
                return node4;

            }
        } else {
            return null;
        }

    }


    int max(int a, int b) {

        return a >= b ? a : b;

    }

}
