package com.example.mycompany;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class infoActivity extends AppCompatActivity implements View.OnClickListener {

    int imgno = 0;
    int imgsp[] = {R.drawable.unnamed,R.drawable.info2,R.drawable.info3
                    ,R.drawable.info4,R.drawable.info5};
    String txts[] = {"https로 안전하게",
                    "방어막처럼","절대 안열리는 자물쇠 처럼","안전한","보안회사"};
    ImageView img_info;
    TextView tXT_info;
    Button btn_info_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        img_info = findViewById(R.id.img_info);
        tXT_info = findViewById(R.id.txt_info);
        btn_info_back = findViewById(R.id.btn_info_back);

        img_info.setOnClickListener(this);
        btn_info_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_info:
                Log.d("TEST", "이미지 클릭");
                imgno = ++imgno %5;
                img_info.setImageResource(imgsp[imgno]);
                tXT_info.setText(txts[imgno]);
                break;
            case R.id.btn_info_back:
                Log.d("TEST", "이미지 클릭");
                finish();
                break;
        }
    }
}