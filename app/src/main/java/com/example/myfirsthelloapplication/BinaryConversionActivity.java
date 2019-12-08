package com.example.myfirsthelloapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myfirsthelloapplication.utils.BinaryConversion;

import java.util.ArrayList;
import java.util.List;

public class BinaryConversionActivity extends AppCompatActivity {       //二进制转化

    //当前字符串代表进制
    String currentBinString = null;
    //目标字符串代表进制
    String targetBinString = null;
    Adapter adapter;
    //目标下拉框
    Spinner targetSpinner;
    //当前下拉框
    Spinner currentSpinner;
    ArrayAdapter<String> arrayAdapter;
    List<String> list;
    //常用控件
    Button button;
    EditText input;
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binaryconversion);
        //获取事件
        currentSpinner = (Spinner) findViewById(R.id.currentSpinner);
        targetSpinner = (Spinner) findViewById(R.id.targetspinner);
        //currentSpinner.setPrompt("请选择当前进制");
        //targetSpinner.setPrompt("请选择目标进制");
        input = (EditText)findViewById(R.id.inputnum) ;
        output = (TextView)findViewById(R.id.result);


        //初始化list
        initDatas();

        //初始化adapt
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);

        currentSpinner.setAdapter(arrayAdapter);

        targetSpinner.setAdapter(arrayAdapter);

        //当前下拉框绑定选择事件
        currentSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //获取当前进制
                currentBinString = list.get(position);

                Toast.makeText(BinaryConversionActivity.this, "您选择的进制是：" + list.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        targetSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //获取目标进制
                targetBinString = list.get(i);
                Toast.makeText(BinaryConversionActivity.this,"您要转化的进制是:"+targetBinString,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //获取按钮
        button = (Button)findViewById(R.id.buttonBin);

        //绑定单击按钮事件
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //判断数字与其对应进制是否正确
                if (BinaryConversion.isTrueNum(input.getText().toString(),currentBinString)){
                    //正确输入
                    String resultText = BinaryConversion.binConvers(currentBinString,targetBinString,input.getText().toString());
                    output.setText(resultText);
                }
                else{
                    Toast.makeText(BinaryConversionActivity.this,"您输入的数字不符合您选择的规范，请重新输入",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void initDatas() {
        //初始化list
        list = new ArrayList<String>();
        list.add("二进制");
        list.add("八进制");
        list.add("十进制");
        list.add("十六进制");
    }
}
