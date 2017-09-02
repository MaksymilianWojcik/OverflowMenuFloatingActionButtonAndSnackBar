package com.example.maks.overflowmenufloatingactionbuttonandsnackbar;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{



    FloatingActionButton floatingActionButton;
    ArrayList<String> list = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    ListView listView;
    private View.OnClickListener undoOnClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(this);

        listView = (ListView) findViewById(R.id.listView1);
        //wyswietlamy liste uzywajac simple_list_item_1 wbudowanego layoutu do podstawowych stringow
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        undoOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(list.size()-1);
                adapter.notifyDataSetChanged();;
                Snackbar.make(v, "Item removed", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        };

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_example, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.mainLaoyt);

        switch(item.getItemId()){
            case R.id.menu_red:
                if (item.isChecked()) {
                    item.setChecked(false);
                } else {
                    item.setChecked(true);
                }
                layout.setBackgroundColor(Color.RED);
                return true;
            case R.id.menu_green:
                if (item.isChecked()) {
                    item.setChecked(false);
                } else {
                    item.setChecked(true);
                }
                layout.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.menu_blue:
                if (item.isChecked()) {
                    item.setChecked(false);
                } else {
                    item.setChecked(true);
                }
                layout.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.menu_yellow:
                if (item.isChecked()) {
                    item.setChecked(false);
                } else {
                    item.setChecked(true);
                }
                layout.setBackgroundColor(Color.YELLOW);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == floatingActionButton.getId()){
            addListItem();
            Snackbar.make(v, "Item added", Snackbar.LENGTH_LONG).setAction("Undo", undoOnClickListener).show();
        }
    }

    private void addListItem() {

        SimpleDateFormat date = new SimpleDateFormat("HH:mm:ss MM/dd/yyyy", Locale.GERMAN);
        list.add(date.format(new Date()));
        adapter.notifyDataSetChanged();
    }
}
