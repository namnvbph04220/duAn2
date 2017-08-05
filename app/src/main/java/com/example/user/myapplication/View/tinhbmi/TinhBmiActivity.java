package com.example.user.myapplication.View.tinhbmi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.myapplication.R;

/**
 * Created by User on 7/19/2017.
 */

public class TinhBmiActivity extends AppCompatActivity {
    private EditText etChieuCao;
    private EditText etCanLang;
    private EditText etTuoi;
    private RadioButton rbNam;
    private RadioButton rbNu;
    private Button btnKetQuaAndroid;
    private TextView txtXuatKT;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tinhbmi_layout);
        init();
        btnKetQuaAndroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etChieuCao.getText().toString().trim().length() > 0 && etCanLang.getText().toString().trim().length() > 0
                        && etTuoi.getText().toString().trim().length() > 0) {
                    if (rbNam.isChecked()) {
                        double chieuCao = Double.valueOf(etChieuCao.getText().toString()) / 100;
                        double canLang = Double.valueOf(etCanLang.getText().toString());
                        double tuoi = Double.valueOf(etTuoi.getText().toString());

                        double kt = canLang / (chieuCao * chieuCao);
                        String xkq = "";
                        if (kt < 18.5) {
                            xkq = "Thiếu cân thiếu năng lượng";
                        } else if (kt > 18.5 && kt < 23) {
                            xkq = "Binhf thường";
                        } else if (kt > 23 && kt < 25) {
                            xkq = "Thừa cân";
                        } else if (kt > 25) {
                            xkq = "béo phì";
                        }
                        Toast.makeText(TinhBmiActivity.this, xkq, Toast.LENGTH_SHORT).show();
                        txtXuatKT.setText(xkq);
                    } else {
                        if (rbNu.isChecked()) {
                            double chieuCao = Double.valueOf(etChieuCao.getText().toString()) / 100;
                            double canLang = Double.valueOf(etCanLang.getText().toString());
                            double tuoi = Double.valueOf(etTuoi.getText().toString());

                            double kt = canLang / (chieuCao * chieuCao);
                            String xkq = "";
                            if (kt < 18.5) {
                                xkq = "Thiếu cân thiếu năng lượng";
                            } else if (kt > 18.5 && kt < 23) {
                                xkq = "Binhf thường";
                            } else if (kt > 23 && kt < 25) {
                                xkq = "Thừa cân";
                            } else if (kt > 25) {
                                xkq = "béo phì";
                            }
                            Toast.makeText(TinhBmiActivity.this, xkq, Toast.LENGTH_SHORT).show();
                            txtXuatKT.setText(xkq);
                        } else {
                            Toast.makeText(TinhBmiActivity.this, "Chọn nam hoặc nữ", Toast.LENGTH_SHORT).show();
                        }
                    }
                }else {
                    Toast.makeText(TinhBmiActivity.this, "Nhập thông tin", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }

    private void init() {
        etChieuCao = (EditText) findViewById(R.id.etChieuCaoBmi);
        etCanLang = (EditText) findViewById(R.id.etCanNangBmi);
        etTuoi = (EditText) findViewById(R.id.etTuoiBmi);
        rbNam = (RadioButton) findViewById(R.id.radio_nam);
        rbNu = (RadioButton) findViewById(R.id.radio_nu);
        btnKetQuaAndroid = (Button) findViewById(R.id.btnKetQuaAndroid);
        txtXuatKT = (TextView) findViewById(R.id.txtXuatKT);
    }
}
