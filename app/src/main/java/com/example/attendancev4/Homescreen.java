package com.example.attendancev4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Homescreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
    }
    public void viewOSReport(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/spreadsheets/d/1hV5Sy7CMPBp928qaxjWzmQ6hIvbaPgECP00oHWvLEEA/edit#gid=0"));
        startActivity(browserIntent);
    }//----------os attendance report ----1
    public void viewSEReport(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/spreadsheets/d/1UFrDOkrfK-cXPuyC6aiRu9ZgBm-eHlb8Nr2KFoEzNQk/edit?usp=sharing"));
        startActivity(browserIntent);
    }//----------se attendance report-----2
    public void viewOSQR(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/presentation/d/1K8XzH3wcEkT1GyqrDINDuOHLg-F0G2V0fw0zs93u4Yc/edit?usp=sharing"));
        startActivity(browserIntent);
    }//----------OSQR
    public void viewSEQR(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/presentation/d/1j2L8AvGPh79UP3ZB3THre0rEvQN9ikaSa4ShJP2hOZU/edit?usp=sharing"));
        startActivity(browserIntent);
    }//----------SEQR
}
