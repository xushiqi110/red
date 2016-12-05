package com.bw.hhzmy.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.hhzmy.util.PhoneFormatCheckUtils;

public class RegisterActivity extends AppCompatActivity {

    private ImageButton Register_title_img;
    private EditText Register_phone_edit;
    private EditText Register_Verification_edit;
    private ImageView Register_Verification_img;
    private CheckBox Register_checkbox_one;
    private TextView Register_checkbox_text1;
    private TextView Register_checkbox_text3;
    private Button Register_Nextstep;
    private TextView Register_CorporateMember;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //找控件
        LoginFindView();
        //绑定监听
        setListener();
    }

    /**
     * 绑定监听
     */
    private void setListener() {
        //头部的返回
        Register_title_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //返回到登陆模块
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
        //复选框状态
        Register_checkbox_one.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            }
        });
        //会员章程
        Register_checkbox_text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        //易付宝协议
        Register_checkbox_text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        //button下一步
        Register_Nextstep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //登陆判断账号和密码
                MyLogin();
            }
        });
        //企业会员注册
        Register_CorporateMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    /**
     * 登陆判断账号和密码
     */
    private void MyLogin() {
        String phone= Register_phone_edit.getText().toString().trim();
        String Verification= Register_Verification_edit.getText().toString().trim();
        if (TextUtils.isEmpty(phone)||TextUtils.isEmpty(Verification)) {
            Toast.makeText(RegisterActivity.this,"手机号或验证码为空",Toast.LENGTH_SHORT).show();

        }else {
            if (PhoneFormatCheckUtils.isChinaPhoneLegal(phone)) {
                Toast.makeText(RegisterActivity.this,"手机号验证成功",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(RegisterActivity.this,"手机号有误",Toast.LENGTH_SHORT).show();
            }
        }
    }

    /**
     * 找控件
     */
    private void LoginFindView() {
        Register_title_img= (ImageButton) findViewById(R.id.Register_title_img);
        Register_phone_edit= (EditText) findViewById(R.id.Register_phone_edit);
        Register_Verification_edit= (EditText) findViewById(R.id.Register_Verification_edit);
        Register_Verification_img= (ImageView) findViewById(R.id.Register_Verification_img);
        Register_checkbox_one= (CheckBox) findViewById(R.id.Register_checkbox_one);
        Register_checkbox_text1= (TextView) findViewById(R.id.Register_checkbox_text1);
        Register_checkbox_text3= (TextView) findViewById(R.id.Register_checkbox_text3);
        Register_Nextstep= (Button) findViewById(R.id.Register_Nextstep);
        Register_CorporateMember= (TextView) findViewById(R.id.Register_CorporateMember);
    }
}
