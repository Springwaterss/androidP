package com.zjut.travels.homepage;

import android.os.Bundle;
//import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.zjut.travels.R;

public class HomeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
    @Override
    public void  onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ImageButton cate = (ImageButton)getActivity().findViewById(R.id.ib_cate);
        ImageButton viewSpot = (ImageButton)getActivity().findViewById(R.id.ib_viewspot);
        ImageButton navigation = (ImageButton)getActivity().findViewById(R.id.ib_navigation);


        cate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("你点击了美食按钮");
                Toast.makeText(getActivity(),"正在跳转美食功能",Toast.LENGTH_LONG).show();
            }
        });

        viewSpot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("你点击了景点按钮");
                Toast.makeText(getActivity(),"正在跳转景点功能",Toast.LENGTH_LONG).show();
            }
        });

        navigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("你点击了导航按钮");
                Toast.makeText(getActivity(),"正在跳转导航功能",Toast.LENGTH_LONG).show();
            }
        });
    }

}
