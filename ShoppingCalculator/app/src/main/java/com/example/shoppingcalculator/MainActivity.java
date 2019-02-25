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
    EditText itemName, itemPrice, itemQuantity, total, salesTax;
    public static List<Item> shoppingItems = new ArrayList<Item>();

    // Global Variables
    public static double Total = 0.0;
    public double sales_Tax = 0.0;

    @Override
    public void onResume() {
        super.onResume();
        computeTotal();
        total.setText(Double.toString(Total));
    }


    public void computeTotal() {
        Total = 0.0;
        for (Item item: shoppingItems){
            Total += item.getTotal();
            double temp = Total * sales_Tax;
            Total = Total + temp;
        }
        Total = Math.round(Total*100.0) / 100.0;  //Rounding to 2 decimal places
    }
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
        salesTax = findViewById(R.id.sales_tax);

        // SALES TAX (8.25% by default)

        compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sales_Tax = Double.parseDouble(salesTax.getText().toString()) / 100;
                String name = itemName.getText().toString();
                double price = Double.parseDouble(itemPrice.getText().toString());
                price = Math.round(price*100.0) / 100.0;  //Rounding to 2 decimal places
                double quantity = Double.parseDouble(itemQuantity.getText().toString());
                shoppingItems.add(new Item(name, price, quantity));
                if (quantity > 0 && price > 0) {
                    //CODE FOR COMPUTING TOTAL AMOUNT AND ADDING FIRST ITEM
                    computeTotal();
                    total.setText(Double.toString(Total));




                    // Last lines of onClickListener enables AddItem and ShowList buttons
                    // and changes color of text from gray to black
                    // Add item and price to both lists.
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
