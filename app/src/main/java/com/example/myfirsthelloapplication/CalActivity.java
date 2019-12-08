package com.example.myfirsthelloapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myfirsthelloapplication.utils.Calculator;

//主界面
/**
 * 计算器类
 */

public class CalActivity extends AppCompatActivity {
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button0;
    TextView inputandgetresult;
    TextView outputtheexp;
    Button btn_plus;
    Button btn_minus;
    Button btn_divide;
    Button btn_multply;
    Button btn_point;
    Button btn_equal;
    Button btn_clear;
    Button btn_del;
    Button btn_sin;
    Button btn_cos;
    Button btn_leftBracket;
    Button btn_rightBracket;
    Button btn_tan;
    Button btn_mi;
//    Button btn_sqrt;
//    Button btn_square;
//    Button btn_cube;
//    Button btn_bin;
//    Button btn_oct;
//    Button btn_dec;
//    Button btn_hex;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        if(this.getResources().getConfiguration().orientation ==Configuration.ORIENTATION_PORTRAIT){
//            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//        }

        setContentView(R.layout.cal_layout);
        //


        //根据id获取view对象
        inputandgetresult = (TextView) findViewById(R.id.inputandgetresult);
        outputtheexp = (TextView) findViewById(R.id.outputtheexp);
        button0 = (Button) findViewById(R.id.btn_0);
        button1 = (Button) findViewById(R.id.btn_1);
        button2 = (Button) findViewById(R.id.btn_2);
        button3 = (Button) findViewById(R.id.btn_3);
        button4 = (Button) findViewById(R.id.btn_4);
        button5 = (Button) findViewById(R.id.btn_5);
        button6 = (Button) findViewById(R.id.btn_6);
        button7 = (Button) findViewById(R.id.btn_7);
        button8 = (Button) findViewById(R.id.btn_8);
        button9 = (Button) findViewById(R.id.btn_9);
        btn_plus = (Button) findViewById(R.id.btn_plus);
        btn_minus = (Button) findViewById(R.id.btn_minus);
        btn_multply = (Button) findViewById(R.id.btn_multply);
        btn_divide = (Button) findViewById(R.id.btn_divide);
        btn_point = (Button) findViewById(R.id.btn_point);
        btn_equal = (Button) findViewById(R.id.btn_equal);
        btn_clear = (Button) findViewById(R.id.btn_clear);
        btn_del = (Button) findViewById(R.id.btn_del);
        btn_sin = (Button) findViewById(R.id.btn_sin);
        btn_cos = (Button) findViewById(R.id.btn_cos);
        btn_leftBracket = (Button) findViewById(R.id.btn_leftBracket);
        btn_rightBracket = (Button) findViewById(R.id.btn_rightBracket);
        btn_tan = (Button) findViewById(R.id.btn_tan);
        btn_mi = (Button)findViewById(R.id.btn_mi);
//        btn_sqrt = (Button) findViewById(R.id.btn_sqrt);
//        btn_square = (Button) findViewById(R.id.btn_square);
//        btn_cube = (Button) findViewById(R.id.btn_cube);
//        btn_bin = (Button) findViewById(R.id.btn_bin);
//        btn_oct = (Button) findViewById(R.id.btn_oct);
//        btn_dec = (Button) findViewById(R.id.btn_dec);
//        btn_hex = (Button) findViewById(R.id.btn_hex);
        //设置欢迎信息

        //绑定单击事件
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputandgetresult.append("0");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputandgetresult.append("1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputandgetresult.append("2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputandgetresult.append("3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputandgetresult.append("4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputandgetresult.append("5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputandgetresult.append("6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputandgetresult.append("7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputandgetresult.append("8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputandgetresult.append("9");
            }
        });
        btn_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputandgetresult.append(".");
            }
        });
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputandgetresult.append("+");
            }
        });
        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputandgetresult.append("-");
            }
        });
        btn_multply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputandgetresult.append("*");
            }
        });
        btn_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputandgetresult.append("/");
            }
        });
//        btn_sin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Double str = Double.valueOf(inputandgetresult.getText().toString());
//                double a = Math.round(Math.cos(str * Math.PI / 180) * 100);
//                inputandgetresult.setText("sin（" );
//                output.setText(a / 100 + "");
//            }
//        });
//        btn_cos.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Double str = Double.valueOf(input.getText().toString());
//                double a = Math.round(Math.cos(str * Math.PI / 180) * 100);
//                input.setText("cos" + input.getText().toString() + "°");
//                output.setText(a / 100 + "");
//            }
//        });
        btn_leftBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputandgetresult.append("(");
            }
        });
        //左括号读入

        btn_rightBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputandgetresult.append(")");
            }
        });
        //右括号读入

        //幂符号
        btn_mi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputandgetresult.append("^");
            }
        });

        //正弦单击事件
        btn_sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputandgetresult.append("sin(");
            }
        });

        //余弦单击事件
        btn_cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputandgetresult.append("cos(");
            }
        });

        //正切符号
        btn_tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Double str = Double.valueOf(inputandgetresult.getText().toString());
