package com.example.zakatgold;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar myToolbar;
    RadioGroup radioGroup;
    RadioButton radioButton;
    Button btnCalculate;
    double value;
    EditText weightInput, currentPrice;
    TextView display, payable, zakat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle(R.string.app_name);

        btnCalculate = findViewById(R.id.calculateButton);
        radioGroup = findViewById(R.id.radiogroup);
        weightInput = findViewById(R.id.weightInput);
        currentPrice = findViewById(R.id.currentPrice);
        display = findViewById(R.id.display);
        payable = findViewById(R.id.payable);
        zakat = findViewById(R.id.zakat);
        btnCalculate.setOnClickListener(this);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.item_share) {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, "This is our Project Application URL - https://github/AfiqAfrina/zakatGold/");
            startActivity(Intent.createChooser(shareIntent, null));

            return true;
        } else if (item.getItemId() == R.id.item_about) {
            Intent aboutIntent = new Intent(this, AboutActivity.class);
            startActivity(aboutIntent);
            Toast.makeText(this, "This is About Page", Toast.LENGTH_SHORT).show();
        }
        return false;
    }


    @Override
    public void onClick(View v) {
        String input = weightInput.getText().toString();
        String input1 = currentPrice.getText().toString();
        double weight = 0.0;
        double price = 0.0;
        try {
            weight = Double.parseDouble(input);
            price = Double.parseDouble(input1);

        } catch (NumberFormatException nfe) {
            Toast.makeText(this, "Please Fill in the Weight ", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Please Fill in current gold value", Toast.LENGTH_SHORT).show();

        }


        int selectId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(selectId);
        if (selectId == -1) {
            Toast.makeText(MainActivity.this, "Please Select!!!!!!!!", Toast.LENGTH_SHORT).show();

        } else if (radioButton.getId() == R.id.wearID) {
            double typeWeight = 200;
            double totalValue = weight * price;
            display.setText((String.format("Total value of Gold: RM %.2f ", totalValue)));

            double totalWeight = weight - typeWeight;
            if (totalWeight > 0) {
                double totalPayable = totalWeight * price;
                payable.setText((String.format("Total gold value that is zakat payable: RM %.2f ", totalPayable)));
                double totalZakat = (2.5 / 100) * totalPayable;
                zakat.setText((String.format("The total zakat : RM %.2f ", totalZakat)));

            } else {
                double totalPayable = 0;
                payable.setText((String.format("Total gold value that is zakat payable: RM %.2f ", totalPayable)));
                double totalZakat = (2.5 / 100) * totalPayable;
                zakat.setText((String.format("The total zakat : RM %.2f ", totalZakat)));
            }


        } else if (radioButton.getId() == R.id.KeepID) {
            double typeWeight = 85;
            double totalValue = weight * price;
            display.setText((String.format("Total value of Gold: RM %.2f ", totalValue)));

            double totalWeight = weight - typeWeight;
            if (totalWeight > 0) {
                double totalPayable = totalWeight * price;
                payable.setText((String.format("Total gold value that is zakat payable: RM %.2f ", totalPayable)));
                double totalZakat = (2.5 / 100) * totalPayable;
                zakat.setText((String.format("The total zakat must pay: RM %.2f ", totalZakat)));

            } else {
                double totalPayable = 0;
                payable.setText((String.format("Total gold value that is zakat payable: RM %.2f ", totalPayable)));
                double totalZakat = (2.5 / 100) * totalPayable;
                zakat.setText((String.format("The total zakat must pay : RM %.2f ", totalZakat)));
            }


        }
    }
}