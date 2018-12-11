package com.example.nithinreddy.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URL;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class QuestionTenActivity extends AppCompatActivity {
    private Button nextBttn;
    private RadioGroup radioGrp;
    private RadioButton selectedAnswer;
    private static ImageView imgView;
    public static String url;
    private static final String TAG = QuestionTenActivity.class.toString();
    private static RequestQueue requestQueue;
    public String breed;

    //Code for downloading image
    private static class DownLoadImageTask extends AsyncTask<String,Void,Bitmap>{
        ImageView imageView;

        public DownLoadImageTask(ImageView imageView){
            this.imageView = imageView;
        }

        /*
            doInBackground(Params... params)
                Override this method to perform a computation on a background thread.
         */
        protected Bitmap doInBackground(String...urls){
            Log.d(TAG, "doInBackground ran");
            String urlOfImage = urls[0];
            Bitmap logo = null;
            try{
                InputStream is = new URL(urlOfImage).openStream();
                /*
                    decodeStream(InputStream is)
                        Decode an input stream into a bitmap.
                 */
                logo = BitmapFactory.decodeStream(is);
                Log.d(TAG, "doInBackground succeeded");
            }catch(Exception e){ // Catch the download exception
                Log.d(TAG, "doInBackground failed");
                e.printStackTrace();
            }
            return logo;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            imageView.setImageBitmap(bitmap);
        }
    }
// code for downloading image

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG,"enter on create");
        requestQueue = Volley.newRequestQueue(QuestionTenActivity.this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_ten);
        imgView = findViewById(R.id.imgView10);
        radioGrp = findViewById(R.id.radioGrp);
        QuestionTenActivity.getRequest();
        new DownLoadImageTask(imgView).execute(url);

        nextBttn = findViewById(R.id.nxtBttn);
        nextBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBaseActivity();
            }
        });
    }


    //API below
    protected static void getRequest() {
        Log.d(TAG,"enter get request");
        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(
                Request.Method.GET,
                "https://api.thedogapi.com/v1/images/search?size=med&mime_types=jpg&format=json&has_breeds=true&order=RANDOM&page=0&limit=1",
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(final JSONArray response) {
                        Log.d(TAG, "enter on response");
                        Log.d(TAG, response.toString());
                        try {
                            JSONObject jresponse = response.getJSONObject(0);
                            url = jresponse.getString("url");
                            Log.d(TAG, jresponse.getString("url"));
                            new DownLoadImageTask(imgView).execute(url);

                        } catch (Exception e) {
                            Log.d(TAG, "caught exception");
                            System.out.println(e.toString());
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(final VolleyError error) {
                Log.w(TAG, error.toString());
            }

        });
        requestQueue.add(jsonObjectRequest);

    }
//API above


    public void openBaseActivity() {
        Intent intent = new Intent(this, BaseActivity.class);
        startActivity(intent);
    }
}
