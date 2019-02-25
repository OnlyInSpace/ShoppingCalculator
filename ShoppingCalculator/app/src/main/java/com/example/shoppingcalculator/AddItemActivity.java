package com.example.shoppingcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class AddItemActivity extends AppCompatActivity {

    Button addItem;
    EditText itemName, itemPrice, itemQuantity, showItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        // Button
        addItem = findViewById(R.id.addItem_Button);
        // Edit Texts
        showItems = findViewById(R.id.total_items);
        itemName = findViewById(R.id.addItem_Name);
        itemPrice = findViewById(R.id.addItem_price);
        itemQuantity = findViewById(R.id.addItem_Quantity);

        // Show number of Items
        String size = String.valueOf(MainActivity.itemPrices.size());
        showItems.setText(size);

        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //CODE FOR ADDING AN ITEM TO BOTH LISTS




                //Refresh the total amount of items in list
                String size = String.valueOf(MainActivity.itemPrices.size());
                showItems.setText(size);
            }
        });


    }
}
