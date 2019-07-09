package examples.aaronhoskins.com.networkexample.model.datasource.remote.retrofit;

import android.util.Log;

import java.io.IOException;

import examples.aaronhoskins.com.networkexample.model.datasource.remote.okhttp3.OkhttpHelper;
import examples.aaronhoskins.com.networkexample.model.randomuser.RandomUserResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static examples.aaronhoskins.com.networkexample.model.datasource.remote.retrofit.UrlConstants.BASE_URL;

public class RetrofitHelper {

    public Retrofit getRetrofitInstance(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(OkhttpHelper.getClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public RandomService getService() {
        return getRetrofitInstance().create(RandomService.class);
    }

    static RandomUserResponse randomUserResponse;
    public RandomUserResponse getSyncRandomUserResponse(final int results, final String gender) throws Exception {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response = getService().getRandomUsers(String.valueOf(results), gender).execute();
                    randomUserResponse = (RandomUserResponse)response.body();
                    Log.d("TAG_RETROFIT", randomUserResponse.getResults().get(0).getEmail());
                } catch (IOException e) {

                }
            }
        });
        thread.start();
        return randomUserResponse;
    }

    public void getAsyncRandomUsers(int results, String gender) {
        RetrofitHelper retrofitHelper = new RetrofitHelper();
        retrofitHelper.getService().getRandomUsers(String.valueOf(results), gender).enqueue(new Callback<RandomUserResponse>() {
            @Override
            public void onResponse(Call<RandomUserResponse> call, Response<RandomUserResponse> response) {
                String firstEmailInList = response.body().getResults().get(0).getEmail();
                Log.d("TAG_ASYNC_RETRO", firstEmailInList);
            }

            @Override
            public void onFailure(Call<RandomUserResponse> call, Throwable t) {

            }
        });
    }
}
