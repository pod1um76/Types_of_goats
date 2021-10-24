package com.example.typesofgoats;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    int quantity = 0;

    Spinner spinner;
    ArrayList<String> arrayListSpinner;
    ArrayAdapter<String> adapterSpinner;

    HashMap<String, Integer> priceForGoatsMap;
    String typeGoat;
    Double price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        arrayListSpinner = new ArrayList<>();

        arrayListSpinner.add("Коза горная");
        arrayListSpinner.add("Коза полевая");
        arrayListSpinner.add("Коза домашняя");
        arrayListSpinner.add("Коза вонючая))");

        adapterSpinner = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arrayListSpinner);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterSpinner);

        priceForGoatsMap = new HashMap<>();

        priceForGoatsMap.put("Коза горная", 8);
        priceForGoatsMap.put("Коза полевая", 7);
        priceForGoatsMap.put("Коза домашняя", 3);
        priceForGoatsMap.put("Коза вонючая))", 15);
    }

    @SuppressLint("ResourceAsColor")
    public void setNewTextClick(View view) {
        TextView changeNewNextButton = findViewById(R.id.quantityTitleTextView);
        changeNewNextButton.setText("Hello Vika!");
        changeNewNextButton.setTextSize(20);
        changeNewNextButton.setBackgroundColor(Color.BLUE);
    }

    public void increaseQuantity(View view) {
        TextView changeQuantityProducts = findViewById(R.id.zero);

        quantity++;

        String newQuantity = Integer.toString(quantity);
        changeQuantityProducts.setText(newQuantity);

        TextView priceTextView = findViewById(R.id.priceTextView);
        String sumPrice = Double.toString(quantity * price);
        priceTextView.setText(sumPrice);
    }

    public void decreaseQuantity(View view) {
        TextView changeQuantityProducts = findViewById(R.id.zero);

        if (quantity > 0) {
            quantity--;

            String newQuantity = Integer.toString(quantity);
            changeQuantityProducts.setText(newQuantity);

            TextView priceTextView = findViewById(R.id.priceTextView);
            String sumPrice = Double.toString(quantity * price);
            priceTextView.setText(sumPrice);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        typeGoat = spinner.getSelectedItem().toString();
        price = (double) priceForGoatsMap.get(typeGoat);

        TextView priceTextView = findViewById(R.id.priceTextView);
        String sumPrice = Double.toString(quantity * price);
        priceTextView.setText(sumPrice);

        ImageView goodsImageView = findViewById(R.id.goodsImageView);

        switch (typeGoat) {
            case "Коза горная":
                goodsImageView.setImageResource(R.drawable.mount_goat);
                break;
            case "Коза полевая":
                goodsImageView.setImageResource(R.drawable.meadow_goat);
                break;
            case "Коза домашняя":
                goodsImageView.setImageResource(R.drawable.home_goat);
                break;
            case "Коза вонючая))":
                goodsImageView.setImageResource(R.drawable.vika_24325oz);
                break;
            default:
                goodsImageView.setImageResource(R.drawable.mount_goat);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
