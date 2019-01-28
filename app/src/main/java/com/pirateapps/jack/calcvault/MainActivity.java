package com.pirateapps.jack.calcvault;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv1, tv2, tvdemo;
    private boolean add, sub, div, mul, point, chk;
    double n1, n2, ans;
    String stemp, s1temp;
    NumberFormat nf = NumberFormat.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bac = findViewById(R.id.button_ac);
        Button bplus = findViewById(R.id.button_plus);
        Button bback = findViewById(R.id.button_Cal);
        Button bdiv = findViewById(R.id.button_div);
        Button bmul = findViewById(R.id.button_mul);
        Button bsub = findViewById(R.id.button_minus);
        Button bpoint = findViewById(R.id.button_point);
        Button bzero = findViewById(R.id.button0);
        Button bone = findViewById(R.id.button1);
        Button btwo = findViewById(R.id.button2);
        Button bthree = findViewById(R.id.button3);
        Button bfour = findViewById(R.id.button4);
        Button bfive = findViewById(R.id.button5);
        Button bsix = findViewById(R.id.button6);
        Button bseven = findViewById(R.id.button7);
        Button beight = findViewById(R.id.button8);
        Button bnine = findViewById(R.id.button9);
        Button bTheme = findViewById(R.id.button_T);
        Button b_CC = findViewById(R.id.button_cc);
        tv1 = findViewById(R.id.text_result);
        tv2 = findViewById(R.id.text_2);
        tvdemo = findViewById(R.id.text_1);


        bone.setOnClickListener(this);
        btwo.setOnClickListener(this);
        bthree.setOnClickListener(this);
        bfour.setOnClickListener(this);
        bfive.setOnClickListener(this);
        bsix.setOnClickListener(this);
        bseven.setOnClickListener(this);
        beight.setOnClickListener(this);
        bnine.setOnClickListener(this);
        bzero.setOnClickListener(this);
        bpoint.setOnClickListener(this);
        bplus.setOnClickListener(this);
        bdiv.setOnClickListener(this);
        bsub.setOnClickListener(this);
        bmul.setOnClickListener(this);
        bac.setOnClickListener(this);
        bback.setOnClickListener(this);
        bTheme.setOnClickListener(this);
        b_CC.setOnClickListener(this);

        tv1.setText("0");
        tv2.setText("0");
        tvdemo.setText("0");
        add = true;
        point = true;
        chk = false;
        nf.setMaximumFractionDigits(4);
    }

    public void scrollMyView() {
        ScrollView sV = findViewById(R.id.scroll1);
        sV.scrollTo(0, tvdemo.getBottom());
    }

    public void operation() {

        if (add) {
            stemp = tv1.getText().toString();
            n2 = Double.parseDouble(stemp);
            ans = n1 + n2;
        } else if (sub) {
            stemp = tv1.getText().toString();
            n2 = Double.parseDouble(stemp);
            ans = n1 - n2;
        } else if (mul) {
            stemp = tv1.getText().toString();
            n2 = Double.parseDouble(stemp);
            ans = n1 * n2;
        } else if (div) {
            stemp = tv1.getText().toString();
            n2 = Double.parseDouble(stemp);
            if (n1 == 0) {
                tv2.setText(getResources().getString(R.string.cannotdiv));
                return;
            }
            if (n2 == 0) {
                tv2.setText("");
            } else {
                ans = n1 / n2;
            }
        }

        tv2.setText(nf.format(ans));

        /*if (ans == (long) ans)
            tv2.setText(String.format(Locale.ENGLISH, "%d", (long) ans));
        else {
            tv2.setText(String.format(Locale.ENGLISH, "%.4f", ans));
        }*/
    }

    public void removetv1() {
        String txt = (String) tv1.getText();
        txt = txt.length() > 1 ? txt.substring(0, txt.length() - 1) : "";
        tv1.setText(txt);
    }

    public void removedemo() {
        String txt1 = (String) tvdemo.getText();
        txt1 = txt1.length() > 1 ? txt1.substring(0, txt1.length() - 1) : "";
        tvdemo.setText(txt1);
    }

    @Override
    public void onClick(View v) {
        scrollMyView();

        switch (v.getId()) {

            case R.id.button1:
                if (tv1.getText() == "0") {
                    removetv1();
                }
                if (tvdemo.getText() == "0") {
                    removedemo();
                }
                tv1.setText(String.format("%s%s", tv1.getText(), getString(R.string.str_1)));
                tvdemo.setText(String.format("%s%s", tvdemo.getText(), getString(R.string.str_1)));
                chk = false;
                operation();
                break;

            case R.id.button2:
                if (tv1.getText() == "0") {
                    removetv1();
                }
                if (tvdemo.getText() == "0") {
                    removedemo();
                }
                tv1.setText(String.format("%s%s", tv1.getText(), getString(R.string.str_2)));
                tvdemo.setText(String.format("%s%s", tvdemo.getText(), getString(R.string.str_2)));
                chk = false;
                operation();
                break;

            case R.id.button3:
                if (tv1.getText() == "0") {
                    removetv1();
                }
                if (tvdemo.getText() == "0") {
                    removedemo();
                }
                tv1.setText(String.format("%s%s", tv1.getText(), getString(R.string.str_3)));
                tvdemo.setText(String.format("%s%s", tvdemo.getText(), getString(R.string.str_3)));
                chk = false;
                operation();
                break;

            case R.id.button4:
                if (tv1.getText() == "0") {
                    removetv1();
                }
                if (tvdemo.getText() == "0") {
                    removedemo();
                }
                tv1.setText(String.format("%s%s", tv1.getText(), getString(R.string.str_4)));
                tvdemo.setText(String.format("%s%s", tvdemo.getText(), getString(R.string.str_4)));
                chk = false;
                operation();
                break;

            case R.id.button5:
                if (tv1.getText() == "0") {
                    removetv1();
                }
                if (tvdemo.getText() == "0") {
                    removedemo();
                }
                tv1.setText(String.format("%s%s", tv1.getText(), getString(R.string.str_5)));
                tvdemo.setText(String.format("%s%s", tvdemo.getText(), getString(R.string.str_5)));
                chk = false;
                operation();
                break;

            case R.id.button6:
                if (tv1.getText() == "0") {
                    removetv1();
                }
                if (tvdemo.getText() == "0") {
                    removedemo();
                }
                tv1.setText(String.format("%s%s", tv1.getText(), getString(R.string.str_6)));
                tvdemo.setText(String.format("%s%s", tvdemo.getText(), getString(R.string.str_6)));
                chk = false;
                operation();
                break;

            case R.id.button7:
                if (tv1.getText() == "0") {
                    removetv1();
                }
                if (tvdemo.getText() == "0") {
                    removedemo();
                }
                tv1.setText(String.format("%s%s", tv1.getText(), getString(R.string.str_7)));
                tvdemo.setText(String.format("%s%s", tvdemo.getText(), getString(R.string.str_7)));
                chk = false;
                operation();
                break;

            case R.id.button8:
                if (tv1.getText() == "0") {
                    removetv1();
                }
                if (tvdemo.getText() == "0") {
                    removedemo();
                }
                tv1.setText(String.format("%s%s", tv1.getText(), getString(R.string.str_8)));
                tvdemo.setText(String.format("%s%s", tvdemo.getText(), getString(R.string.str_8)));
                chk = false;
                operation();
                break;

            case R.id.button9:
                if (tv1.getText() == "0") {
                    removetv1();
                }
                if (tvdemo.getText() == "0") {
                    removedemo();
                }
                tv1.setText(String.format("%s%s", tv1.getText(), getString(R.string.str_9)));
                tvdemo.setText(String.format("%s%s", tvdemo.getText(), getString(R.string.str_9)));
                chk = false;
                operation();
                break;

            case R.id.button0:
                if (tv1.getText() == "0") {
                    removetv1();
                }
                tv1.setText(String.format("%s%s", tv1.getText(), getString(R.string.str_0)));
                if (tvdemo.getText() == "0") {
                    removedemo();
                }
                tvdemo.setText(String.format("%s%s", tvdemo.getText(), getString(R.string.str_0)));
                chk = false;
                operation();
                break;


            case R.id.button_plus:
                if (chk) {
                    removedemo();
                }
                chk = true;
                tvdemo.setText(String.format("%s%s", tvdemo.getText(), getString(R.string.str_plus)));
                tv1.setText("0");
                point = true;
                add = true;
                div = false;
                mul = false;
                sub = false;
                s1temp = tv2.getText().toString().replace(",", "");
                n1 = Double.parseDouble(s1temp);
                operation();
                break;

            case R.id.button_minus:
                if (chk) {
                    removedemo();
                }
                chk = true;
                tvdemo.setText(String.format("%s%s", tvdemo.getText(), getString(R.string.str_minus)));
                tv1.setText("0");
                point = true;
                sub = true;
                div = false;
                mul = false;
                add = false;
                s1temp = tv2.getText().toString().replace(",", "");
                n1 = Double.parseDouble(s1temp);
                operation();
                break;

            case R.id.button_mul:
                if (chk) {
                    removedemo();
                }
                chk = true;
                tvdemo.setText(String.format("%s%s", tvdemo.getText(), getString(R.string.str_mul)));
                tv1.setText("0");
                point = true;
                mul = true;
                div = false;
                add = false;
                sub = false;
                s1temp = tv2.getText().toString().replace(",", "");
                n1 = Double.parseDouble(s1temp);
                operation();
                break;

            case R.id.button_div:
                if (chk) {
                    removedemo();
                }
                chk = true;
                tvdemo.setText(String.format("%s%s", tvdemo.getText(), getString(R.string.str_div)));
                tv1.setText("0");
                point = true;
                div = true;
                add = false;
                mul = false;
                sub = false;
                s1temp = tv2.getText().toString().replace(",", "");
                n1 = Double.parseDouble(s1temp);
                operation();
                break;

            case R.id.button_ac:
                tv1.setText("0");
                tv2.setText("0");
                tvdemo.setText("0");
                add = true;
                point = true;
                chk = false;
                s1temp = tv2.getText().toString().replace(",", "");
                n1 = Double.parseDouble(s1temp);
                break;

            case R.id.button_Cal:
                if (tv1.getText() == "0" && !chk) {
                    removedemo();
                    chk = true;
                }
                if (tv1.length() > 0 && tv1.getText() != "0") {
                    String txt1 = (String) tvdemo.getText();
                    txt1 = txt1.length() > 1 ? txt1.substring(0, txt1.length() - 1) : "";
                    tvdemo.setText(txt1);
                }

                String txt = (String) tv1.getText();
                txt = txt.length() > 1 ? txt.substring(0, txt.length() - 1) : "0";
                tv1.setText(txt);
                operation();
                break;

            case R.id.button_point:
                if (point) {
                    tv1.setText(String.format("%s%s", tv1.getText(), getString(R.string.str_point)));
                    tvdemo.setText(String.format("%s%s", tvdemo.getText(), getString(R.string.str_point)));
                    point = false;
                }
                break;

            case R.id.button_T:
                if (tv2.getText().toString().replace(",", "").equals("4588")) {
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(intent);
                    finish();
                } else {
                    if (tv2.getCurrentTextColor() == getResources().getColor(R.color.colorPrimary)) {
                        tv2.setTextColor(getResources().getColor(R.color.colorAccent1));
                    } else if (tv2.getCurrentTextColor() == getResources().getColor(R.color.colorAccent1)) {
                        tv2.setTextColor(getResources().getColor(R.color.colorAccent2));
                    } else if (tv2.getCurrentTextColor() == getResources().getColor(R.color.colorAccent2)) {
                        tv2.setTextColor(getResources().getColor(R.color.colorAccent3));
                    } else {
                        tv2.setTextColor(getResources().getColor(R.color.colorPrimary));
                    }
                }
                break;
        }
    }
}