//                double a = Math.round(Math.tan(str * Math.PI / 180) * 100);
//                input.setText("tan" + input.getText().toString() + "°");
//                output.setText(a / 100 + "");
                inputandgetresult.append("tan(");

            }
        });
        //正切求值
//
//        btn_sqrt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                double str = Double.valueOf(input.getText().toString());
//                input.setText("√" + input.getText());
//                output.setText(Math.sqrt(str) + "");
//            }
//        });
//        //开平方
//
//        btn_square.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                double str = Double.valueOf(input.getText().toString());
//                input.setText(input.getText() + "²");
//                output.setText(str * str + "");
//            }
//        });
//        //平方
//
//        btn_cube.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                double str = Double.valueOf(input.getText().toString());
//                input.setText(input.getText() + "³");
//                output.setText(str * str * str + "");
//            }
//        });

//        btn_bin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int str = Integer.valueOf(inputandgetresult.getText().toString());
//                outputtheexp.setText(inputandgetresult.getText().toString());
//                inputandgetresult.setText(Integer.toBinaryString(str));
//            }
//        });
//        //二进制转换
//
//        btn_oct.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int str = Integer.valueOf(inputandgetresult.getText().toString());
//                outputtheexp.setText(inputandgetresult.getText().toString());
//                outputtheexp.setText(Integer.toOctalString(str));
//            }
//        });
//        //八进制转换
//
//        btn_dec.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                output.setText(input.getText().toString());
//                input.setText(input.getText().toString());
//            }
//        });
//        //十进制转换
//
//        btn_hex.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int str = Integer.valueOf(input.getText().toString());
//                output.setText(input.getText().toString() + "hex");
//                input.setText(Integer.toHexString(str));
//            }
//        });
//        //十六进制转换

        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String exp = inputandgetresult.getText().toString();

            //    double result = Calculator.conversion(exp);
         //       Toast.makeText(CalActivity.this, "输入错误", Toast.LENGTH_LONG).show();
                if (Double.isNaN(Calculator.conversion(exp))) {
                    Toast.makeText(CalActivity.this, "输入错误,请检查表达式是否正确", Toast.LENGTH_LONG).show();
                }
                //if ()
                else {
                    outputtheexp.setText(inputandgetresult.getText().toString() + "=");
                    inputandgetresult.setText(Calculator.conversion(exp) + "");
                }


            }
        });
        //等于号，输出结果

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                outputtheexp.setText("");
                inputandgetresult.setText("");
            }
        });
        //清零

        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = inputandgetresult.getText().toString();
                if (!"".equals(str)) {

                    String substring = str.substring(0, str.length() - 1);
                    inputandgetresult.setText(substring);
                }

            }
        });
        //回退

    }


    /**
     * 重写onCreateOptionsMenu方法，添加选项菜单
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //实例化MenuInflater对象，用于解析菜单资源文件，传递参数为上下文对象this
        MenuInflater menuInflater = new MenuInflater(this);
        //解析菜单资源文件，
        menuInflater.inflate(R.menu.menu_change, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * 重写onOptionsItemSelected，点击逻辑
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //分支判断哪个组件被点击
        switch (item.getItemId()) {
            case R.id.help:
                Intent intent_help = new Intent(CalActivity.this, HelpAvtivity.class);
                startActivity(intent_help);
                break;
            case R.id.unitconversion:
                Intent intent_unit = new Intent(CalActivity.this, UnitConversionActivity.class);
                startActivity(intent_unit);
                break;
            case R.id.binaryconversion:
                Intent intent_binary = new Intent(CalActivity.this, BinaryConversionActivity.class);
                startActivity(intent_binary);
                break;
            case R.id.calculator:
                Intent intent_cal = new Intent(CalActivity.this, CalActivity.class);
                startActivity(intent_cal);
                break;


        }
        return super.onOptionsItemSelected(item);
    }

//    public void onConfigurationChanged(Configuration newConfig) {
//
//        super.onConfigurationChanged(newConfig);
//
//        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            // 加入横屏要处理的代码
//
//            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
//        } else if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
//            // 加入竖屏要处理的代码
//            // 强制切换为竖屏
//            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//        }
//    }

//     * 处理横屏布局
//     */
//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//
//        setContentView(R.layout.cal_layout);
//    }

//    //用onCreateOptionsMenu（）显示菜单
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_change,menu);//getMenuInflater()方法得到MenuInflater
//        //调用inflate接收两个参数
//        //R.menu.main指调用menu文件下的main资源文件
//        return true;//返回true，允许创建的菜单显示,返回false不显示
//    }
    //定义菜单响应事件
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){   //item.getItemId()判断我们选择那个菜单项
//            case R.id.first:
//                Toast.makeText(this, "FIRST", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(CalActivity.this,HelpActivity.class);
//                startActivity(intent);
//                break;
//            case R.id.second:
//                Toast.makeText(this, "SECOND", Toast.LENGTH_SHORT).show();
//                finish();
//                break;
//            default:
//        }
//        return true;
//    }

}


