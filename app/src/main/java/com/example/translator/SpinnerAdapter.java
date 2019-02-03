package com.example.translator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SpinnerAdapter extends ArrayAdapter {

    private LayoutInflater inflater;
    private ArrayList<SpinnerItem> items;

    public SpinnerAdapter(Context context, ArrayList<SpinnerItem> items) {
        super(context, 0, items);
        this.items = items;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return  initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.spinner_item, parent, false);
        }

        TextView tvLanguageName   = convertView.findViewById(R.id.tvLanguageName);
        ImageView imgLanguageFlag = convertView.findViewById(R.id.imgLanguageFlag);

        tvLanguageName.setText( items.get(position).getLanguageName() );
        imgLanguageFlag.setImageResource( items.get(position).getLanguageFlag() );
        return convertView;
    }


}
