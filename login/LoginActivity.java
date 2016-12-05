package com.bw.hhzmy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.bw.hhzmy.util.PhoneFormatCheckUtils;

public class LoginActivity extends AppCompatActivity {

    private ImageButton login_title_img;
    private EditText login_Account_edit;
    private EditText login_Password_edit;
    private Button loginbutton;
    private ImageButton login_registerButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //找控件
        LoginFindView();
        //绑定监听
        setListener();
    }

    /**
     * 绑定监听
     */
    private void setListener() {
        login_title_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //登陆判断账号和密码
                MyLogin();
            }
        });
        login_registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //跳转注册模块
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
    }

    /**
     * 登陆判断账号和密码
     */
    private void MyLogin() {
        String mAccount= login_Account_edit.getText().toString().trim();
        String mPassword= login_Password_edit.getText().toString().trim();
        if (TextUtils.isEmpty(mAccount)||TextUtils.isEmpty(mPassword)) {
            Toast.makeText(LoginActivity.this,"密码或账号为空",Toast.LENGTH_SHORT).show();

        }else {
            if (PhoneFormatCheckUtils.isChinaPhoneLegal(mAccount)) {
                Toast.makeText(LoginActivity.this,"登陆成功",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(LoginActivity.this,"手机号有误",Toast.LENGTH_SHORT).show();
            }
        }
    }

    /**
     * 找控件
     */
    private void LoginFindView() {
        login_title_img= (ImageButton) findViewById(R.id.login_title_img);
        login_Account_edit= (EditText) findViewById(R.id.login_Account_edit);
        login_Password_edit= (EditText) findViewById(R.id.login_Password_edit);
        loginbutton= (Button) findViewById(R.id.login_loginbutton);
        login_registerButton= (ImageButton) findViewById(R.id.login_registerButton);
    }

}
