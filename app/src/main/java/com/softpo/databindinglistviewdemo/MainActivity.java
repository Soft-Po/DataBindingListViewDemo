package com.softpo.databindinglistviewdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.softpo.databindinglistviewdemo.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private List<User> mData = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        for (int i = 0; i < 100; i++) {
            User user = new User();
            if(i%2==0){
                user.setName("白云");
                user.setImageId(R.mipmap.cloud);
            }else {
                user.setName("黑土");
                user.setImageId(R.mipmap.black);
            }
            mData.add(user);
        }
        MultiAdapter adapter = new MultiAdapter(this,mData);
        binding.setAdapter(adapter);
        binding.setItemclicklistener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,"您点击的条目是： "+position,Toast.LENGTH_LONG).show();
    }
}
