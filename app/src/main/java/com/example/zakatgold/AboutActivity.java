package com.example.zakatgold;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class AboutActivity extends AppCompatActivity {

    Toolbar aboutToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        aboutToolbar= findViewById(R.id.about_toolbar);
        setSupportActionBar(aboutToolbar);
        getSupportActionBar().setTitle("About");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        TextView linkgithub = findViewById(R.id.GithubLink);
        linkgithub.setMovementMethod(LinkMovementMethod.getInstance());



    }

    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == android.R.id.home){

            super.onBackPressed();
            Toast.makeText(this," This is Home Page", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
