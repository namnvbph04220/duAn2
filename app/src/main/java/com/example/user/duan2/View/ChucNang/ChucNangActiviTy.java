package com.example.user.duan2.View.ChucNang;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.user.duan2.R;
import com.example.user.duan2.View.ChonThucDon.ChonThucDonActivity;
import com.example.user.duan2.View.TinhBmi.TinhBmiActivity;
import com.example.user.duan2.View.TinhKaLo.TinhCaLoActivity;

/**
 * Created by User on 7/15/2017.
 */

public class ChucNangActiviTy extends AppCompatActivity {
    private Button btnTinhCaLo;
    private Button btnTinhBIm;
    private Button btnChonThucDon;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chucnang_layout);
        init();
        btnTinhCaLo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iTinhCaLo = new Intent(ChucNangActiviTy.this, TinhCaLoActivity.class);
                startActivity(iTinhCaLo);
            }
        });
        btnTinhBIm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iTinhBmi = new Intent(ChucNangActiviTy.this, TinhBmiActivity.class);
                startActivity(iTinhBmi);
            }
        });
        btnChonThucDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iThucDon = new Intent(ChucNangActiviTy.this, ChonThucDonActivity.class);
                startActivity(iThucDon);
            }
        });
    }

    private void init(){
        btnTinhCaLo = (Button) findViewById(R.id.btnTinhLuongCalo);
        btnTinhBIm = (Button) findViewById(R.id.btnTinhBIM);
        btnChonThucDon = (Button) findViewById(R.id.btnThucDon);
    }
}
