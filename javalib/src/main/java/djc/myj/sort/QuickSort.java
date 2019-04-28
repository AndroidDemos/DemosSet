package djc.myj.sort;

/**
 * @author Zeus QQ:1946690608
 * @name DemosSet
 * @time 2018/7/20 14:45
 * @change time
 * @class describe 快速排序算法
 */

import java.util.Arrays;

/**
 * 快速排序是通常被认为在同数量级（O(nlog2n)）的排序方法中平均性能最好的。
 * 但若初始序列按关键码有序或基本有序时，快排序反而蜕化为冒泡排序。为改进之，
 * 通常以“三者取中法”来选取基准记录，即将排序区间的两个端点与中点三个记录关键码居中的调整为支点记录。快速排序是一个不稳定的排序方法。
 */
public class QuickSort {
    static int[] arr = new int[]{7, 44, 9, 1, 5, 65, 23, 53, 95, 32};

    public static void main(String[] args) {
        doQuick();
    }

    private static void doQuick() {

        quickSort(arr);
        System.out.print(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr) {
        doQuickSort(arr, 0, arr.length - 1);
    }

    private static void doQuickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        // 取第一个位置的元素作为基准元素
        int base = arr[startIndex];
        // 获取中轴
        int pivot = partition(arr, base, startIndex + 1, endIndex);
        // 将startIndex和pivot互换，B应该和最后的元素互换
        // 可以判断是否等于，来决定是否交换
        if (pivot != startIndex) {
            swap(arr, startIndex, pivot);
        }
        // 根据中轴分成两块，递归排序，注意不需要再包括pivot
        doQuickSort(arr, startIndex, pivot - 1);
        doQuickSort(arr, pivot + 1, endIndex);

    }

    private static int partition(int[] arr, int base, int startIndex, int endIndex) {
        // 取第一个位置的元素作为基准元素
        // 取i是startIndex+1
        int i = startIndex;
        // 取j是endIndex
        int j = endIndex;

        // 从左边开始找到第一个大于base的数
        // 这里注意控制一下大于小于是否包含等于，这里其实随便定义就好，只要左右互斥
        // 假设大于等于base认为是大于，那么另一个方向就是小于，反之亦然
        // 如果找不到i推进到最后
        // 如果找到i停在找到的位置
        for (; i <= j; ) {
            if (arr[i] > base) {
                break;
            }
            i++;
        }

        // 如果没找到比B大的元素，说明B是最大的
        if (i == endIndex + 1) {
            return endIndex;
        }

        // 从右边，到i+1截止，尝试找到第一个小于base的数
        // 如果程序提前退出，那么i < j，否则 i == j
        for (; j >= i + 1; ) {
            if (arr[j] <= base) {
                break;
            }
            j--;
        }

        // 如果找到了两个，也就是能交换，则继续递归寻找中轴
        if (i < j) {
            swap(arr, i, j);
            // 从i+1，到j-1继续交换
            return partition(arr, base, i + 1, j - 1);
        } else {
            // 如果没找到j，说明i之后的数（包括i）都大于B，B应该在i-1的位置
            return i - 1;
        }
    }

    /**
     * 交换元素
     *
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
