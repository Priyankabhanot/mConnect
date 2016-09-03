package com.example.priyanka.connect.gcm;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by priyanka on 2/9/16.
 */
public class MyPreferenceManager {
    private String TAG = MyPreferenceManager.class.getSimpleName();

    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    SharedPreferences.Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "mconnect_gcm";

    // All Shared Preferences Keys
    private static final String KEY_USER_ID = "user_id";
    private static final String KEY_USER_NAME = "user_name";
    private static final String KEY_USER_EMAIL = "user_email";
    private static final String KEY_NOTIFICATIONS = "notifications";

    // Constructor
    public MyPreferenceManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void addNotification(String notification) {

        // get old notifications
        String oldNotifications = getNotifications();

        if (oldNotifications != null) {
            oldNotifications += "|" + notification;
        } else {
            oldNotifications = notification;
        }

        editor.putString(KEY_NOTIFICATIONS, oldNotifications);
        editor.commit();
    }

    public String getNotifications() {
        return pref.getString(KEY_NOTIFICATIONS, null);
    }

    public void clear() {
        editor.clear();
        editor.commit();
    }

    private static final String PREF_GCM_REGID = "gcm_reg_Id";
    private static final String PREF_APP_VER = "app_version";
    private static final String PREF_IS_GCM_ID_SENT = "is_gcm_id_sent";

    private static SharedPreferences getSharedPref(Context ctx) {
        return ctx.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }


    /**
     * Store gcm id
     *
     * @param context the Context of activity
     * @param gcmId
     * */
    public static void setGcmRegId(Context context, String gcmId) {
        SharedPreferences.Editor edit = getSharedPref(context).edit();
        edit.putString(PREF_GCM_REGID, gcmId);
        edit.apply();
    }

    /**
     * Retrieve gcm id
     *
     * @param context
     * */
    public static String getGcmRegId(Context context) {
        return getSharedPref(context).getString(PREF_GCM_REGID, "");
    }


    /**
     * Determine if gcm id sent
     *
     * @param context the Context of activity
     * */
    public static boolean isGcmIdSent(Context context) {
        return getSharedPref(context).getBoolean(PREF_IS_GCM_ID_SENT, false);
    }


    /**
     *  Sets flag for gcm id sent
     *
     * @param context the Context of activity
     * */
    public static void setGcmIdSent(Context context) {
        SharedPreferences.Editor edit = getSharedPref(context).edit();
        edit.putBoolean(PREF_IS_GCM_ID_SENT, true);
        edit.apply();
    }

    /**
     * Store app version
     *
     * @param context the Context of activity
     * @param appVersion
     * */
    public static void setAppVersion(Context context, int appVersion) {
        SharedPreferences.Editor edit = getSharedPref(context).edit();
        edit.putInt(PREF_APP_VER, appVersion);
        edit.apply();
    }


    /**
     * Retrieve app version
     *
     * @param context
     * */
    public static int getAppVersion(Context context) {
        return getSharedPref(context).getInt(PREF_APP_VER, Integer.MIN_VALUE);
    }

}
