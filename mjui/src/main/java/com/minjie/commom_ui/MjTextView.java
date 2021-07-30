package com.minjie.commom_ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MjTextView extends LinearLayout {
    private TextView tv_01;
    private TextView tv_02;
    private boolean needColon = true;
    private String strTitle = "";
    private String strContent = "";
    private int textSize1 = 12;
    private int textSize2 = 12;
    private boolean bold1 = false;
    private boolean bold2 = false;

    public MjTextView(Context context) {
        super(context);
    }

    public MjTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.layout_mjtextview, this, true);
        tv_01 = (TextView) findViewById(R.id.tv_01);
        tv_02 = (TextView) findViewById(R.id.tv_02);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MjTextView);
        int firstColor = a.getColor(R.styleable.MjTextView_color1, context.getResources().getColor(R.color.black));
        int secondColor = a.getColor(R.styleable.MjTextView_color2, context.getResources().getColor(R.color.black));
        needColon = a.getBoolean(R.styleable.MjTextView_needColon, true);
        strTitle = a.getString(R.styleable.MjTextView_text1);
        strContent = a.getString(R.styleable.MjTextView_text2);
        textSize1 = a.getInteger(R.styleable.MjTextView_textSize1, 12);
        textSize2 = a.getInteger(R.styleable.MjTextView_textSize2, 12);
        bold1 = a.getBoolean(R.styleable.MjTextView_bold1, true);
        bold2 = a.getBoolean(R.styleable.MjTextView_bold2, true);
        a.recycle();
        tv_01.setText(strTitle + (needColon ? ":" : ""));
        tv_02.setText(strContent);
        tv_01.setTextColor(firstColor);
        tv_02.setTextColor(secondColor);
        tv_01.setTextSize(textSize1);
        tv_02.setTextSize(textSize2);
        if (bold1){
            tv_01.setTypeface(tv_01.getTypeface(), Typeface.BOLD);
        }
        if (bold2){
            tv_02.setTypeface(tv_02.getTypeface(), Typeface.BOLD);
        }

    }
    public void setTitle(String title){
        tv_01.setText(title);
    }
    public void setContent(String content){
        tv_02.setText(content);
    }
}
