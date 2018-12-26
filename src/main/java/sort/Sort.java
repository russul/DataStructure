package sort;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: sort
 * @date:2018/12/26 0026
 */
public class Sort {



    /*
     *
     *
     * @author kevin
     * @date 2018/12/26 0026 19:52
     * @param [arr, start, end]
     * arr:待排序数组
     * start：待排序数组的起始索引
     * end：待排序数组的终止索引
     * @return void
     * @description
     */
    public void mergeSort_Recursive(int[] arr, int start, int end) {

        if (start < end) {
            int among = (start + end) / 2;
            mergeSort_Recursive(arr, start, among);
            mergeSort_Recursive(arr, among + 1, end);
            merge(arr, start, among, end);
        }

    }


    public void mergeSort_NonRecursive(int[] arr){

        int k = 1;

        while (k<arr.length){
            mergePass(arr,k,arr.length);
            k = k*2;
        }

    }


    //将数字中相邻长度为k的子序列两两合并
    private void mergePass(int[] arr, int k, int length) {

        int i = 0;
//        int j;

        while (i<length-1-2*k+1){
            merge(arr,i,i+k-1,i+2*k-1);
            i = i + 2*k;
        }

        //因为最后的子序列索引可能不是规则的（最后合并可能会剩余1个（当k=1，最后一组的元素个数可能不等于2k个）），
        // 所以这里把最后一组单独考虑，如果满足这个条件（元素个数等于2k个就也合并最后一组），
        // 如果个数少于2k个，就不处理直接还是放在原地作为单独的一个不规则组
        if (i<length-1-k+1){
            merge(arr,i,i+k-1,length-1);
        }
    }


    //主序列的索引范围是[start,end]，左子序列索引范围是[start,among]，右子序列索引范围是[among+1,end]

    private void merge(int[] arr, int start, int among, int end) {
        int[] left = new int[among - start + 1];
        int[] right = new int[end - among];


        //从主序列中找到已经有序的两个子序列
        for (int i = 0; i < left.length; i++) {
            left[i] = arr[i + start];

        }

        for (int i = 0; i < right.length; i++) {

            right[i] = arr[i + among + 1];
        }


        int j = 0, k = 0;

        //合并过程
        for (int p = start; p < end + 1; p++) {

            //如果有一个子序列都已经合并到主序列中，
            // 接下来就不需要比较了，直接把另一个子序列剩余部分放入主序列即可
            if (j == left.length) {
                for (int i = 0; k + i < right.length; i++) {
                    arr[p + i] = right[k + i];
                }
                break;
            }

            if (k == right.length) {
                for (int i = 0; j + i < left.length; i++) {
                    arr[p + i] = left[j + i];
                }
                break;
            }
            if (left[j] <= right[k]) {
                arr[p] = left[j];
                j++;
            } else {
                arr[p] = right[k];
                k++;
            }

        }


    }
}
