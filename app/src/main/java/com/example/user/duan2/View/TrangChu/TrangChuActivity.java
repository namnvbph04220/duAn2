package com.example.user.duan2.View.TrangChu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.user.duan2.R;
import com.example.user.duan2.View.ChucNang.ChucNangActiviTy;

/**
 * Created by User on 7/15/2017.
 */

public class TrangChuActivity extends AppCompatActivity {
    private Button btnStart;
    private Button btrQuit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trangchu_layout);
        init();
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iChucNang = new Intent(TrangChuActivity.this, ChucNangActiviTy.class);
                startActivity(iChucNang);
            }
        });
        btrQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(1);
            }
        });

    }

    private  void  init(){
        btnStart = (Button) findViewById(R.id.btnStar);
        btrQuit = (Button) findViewById(R.id.btnQuit);
    }
}
