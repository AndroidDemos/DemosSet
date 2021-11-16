package com.kky.example.util;

/*
 * @author Zeus
 * create at 2019/4/8 16:33
 * modify at 2019/4/8 16:33
 * modify because
 * description: TO FIT
 */
public class PinCheckUtil {
    private static int coutLimit = 4 - 1;//重复次数，连续次数均为此参数

    /**
     * 密码是否是正序或反序连续3位及以上
     *
     * @param pwd
     * @return true为正确，false为错误。
     */
    private static boolean isPasswordContinuous(String pwd) {
        int count = 1;//正序次数
        int reverseCount = 1;//反序次数
        int sameCount = 1;//相同次数
        String[] strArr = pwd.split("");
        for (int i = 1; i < strArr.length - 1; i++) {//从1开始是因为划分数组时，第一个为空
            if (isPositiveContinuous(strArr[i], strArr[i + 1])) {
                count++;
            } else {
                count = 1;
            }
            if (isReverseContinuous(strArr[i], strArr[i + 1])) {
                reverseCount++;
            } else {
                reverseCount = 1;
            }
            if (isSameNumber(strArr[i], strArr[i + 1])) {
                sameCount++;
            } else {
                sameCount = 1;
            }


            if (count > coutLimit || reverseCount > coutLimit || sameCount > coutLimit)
                break;
        }
        if (count > coutLimit || reverseCount > coutLimit || sameCount > coutLimit)
            return false;
        return true;
    }

    /**
     * 是否是正序连续
     *
     * @param str1
     * @param str2
     * @return
     */
    private static boolean isPositiveContinuous(String str1, String str2) {
        if (str2.hashCode() - str1.hashCode() == 1) return true;
        return false;
    }

    /**
     * 是否是相同数字
     *
     * @param str1
     * @param str2
     * @return
     */
    private static boolean isSameNumber(String str1, String str2) {
        if (str2.hashCode() - str1.hashCode() == 0) return true;
        return false;
    }

    /**
     * 是否是反序连续
     *
     * @param str1
     * @param str2
     * @return
     */
    private static boolean isReverseContinuous(String str1, String str2) {
        if (str2.hashCode() - str1.hashCode() == -1) return true;
        return false;
    }

    /**
     * - 字母区分大小写，可输入符号<br/>
     * - 密码必须同时包含字母和数字<br/>
     * - 密码长度8-20位<br/>*
     *
     * @param password 密码
     * @return true为正确，false为错误
     * @author Miaozz.
     */
    public static boolean isPasswordAvailable(String password) {
        return isPasswordContinuous(password);

    }
}
