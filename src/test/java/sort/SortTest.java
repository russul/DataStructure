package sort;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: sort
 * @date:2018/12/26 0026
 */
public class SortTest {

    @Test
    public void mergeSort_Recursive() {

        int[] arr = new int[]{2, 4, 6, 7, 1, 4, 35, 65, 3, 5};

        Sort sort = new Sort();
//        for (int i:arr
//             ) {
//            System.out.print(i+" ");
//        }
//        sort.mergeSort_Recursive(arr,0,arr.length-1);
//        System.out.println();
//        for (int i:arr
//                ) {
//            System.out.print(i+" ");
//        }


        for (int i : arr
                ) {
            System.out.print(i + " ");
        }

        sort.mergeSort_NonRecursive(arr);
        System.out.println();

        for (int i : arr
                ) {
            System.out.print(i + " ");
        }

    }
}