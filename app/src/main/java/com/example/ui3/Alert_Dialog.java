package com.example.ui3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.app.AlertDialog;

public class Alert_Dialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);

        // 创建对话框构建器
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // 获取布局
        View view = View.inflate(Alert_Dialog.this, R.layout.alert_view, null);
        // 获取布局中的控件
        final ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        final EditText username = (EditText) view.findViewById(R.id.username);
        final EditText password = (EditText) view.findViewById(R.id.password);
        final Button button1 = (Button) view.findViewById(R.id.btn_login);
        final Button button2 = (Button) view.findViewById(R.id.btn_cancel);
        // 设置参数
        builder.setTitle("Login").setView(view);
        // 创建对话框
        final AlertDialog alertDialog = builder.create();
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String uname = username.getText().toString().trim();
                String psd = password.getText().toString().trim();
                if (uname.equals("root") && psd.equals("123456")) {
                    Toast.makeText(Alert_Dialog.this, "登录成功", Toast.LENGTH_SHORT).show();
                }
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(Alert_Dialog.this, "退出登录",Toast.LENGTH_SHORT).show();
                alertDialog.dismiss();// 对话框消失
            }
        });
        alertDialog.show();
    }
}
