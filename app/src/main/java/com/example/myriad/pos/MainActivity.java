package com.example.myriad.pos;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.EventLogTags;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.*;


public class MainActivity extends AppCompatActivity implements Cashier.OnFragmentInteractionListener{

    public double taxvarg=.05;
    public double taxvarp=.07;

    public int can_be_tax = 0;
    public boolean type_tax = false;

    private double value = 0.0;

    private String fileName = "receipt.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();



    }

    public void appendText(String text){
        TextView resultsstd = (TextView) findViewById(R.id.tview);
        resultsstd.append(text);
    }

    public void clearText(){
        TextView resultsstd = (TextView) findViewById(R.id.tview);
        resultsstd.setText("");
    }

    public double taxable(){
        TextView resultsstd = (TextView) findViewById(R.id.tview);
        String temp = resultsstd.getText().toString();

        double test;
        double test2;

        test = Double.parseDouble(temp);

        if (can_be_tax == 1){
            if (type_tax == true){
                test2 = test * taxvarg;
                test = test + test2;
            }

            if(type_tax == false) {
                test2 = test * taxvarp;
                test = test + test2;
            }
        }

        return test;
    }

    public void itemhandler (int chk){
        TextView resultsstd = (TextView) findViewById(R.id.tview);
        switch (chk){
            case 1:
                resultsstd.setText(String.valueOf(taxable()));
                break;
            case 2:

                break;
            case 3:

                break;
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onFragmentInteraction(String string, int chk) {
        FragmentManager FragManager = getFragmentManager();

        if(chk == 0){
            appendText(string);
        }

        if(string.equals("Clear") && chk == 1) {
            clearText();
        }

        if(string.equals("Grocery") && chk == 1){
            itemhandler(1);
        }

        if(string.equals("Auto") && chk == 1){

        }

        if(string.equals("General") && chk == 1){

        }

        if(string.equals("GST") && chk == 1){
            can_be_tax = 1;
            type_tax = true;
        }

        if(string.equals("PST") && chk == 1){
            can_be_tax = 1;
            type_tax = false;
        }
    }

}
