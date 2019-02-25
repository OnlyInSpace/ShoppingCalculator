package com.example.shoppingcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class AddItemActivity extends AppCompatActivity {
    EditText itemName, itemPrice, itemQuantity, showItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        // Edit Texts
        showItems = findViewById(R.id.total_items);
        itemName = findViewById(R.id.addItem_Name);
        itemPrice = findViewById(R.id.addItem_price);
        itemQuantity = findViewById(R.id.addItem_Quantity);

        // Show number of Items
        String size = String.valueOf(MainActivity.shoppingItems.size());
        showItems.setText(size);


    }
}
