package examples.aaronhoskins.com.networkexample.model.datasource.remote.httpurlconnection;

import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;

import examples.aaronhoskins.com.networkexample.model.randomuser.RandomUserResponse;

public class HttpURLConnectionRunnable implements Runnable {
    TextView textView;
    RandomUserResponse randomUserResponse;

    public HttpURLConnectionRunnable(TextView textView) {
        this.textView = textView;
    }

    @Override
    public void run() {
        try {
            String jsonResult = HttpUrlConnectionHelper.getRandomUserResponse();
            randomUserResponse = new Gson().fromJson(jsonResult, RandomUserResponse.class);
            Log.d("TAG", jsonResult);
            Log.d("TAG", randomUserResponse.getResults().get(0).getEmail());
            textView.setText(randomUserResponse.getResults().get(0).getEmail());
            String jsonFromPOJO = new Gson().toJson(randomUserResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
