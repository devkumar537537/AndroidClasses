package com.example.fingerprintscanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.KeyguardManager;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Bundle;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyPermanentlyInvalidatedException;
import android.security.keystore.KeyProperties;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class MainActivity extends AppCompatActivity {

private KeyguardManager keyguardManager;
    private FingerprintManager fingerprintManager;
    private TextView textView;
String keYName = "Mykey";
    String[] permissions = {Manifest.permission.USE_FINGERPRINT};
    int permissioncode = 456;
    private KeyStore keyStore;
    private KeyGenerator keyGenerator;
    private Cipher cipher;
    private FingerprintManager.CryptoObject cryptoObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.M)
        {
            if(ActivityCompat.checkSelfPermission(this,Manifest.permission.USE_FINGERPRINT) != PackageManager.PERMISSION_GRANTED){
                requestPermissions(permissions,permissioncode);
            }
            keyguardManager = (KeyguardManager) getSystemService(KEYGUARD_SERVICE);
            fingerprintManager = (FingerprintManager) getSystemService(FINGERPRINT_SERVICE);
            textView = findViewById(R.id.textview);
        }

        if (!fingerprintManager.isHardwareDetected()) {
            textView.setText("Your Device does not support finger print");
        }
        if(!fingerprintManager.hasEnrolledFingerprints())
        {
            textView.setText("No FingerPrint configured.Please register at least one firngerprint");
        }
        if (!keyguardManager.isKeyguardSecure()) {
            textView.setText("Please enable lockscreen lock");
        }else
        {

            try {
                generateKeys();
            } catch (FingerPrintException e) {
                e.printStackTrace();
            }
        }

        if (initChiper()) {
            cryptoObject = new FingerprintManager.CryptoObject(cipher);
            FingerScannerHelperClass helpterClass = new FingerScannerHelperClass(this);
            helpterClass.startauth(fingerprintManager,cryptoObject);

        }

    }

    private boolean initChiper() {
        try {
            cipher = Cipher.getInstance(
                    KeyProperties.KEY_ALGORITHM_AES + "/"
                            + KeyProperties.BLOCK_MODE_CBC + "/"
                            + KeyProperties.ENCRYPTION_PADDING_PKCS7);
        } catch (NoSuchPaddingException
                | NoSuchAlgorithmException e) {
            throw  new RuntimeException("Failed to get Cipher",e);
        }


        try {
            keyStore.load(null);

            SecretKey key = (SecretKey) keyStore.getKey(keYName,null);
            cipher.init(Cipher.ENCRYPT_MODE,key);
            return true;
        }catch (KeyPermanentlyInvalidatedException e){
            return false;
        } catch (KeyStoreException
                | CertificateException
                | UnrecoverableKeyException
                | IOException
                | NoSuchAlgorithmException
                | InvalidKeyException
                e) {
            throw new RuntimeException("Failed t int ciperh",e);
        }


    }

    private void generateKeys() throws FingerPrintException {

        try {
            keyStore = KeyStore.getInstance("AndroidKeyStore");

            keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore");

            keyStore.load(null);


                keyGenerator.init(new
                        KeyGenParameterSpec.Builder(
                          keYName,KeyProperties.PURPOSE_ENCRYPT | KeyProperties.PURPOSE_DECRYPT)
                                .setBlockModes(KeyProperties.BLOCK_MODE_CBC)
                        .setUserAuthenticationRequired(true)
                        .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_PKCS7)
                                .build()
                        );

                keyGenerator.generateKey();



        } catch (KeyStoreException
                | NoSuchAlgorithmException
                | NoSuchProviderException
                | InvalidAlgorithmParameterException
                | CertificateException
                | IOException exc

        ) {
            exc.printStackTrace();
            throw new FingerPrintException("finger invalide");
        }
    }

    private class FingerPrintException extends Exception{
        public FingerPrintException(String msg)
        {
            super(msg);
        }
    }
}