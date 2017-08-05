package com.example.user.myapplication.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.user.myapplication.DTO.MonDTO;
import com.example.user.myapplication.sqlite.DataMonAn;

import java.util.ArrayList;
import java.util.List;



public class MonDAO {
    SQLiteDatabase sqLiteDatabase;
    String[] clMonAn = {DataMonAn.CL_id,DataMonAn.CL_TENMON,DataMonAn.CL_kalo};
    DataMonAn monAn;

    public MonDAO(Context context){
        monAn = new DataMonAn(context);
    }
    public void open(){
        sqLiteDatabase = monAn.getWritableDatabase();
    }
    public void close(){
        monAn.close();
    }

    public boolean ThemMon(MonDTO monDTO){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataMonAn.CL_TENMON,monDTO.getTenmon().toString());
        contentValues.put(DataMonAn.CL_kalo,monDTO.getKalo());
        long id_mon = sqLiteDatabase.insert(DataMonAn.TB_Mon,null,contentValues);
        if(id_mon != 0)
            return true;
        else return false;
    }

    public List<MonDTO> ListMonAn(){
        List<MonDTO> monDTOs = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.query(DataMonAn.TB_Mon,clMonAn,null,null,null,null,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int _id = cursor.getInt(0);
            String tenmon = cursor.getString(1);
            int kalo = cursor.getInt(2);
            MonDTO monDTO = new MonDTO(_id,tenmon,kalo);
            monDTOs.add(monDTO);
            cursor.moveToNext();
        }
        return monDTOs;
    }

    public boolean deleteMonDTO(MonDTO monDTO){
        int i = sqLiteDatabase.delete(DataMonAn.TB_Mon,DataMonAn.CL_id + " = " + monDTO.get_id(),null);
        if (i != 0){
            return true;
        }else {
            return false;
        }
    }
}
