package com.example.appcolorconfig;

import android.text.InputFilter;
import android.text.Spanned;

/**
 * Author: Zeus
 * Date: 2020/12/21 14:06
 * Description:
 * History:
 */
public class PointInputFilter implements InputFilter {

    private static final int DECIMAL_DIGITS = 2;//小数的位数
    private static final int INTEGER_DIGITS = 6;//整数位的位数
    private static final int TOTAL_DIGITS = 9; //整数部分 + “小数点” + 小数部分
    private int currentLimitDigits = INTEGER_DIGITS;

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {

        // 删除等特殊字符，直接返回
        if ("".equals(source.toString())) {
            return null;
        }

        /*
        如果想要直接禁止复制粘贴多个数字，直接这边限制。
        if(source.length() > 1){
            return "";
        }*/

        String dValue = dest.toString();
        String[] splitArray = dValue.split("\\.");
        switch (splitArray.length) {
            case 1:

                if (dValue.indexOf(".") != -1) {
                    currentLimitDigits = TOTAL_DIGITS;
                } else {
                    currentLimitDigits = INTEGER_DIGITS;
                }

                if (source.length() > 1) {

                    String sValue = source.toString();
                    String[] subSplitArray = sValue.split("\\.");
                    switch (subSplitArray.length) {
                        case 1:
                            if (source.length() + dest.length() > currentLimitDigits) {
                                return source.subSequence(0, currentLimitDigits - dest.length());
                            }
                            break;
                        case 2:
                            String content = "";

                            if (dstart == dest.length()) {
                                if (subSplitArray[0].length() + dest.length() > INTEGER_DIGITS) {
                                    content += subSplitArray[0].subSequence(0, INTEGER_DIGITS - dest.length());
                                } else {
                                    content += subSplitArray[0];
                                }

                                if (subSplitArray[1].length() > DECIMAL_DIGITS) {
                                    content += "."+ subSplitArray[1].substring(0, DECIMAL_DIGITS);

                                } else {
                                    content += "."+ subSplitArray[1];
                                }
                                return content;

                            } else {
                                if (subSplitArray[0].length() + dest.length() > INTEGER_DIGITS) {
                                    content += subSplitArray[0].subSequence(0, INTEGER_DIGITS - dest.length());
                                } else {
                                    content += subSplitArray[0];
                                }
                            }
                            return content;

                        default:
                            break;
                    }

                }

                if (splitArray[0].length() >= currentLimitDigits && !".".equals(source.toString())) {
                    return "";
                }

                break;

            case 2:
                String integerValue = splitArray[0];
                String dotValue = splitArray[1];
                int dotIndex = dValue.indexOf(".");

                if (dstart <= dotIndex) {

                    if (integerValue.length() >= INTEGER_DIGITS) {
                        return "";
                    } else if (source.length() + integerValue.length() >= INTEGER_DIGITS) {
                        return source.subSequence(0, INTEGER_DIGITS - integerValue.length());
                    }

                } else {

                    if (dotValue.length() >= DECIMAL_DIGITS) {
                        return "";
                    } else if (source.length() + dotValue.length() >= DECIMAL_DIGITS) {
                        return source.subSequence(0, DECIMAL_DIGITS - dotValue.length());
                    }
                }

                break;
            default:
                break;
        }

        return null;
    }
}
