package examples.aaronhoskins.com.networkexample.model.datasource.remote.rxjava;

import android.util.Log;

import examples.aaronhoskins.com.networkexample.model.randomuser.RandomUserResponse;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class RandomUserObserver implements Observer<RandomUserResponse> {
    Callback callback;
    private RandomUserResponse randomUserResponse;
    public RandomUserObserver(Callback callback) {
        this.callback = callback;
    }

    @Override
    public void onSubscribe(Disposable d) {
        //Do what is in here when we a object starts listening for emitting
    }

    @Override
    public void onNext(RandomUserResponse response) {
        //Do this when we get an result
        Log.d("TAG", response.getResults().get(0).getEmail());
        this.randomUserResponse = response;
    }

    @Override
    public void onError(Throwable e) {
        //Do this if something goes wrong
    }

    @Override
    public void onComplete() {
        //Do this once observable has completed emitting data
        callback.getRandomUserResponse(randomUserResponse);
    }
}
