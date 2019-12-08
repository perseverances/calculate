package com.example.myfirsthelloapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myfirsthelloapplication.utils.UnitConversion;

import java.util.ArrayList;
import java.util.List;

public class UnitConversionActivity extends AppCompatActivity {

    Adapter adapter;

    Spinner currentSpinner;
    Spinner targetSpinner;
    ArrayAdapter<String> arrayAdapter;
    List<String> list;
    EditText input;
    TextView output;
    Button button;

    //用于存储信息
    String inputmessage_unit;
    String targetmessage_unit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unitconversion);
        //获取两个下拉框对应控件
        currentSpinner = (Spinner)findViewById(R.id.currentSpinner_unit);
        targetSpinner = (Spinner)findViewById(R.id.targetspinner_unit);
        input = (EditText)findViewById(R.id.input_unit);
        output = (TextView)findViewById(R.id.result_unit);
        button = (Button)findViewById(R.id.button_unit);


        initDatas();
        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        currentSpinner.setAdapter(arrayAdapter);
        targetSpinner.setAdapter(arrayAdapter);

        //当前下拉框绑定选择事件
        currentSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //获取当前进制
                inputmessage_unit = list.get(position);

                Toast.makeText(UnitConversionActivity.this, "您选择的进制是：" + list.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        targetSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //获取目标进制
                targetmessage_unit = list.get(i);
                Toast.makeText(UnitConversionActivity.this,"您要转化的进制是:"+list.get(i),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //绑定转化单击事件
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //清空output
                output.setText("");

                //判断输入是否为数字
                if (!UnitConversion.isNum(input.getText().toString())){
                    //输入数字不合法
                    Toast.makeText(UnitConversionActivity.this,"输入数字不合法，请检查",Toast.LENGTH_LONG).show();
                }
                else{
                    //合法继续判断
                    if (!UnitConversion.canConversion(inputmessage_unit, targetmessage_unit)){
                        //单位不合法
                        Toast.makeText(UnitConversionActivity.this,"您选择的单位间不能换算，请从新选择",Toast.LENGTH_LONG).show();
                    }
                    else{
                        //合法
//                        if ("".equals(input.getText().toString())){
//                            //输入为空
//                            Toast.makeText(UnitConversionActivity.this,"输入为空")
//                        }
                        String result = UnitConversion.conversion(inputmessage_unit, targetmessage_unit, input.getText().toString());
                        output.setText(result);

                    }

                }
            }
        });

    }

    private void initDatas() {

        //初始化list
        list = new ArrayList<String>();
        list.add("厘米");
        list.add("米");
        list.add("千米");
//        list.add("克");
//        list.add("千克");
//        list.add("吨");
//        list.add("平方厘米");
//        list.add("平方米");
//        list.add("平方千米");
        list.add("立方厘米");
        list.add("立方米");
        list.add("立方千米");
//        list.add("时");
//        list.add("分");
//        list.add("秒");
    }
}
