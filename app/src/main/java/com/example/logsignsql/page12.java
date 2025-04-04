package com.example.logsignsql;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import android.net.Uri;

public class page12 extends AppCompatActivity {

    private static final String TAG = "Page12";
    private static final int QR_SIZE = 500;

    private ImageView generatedQrImage;
    private TextView ticketDetails, timeLeft;
    private Bitmap qrBitmap;
    private Button closePopupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page12);

        // Initialize UI components
        generatedQrImage = findViewById(R.id.generatedQrImage);
        ticketDetails = findViewById(R.id.ticketDetails);
        timeLeft = findViewById(R.id.timeLeft);
        closePopupBtn = findViewById(R.id.closePopupBtn);

        // Get ticket details from Intent
        Intent intent = getIntent();
        String qrData = intent.getStringExtra("qrData");
        String passengerCount = intent.getStringExtra("passengerCount");
        String fromStation = intent.getStringExtra("fromStation");
        String toStation = intent.getStringExtra("toStation");

        // Log received values for debugging
        Log.d(TAG, "Received Data -> QR: " + qrData + ", From: " + fromStation + ", To: " + toStation);

        // Ensure valid values (avoid null issues)
        if (qrData == null || qrData.isEmpty()) {
            qrData = "No QR Data Available";
        }
        if (passengerCount == null) passengerCount = "1"; // Default to 1 passenger
        if (fromStation == null) fromStation = "Unknown";
        if (toStation == null) toStation = "Unknown";

        // Generate QR Code
        generateQrCode(qrData);

        // Display ticket details
        ticketDetails.setText(
                "Passengers: " + passengerCount + "\n" +
                        "From: " + fromStation + "\n" +
                        "To: " + toStation + "\n" +
                        "Date: " + getCurrentDate()
        );

        // Set expiration time
        timeLeft.setText("Valid for: 2 hours");

        // Close button action
        closePopupBtn.setOnClickListener(view -> finish());
    }

    private void generateQrCode(String qrData) {
        try {
            BarcodeEncoder encoder = new BarcodeEncoder();
            qrBitmap = encoder.encodeBitmap(qrData, BarcodeFormat.QR_CODE, QR_SIZE, QR_SIZE);
            generatedQrImage.setImageBitmap(qrBitmap);
            Log.d(TAG, "QR Code Generated Successfully");
        } catch (WriterException e) {
            Log.e(TAG, "QR Generation Failed: " + e.getMessage());
        }
    }

    private String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        return sdf.format(Calendar.getInstance().getTime());
    }

    private Uri getUriFromBitmap() {
        try {
            File file = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES),
                    "qr_code_" + System.currentTimeMillis() + ".png");
            FileOutputStream outStream = new FileOutputStream(file);
            if (qrBitmap != null) {
                qrBitmap.compress(Bitmap.CompressFormat.PNG, 90, outStream);
                outStream.close();
                return FileProvider.getUriForFile(this, "com.example.logsignsql.provider", file);
            }
        } catch (IOException e) {
            Log.e(TAG, "getUriFromBitmap: " + e.getMessage());
        }
        return null;
    }
}
