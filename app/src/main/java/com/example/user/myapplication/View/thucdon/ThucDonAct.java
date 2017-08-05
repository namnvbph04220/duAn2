package com.example.user.myapplication.View.thucdon;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.myapplication.DTO.MonDTO;
import com.example.user.myapplication.Model.CustomMonViewAdapter;
import com.example.user.myapplication.R;
import com.example.user.myapplication.View.chonthucdon.ChonThucDonActivity;
import com.example.user.myapplication.dao.MonDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 8/5/2017.
 */

public class ThucDonAct extends AppCompatActivity {
    ListView lvThucDonDaChon;
    TextView txtTongCaloThucDon;
    MonDAO monDAO;
    List<MonDTO> monDTOs;
    int cong;
    CustomMonViewAdapter adapter;
    Button btnTinhTongCalo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thuc_don_layout);
        init();
        cong = 0;
        monDTOs = new ArrayList<>();
        monDAO = new MonDAO(this);
        monDAO.open();
        monDTOs = monDAO.ListMonAn();
        adapter = new CustomMonViewAdapter(ThucDonAct.this, R.layout.custom_mon_layout, monDTOs);
        lvThucDonDaChon.setAdapter(adapter);
        for (int i = 0; i < monDTOs.size(); i++) {
            cong += monDTOs.get(i).getKalo();
        }
        txtTongCaloThucDon.setText(cong + "");
        registerForContextMenu(lvThucDonDaChon);
        btnTinhTongCalo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cong = 0;
                for (int i = 0; i < monDTOs.size(); i++) {
                    cong += monDTOs.get(i).getKalo();
                }
                txtTongCaloThucDon.setText(cong + "");
            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.xoamon_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemXoa:
                AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                MonDTO monDTO = monDTOs.get(menuInfo.position);
                if (monDAO.deleteMonDTO(monDTO)) {
                    adapter.remove(monDTO);
                    adapter.notifyDataSetChanged();
                    Toast.makeText(ThucDonAct.this, "Xóa thành công", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ThucDonAct.this, "Xóa thất bại", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.itemThoatXoa:
                break;
        }
        return super.onContextItemSelected(item);
    }

    public void init() {
        lvThucDonDaChon = (ListView) findViewById(R.id.lvThucDonDaChon);
        txtTongCaloThucDon = (TextView) findViewById(R.id.txtTongCaloThucDon);
        btnTinhTongCalo = (Button) findViewById(R.id.btnTinhTongCalo);
    }
}
