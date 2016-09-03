package com.example.priyanka.connect.gcm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.util.Log;

import com.example.priyanka.connect.MainActivity;
import com.example.priyanka.connect.NewAnswerActivity;
import com.example.priyanka.connect.NewQuestionActivity;
import com.example.priyanka.connect.YourAnswerActivity;
import com.google.android.gms.gcm.GcmListenerService;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by priyanka on 2/9/16.
 */
public class MyGcmPushReceiver extends GcmListenerService {
    private static final String TAG = MyGcmPushReceiver.class.getSimpleName();

    static final String NEW_ANSWER = "NewAnswer".toLowerCase();
    static final String NEW_QUESTION = "NewQuestion".toLowerCase();
    static final String YOUR_ANSWER = "YourAnswer".toLowerCase();

    private NotificationUtils notificationUtils;

    /**
     * Called when message is received.
     *
     * @param from   SenderID of the sender.
     * @param bundle Data bundle containing message data as key/value pairs.
     *               For Set of keys use data.keySet().
     */

    @Override
    public void onMessageReceived(String from, Bundle bundle) {
        String type = bundle.getString("msg_type");
        String question = bundle.getString("question");
        String answer = bundle.getString("answer");
        String likeCount = bundle.getString("likeCount");
        String dislikeCount = bundle.getString("dislikeCount");
        String localityId = bundle.getString("localityId");
        String userId = bundle.getString("userId");
        String title = "";
        Log.e(TAG, "From: " + from);
        Log.e(TAG, "Title: " + type);
        Log.e(TAG, "message: " + question);
        Log.e(TAG, "image: " + answer);
        Log.e(TAG, "timestamp: " + likeCount + "dislike: " + dislikeCount);

        if (!NotificationUtils.isAppIsInBackground(getApplicationContext())) {

            // app is in foreground, broadcast the push message
            Intent pushNotification = new Intent(Config.PUSH_NOTIFICATION);
            pushNotification.putExtra("message", question);
            pushNotification.putExtra("title", type);
            LocalBroadcastManager.getInstance(this).sendBroadcast(pushNotification);
            Intent resultIntent;
            JSONObject uniObject = null;
           /* if(message != null) {
                Log.e("RAW DATA", "Data: " + message.toString());
           */  //   String notiType = "";
               /* try {
                    JSONObject mainObject = new JSONObject(message);
                     uniObject = mainObject.getJSONObject("msg_data");
                     notiType = mainObject.getString("msg_type");

                }catch (Exception ex){
                    Log.e("JSON OBJECT","Json Exception: " + ex.toString());
                }
*/
            if (type != null) {
                if (type.contentEquals("getAnswer")) {
                    resultIntent = new Intent(getApplicationContext(), NewQuestionActivity.class);
                    resultIntent.putExtra("question", question);
                    title = "please answer this question";
                         resultIntent.putExtra("localityId",localityId);
                    resultIntent.putExtra("userId",userId);
                    //    resultIntent.putExtra("message", question);
                } else if (type.contentEquals("showAnswer")) {
                    resultIntent = new Intent(getApplicationContext(), NewAnswerActivity.class);
                    resultIntent.putExtra("question", question);
                    resultIntent.putExtra("answer", answer);
                    title = "someone answered your question";
                } else if (type.contentEquals("showRating")) {
                    resultIntent = new Intent(getApplicationContext(), YourAnswerActivity.class);
                    try {
                        // JSONObject notiData = uniObject.getJSONObject("data");
                        title = "feedback on your answer";
                        resultIntent.putExtra("question", question);//uniObject.getString("question"));
                        resultIntent.putExtra("answer", answer);//uniObject.getString("answer"));
                        resultIntent.putExtra("likeCount", likeCount);// uniObject.getInt("likeCount"));
                        resultIntent.putExtra("dislikeCount", dislikeCount);//uniObject.getInt("dislikeCount"));
                        Log.e("SHOW RATING", "Ques: " + question + "Ans: " + answer
                                + "like: " + likeCount + "dislike: " + dislikeCount);
                    } catch (Exception e) {
                        Log.e("JSON OBJECT", "Json Exception: " + e.toString());
                    }

                } else {
                    resultIntent = new Intent(getApplicationContext(), MainActivity.class);
                    resultIntent.putExtra("message", question);
                }

                //   if (TextUtils.isEmpty(image)) {
                if (answer == null) answer = "";
                showNotificationMessage(getApplicationContext(), title, question, answer, resultIntent);
              /*  } else {
                    showNotificationMessageWithBigImage(getApplicationContext(), title, message, timestamp, resultIntent, image);
                }*/
                // play notification sound
                NotificationUtils notificationUtils = new NotificationUtils();
                notificationUtils.playNotificationSound();
            } else {
                Log.e("RAW DATA", "Data is null");
            }

        } else {
            Intent resultIntent;
            if (type != null) {
                if (type.contentEquals("getAnswer")) {
                    resultIntent = new Intent(getApplicationContext(), NewQuestionActivity.class);
                    resultIntent.putExtra("question", question);
                    title = "please answer this question";
                    //     resultIntent.putExtra("localityId",);
                    //    resultIntent.putExtra("message", question);
                } else if (type.contentEquals("showAnswer")) {
                    resultIntent = new Intent(getApplicationContext(), NewAnswerActivity.class);
                    resultIntent.putExtra("question", question);
                    resultIntent.putExtra("answer", answer);
                    title = "someone answered your question";
                } else if (type.contentEquals("showRating")) {
                    title = "feedback on your answer";
                    resultIntent = new Intent(getApplicationContext(), YourAnswerActivity.class);
                    try {
                        // JSONObject notiData = uniObject.getJSONObject("data");
                        resultIntent.putExtra("question", question);//uniObject.getString("question"));
                        resultIntent.putExtra("answer", answer);//uniObject.getString("answer"));
                        resultIntent.putExtra("likeCount", likeCount);// uniObject.getInt("likeCount"));
                        resultIntent.putExtra("dislikeCount", dislikeCount);//uniObject.getInt("dislikeCount"));
                        Log.e("SHOW RATING", "Ques: " + question + "Ans: " + answer
                                + "like: " + likeCount + "dislike: " + dislikeCount);
                    } catch (Exception e) {
                        Log.e("JSON OBJECT", "Json Exception: " + e.toString());
                    }

                } else {
                    resultIntent = new Intent(getApplicationContext(), MainActivity.class);
                    resultIntent.putExtra("message", question);
                }

                //   if (TextUtils.isEmpty(image)) {
                if (answer == null) answer = "";
                showNotificationMessage(getApplicationContext(), title, question, answer, resultIntent);

                NotificationUtils notificationUtils = new NotificationUtils();
                notificationUtils.playNotificationSound();
                //       if (TextUtils.isEmpty(image)) {
                //       showNotificationMessage(getApplicationContext(), title, message, timestamp, resultIntent);
      /*      } else {
                showNotificationMessageWithBigImage(getApplicationContext(), title, message, timestamp, resultIntent, image);
            }*/
            }
        }
    }
   // }

    /**
     * Showing notification with text only
     */
    private void showNotificationMessage(Context context, String title, String message, String timeStamp, Intent intent) {
        notificationUtils = new NotificationUtils(context);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        notificationUtils.showNotificationMessage(title, message, timeStamp, intent);
    }

    /**
     * Showing notification with text and image
     */
    private void showNotificationMessageWithBigImage(Context context, String title, String message, String timeStamp, Intent intent, String imageUrl) {
        notificationUtils = new NotificationUtils(context);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        notificationUtils.showNotificationMessage(title, message, timeStamp, intent, imageUrl);
    }
}
