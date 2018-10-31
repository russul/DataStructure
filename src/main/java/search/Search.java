package search;

import java.util.Arrays;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: search
 * @date:2018/10/30
 */
public class Search {

    public static BiTNode current = null;

    /*
     *
     *
     * @author kevin
     * @date 2018/10/30 10:19
     * @param [key]
     * @return void
     * @description 顺序表查找
     */
    public static int sequential_Search(int[] collection, int key) {

        /*用数组（线性表）存在查找表集合，key是要查找的关键字*/
        /*当查找复杂表结构记录时，只要把数组collection和关键字定义成你所需要的类型即可*/
        for (int i = 0; i < collection.length; i++) {
            if (collection[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static int binary_Search(int[] collection, int key) {
        int low;
        int high;
        int mid;
        low = 0;
        high = collection.length - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (key < collection[mid]) {
                high = mid - 1;
            } else if (key > collection[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        /*查询失败*/
        return -1;
    }


    public static int interpolation_Search(int[] collection, int key) {
        int low;
        int high;
        int mid;
        low = 0;
        high = collection.length - 1;
        while (low <= high) {
            mid = low + (high - low) * ((key - collection[low]) / (collection[high] - collection[low]));
            if (key < collection[mid]) {
                high = mid - 1;
            } else if (key > collection[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        /*查询失败*/
        return -1;
    }


    public static int fibonacciSearch(int[] collection, int key) {
        int[] fibo = generateFibonacci(10);   /*生成一个斐波那契数组*/
        int low = 0;         /*low的初始值*/
        int high = collection.length - 1;   /*high的初始值*/
        int k = 0;
        while (collection.length > fibo[k] - 1) {   /*寻找合适的斐波那契数fibo[k]-1,这就是用斐波那契查找的查找表的长度*/
            k++;
        }

        int[] temp = Arrays.copyOf(collection, fibo[k] - 1);
        for (int i = collection.length - 1; i < fibo[k] - 1; i++) {     /*将有序表的长度用最后一个元素值将斐波那契查找表填充完全*/
            temp[i] = collection[collection.length - 1];
        }


        /*查找过程*/
        while (low <= high) {
            /*这里用fibo[k-1]而不是fibo[k]，是因为在上面的选择斐波那契查找表的长度时当k跳出while循环时多加了1*/
            int mid = low + fibo[k - 1] - 1;
            if (key < temp[mid]) {
                high = mid - 1;
                k = k - 1;
            } else if (key > temp[mid]) {
                low = mid + 1;
                k = k - 2;
            } else {
                if (mid < collection.length - 1) {
                    return mid;
                } else {      /*mid>原始数据的最后一个的索引，那么它必然找到的是原始最后一个元素（它是在斐波那契查找表中找到的）*/
                    return collection.length - 1;
                }
            }
        }
        return -1;
    }


    public static int fibonacci_Search(int[] collection, int key) {
        int[] fibo = generateFibonacci(10);   /*生成一个斐波那契数组*/
        int low = 0;         /*low的初始值*/
        int high = collection.length - 1;   /*high的初始值*/
        int k = 0;
        while (collection.length > fibo[k]) {   /*寻找合适的斐波那契数fibo[k]-1,这就是用斐波那契查找的查找表的长度*/
            k++;
        }

        int[] temp = Arrays.copyOf(collection, fibo[k]);
        for (int i = collection.length - 1; i < fibo[k]; i++) {     /*将有序表的长度用最后一个元素值将斐波那契查找表填充完全*/
            temp[i] = collection[collection.length - 1];
        }


        /*查找过程*/
        while (low <= high) {
            /*这里用fibo[k-1]而不是fibo[k]，是因为在上面的选择斐波那契查找表的长度时当k跳出while循环时多加了1*/
            int mid = low + fibo[k - 1] - 1;
            if (key < temp[mid]) {
                high = mid - 1;
                k = k - 1;
            } else if (key > temp[mid]) {
                low = mid + 1;
                k = k - 2;
            } else {
                if (mid < collection.length - 1) {
                    return mid;
                } else {      /*mid>原始数据的最后一个的索引，那么它必然找到的是原始最后一个元素（它是在斐波那契查找表中找到的）*/
                    return collection.length - 1;
                }
            }
        }
        return -1;
    }

    /*
     *
     *
     * @author kevin
     * @date 2018/10/30 14:36
     * @param [length]
     * @return int[]
     * @description 斐波那契数列用迭代（循环）的方式产生
     */
    private static int[] generateFibonacci(int length) {
        int[] fibo = new int[length];
        fibo[0] = 0;
        fibo[1] = 1;
        int count = 2;
        while (count != fibo.length) {
            fibo[count] = fibo[count - 1] + fibo[count - 2];
            count++;
        }
        return fibo;
    }

    /*
     *
     *
     * @author kevin
     * @date 2018/10/30 14:36
     * @param [n]
     * @return int
     * @description 斐波那契数用递归方式产生
     */
    private static int fibo(int n) {
        /*递归的出口条件*/
        if (n < 2) {
            return n == 0 ? 0 : 1;
        }

        return fibo(n - 1) + fibo(n - 2);
    }


    public static String searchBST(BiTNode root, int key, BiTNode parent) {
        if (root == null) {
            Search.current = parent;
            return "FALSE";
        } else if (key == (int) ((Integer) root.getData())) {
            Search.current = root;
            return "TRUE";
        } else if (key < (Integer) root.getData()) {
            return searchBST(root.getLeftChild(), key, root);
        } else {
            return searchBST(root.getRightChild(), key, root);
        }
    }

    public static BiTNode searchBST(BiTNode root, int key, BiTNode parent, BiTNode current) {
        if (root == null) {
            current = parent;
            System.out.println("FALSE");
            return current;
        } else if (key == (int) ((Integer) root.getData())) {
            current = root;
            System.out.println("TRUE");
            return current;
        } else if (key < (Integer) root.getData()) {
            return searchBST(root.getLeftChild(), key, root, current);
        } else {
            return searchBST(root.getRightChild(), key, root, current);
        }
    }


    public static BiTNode insertBST(BiTNode root, int key) {

        BiTNode s;
        if (searchBST(root, key, null).equals("FALSE")) {
            s = new BiTNode();
            s.setData(key);
            s.setLeftChild(null);
            s.setRightChild(null);

            if (Search.current == null) {
                root = s;
            } else if (key < (Integer) Search.current.getData()) {
                Search.current.setLeftChild(s);
            } else {
                Search.current.setRightChild(s);
            }

            System.out.println("true");
        } else {
            System.out.println("false");
        }

        return root;
    }

    public static BiTNode insertBST2(BiTNode root, int key) {

        BiTNode s;
        BiTNode p = new BiTNode();
        BiTNode current = searchBST(root, key, null, p);
        if (current == null) {
            s = new BiTNode();
            s.setData(key);
            s.setLeftChild(null);
            s.setRightChild(null);

            root = s;
            System.out.println("true");
            return root;
        }
        if (key != (Integer) current.getData()) {
            s = new BiTNode();
            s.setData(key);
            s.setLeftChild(null);
            s.setRightChild(null);

            if (key < (Integer) current.getData()) {
                current.setLeftChild(s);
            } else {
                current.setRightChild(s);
            }

            System.out.println("true");
            return root;
        } else {
            System.out.println("false");
            return root;
        }


    }
}
