package examples.aaronhoskins.com.networkexample.model.datasource.remote.rxjava;

import examples.aaronhoskins.com.networkexample.model.randomuser.RandomUserResponse;

public interface Callback {
    void getRandomUserResponse(RandomUserResponse randomMeResponse);
}
