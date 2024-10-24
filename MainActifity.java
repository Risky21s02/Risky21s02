package com.sharedpreferences_riskyseptiani;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private TextView Hasil;
    private EditText Masukkan;
    private Button Eksekusi;

    private SharedPreferences preferences;

    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Masukkan = (EditText) findViewById(R.id.input);
        Hasil = (TextView) findViewById(R.id.output);
        Eksekusi = (Button) findViewById(R.id.save);

        preferences=getSharedPreferences("Belajar_SharedPreferences",Context.MODE_PRIVATE);

        Eksekusi.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
                Toast.makeText(getApplicationContext(),"Data Tersimpan", Toast.LENGTH_SHORT).show();
            }
        }));
    }

    private  void getData(){

        String getKonten = Masukkan.getText().toString();

        editor=preferences.edit();

        editor.putString("data_saya", getKonten);

        editor.apply();

        Hasil.setText("Output data:"+preferences.getString("data_saya",null));
    }
}
