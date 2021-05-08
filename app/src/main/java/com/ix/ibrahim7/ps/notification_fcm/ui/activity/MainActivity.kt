package com.ix.ibrahim7.ps.notification_fcm.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.firebase.iid.FirebaseInstanceId
import com.ix.ibrahim7.ps.notification_fcm.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.apply {
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }

        FirebaseInstanceId.getInstance().instanceId.addOnSuccessListener { token->
            Log.e("eee token" ,"your token is ${token.token}")
        }

    }
}