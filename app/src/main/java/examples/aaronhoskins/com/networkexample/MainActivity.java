package examples.aaronhoskins.com.networkexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import examples.aaronhoskins.com.networkexample.model.datasource.remote.httpurlconnection.HttpURLConnectionRunnable;
import examples.aaronhoskins.com.networkexample.model.datasource.remote.httpurlconnection.HttpUrlConnectionHelper;
import examples.aaronhoskins.com.networkexample.model.datasource.remote.okhttp3.OkHttpAsyncTask;
import examples.aaronhoskins.com.networkexample.model.datasource.remote.okhttp3.OkHttpResponseCallback;
import examples.aaronhoskins.com.networkexample.model.datasource.remote.okhttp3.OkhttpHelper;
import examples.aaronhoskins.com.networkexample.model.randomuser.RandomUserResponse;

public class MainActivity extends AppCompatActivity implements OkHttpResponseCallback {
    public static final String IMAGE_URL
            = "https://www.geek.com/wp-content/uploads/2018/06/goku_large-625x352.png";
    //Declare views
    ImageView imgImageUsingGlide;
    TextView tvEmailDisplay;

    RandomUserResponse randomUserResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgImageUsingGlide = findViewById(R.id.imgImageFromGlide);
        tvEmailDisplay = findViewById(R.id.tvEmail);

        Glide
                .with(this)
                .load(IMAGE_URL)
                .into(imgImageUsingGlide);

//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    String jsonResult = HttpUrlConnectionHelper.getRandomUserResponse();
//                    randomUserResponse = new Gson().fromJson(jsonResult, RandomUserResponse.class);
//                    Log.d("TAG", jsonResult);
//                    Log.d("TAG", randomUserResponse.getResults().get(0).getEmail());
//                    tvEmailDisplay.setText(randomUserResponse.getResults().get(0).getEmail());
//                    String jsonFromPOJO = new Gson().toJson(randomUserResponse);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        thread.start();
        Thread httpurlconnThread = new Thread(new HttpURLConnectionRunnable(tvEmailDisplay));
        httpurlconnThread.start();
       OkhttpHelper.getAsyncroniousOkHttpResponce(this);

        OkHttpAsyncTask okHttpAsyncTask = new OkHttpAsyncTask();
        okHttpAsyncTask.execute();
    }


    @Override
    public void randomUserResponseFromOkHttp(RandomUserResponse response) {
        Log.d("TAG", "randomUserResponseFromOkHttp: "
                + response.getResults().get(0).getEmail());
    }
}
