package com.example.priyanka.connect.gcm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.priyanka.connect.gcm.Config;

/**
 * Created by priyanka on 2/9/16.
 */
public class NotificationReceiver extends BroadcastReceiver {
    String message, title;

    @Override
    public void onReceive(Context context, Intent intent) {
// checking for type intent filter
        if (intent.getAction().equals(Config.REGISTRATION_COMPLETE)) {
            // gcm successfully registered
            // now subscribe to `global` topic to receive app wide notifications
            String token = intent.getStringExtra("token");

            Toast.makeText(context, "GCM registration done ", Toast.LENGTH_LONG).show();

        } else if (intent.getAction().equals(Config.SENT_TOKEN_TO_SERVER)) {
            // gcm registration id is stored in our server's MySQL

            Toast.makeText(context, "GCM registration token is stored in server!", Toast.LENGTH_LONG).show();

        } else if (intent.getAction().equals(Config.PUSH_NOTIFICATION)) {
            // new push notification is received

      //      Toast.makeText(context, "Push notification is received!", Toast.LENGTH_LONG).show();
        }
    }

}
