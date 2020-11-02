package com.example.takeImagesAndStore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartTakingPictures extends AppCompatActivity {
    Button takePicture;
    Bundle send = new Bundle();
    int count = 0;
    Bundle recieve = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_taking_pictures);
        takePicture = findViewById(R.id.takepicture);
        takePicture.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(getIntent().getExtras() != null) {
                    recieve = getIntent().getExtras();
                    count = recieve.getInt("counter");
                }
                send.putInt("count",count);
                Intent intent = new Intent(StartTakingPictures.this, MainActivity.class);
                intent.putExtras(send);
                startActivity(intent);
            }
        });
    }
}