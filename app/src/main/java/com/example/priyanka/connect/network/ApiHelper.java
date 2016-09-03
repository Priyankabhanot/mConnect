package com.example.priyanka.connect.network;

import android.text.TextUtils;

import org.json.JSONObject;

/**
 * Created by priyanka on 3/9/16.
 */
public class ApiHelper {

/*    *//**//**
     * A method for making generic request with JSONObject
     *
     * @param requestUrl the url for API request
     * @param tag request tag String
     * @param listeners this consists of volley response and error listener {@link ApiListeners}}
     * @param jsonObject a JSONObject request body
     *
     * *//**//**/
  /*  public static void makeRequest(String requestUrl, String tag, ApiListeners listeners,
                                   JSONObject jsonObject, int method){
        if(listeners.getSuccessListener() ==null
                || listeners.getErrorListener()==null
                || jsonObject==null){
            throw new IllegalArgumentException("Invalid argument");
        }

        if(TextUtils.isEmpty(requestUrl)){
            throw new IllegalArgumentException("Invalid argument");
        }

        requestUrl = appendSourceDomain(requestUrl);

        CustomStringRequest stringRequest = new CustomStringRequest(context, method, requestUrl,
                listeners.getSuccessListener(), jsonObject, listeners.getErrorListener());

        stringRequest.setRetryPolicy(
                new DefaultRetryPolicy(CONNECTION_TIMEOUT,
                        DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(stringRequest, tag);
    }
*/
}
