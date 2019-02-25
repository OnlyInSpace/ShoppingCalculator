package com.example.shoppingcalculator;

import android.content.Intent;
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

    @Override
    public void onBackPressed() {
        String item_name = showItems.getText().toString();
        double item_price = Double.parseDouble(itemPrice.getText().toString());
        item_price = Math.round(item_price*100.0) / 100.0;  //Rounding to 2 decimal places
        double quantity = Double.parseDouble(itemQuantity.getText().toString());
        if (quantity > 0 && item_price > 0) {
            MainActivity.shoppingItems.add(new Item(item_name, item_price, quantity));
            Intent intent = new Intent(AddItemActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }
}
