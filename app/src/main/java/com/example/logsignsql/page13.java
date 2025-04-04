package com.example.logsignsql;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.common.moduleinstall.ModuleInstall;
import com.google.android.gms.common.moduleinstall.ModuleInstallClient;
import com.google.android.gms.common.moduleinstall.ModuleInstallRequest;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.codescanner.GmsBarcodeScanner;
import com.google.mlkit.vision.codescanner.GmsBarcodeScannerOptions;
import com.google.mlkit.vision.codescanner.GmsBarcodeScanning;

public class page13 extends AppCompatActivity {

    private Button scanQrBtn;
    private TextView scannedValueTv;
    private boolean isScannerInstalled = false;
    private GmsBarcodeScanner scanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page12);

        installGoogleScanner();
        initVars();
        registerUiListener();
    }

    private void installGoogleScanner() {
        ModuleInstallClient moduleInstall = ModuleInstall.getClient(this);
        ModuleInstallRequest moduleInstallRequest = new ModuleInstallRequest.Builder()
                .addApi(GmsBarcodeScanning.getClient(this))
                .build();

        moduleInstall.installModules(moduleInstallRequest)
                .addOnSuccessListener(unused -> isScannerInstalled = true)
                .addOnFailureListener(e -> {
                    isScannerInstalled = false;
                    Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }

    private void initVars() {
//        scanQrBtn = findViewById(R.id.scanQrBtn);
//        scannedValueTv = findViewById(R.id.scannedValueTv);

        GmsBarcodeScannerOptions options = initializeGoogleScanner();
        scanner = GmsBarcodeScanning.getClient(this, options);
    }

    private GmsBarcodeScannerOptions initializeGoogleScanner() {
        return new GmsBarcodeScannerOptions.Builder()
                .setBarcodeFormats(Barcode.FORMAT_QR_CODE)
                .enableAutoZoom()
                .build();
    }

    private void registerUiListener() {
        scanQrBtn.setOnClickListener(v -> {
            if (isScannerInstalled) {
                startScanning();
            } else {
                Toast.makeText(this, "Please try again...", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void startScanning() {
        scanner.startScan()
                .addOnSuccessListener(result -> {
                    String scannedText = result.getRawValue();
                    if (scannedText != null) {
                        scannedValueTv.setText("Scanned Value: " + scannedText);
                    }
                })
                .addOnCanceledListener(() ->
                        Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show())
                .addOnFailureListener(e ->
                        Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show());
    }
}
