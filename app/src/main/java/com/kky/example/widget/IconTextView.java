package com.kky.example.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;

import com.kky.example.R;
import com.kky.example.util.ConvertUtils;


/*
 * @author Zeus
 * create at 2018/12/20 10:19
 * modify at 2018/12/20 10:19
 * modify because
 * description: TO FIT
 */
public class IconTextView extends LinearLayout {
    private AppCompatTextView tvBottom;
    private ImageView ivTop;
    private static int defaultTextSize = 0;//默认sp
    private static float defaultsSize = 0;//默认dp
    private static final String tag = "ICON_TEXT";

    //it_text_color,it_tv_margin,it_iv_size,it_text_size
    public IconTextView(Context context) {
        this(context, null);
    }

    public void setIvTop(int res) {
        ivTop.setImageResource(res);
    }

    public void setTvBottom(String text) {
        tvBottom.setText(text);
    }

    public String getText() {
        String txt;
        txt = (TextUtils.isEmpty(tvBottom.getText().toString())) ? "" :
                tvBottom.getText().toString();
        return txt;
    }

    public IconTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        getAttrs(context, attrs);

    }

    /**
     * 读取属性合集
     *
     * @param context
     * @param attrs
     */
    private void getAttrs(Context context, AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.IconTextView);
        //设置文本
        String text = array.getString(R.styleable.IconTextView_bottomText);
        float textSize = array.getDimension(R.styleable.IconTextView_it_text_size, defaultTextSize);
        int textColor = array.getColor(R.styleable.IconTextView_it_text_color, ContextCompat.getColor(context,
                R.color.white));
        float tControlSize = array.getDimension(R.styleable.IconTextView_it_iv_size, defaultsSize);
        Log.e(tag, "tControlSize" + tControlSize);
        int resourceId = array.getResourceId(R.styleable.IconTextView_imgTop, R.mipmap.icon_contact);
        View view = View.inflate(getContext(), R.layout.view_icon_text, this);
        tvBottom = view.findViewById(R.id.tv_bottom);
        ivTop = view.findViewById(R.id.iv_top);
        tvBottom.setTextColor(textColor);
        tvBottom.setText(text);
        if (textSize != defaultTextSize) {
//            Log.e(tag, "textSize" + textSize);
//            Log.e(tag, "defaultTextSize" + defaultTextSize);
            tvBottom.setTextSize(ConvertUtils.px2sp(textSize));
//            tvBottom.setTextSize(textSize);
        }
        float defaultsSizeInPx = ConvertUtils.dp2px(40);

        Log.e(tag, "defaultsSizeInPx" + defaultsSizeInPx);
        if (tControlSize != defaultsSize) {
            float controlSize = ConvertUtils.dp2px(tControlSize);
            Log.e(tag, "controlSize" + controlSize);
            ivTop.getLayoutParams().width = (int) tControlSize;
            ivTop.getLayoutParams().height = (int) tControlSize;
        }
        ivTop.setImageResource(resourceId);
    }


}
