package com.zeus.algorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * Author: Zeus
 * Date: 2020/7/13 14:32
 * Description: 烧饼排序
 * History:
 */
class Cakes {
    static LinkedList<Integer> res = new LinkedList<>();

    static List<Integer> pancakeSort(int[] cakes) {
        sort(cakes, cakes.length);
        return res;
    }

    static void sort(int[] cakes, int n) {
        // base case
        if (n == 1) return;

        // 寻找最大饼的索引
        int maxCake = 0;
        int maxCakeIndex = 0;
        for (int i = 0; i < n; i++)
            if (cakes[i] > maxCake) {
                maxCakeIndex = i;
                maxCake = cakes[i];
            }

        // 第一次翻转，将最大饼翻到最上面
        reverse(cakes, 0, maxCakeIndex);
        res.add(maxCakeIndex + 1);
        // 第二次翻转，将最大饼翻到最下面
        reverse(cakes, 0, n - 1);
        res.add(n);

        // 递归调用
        sort(cakes, n - 1);
    }

    static int reverseCount = 0;

    static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            reverseCount++;
            System.out.println("reverseCount--" + reverseCount);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    static int countNN = 0;
    static int countXX = 0;

    public static void main(String[] args) {
        countNN = countNN++;//先使用再自加
        countXX = ++countXX;//是先自加再使用而后
        System.out.println("--nn---" + countNN);
        System.out.println("--xx---" + countXX);

        res.add(10);
        res.add(5);
        res.add(4);
        res.add(8);
        res.add(7);
        res.add(6);
        int[] cackes = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            cackes[i] = res.get(i);
        }
        pancakeSort(cackes);
    }
}
