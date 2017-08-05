package com.example.user.myapplication.View.chonthucdon;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.myapplication.DTO.MonDTO;
import com.example.user.myapplication.Model.CustomMonViewAdapter;
import com.example.user.myapplication.R;
import com.example.user.myapplication.View.thucdon.ThucDonAct;
import com.example.user.myapplication.dao.ListMonAn;
import com.example.user.myapplication.dao.MonDAO;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by User on 7/22/2017.
 */

public class ChonThucDonActivity extends AppCompatActivity {
    Button btnTimKiem;
    Button btnThucDon;
    EditText etTimKiem;
    ListView lvChonMon;
    List<MonDTO> monDTOs;
    ListMonAn listMonAn = new ListMonAn();
    MonDAO monDAO;
    CustomMonViewAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chonthucdon_layout);
        init();
        monDTOs = new ArrayList<>();
        monDAO = new MonDAO(this);
        monDAO.open();
        monDTOs = listMonAn.getDsMonAn();
        adapter = new CustomMonViewAdapter(ChonThucDonActivity.this, R.layout.custom_mon_layout, monDTOs);
        lvChonMon.setAdapter(adapter);

        btnTimKiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etTimKiem.getText() == null) {
                    monDTOs = listMonAn.getDsMonAn();
                } else {
                    for (int i = 0; i < listMonAn.getDsMonAn().size(); i++) {
                        if (etTimKiem.getText().equals(listMonAn.getDsMonAn().get(i).getTenmon())) {
                            monDTOs.add(listMonAn.getDsMonAn().get(i));
                        } else {
                            Toast.makeText(ChonThucDonActivity.this, "Không tìm thấy món ăn này", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                adapter.notifyDataSetChanged();
            }
        });

        btnThucDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentThucDon = new Intent(ChonThucDonActivity.this, ThucDonAct.class);
                startActivity(intentThucDon);
            }
        });

        registerForContextMenu(lvChonMon);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.contex_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemChon:
                AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                MonDTO monDTO = monDTOs.get(menuInfo.position);
                if(monDAO.ThemMon(monDTO)){
                    Toast.makeText(ChonThucDonActivity.this,"Thêm thành công",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(ChonThucDonActivity.this,"Thêm thất bại",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.itemThoat:
                break;
        }
        return super.onContextItemSelected(item);
    }



    public void init() {
        lvChonMon = (ListView) findViewById(R.id.lvThucDon);
        btnTimKiem = (Button) findViewById(R.id.btnTimKiem);
        etTimKiem = (EditText) findViewById(R.id.etTimKiem);
        btnThucDon = (Button) findViewById(R.id.btnThucDon);
    }
}
