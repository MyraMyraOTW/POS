package com.example.myriad.pos;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private double total;
    private String pattern = "0.##";
    private int ttype,taxchk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.b1).setOnClickListener(num);
        findViewById(R.id.b2).setOnClickListener(num);
        findViewById(R.id.b3).setOnClickListener(num);
        findViewById(R.id.b4).setOnClickListener(num);
        findViewById(R.id.b5).setOnClickListener(num);
        findViewById(R.id.b5).setOnClickListener(num);
        findViewById(R.id.b6).setOnClickListener(num);
        findViewById(R.id.b7).setOnClickListener(num);
        findViewById(R.id.b8).setOnClickListener(num);
        findViewById(R.id.b9).setOnClickListener(num);
        findViewById(R.id.b0).setOnClickListener(num);
        findViewById(R.id.b00).setOnClickListener(num);
        findViewById(R.id.dot).setOnClickListener(num);

        findViewById(R.id.groc).setOnClickListener(op);
        findViewById(R.id.auto).setOnClickListener(op);
        findViewById(R.id.general).setOnClickListener(op);
        findViewById(R.id.clear).setOnClickListener(op);
        findViewById(R.id.gst).setOnClickListener(op);
        findViewById(R.id.pst).setOnClickListener(op);
        findViewById(R.id.total).setOnClickListener(op);
        findViewById(R.id.refund).setOnClickListener(op);

        TextView resultsstd = (TextView) findViewById(R.id.tview);
        resultsstd.setTextColor(Color.parseColor("#ffe650"));

    }

    private View.OnClickListener num = new View.OnClickListener() {
        public void onClick(View v) {
            TextView resultsstd = (TextView) findViewById(R.id.tview);
            Button std = (Button)v;
            resultsstd.append(std.getText().toString());
        }
    };

    private View.OnClickListener op = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DecimalFormat fmat = new DecimalFormat(pattern);
            TextView resultsstd = (TextView) findViewById(R.id.tview);
            double item, temp;
            switch (v.getId()){
                case R.id.groc:
                    item = Double.parseDouble(resultsstd.getText().toString());
                    switch (taxchk){
                        case 1:
                            temp = tax(item);
                            item = temp;
                            break;
                        case 0:
                            break;
                    }
                    total = total + item;
                    resultsstd.setText("");
                    taxchk = 0;
                    break;
                case R.id.auto:
                    item = Double.parseDouble(resultsstd.getText().toString());
                    switch (taxchk){
                        case 1:
                            temp = tax(item);
                            item = temp;
                            break;
                        case 0:
                            break;
                    }
                    total = total + item;
                    resultsstd.setText("");
                    taxchk = 0;
                    break;
                case R.id.general:
                    item = Double.parseDouble(resultsstd.getText().toString());
                    switch (taxchk){
                        case 1:
                            temp = tax(item);
                            item = temp;
                            break;
                        case 0:
                            break;
                    }
                    total = total + item;
                    resultsstd.setText("");
                    taxchk = 0;
                    break;
                case R.id.clear:
                    resultsstd.setText("");
                    taxchk = 0;
                    break;
                case R.id.gst:
                    taxchk = 1;
                    ttype = 1;
                    break;
                case R.id.pst:
                    taxchk = 1;
                    ttype = 2;
                    break;
                case R.id.total:
                    resultsstd.setText(fmat.format(total));
                    taxchk = 0;
                    total = 0;
                    break;
                case R.id.refund:
                    taxchk = 0;
                    item = Double.parseDouble(resultsstd.getText().toString());
                    total = total - item;
                    resultsstd.setText("");
                    break;
            }
        }
    };

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        TextView resultsstd = (TextView) findViewById(R.id.tview);
        outState.putString("totalValue", resultsstd.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        TextView resultsstd = (TextView) findViewById(R.id.tview);
        resultsstd.setText(savedInstanceState.getString("totalValue"));
    }

    private double tax(double x){
        double temp;
        switch (ttype){
            case 1:
                temp = x * .05;
                x = x + temp;
                break;
            case 2:
                temp = x * .07;
                x = x + temp;
                break;
        }
        return x;
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
}
