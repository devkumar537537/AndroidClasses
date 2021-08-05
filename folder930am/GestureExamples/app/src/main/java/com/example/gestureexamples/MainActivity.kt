package com.example.gestureexamples

import android.Manifest
import android.app.PendingIntent
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.telecom.TelecomManager
import android.telephony.SmsManager
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.GestureDetectorCompat

class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener,
    GestureDetector.OnDoubleTapListener {
    var constraintLayout: ConstraintLayout? = null
    private var mDetector: GestureDetectorCompat? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mDetector = GestureDetectorCompat(this, this)
        mDetector!!.setOnDoubleTapListener(this)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return if (mDetector!!.onTouchEvent(event)) {
            true
        } else super.onTouchEvent(event)
    }

    override fun onDown(event: MotionEvent): Boolean {
        Log.d(DEBUG_TAG, "onDown: $event")
        return true
    }

    override fun onFling(
        event1: MotionEvent, event2: MotionEvent,
        velocityX: Float, velocityY: Float
    ): Boolean {
        Log.d(DEBUG_TAG, "onFling: $event1$event2")
        return true
    }

    override fun onLongPress(event: MotionEvent) {
        Log.d(DEBUG_TAG, "onLongPress: $event")
    }

    override fun onScroll(
        event1: MotionEvent, event2: MotionEvent, distanceX: Float,
        distanceY: Float
    ): Boolean {
        Log.d(DEBUG_TAG, "onScroll: $event1$event2")
        return true
    }

    override fun onShowPress(event: MotionEvent) {
        Log.d(DEBUG_TAG, "onShowPress: $event")
    }

    override fun onSingleTapUp(event: MotionEvent): Boolean {
        Log.d(DEBUG_TAG, "onSingleTapUp: $event")
        return true
    }

    override fun onDoubleTap(event: MotionEvent): Boolean {
        Log.d(DEBUG_TAG, "onDoubleTap: $event")
        return true
    }

    override fun onDoubleTapEvent(event: MotionEvent): Boolean {
        Log.d(DEBUG_TAG, "onDoubleTapEvent: $event")
        return true
    }

    override fun onSingleTapConfirmed(event: MotionEvent): Boolean {
        Log.d(DEBUG_TAG, "onSingleTapConfirmed: $event")
        return true
    }

    companion object {
        private const val DEBUG_TAG = "Anything"
    }

    sendemail.setOnClickListener(
    object : View.OnClickListener {
        override fun onClick(v: View) {
            val email_text: String = receiveremail.getText().toString().trim({ it <= ' ' })
            val subject_text: String = subjecttext.getText().toString().trim({ it <= ' ' })
            val message_text: String = mssage.getText().toString().trim({ it <= ' ' })
            val email = Intent(Intent.ACTION_SEND)
            email.putExtra(Intent.EXTRA_EMAIL, arrayOf(email_text))
            email.putExtra(Intent.EXTRA_SUBJECT, subject_text)
            email.putExtra(Intent.EXTRA_TEXT, message_text)
            email.type = "message/rfc822"
            startActivity(Intent.createChooser(email, "Choose an Email client :"))
        }
    })

    callbtn.setOnClickListener(
    object : View.OnClickListener {
        override fun onClick(v: View) {
            val number: String = numbertext.getText().toString().trim({ it <= ' ' })
            //  String numberr = "7009125438";
            if (ContextCompat.checkSelfPermission(
                    this@MainActivity,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                requestPermissions(perm, CALL_REQUEST)
            } else {
                val telecomManager =
                    getApplicationContext().getSystemService(TELECOM_SERVICE) as TelecomManager
                val phoneAccountHandleList = telecomManager.callCapablePhoneAccounts
                val callintent = Intent(Intent.ACTION_CALL)
                callintent.data = Uri.parse("tel:$number")
                callintent.putExtra("simSlot", 1)
                //                    i.putExtra("com.android.phone.extra.slot", SimIndex)
                startActivity(callintent)
            }
        }
    })

    sendsmsbtn.setOnClickListener(
    object : View.OnClickListener {
        override fun onClick(v: View) {
            val number_text: String = numberedit.getText().toString().trim({ it <= ' ' })
            val message_text: String = messageedit.getText().toString().trim({ it <= ' ' })
            val smsintent = Intent(
                getApplicationContext(),
                com.example.androitelephonymanager.SmsActivity::class.java
            )
            val pendingIntent =
                PendingIntent.getActivity(getApplicationContext(), SMS_REQUEST, smsintent, 0)
            val sms = SmsManager.getDefault()
            sms.sendTextMessage(number_text, null, message_text, pendingIntent, null)
            Toast.makeText(
                getApplicationContext(),
                "Messages Send Successfully",
                Toast.LENGTH_SHORT
            ).show()
        }
    })
}