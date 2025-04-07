package com.example.logsignsql;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

public class localization extends AppCompatActivity {

    private TextView welcomeText, appName;
    private Button btnNextPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localization);

        welcomeText = findViewById(R.id.welcomeText);
        appName = findViewById(R.id.appName);
        btnNextPage = findViewById(R.id.btnNextPage);

        Button btnEnglish = findViewById(R.id.btnEnglish);
        Button btnHindi = findViewById(R.id.btnHindi);
        Button btnGujarati = findViewById(R.id.btnGujarati);

        // Language Change Listeners
        btnEnglish.setOnClickListener(v -> setLocale("en"));
        btnHindi.setOnClickListener(v -> setLocale("hi"));
        btnGujarati.setOnClickListener(v -> setLocale("gu"));


        // Next Page Button Listener
        btnNextPage.setOnClickListener(v -> {
            Intent intent = new Intent(localization.this, homepage.class); // Change to your actual next activity
            startActivity(intent);
        });
    }

    private void setLocale(String langCode) {
        Locale locale = new Locale(langCode);
        Locale.setDefault(locale);

        Configuration config = new Configuration();
        config.setLocale(locale);

        getResources().updateConfiguration(config, getResources().getDisplayMetrics());

        // Restart activity to apply changes
        Intent refresh = new Intent(this, localization.class);
        startActivity(refresh);
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        welcomeText.setText(getString(R.string.welcome));
        appName.setText(getString(R.string.app_name));
    }
}
