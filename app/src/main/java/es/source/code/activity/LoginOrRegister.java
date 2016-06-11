package es.source.code.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginOrRegister extends Activity implements View.OnClickListener {
    private EditText login_username;
    private EditText login_password;
    private Button user_login_button;
    private Button user_return_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.activity_login_or_register);
        initWidget();
    }

    private void initWidget() {
        login_username = (EditText) findViewById(R.id.username);
        login_password = (EditText) findViewById(R.id.login_password);
        user_login_button = (Button) findViewById(R.id.login_button);
        user_return_button = (Button) findViewById(R.id.return_button);
        user_login_button.setOnClickListener(this);
        user_return_button.setOnClickListener(this);
        login_username.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String username = login_username.getText().toString().trim();
                    if (username.replaceAll("[a-z]*[A-Z]*\\d*-*_*\\s*", "").length() == 0) {
                        Toast.makeText(LoginOrRegister.this, "用户名包含非法字符！", Toast.LENGTH_SHORT);
                    }
                }
            }

        });
        login_password.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String password = login_password.getText().toString().trim();
                    if (password.replaceAll("[a-z]*[A-Z]*\\d*-*_*\\s*", "").length() != 0)
                        Toast.makeText(LoginOrRegister.this, "密码包含非法字符！", Toast.LENGTH_SHORT);
                }
            }
        });
    }

    //确认登陆还是返回
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button:
                if (checkEdit()) {
                    login();
                }

                break;
            case R.id.return_button:
                Intent intent2 = new Intent(LoginOrRegister.this, MainScreen.class);
                startActivity(intent2);
                break;
        }
    }

    //检查登录名和密码是否为空
    private boolean checkEdit() {
        if (login_username.getText().toString().trim().equals("")) {
            Toast.makeText(LoginOrRegister.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
        } else if (login_password.getText().toString().trim().equals("")) {
            Toast.makeText(LoginOrRegister.this, "密码不能为空", Toast.LENGTH_SHORT).show();
        } else {
            return true;
        }
        return false;
    }

    //登录
    private void login() {

    }
}
