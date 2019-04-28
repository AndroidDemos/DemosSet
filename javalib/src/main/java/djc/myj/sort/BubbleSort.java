package djc.myj.sort;

/**
 * @author Zeus QQ:1946690608
 * @name DemosSet
 * @time 2018/7/20 14:45
 * @change time
 * @class describe 冒泡算法
 */

/**
 * 冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，
 * 如果他们的顺序错误就把他们交换过来。走访数列的工作是重复地进行直到没有再需要交换，
 * 也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端
 */
public class BubbleSort {
    static int[] array = new int[]{7, 44, 9, 1, 5, 65, 23, 53, 95, 32};

    public static void main(String[] args) {
        doBubble();
    }

    private static void doBubble() {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int oldJ = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = oldJ;
                }
            }
        }
        for (int i : array) {
            System.out.print("i---" + i + "\n");
        }
    }
}
