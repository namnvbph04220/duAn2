package com.example.user.myapplication.Model;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.user.myapplication.DTO.MonDTO;
import com.example.user.myapplication.R;

import java.util.List;

/**
 * Created by User on 8/4/2017.
 */
public class CustomMonViewAdapter extends ArrayAdapter<MonDTO> {
    Context context;
    int resource;
    List<MonDTO> objects;

    public CustomMonViewAdapter(Context context, int resource, List<MonDTO> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(resource,parent,false);

        TextView txtMon = (TextView) view.findViewById(R.id.txttenMon);
        TextView txtCalo = (TextView) view.findViewById(R.id.txtSoCaLo);

        txtMon.setText(objects.get(position).getTenmon().toString());
        txtCalo.setText(objects.get(position).getKalo()+"");

        return view;
    }
}
