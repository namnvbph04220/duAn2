package com.example.user.myapplication.View.tinhkalo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.example.user.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 7/18/2017.
 */

public class TinhCaLoActivity extends AppCompatActivity {

    private Spinner spnLuaChon;
    private EditText etChieuCao;
    private EditText etCanNang;
    private EditText etTuoi;
    private RadioButton radio_vuaPhai;
    private RadioButton radio_caoi;
    private RadioButton radio_it;
    private RadioButton radio_voCungCao;
    private RadioButton radio_nam;
    private RadioButton radio_nu;
    private Button btnKetQuaAndroid;
    private TextView txtKaloHq;
    double kaloCan;
    double ketqua;
    String kqx = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tinhcalo_layout);
        init();
        List<String> list = new ArrayList<>();
        list.add("Select...");
        list.add("Tăng cân");
        list.add("Giảm cân");
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spnLuaChon.setAdapter(adapter);
        btnKetQuaAndroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = spnLuaChon.getSelectedItemPosition();
                double chieuCao = Double.valueOf(etChieuCao.getText().toString());
                double canNang = Double.valueOf(etCanNang.getText().toString());
                double tuoi = Double.valueOf(etTuoi.getText().toString());
                if (etCanNang.getText().toString() != null && etChieuCao.getText().toString() != null &&
                        etTuoi.getText().toString() != null) {
                    if (radio_nam.isChecked()) {
                        ketqua = 66 + (13.7 * canNang) + (5 * chieuCao) + (6.8 * tuoi);
                    } else if (radio_nu.isChecked()) {
                        ketqua = 655 + (9.6 * canNang) + (1.8 * chieuCao) + (4.7 * tuoi);
                    } else {
                        Toast.makeText(TinhCaLoActivity.this, "Chọn giới tính", Toast.LENGTH_SHORT).show();
                    }
                    if (radio_nam.isChecked() || radio_nu.isChecked()) {
                        if (radio_it.isChecked()) {
                            kaloCan = ketqua * 1.2;
                        } else if (radio_vuaPhai.isChecked()) {
                            kaloCan = ketqua * 1.375;
                        } else if (radio_caoi.isChecked()) {
                            kaloCan = ketqua * 1.55;
                        } else if (radio_voCungCao.isChecked()) {
                            kaloCan = ketqua * 1.99;
                        } else {
                            Toast.makeText(TinhCaLoActivity.this, "Chọn mức vận động", Toast.LENGTH_SHORT).show();
                        }
                    }
                    if (kaloCan != -1) {
                        switch (i) {
                            case 0:
                                kqx = "Bạn cần " + kaloCan + " để duy trì cân lặng";
                                break;
                            case 1:
                                kqx = "Bạn cần " + (kaloCan + 500) + " để tăng 0.5kg trên 1 tuần";
                                break;
                            case 2:
                                kqx = "Bạn cần " + (kaloCan - 500) + " để giảm 0.5kg trên 1 tuần";
                                break;
                        }
                    }
                    Toast.makeText(TinhCaLoActivity.this, kqx, Toast.LENGTH_SHORT).show();
                    txtKaloHq.setText(kqx);
                } else {
                    Toast.makeText(TinhCaLoActivity.this, "Nhập thông tin", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void init() {
        spnLuaChon = (Spinner) findViewById(R.id.spnLuaChon);
        btnKetQuaAndroid = (Button) findViewById(R.id.btnKetQuaAndroid);
        radio_nu = (RadioButton) findViewById(R.id.radio_nu);
        radio_nam = (RadioButton) findViewById(R.id.radio_nam);
        radio_voCungCao = (RadioButton) findViewById(R.id.radio_voCungCao);
        radio_it = (RadioButton) findViewById(R.id.radio_it);
        radio_caoi = (RadioButton) findViewById(R.id.radio_caoi);
        radio_vuaPhai = (RadioButton) findViewById(R.id.radio_vuaPhai);
        etTuoi = (EditText) findViewById(R.id.etTuoi);
        etCanNang = (EditText) findViewById(R.id.etCanNang);
        etChieuCao = (EditText) findViewById(R.id.etChieuCao);
        txtKaloHq = (TextView) findViewById(R.id.txtKaloHq);
    }
}
