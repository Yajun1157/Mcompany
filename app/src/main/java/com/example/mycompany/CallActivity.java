package com.example.mycompany;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class CallActivity extends AppCompatActivity {
    EditText edit_name , edit_phone, edit_mail;
    CheckBox chk_agree;
    Button btn_mail, btn_callcenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        edit_name = findViewById(R.id.edit_name);
        edit_phone = findViewById(R.id.edit_phone);
        edit_mail = findViewById(R.id.edit_mail);
        chk_agree = findViewById(R.id.chk_agree);
        btn_mail = findViewById(R.id.btn_mail);
        btn_callcenter = findViewById(R.id.btn_callcenter);

        //콜센터에 전화걸기
        btn_callcenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:080-1111-2222"));
                try{
                    startActivity(intent);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        //메신저 보내기
        //이름, 전화번호, 상담내용, 개인정보 동의에 대해서
        //입력여부를 확인한다.

        btn_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edit_name.length()<1){
                    Toast.makeText(CallActivity.this, "이름을 입력하세요", Toast.LENGTH_SHORT).show();
                    edit_name.requestFocus();
                }
                else if(edit_phone.length()<1){
                    Toast.makeText(CallActivity.this, "전화번호를 입력하세요", Toast.LENGTH_SHORT).show();
                    edit_phone.requestFocus();
                }else if(edit_mail.length()<1){
                    Toast.makeText(CallActivity.this, "상담내용을 입력하세요", Toast.LENGTH_SHORT).show();
                    edit_mail.requestFocus();
                }else if(!chk_agree.isChecked()){
                    Toast.makeText(CallActivity.this, "개인정보 제공방침에 동의해주세요", Toast.LENGTH_SHORT).show();
                    chk_agree.requestFocus();
                }else{
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setData(Uri.parse("smsto:"));
                    intent.putExtra("sms_body", edit_mail.getText().toString());
                    startActivity(intent);
                }

            }
        });
    }
}