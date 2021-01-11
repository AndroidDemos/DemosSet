package com.eus.flex;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * Created by admin on 2018/11/14.
 */

public class TitleBar extends RelativeLayout {

    private Context mContext;//标题
    private LinearLayout llContainer;
    private TextView tvCenter;


    private int bgColor = 0xFFFFFF;//
    private int textColor = 0xFFFFFF;//
    private String textss = "0xFFFFFF";//
    public static final String titleColor1 = "#FFFFFF";//
    public static final String titleColor2 = "#F7F7F7";
    public static final String titleColor3 = "#5097FB";

    public TitleBar(Context context) {
        this(context, null);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init();
        getAttrs(context, attrs);
    }


    /**
     * 读取属性合集
     *
     * @param context
     * @param attrs
     */
    private void getAttrs(Context context, AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.TitleBar);
        bgColor = array.getColor(R.styleable.TitleBar_title_bg_color, getResources().getColor(R.color.colorWhite));
        textColor = array.getColor(R.styleable.TitleBar_title_txt_color, getResources().getColor(R.color.colorWhite));
        textss = array.getString(R.styleable.TitleBar_tt_name);
        tvCenter.setTextColor(textColor);
        tvCenter.setText(textss);
        llContainer.setBackgroundColor(bgColor);
        ColorActivity.Companion.print("bg-in-title--" + bgColor);
    }


    private void init() {
        View view = View.inflate(getContext(), R.layout.view_title, this);
        llContainer = view.findViewById(R.id.ll_title_container);
        tvCenter = view.findViewById(R.id.tv_center);
    }


    public int getBgColor() {
        return bgColor;
    }


}
