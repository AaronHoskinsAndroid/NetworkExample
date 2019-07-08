package examples.aaronhoskins.com.networkexample.model.datasource.remote.okhttp3;

import examples.aaronhoskins.com.networkexample.model.randomuser.RandomUserResponse;

public interface OkHttpResponseCallback {
    void randomUserResponseFromOkHttp(RandomUserResponse response);
}
