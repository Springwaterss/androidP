package com.zjut.travels.homepage;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.zjut.travels.R;

public class RegisteOrLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_and_login);
        Resources res =getResources();
        String[] type=res.getStringArray(R.array.user_type);//将province中内容添加到数组city中
        final Spinner mSpinner = (Spinner)findViewById(R.id.spinner2);
        //为下拉列表定义一个适配器
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, type);
        //添加数据
        mSpinner.setAdapter(adapter);
        //点击响应事件
        mSpinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> arg0, View view, int arg1, long arg2) {
                String text= mSpinner.getItemAtPosition(arg1).toString();
                System.out.println(adapter.getItem(arg1));  //输出所选项目
                Toast.makeText(RegisteOrLogin.this,text,Toast.LENGTH_SHORT).show();
            }
            public void onNothingSelected(AdapterView<?> arg0) {
                String text = "请选择用户类型";
                Toast.makeText(RegisteOrLogin.this,text,Toast.LENGTH_LONG).show();
                Toast toast = Toast.makeText(RegisteOrLogin.this, text, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.LEFT,0, 0);
                toast.show();
            }
        });

    }
}
