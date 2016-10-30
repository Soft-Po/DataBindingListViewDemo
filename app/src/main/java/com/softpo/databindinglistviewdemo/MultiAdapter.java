package com.softpo.databindinglistviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.softpo.databindinglistviewdemo.databinding.ItemLeftBinding;
import com.softpo.databindinglistviewdemo.databinding.ItemRightBinding;

import java.util.List;

/**
 * Created by softpo on 2016/10/30.
 */

public class MultiAdapter extends BaseAdapter {
    public static final int TYPE_ONE = 0;
    public static final int TYPE_TWO = 1;
    private Context mContext;
    private List<User> mData;
    public MultiAdapter(Context context, List<User> data) {
        this.mContext = context;
        this.mData = data;
    }

    @Override
    public int getCount() {
        return mData!=null?mData.size():0;
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolderOne viewHolderOne = null;
        ViewHolderTwo viewHolderTwo = null;

        int viewType = getItemViewType(position);

        switch (viewType){
            case TYPE_ONE:
                if (convertView == null) {
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.item_left,parent,false);
                    viewHolderOne = new ViewHolderOne();
                    viewHolderOne.mItemLeftBinding = ItemLeftBinding.bind(convertView);
                    convertView.setTag(viewHolderOne);
                }else {
                    viewHolderOne = (ViewHolderOne) convertView.getTag();
                }
                viewHolderOne.mItemLeftBinding.setUser(mData.get(position));
                break;
            case TYPE_TWO:
                if (convertView == null) {
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.item_right,parent,false);
                    viewHolderTwo = new ViewHolderTwo();

                    viewHolderTwo.mItemRightBinding = ItemRightBinding.bind(convertView);
                    convertView.setTag(viewHolderTwo);
                }else {
                    viewHolderTwo = (ViewHolderTwo) convertView.getTag();
                }

                viewHolderTwo.mItemRightBinding.setUser(mData.get(position));
                break;
        }


        return convertView;
    }
    private static class  ViewHolderOne{
        ItemLeftBinding mItemLeftBinding;
    }
    private static class ViewHolderTwo{
        ItemRightBinding mItemRightBinding;
    }

    //告诉BaseAdapter总共有几种布局
    @Override
    public int getViewTypeCount() {
        return 2;
    }

    //返回多布局类型，必须从0开始，类似索引
    @Override
    public int getItemViewType(int position) {
        if(position%2==0){
            return TYPE_ONE;
        }else {
            return TYPE_TWO;
        }
    }

}

