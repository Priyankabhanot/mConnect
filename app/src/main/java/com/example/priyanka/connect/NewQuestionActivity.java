package com.example.priyanka.connect;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.priyanka.connect.CustomViews.CustomFontTextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by priyanka on 2/9/16.
 */
public class NewQuestionActivity extends AppCompatActivity {
    @Bind(R.id.questionTv)
    CustomFontTextView mQuestionTv;
    @Bind(R.id.answerEt)    EditText mAnswerEt;
   /* @Bind(R.id.referBtn)   Button mReferBtn;
    @Bind(R.id.skipBtn) CustomFontTextView mSkipBtn;
   */ @Bind(R.id.nextBtn) Button mNextBtn;
    String userId = "", localityId = "", answer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anwer_question_layout);
        ButterKnife.bind(this);

        if(getIntent().getExtras() != null){
            if(getIntent().getExtras().get("question") != null){
            mQuestionTv.setText(getIntent().getExtras().get("question").toString());
        }if(getIntent().getExtras().get("localityId") != null){
                localityId = getIntent().getExtras().get("localityId").toString();
            }
            if(getIntent().getExtras().get("userId") != null){
                userId = getIntent().getExtras().get("userId").toString();
            }
            }
    }

    @OnClick(R.id.nextBtn) void onNextClicked(){
        if(!TextUtils.isEmpty(mAnswerEt.getText())){
            Toast.makeText(getApplicationContext(),"Thanks for submitting your answer!",Toast.LENGTH_SHORT).show();
            finish();
         //   String url = "http://10.10.2.131:4000/save-answer?userId=1&questionId=1&answer="+
                    answer = mAnswerEt.getText().toString();
            String url = "http://10.10.2.131:4000/save-answer?userId=1&questionId=1&answer="+answer;
            ConnectivityManager connMgr = (ConnectivityManager)
                    getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected()) {
                // fetch data
          //      new AsyncHttpTask().execute(url);

            } else {
                // display error
                Toast.makeText(NewQuestionActivity.this, "No network connection available.", Toast.LENGTH_SHORT).show();

            }
        //    new AsyncHttpTask().execute();
         //   Log.e("URL",url);
         //   sendAnswer(url);
        }else {
            Toast.makeText(getApplicationContext(),"Please type the answer before submitting",Toast.LENGTH_SHORT).show();
        }
    }
    public class AsyncHttpTask extends AsyncTask<String, Void, Integer> {
        protected static final String TAG = "Async Rating Task";

        @Override
        protected void onPreExecute() {
          //  mProgressLayout.setVisibility(View.VISIBLE);
        }

        @Override
        protected Integer doInBackground(String... params) {
            Integer result = -1;
            HttpURLConnection urlConnection;
            try {
                URL url = new URL(params[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();
              /*  int statusCode = urlConnection.getResponseCode();

                // 200 represents HTTP OK
                if (statusCode == 200) {
                    BufferedReader r = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = r.readLine()) != null) {
                        response.append(line);
                    }
                    parseResult(response.toString());
                    result = 1; // Successful
                } else {
                    result = 0; //"Failed to fetch data!";
                }*/

                int response = urlConnection.getResponseCode();
                Log.d("PRIYANKA", "The response is: " + response);
                result = 1;
            } catch (Exception e) {
                Log.d(TAG, e.getLocalizedMessage());
            }
            return result; //"Failed to fetch data!";
        }

        @Override
        protected void onPostExecute(Integer result) {
            // Download complete. Let us update UI
            if (result == 1) {

            } else {
                Toast.makeText(getApplicationContext(), "Couldn't fetch localities!", Toast.LENGTH_SHORT).show();
            }
       //     mProgressLayout.setVisibility(View.GONE);
        }

    }

    public void parseResult(String result) {
        try {
            JSONObject response = new JSONObject(result);
            JSONArray data = response.optJSONArray("data");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    /*private class SubmitTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            // params comes from the execute() call: params[0] is the url.
            try {
                return downloadUrl(urls[0]);
            } catch (IOException e) {
                return "Unable to retrieve web page. URL may be invalid.";
            }
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
        }
*/





  //  public void sendAnswer(String url) {
  //      new AsyncHttpTask().execute(url);
  //  }

  /*  public class AsyncHttpTask extends AsyncTask<String, Void, Integer> {
        protected static final String TAG = "Async Rating Task";

        @Override
        protected void onPreExecute() {
            //mProgressLayout.setVisibility(View.VISIBLE);
        }

        @Override
        protected Integer doInBackground(String... params) {
            Integer result = -1;
            HttpURLConnection urlConnection;
            try {
                URL url = new URL(params[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                int statusCode = urlConnection.getResponseCode();

                // 200 represents HTTP OK
           //     if (statusCode == 200) {
                    BufferedReader r = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = r.readLine()) != null) {
                        response.append(line);
                    }
           //         parseResult(response.toString());
                    result = 1; // Successful
           *//*     } else {
                    result = 0; //"Failed to fetch data!";
                }*//*
            } catch (Exception e) {
                Log.d(TAG, e.getLocalizedMessage());
            }
            return result; //"Failed to fetch data!";
        }

        @Override
        protected void onPostExecute(Integer result) {
            // Download complete. Let us update UI
            if (result == 1) {
                Toast.makeText(getApplicationContext(),"Successful!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Couldn't fetch localities!", Toast.LENGTH_SHORT).show();
            }
     //       mProgressLayout.setVisibility(View.GONE);
        }
*/
/*
    class AsyncHttpTask extends AsyncTask<Void, Void, String> {

        private Exception exception; String TAG = "get call";

        protected void onPreExecute() {
         *//*   progressBar.setVisibility(View.VISIBLE);
            responseView.setText("");
       *//* }

        protected String doInBackground(Void... urls) {
           // String email = mAnswerEt.getText().toString();
            // Do some validation here
            String response = null;

            try {
                URL url = new URL("http://10.10.2.131:4000/save-answer?userId=1&questionId=1&answer="+answer);
                 *//*   HttpClient httpclient = new DefaultHttpClient();
                    HttpGet httpget = new HttpGet(url);
                    HttpResponse response = httpclient.execute(httpget);
                    HttpEntity entity = response.getEntity();
                    InputStream webs = entity.getContent();
                    try{
                        BufferedReader reader = new BufferedReader(new InputStreamReader(webs, "iso-8859-1"), 8 );
                        test.setText(reader.readLine());
                        webs.close();
                    }catch(Exception e) {
                        Log.e("Error in conversion: ", e.toString());
                    }
                }catch(Exception e) {
                    Log.e("Error in connection: ", e.toString());
                }*//*
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                response = convertStreamToString(in);

                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");
                    }
                    bufferedReader.close();
                    return stringBuilder.toString();
                }
                finally{
                    urlConnection.disconnect();
                }
            } catch (MalformedURLException e) {
                Log.e(TAG, "MalformedURLException: " + e.getMessage());
            } catch (ProtocolException e) {
                Log.e(TAG, "ProtocolException: " + e.getMessage());
            } catch (IOException e) {
                Log.e(TAG, "IOException: " + e.getMessage());
            } catch (Exception e) {
                Log.e(TAG, "Exception: " + e.getMessage());
            }
            return response;
        }


        protected void onPostExecute(String response) {
            if(response == null) {
                response = "THERE WAS AN ERROR";
            }
         //   progressBar.setVisibility(View.GONE);
            Log.i("INFO", response);
            finish();
         //   responseView.setText(response);
        }
    }
    private String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    public void parseResult(String result) {
        try {
            JSONObject response = new JSONObject(result);
           // JSONArray data = response.optJSONArray("data");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }*/
/*
    @OnClick(R.id.skipBtn) void onSkipClicked(){

    }

    @OnClick(R.id.referBtn) void onReferClicked(){

    }*/
}
