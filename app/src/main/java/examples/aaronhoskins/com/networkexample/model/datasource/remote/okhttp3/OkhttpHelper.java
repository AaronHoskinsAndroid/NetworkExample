package examples.aaronhoskins.com.networkexample.model.datasource.remote.okhttp3;

import android.util.Log;

import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import examples.aaronhoskins.com.networkexample.model.randomuser.RandomUserResponse;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkhttpHelper {
    public static final String RANDOM_USER_URL = "https://randomuser.me/api/?results=5";

    //Constructor for callback
//    static OkHttpResponseCallback okHttpResponseCallback;
//    public OkhttpHelper(OkHttpResponseCallback okHttpResponseCallback) {
//        this.okHttpResponseCallback = okHttpResponseCallback;
//    }

    private static OkHttpClient getClient() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient
                    .Builder()
                    .addInterceptor(httpLoggingInterceptor)
                    .build();
    }

    public static RandomUserResponse getSyncroniousOkHttpResponse() throws Exception{
        Request request = new Request.Builder().url(RANDOM_USER_URL).build();
        Response response = getClient().newCall(request).execute();
        return new Gson().fromJson(response.body().string(), RandomUserResponse.class);
    }

    public static void getAsyncroniousOkHttpResponce(final OkHttpResponseCallback okHttpResponseCallback) {
        Request request = new Request.Builder().url(RANDOM_USER_URL).build();
        getClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.e("TAG", "OKHTTP3 HAS AN ERROR", e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String jsonString = response.body().string();
                okHttpResponseCallback.randomUserResponseFromOkHttp(
                        new Gson().fromJson(jsonString, RandomUserResponse.class)
                );
            }
        });
    }
}
