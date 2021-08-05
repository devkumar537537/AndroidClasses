package com.example.fingerprintauthorization;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.KeyguardManager;
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
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class MainActivity extends AppCompatActivity {
    String[] permissions = {Manifest.permission.USE_FINGERPRINT};
    int permsiisoncode = 123;
    private KeyguardManager keyguardManager;
    private FingerprintManager fingerprintManager;
    private TextView textView;
    private KeyStore keyStore;
    private KeyGenerator keyGenerator;
    String keyname = "mykey";
    private Cipher cipher;
    private FingerprintManager.CryptoObject cryptoObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            keyguardManager = (KeyguardManager) getSystemService(KEYGUARD_SERVICE);

            fingerprintManager = (FingerprintManager) getSystemService(FINGERPRINT_SERVICE);
            textView = findViewById(R.id.textview);

        }

        if (!fingerprintManager.isHardwareDetected()){
            textView.setText("Your Device does not support finger print");
        }
        if(!fingerprintManager.hasEnrolledFingerprints())
        {
            textView.setText("No FingerPrint configured.Please register at least one fingerprint");
            return;
        }

        if (!keyguardManager.isKeyguardSecure()) {
            textView.setText("Please enable lockscreen lock");
            return;
        } else {
            try {
                generatekeys();
            } catch (FingerPrintException e) {
                e.printStackTrace();
            }

        }

        if (initChiper()) {
            cryptoObject = new FingerprintManager.CryptoObject(cipher);
            FingerPrintHelperClass helpterClass = new FingerPrintHelperClass(this);
            helpterClass.startauth(fingerprintManager,cryptoObject);
        }
    }

    private boolean initChiper() {
        try {
            cipher = Cipher.getInstance(
                    KeyProperties.KEY_ALGORITHM_AES + "/"
                            + KeyProperties.BLOCK_MODE_CBC + "/"
                            + KeyProperties.ENCRYPTION_PADDING_PKCS7);

        } catch (NoSuchPaddingException |
                NoSuchAlgorithmException
                e) {
            throw  new RuntimeException("Failed to get Cipher",e);
        }

        try {
            keyStore.load(null);
            SecretKey key = (SecretKey) keyStore.getKey(keyname,null);
            cipher.init(Cipher.ENCRYPT_MODE,key);
            return true;
        }catch (KeyPermanentlyInvalidatedException e)
    {
        return  false;
    } catch (CertificateException | IOException | NoSuchAlgorithmException | KeyStoreException | UnrecoverableKeyException | InvalidKeyException e) {
        e.printStackTrace();
        throw new RuntimeException("Failed t int ciperh",e);
    }


    }

    private void generatekeys() throws FingerPrintException{
        try {
            keyStore = KeyStore.getInstance("AndroidKeyStore");

                keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore");
                keyStore.load(null);
            keyGenerator.init(new KeyGenParameterSpec.Builder(keyname,KeyProperties.PURPOSE_ENCRYPT | KeyProperties.PURPOSE_DECRYPT)
                     .setBlockModes(KeyProperties.BLOCK_MODE_CBC)
                        .setUserAuthenticationRequired(true)
                        .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_PKCS7)
                        .build()


                    );

            keyGenerator.generateKey();
            }  catch (NoSuchProviderException | CertificateException | IOException | NoSuchAlgorithmException | KeyStoreException | InvalidAlgorithmParameterException

                    e) {
            e.printStackTrace();
            throw new FingerPrintException("finger invalide");
            }
        }


    private class FingerPrintException extends Exception{
        FingerPrintException(String msg)
        {
            super(msg);
        }
    }
}