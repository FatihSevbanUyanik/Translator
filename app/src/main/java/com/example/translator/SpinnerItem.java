package com.example.translator;

import android.content.Context;

import java.util.ArrayList;

public class SpinnerItem {

    private String languageName;
    private int languageFlag;


    private SpinnerItem(String languageName, int languageFlag) {
        this.languageName = languageName;
        this.languageFlag = languageFlag;
    }


    public String getLanguageName() {
        return languageName;
    }


    public int getLanguageFlag() {
        return languageFlag;
    }


    public static ArrayList<SpinnerItem> getSpinnerData(Context context) {
        ArrayList<SpinnerItem> items = new ArrayList<>();
        items.add(new SpinnerItem("English" , R.drawable.flag_en));
        items.add(new SpinnerItem("Chinese" , R.drawable.flag_zh));
        items.add(new SpinnerItem("German"  , R.drawable.flag_de));
        items.add(new SpinnerItem("Italian" , R.drawable.flag_it));
        items.add(new SpinnerItem("Turkish" , R.drawable.flag_tr));
        items.add(new SpinnerItem("Dutch"   , R.drawable.flag_nl));
        items.add(new SpinnerItem("Spanish" , R.drawable.flag_es));
        items.add(new SpinnerItem("Arabic"  , R.drawable.flag_ar));
        items.add(new SpinnerItem("Finnish" , R.drawable.flag_fi));
        items.add(new SpinnerItem("Romanian", R.drawable.flag_ro));
        return items;
    }
}