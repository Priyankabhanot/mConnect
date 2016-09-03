package com.example.priyanka.connect.network;

import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import javax.xml.transform.ErrorListener;

/**
 * Created by priyanka on 3/9/16.
 */
public class ApiListeners<T> {

   /* private Response.Listener<T> successListener;
    private ErrorListener errorListener;

    public ApiListeners(final ApiResponseListener responseListener, final ApiErrorListener errorListener){

        this.successListener = new Response.Listener<T>() {

            @Override
            public void onResponse(T response) {
                responseListener.onApiResponse(response);
            }
        };

        this.errorListener = new ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                String statusCode = "";
                try {
                    NetworkResponse response = volleyError.networkResponse;

                    if (response != null && response.data != null && response.data.length > 0) {
                        BaseJsonModel baseModel =
                                (BaseJsonModel) JsonParser.parseJson(new String(response.data), BaseJsonModel.class);
                        if (null != baseModel) {
                            statusCode = baseModel.getStatusCode();
                        }
                    }
                } catch(Exception e){
                    Crashlytics.logException(e);
                }

                ResponseError error = new ResponseError();
                error.setStatusCode(statusCode);
                error.setError(volleyError);
                errorListener.onApiError(error);

            }
        };

    }

    public Listener getSuccessListener() {
        return successListener;
    }

    public void setSuccessListener(Listener successListener) {
        this.successListener = successListener;
    }

    public ErrorListener getErrorListener() {
        return errorListener;
    }

    public void setErrorListener(ErrorListener errorListener) {
        this.errorListener = errorListener;
    }*/
}
