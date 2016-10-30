package com.softpo.databindinglistviewdemo;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

/**
 * Created by softpo on 2016/10/30.
 */

public class User {
    private String name;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    private int imageId;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    //自定义Setter
    @BindingAdapter({"bind:image"})
    public static void imgLoader(ImageView imageView, int imageId) {
        imageView.setImageResource(imageId);
    }
}
