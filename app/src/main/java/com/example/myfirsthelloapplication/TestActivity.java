package com.example.myfirsthelloapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class TestActivity extends AppCompatActivity {



    RadioGroup radioGroup;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);
        /**
         * 获取选中单选框并使用toast输出选中文本
         */

        radioGroup = (RadioGroup)findViewById(R.id.radiogroup);
        //绑定按钮改选事件
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            //i为选中状态主动改变的radioButton的id号
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton = findViewById(i);
                //第一个参数为上下文对象
                Toast.makeText(TestActivity.this,"性别："+radioButton.getText(),Toast.LENGTH_LONG).show();
            }
        });
        //第二种方法提交按钮
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < radioGroup.getChildCount(); i++) {
                    RadioButton child = (RadioButton) radioGroup.getChildAt(i);
                    if (child.isChecked()){
                        Toast.makeText(TestActivity.this,"性别："+child.getText(),Toast.LENGTH_LONG).show();
                        break;
                    }
                }
            }
        });
    }
}
