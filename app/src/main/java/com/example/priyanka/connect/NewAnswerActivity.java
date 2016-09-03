package com.example.priyanka.connect;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.priyanka.connect.CustomViews.CustomFontButton;
import com.example.priyanka.connect.CustomViews.CustomFontTextView;
import com.google.android.gms.maps.model.LatLng;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by priyanka on 2/9/16.
 */
public class NewAnswerActivity extends AppCompatActivity {
    @Bind(R.id.questionTv)
    CustomFontTextView mQuestionTv;
    @Bind(R.id.answerTv) CustomFontTextView mAnswerTv;
    @Bind(R.id.likeDislikeRg) RadioGroup mLikeDislikeRg;
    @Bind(R.id.likeRbtn) RadioButton mLikeRbtn;
    @Bind(R.id.dislikeRbtn) RadioButton mDislikeRbtn;
    @Bind(R.id.submitRatingBtn) CustomFontButton mSubmitRatingBtn;
    @Bind(R.id.progressLayout) LinearLayout mProgressLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rate_answer_layout);
        ButterKnife.bind(this);

        if(getIntent().getExtras() != null){
            String question = getIntent().getExtras().get("question").toString();
            String answer = getIntent().getExtras().get("answer").toString();
            mQuestionTv.setText(question);
            mAnswerTv.setText(answer);
            mLikeDislikeRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    if(checkedId == R.id.likeRbtn) {

                    }else {

                    }
                }
            });
        }

    }

    @OnClick(R.id.submitRatingBtn) void onSubmitRating(){
        mLikeDislikeRg.getCheckedRadioButtonId();
        Toast.makeText(NewAnswerActivity.this, "Thanks for your feedback!", Toast.LENGTH_SHORT).show();
        finish();
  //      sendRating();
    }

    public void sendRating(String url) {
            new AsyncHttpTask().execute(url);
    }

    public class AsyncHttpTask extends AsyncTask<String, Void, Integer> {
        protected static final String TAG = "Async Rating Task";

        @Override
        protected void onPreExecute() {
            mProgressLayout.setVisibility(View.VISIBLE);
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
                }
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
            mProgressLayout.setVisibility(View.GONE);
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


}