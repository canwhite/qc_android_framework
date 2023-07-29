package com.example.qcframework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qcframework.utils.SingleTonMMKV;
import com.tencent.mmkv.MMKV;

public class LoginActivity extends AppCompatActivity {

    private EditText accountEdit;
    private EditText passwordEdit;
    private Button login;
    private CheckBox rememberPass;
    private MMKV mmkv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //设定MMKV的根目录
        SingleTonMMKV.getInstance().initMMKVWithContext(this);

        //获取
        boolean islogin = SingleTonMMKV.getInstance().getBoolvalueByKey("isLogin");
        if (islogin){

            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);

        }

        //账号
        accountEdit = (EditText) findViewById(R.id.account);
        accountEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE){
                    int id = v.getId();
                    if (id == R.id.account){
                        //失去焦点
                        v.clearFocus();
                    }
                }
                return false;
            }
        });

        //密码
        passwordEdit = (EditText) findViewById(R.id.password);
        passwordEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if (actionId == EditorInfo.IME_ACTION_DONE){
                    int id = v.getId();
                    if (id == R.id.password){
                        //失去焦点
                        v.clearFocus();
                    }
                }
                return false;
            }
        });


        rememberPass = (CheckBox) findViewById(R.id.remember_pass);
        rememberPass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked){
                    //判断非空的话记住
                    String account =  accountEdit.getText().toString();
                    String password = passwordEdit.getText().toString();
                    if (!TextUtils.isEmpty(account) && !TextUtils.isEmpty(password)){


                        SingleTonMMKV.getInstance().setkeyAndStringValue("account",account);
                        SingleTonMMKV.getInstance().setkeyAndStringValue("password",password);
                        SingleTonMMKV.getInstance().setKeyAndBoolValue("remember_password",true);

                        rememberPass.setChecked(true);




                    }else{

                        Toast.makeText(LoginActivity.this,"请输入账号密码",Toast.LENGTH_SHORT).show();

                    }



                }else {



                    SingleTonMMKV.getInstance().setkeyAndStringValue("account","");
                    SingleTonMMKV.getInstance().setkeyAndStringValue("password","");
                    SingleTonMMKV.getInstance().setKeyAndBoolValue("remember_password",false);




                }


            }
        });

        login = (Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String account =  accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                if (account.equals("admin") && password.equals("123456")){

                    SingleTonMMKV.getInstance().setKeyAndBoolValue("isLogin",true);

                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    //finish();


                }



            }
        });



        //默认是记住密码的
        boolean isRemember=  SingleTonMMKV.getInstance().getBoolvalueByKey("remember_password");
        //如果isremember存在
        if (isRemember){


            String accoutn = SingleTonMMKV.getInstance().getStringValueByKey("account");
            String password = SingleTonMMKV.getInstance().getStringValueByKey("password");


            passwordEdit.setText(password);
            accountEdit.setText(accoutn);
            rememberPass.setChecked(true);

        }



    }
}
