package com.example.yapayzekasnflandrma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText TN,TP,FN,FP;
    Button  hesapla;
    TextView sonuc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init(){
    TN=(EditText) findViewById(R.id.TN);
    FP=(EditText) findViewById(R.id.FP);
    FN=(EditText) findViewById(R.id.FN);
    TP=(EditText) findViewById(R.id.TP);
    hesapla=(Button) findViewById(R.id.hesapla);
    sonuc=(TextView) findViewById(R.id.sonuc);
    }
    public void hesapislem(View view) {
        double TNN=0,FPP=0,FNN=0,TPP=0,accuracy=0,sens=0,pre=0,spe=0,F1=0;
        TNN=Double.parseDouble(TN.getText().toString());
        FNN=Double.parseDouble(FN.getText().toString());
        TPP=Double.parseDouble(TP.getText().toString());
        FPP=Double.parseDouble(FP.getText().toString());

        accuracy=(TPP+TNN)/(TNN+TPP+FNN+FPP);
        sens=(TPP)/(TPP+FNN);
        pre=TPP/(TPP+FPP);
        spe=TNN/(TNN+FPP);
        F1=2*(pre*sens)/(pre+sens);

        sonuc.setText("Doğruluk: "+accuracy+"\nKesinlik: "+pre+"\nHassaslık: "+sens+"\nSeçicilik: "+spe+"\nF1: "+F1);

    }
}