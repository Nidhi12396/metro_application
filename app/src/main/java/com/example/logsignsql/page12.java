package com.example.logsignsql;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import android.net.Uri;

public class page12 extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int QR_SIZE = 1024;

    private ImageView generatedQrImage;
    private Bitmap qrBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page12);

        generatedQrImage = findViewById(R.id.generatedQrImage);
        Button generateQrBtn = findViewById(R.id.generateQrBtn);

        generateQrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateQrCode();
            }
        });
    }

    private void generateQrCode() {
        String qrContent = "Hello, this is your QR code!"; // You can change this to any static/dynamic content

        try {
            BarcodeEncoder encoder = new BarcodeEncoder();
            qrBitmap = encoder.encodeBitmap(qrContent, BarcodeFormat.QR_CODE, QR_SIZE, QR_SIZE);
            generatedQrImage.setImageBitmap(qrBitmap);
        } catch (WriterException e) {
            Log.e(TAG, "generateQrCode: " + e.getMessage());
        }
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
