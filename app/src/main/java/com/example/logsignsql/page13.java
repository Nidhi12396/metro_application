package com.example.logsignsql;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;  // Don't forget this
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class page13 extends AppCompatActivity {

    Button payButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page13);  // Link to your XML layout file

        payButton = findViewById(R.id.pay_button);  // Button id from XML file

        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String upiId = "yashvaghela1105@oksbi";
                String name = "nidhivaghela";
                String amount = "1";

                String url = "upi://pay?pa=" + upiId + "&pn=" + name + "&am=" + amount + "&cu=INR";

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                intent.setPackage("com.google.android.apps.nbu.paisa.user");  // Package name of Google Pay

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Toast.makeText(page13.this, "Google Pay is not installed", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
