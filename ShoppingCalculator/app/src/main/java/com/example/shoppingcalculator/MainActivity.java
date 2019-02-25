package com.example.shoppingcalculator;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button compute, addItem, showList;
    EditText itemName, itemPrice, itemQuantity, total;
    double salesTax;
    public static List<String> itemNameList = new ArrayList<String>();
    public static List<Double> itemPrices = new ArrayList<Double>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // BUTTONS
        compute = findViewById(R.id.computeButton);
        addItem = findViewById(R.id.main_addItemButton);
        showList= findViewById(R.id.show_listButton);

        // EDIT TEXTS
        itemName = findViewById(R.id.item_name);
        itemPrice = findViewById(R.id.item_price);
        itemQuantity = findViewById(R.id.quantity);
        total = findViewById(R.id.total);

        // Default Sales Tax
        salesTax = .0825;

        compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int items = Integer.parseInt(itemQuantity.getText().toString());
                double price = Double.parseDouble(itemPrice.getText().toString());
                if (items > 0 && price > 0) {
                    //CODE FOR COMPUTING TOTAL AMOUNT AND ADDING FIRST ITEM




                    // Last lines of onClickListener enables AddItem and ShowList buttons
                    // and changes color of text from gray to black
                    // Add item and price to both lists.
                    MainActivity.itemPrices.add(price);
                    addItem.setEnabled(true);
                    showList.setEnabled(true);
                    addItem.setTextColor(Color.BLACK);
                    showList.setTextColor(Color.BLACK);
                    compute.setEnabled(false);
                    compute.setTextColor(Color.GRAY);
                }
            }
        });

        // Changing to addItem activity upon button press
        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddItemActivity.class));
            }
        });

        // Changing to showList activity upon button press
        showList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ShoppingListActivity.class));
            }
        });
    }
}
