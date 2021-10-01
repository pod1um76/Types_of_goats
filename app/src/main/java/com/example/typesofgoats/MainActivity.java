package com.example.typesofgoats;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setNewTextClick(View view) {
        TextView changeNewNextButton = findViewById(R.id.quantityTitleTextView);
        changeNewNextButton.setText("Hello Vika!");
    }
}
