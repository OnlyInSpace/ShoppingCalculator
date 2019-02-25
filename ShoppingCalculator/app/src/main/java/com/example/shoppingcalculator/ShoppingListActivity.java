package com.example.shoppingcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ShoppingListActivity extends AppCompatActivity {

    public void init() {
        TableLayout tbLay = findViewById(R.id.table_shopping);
        for (Item item: MainActivity.shoppingItems) {
            TableRow tbRow = new TableRow(this);

            TextView t1v = new TextView(this);
            t1v.setText(item.getName());
            t1v.setPadding(0,0,20,0);
            tbRow.addView(t1v);

            TextView t2v = new TextView(this);
            t2v.setText(Double.toString(item.getPrice()));
            t2v.setPadding(0,0,20,0);
            tbRow.addView(t2v);

            TextView t3v = new TextView(this);
            t3v.setText(Double.toString(item.getQuantity()));
            t3v.setPadding(0,0,20,0);
            tbRow.addView(t3v);

            tbLay.addView(tbRow);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);
        init();
        }
    }
