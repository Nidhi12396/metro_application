package com.example.logsignsql;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.CountDownTimer;
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
<<<<<<< HEAD
=======
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
>>>>>>> 28f61129b7163b699da58724621e0f0104adf61d
import android.net.Uri;

public class page12 extends AppCompatActivity {

    private static final String TAG = "Page12";
    private static final int QR_SIZE = 500;
    private static final long VALIDITY_PERIOD = 2 * 60 * 60 * 1000; // 2 Hours in milliseconds

    private ImageView generatedQrImage;
    private TextView stationDetails, passengerDetails, ticketStatus, timeLeft;
    private Bitmap qrBitmap;
<<<<<<< HEAD
=======
    private Button closePopupBtn;
    private CountDownTimer countDownTimer;
>>>>>>> 28f61129b7163b699da58724621e0f0104adf61d

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page12);

<<<<<<< HEAD
=======
        // Initialize UI components
>>>>>>> 28f61129b7163b699da58724621e0f0104adf61d
        generatedQrImage = findViewById(R.id.generatedQrImage);
        stationDetails = findViewById(R.id.stationDetails);
        passengerDetails = findViewById(R.id.passengerDetails);
        ticketStatus = findViewById(R.id.ticketStatus);
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

        // Set station details (Above QR)
        stationDetails.setText(fromStation + " → " + toStation);

        // Get current date dynamically
        String currentDate = getCurrentDate();

        // Set Passenger Count & Date dynamically (VERTICAL FORMAT)
        passengerDetails.setText("Passengers: " + passengerCount + "\nDate: " + currentDate);

        // Set ticket status (Below QR)
        ticketStatus.setText("Ticket Generated Successfully");

        // Start countdown timer
        startCountdownTimer();

        // Close button action
        closePopupBtn.setOnClickListener(view -> {
            if (countDownTimer != null) {
                countDownTimer.cancel(); // Stop timer when closing
            }
            finish();
        });
    }

<<<<<<< HEAD
    private void generateQrCode() {
        String qrContent = "Hello, this is your QR code!"; // You can change this to any static/dynamic content

        try {
            BarcodeEncoder encoder = new BarcodeEncoder();
            qrBitmap = encoder.encodeBitmap(qrContent, BarcodeFormat.QR_CODE, QR_SIZE, QR_SIZE);
=======
    private void generateQrCode(String qrData) {
        try {
            BarcodeEncoder encoder = new BarcodeEncoder();
            qrBitmap = encoder.encodeBitmap(qrData, BarcodeFormat.QR_CODE, QR_SIZE, QR_SIZE);
>>>>>>> 28f61129b7163b699da58724621e0f0104adf61d
            generatedQrImage.setImageBitmap(qrBitmap);
            Log.d(TAG, "QR Code Generated Successfully");
        } catch (WriterException e) {
            Log.e(TAG, "QR Generation Failed: " + e.getMessage());
        }
    }

<<<<<<< HEAD
=======
    private void startCountdownTimer() {
        if (timeLeft == null) {
            Log.e(TAG, "TextView timeLeft is NULL! Check XML id.");
            return;
        }

        countDownTimer = new CountDownTimer(VALIDITY_PERIOD, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long hours = (millisUntilFinished / (1000 * 60 * 60)) % 24;
                long minutes = (millisUntilFinished / (1000 * 60)) % 60;
                long seconds = (millisUntilFinished / 1000) % 60;

                String timeText = String.format(Locale.getDefault(), "%02d:%02d:%02d", hours, minutes, seconds);

                runOnUiThread(() -> {
                    if (timeLeft != null) {
                        timeLeft.setText(timeText);
                        timeLeft.setBackgroundColor(getResources().getColor(R.color.white));
                    }
                });

                Log.d(TAG, "Countdown: " + timeText);
            }

            @Override
            public void onFinish() {
                runOnUiThread(() -> {
                    timeLeft.setText("Expired");
                    finish(); // Close activity when time runs out
                });
            }
        };

        countDownTimer.start();
        Log.d(TAG, "Countdown Timer Started");
    }

    private String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        return sdf.format(Calendar.getInstance().getTime());
    }

>>>>>>> 28f61129b7163b699da58724621e0f0104adf61d
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
<<<<<<< HEAD
=======

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel(); // Stop timer when activity is destroyed
        }
    }
>>>>>>> 28f61129b7163b699da58724621e0f0104adf61d
}
