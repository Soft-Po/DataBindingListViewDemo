package com.softpo.databindinglistviewdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by softpo on 2016/10/30.
 */

public class CircleImageView extends ImageView {
    private Bitmap mBitmap;
    private BitmapShader mBitmapShader;
    public CircleImageView(Context context) {
        this(context,null);
    }

    public CircleImageView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CircleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);

        BitmapDrawable drawable = (BitmapDrawable) getDrawable();

        if (drawable != null) {
            mBitmap =  drawable.getBitmap();

            mBitmapShader = new BitmapShader(mBitmap, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR);


            ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());

            shapeDrawable.getPaint().setShader(mBitmapShader);

            shapeDrawable.setBounds(0,0,120,120);

            shapeDrawable.draw(canvas);

        }else {
            super.onDraw(canvas);
        }
    }
}
