package com.example.priyanka.connect;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import com.example.priyanka.connect.gcm.MyPreferenceManager;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;

/**
 * Created by priyanka on 2/9/16.
 */
public class MyApplication extends Application{

    public static final String TAG = MyApplication.class
            .getSimpleName();

    private static MyApplication mInstance;

    private MyPreferenceManager pref;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static synchronized MyApplication getInstance() {
        return mInstance;
    }


    public MyPreferenceManager getPrefManager() {
        if (pref == null) {
            pref = new MyPreferenceManager(this);
        }

        return pref;
    }
/*
    private static void registerInBackground(final Context context) {
        AsyncTask<Void, Void, String> task = new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                String msg = "";
                try {
                    InstanceID instanceID = InstanceID.getInstance(context);

                    sRegid = instanceID.getToken(SENDER_ID,
                            GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);

                    JarvisConstants.DELIVERY_ID = sRegid;

                    JarvisClient.getInstance().openSocketAndFetchHistory();
                    msg = "Device registered, registration ID = " + sRegid;
                    GcmPreferences.setGcmRegId(context, sRegid);
                    GcmPreferences.setAppVersion(context, CommonUtil.getAppVersion(context));
                    sendRegistrationIdToBackend(sRegid);
                    subscribeTopics(context, sRegid);

                } catch (Exception ex) {
                    Crashlytics.log("Error while registering for GCM:" + ex.getMessage());
                    Crashlytics.logException(ex);
                    msg = "Error while registering for GCM:" + ex.getMessage();
                }
                return msg;
            }

            @Override
            protected void onPostExecute(String msg) {
            }

        };
        task.execute(null, null, null);
    }*/

}
