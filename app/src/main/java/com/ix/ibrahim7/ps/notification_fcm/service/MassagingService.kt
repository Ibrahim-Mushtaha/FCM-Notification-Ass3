package com.ix.ibrahim7.ps.notification_fcm.service

import android.content.Intent
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.ix.ibrahim7.ps.notification_fcm.ui.activity.MainActivity

class MassagingService : FirebaseMessagingService() {

    companion object {
        const val ALERT = "alert"
    }

    lateinit var notificationManager: NotificationManager
    override fun onNewToken(p0: String) {
        super.onNewToken(p0)
    }


    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        notificationManager = NotificationManager(this)


        if (remoteMessage.data[ALERT] == null) {
            Log.e("eee title", remoteMessage.notification!!.title.toString())
            Log.e("eee data", remoteMessage.data.toString())
            notificationManager.showNotification(
                    1,
                    remoteMessage.notification!!.title!!,
                    remoteMessage.notification!!.body!!,
                    Intent(
                            applicationContext,
                            MainActivity::class.java
                    )
            )
        } else {
            Log.e("eee", remoteMessage.notification.toString())
        }
    }


}