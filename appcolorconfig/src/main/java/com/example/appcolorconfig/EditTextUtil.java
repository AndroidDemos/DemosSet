package com.example.appcolorconfig;

import android.app.Activity;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * @author Zeus
 * create at 2018/12/22 15:11
 * modify at 2018/12/22 15:11
 * modify because
 * description: Edit限制输入字符
 */
public class EditTextUtil {
    /**
     * @param editText     EditText输入框
     * @param integetDigts 小数点前面面位数
     * @param decimalDigts 小数点后面位数
     */
    public static void setDoubleText(EditText editText, final int integetDigts, final int decimalDigts) {
        InputFilter inputFilter = new InputFilter() {
            //参数source：将要插入的字符串，来自键盘输入、粘贴
            //参数start：source的起始位置，为0（暂时没有发现其它值的情况）
            //参数end：source的长度
            //参数dest：EditText中已经存在的字符串
            //参数dstart：插入点的位置
            //参数dend：插入点的结束位置，一般情况下等于dstart；如果选中一段字符串（这段字符串将会被替换），dstart的值就插入点的结束位位置
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                String destText = dest.toString();
                String sourceText = source.toString();
                if (sourceText.length() > 1) {
                    return "";
                }

                if (dest == null) {//初始输入
                    if (sourceText.equals("0") || source.equals(POINTER)) {
                        if (dest == null) {
                            return "0.";
                        }
                    }
                } else {
                    if (source.equals(POINTER)) {//
                        if (destText.contains(POINTER)) {
                            return "";
                        }
                    }
                    if (sourceText.equals("0")) {
                        if (dstart == 0) {
                            return "";
                        }
                    }
                }
                if (destText.contains(POINTER)) {
                    int index = destText.indexOf(POINTER);
                    int decimalLength = destText.substring(index).length();
                    String substring = destText.substring(0, index);
                    int integerLength = substring.length();

                    if (dstart > index) {
                        if (decimalLength == decimalDigts + 1) {
                            return "";
                        }
                    } else {
                        if (integerLength == integetDigts + 1) {
                            return "";
                        }
                    }
                }
                if (destText.length() == 10) {
                    return "";
                }
                return null;
            }
        };
        editText.setFilters(new InputFilter[]{inputFilter});
    }

    public static String getRidOfZero(String args) {
        String result = args;
        if (args.startsWith("0") && args.contains(".")) {
            if (args.indexOf(".") != 1) {
                result = args.substring(0, 1);
            }
        }
        return result;
    }

    static String POINTER = ".";
    static String DELETETEXT = "";

    /**
     * @param editText       EditText输入框
     * @param POINTER_LENGTH 小数点后面位数
     */
    public static void setDoubleText2(EditText editText, final int POINTER_LENGTH) {
        final Pattern mPattern = Pattern.compile("([0-9]|\\.)*");
        InputFilter inputFilter = new InputFilter() {
            //参数source：将要插入的字符串，来自键盘输入、粘贴
            //参数start：source的起始位置，为0（暂时没有发现其它值的情况）
            //参数end：source的长度
            //参数dest：EditText中已经存在的字符串
            //参数dstart：插入点的位置
            //参数dend：插入点的结束位置，一般情况下等于dstart；如果选中一段字符串（这段字符串将会被替换），dstart的值就插入点的结束位位置

            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                String sourceText = source.toString();
                String destText = dest.toString();
//验证删除等按键
                if (TextUtils.isEmpty(sourceText)) {
                    if (dstart == 0 && destText.indexOf(POINTER) == 1) {//保证小数点不在第一个位置
                        return "0";
                    }
                    return "";
                }
                Matcher matcher = mPattern.matcher(source);
//已经输入小数点的情况下，只能输入数字
                if (destText.contains(POINTER)) {
                    if (!matcher.matches()) {
                        return "";
                    } else {
                        if (POINTER.equals(source)) { //只能输入一个小数点
                            return "";
                        }
                    }
//验证小数点精度，保证小数点后只能输入两位
                    int index = destText.indexOf(POINTER);
                    int length = destText.trim().length() - index;
                    if (length > POINTER_LENGTH && dstart > index) {
                        return "";
                    }
                } else {
//没有输入小数点的情况下，只能输入小数点和数字，但首位不能输入小数点和0
                    if (!matcher.matches()) {
                        return "";
                    } else {
                        if ((POINTER.equals(source)) && dstart == 0) {//第一个位置输入小数点的情况
                            return "0.";
                        }
                    }
                }
//验证输入金额的大小
                if (dest.toString().length() == 8) {
                    return "";
                }
                return dest.subSequence(dstart, dend) + sourceText;
            }
        };
        editText.setFilters(new InputFilter[]{inputFilter});
    }

    public static void printLoge(String args) {
        Log.e("zeus-tag", args);
    }

    public static void asissit(Activity activity){
        AndroidWorkaround.assistActivity(activity);
    }
}
