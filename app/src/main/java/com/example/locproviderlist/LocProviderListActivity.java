package com.example.locproviderlist;

import androidx.appcompat.app.AppCompatActivity;

import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class LocProviderListActivity extends AppCompatActivity {
    TextView mTextView;
    LocationManager lm;
    List<String> locProvsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.txtOutput);
        lm=(LocationManager) getSystemService(LOCATION_SERVICE);

        locProvsList = lm.getAllProviders();

        String s = "";
        for(int i=0; i<locProvsList.size(); i++){
            s+="loc.Provider:" + locProvsList.get(i) + "\n" + "Status :"
                    +lm.isProviderEnabled(locProvsList.get(i)) + "\n\n";
        }
        mTextView.setText(s);
    }
}