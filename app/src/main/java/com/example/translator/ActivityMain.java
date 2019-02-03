package com.example.translator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@SuppressWarnings("ALL")
public class ActivityMain extends AppCompatActivity {

    private Spinner spnFrom;
    private Spinner spnTo;
    private EditText etContent;
    private TextView tvResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Translation.setupRetrofit();
        setupViews();
    }


    private void setupViews() {
        etContent = findViewById(R.id.etContent);
        spnFrom   = findViewById(R.id.spnFrom);
        spnTo     = findViewById(R.id.spnTo);
        tvResult  = findViewById(R.id.tvResult);

        SpinnerAdapter adapter1 = new SpinnerAdapter(this,
                SpinnerItem.getSpinnerData(this));

        SpinnerAdapter adapter2 = new SpinnerAdapter(this,
                SpinnerItem.getSpinnerData(this));

        spnFrom.setAdapter(adapter1);
        spnTo.setAdapter(adapter2);
        spnFrom.setSelection(4);
    }


    public void translate(View view) {

        int positionFrom = spnFrom.getSelectedItemPosition();
        int positionTo = spnTo.getSelectedItemPosition();

        String[] languageCodes = getResources().
                getStringArray( R.array.languages_code_array );

        String from    = languageCodes[ positionFrom ];
        String to      = languageCodes[ positionTo ];
        String content = etContent.getText().toString();


        Map map = new HashMap();
        map.put("key", Translation.KEY);
        map.put("text", content);
        map.put("lang", from + "-" + to);


        TranslationApi api = Translation.getRetrofit().create(TranslationApi.class);
        Call<Translation> translationCall =  api.translate(map);


        translationCall.enqueue(new Callback<Translation>() {

            @Override
            public void onResponse(Call<Translation> call, Response<Translation> response) {
                if (response.body() != null) {
                    String translation = response.body().getText()[0];
                    tvResult.setText( translation );
                }
            }

            @Override
            public void onFailure(Call<Translation> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}