package examples.aaronhoskins.com.networkexample.model.datasource.remote.rxjava;

import examples.aaronhoskins.com.networkexample.model.datasource.remote.retrofit.RetrofitHelper;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class RandomUserRepo {
    public static void getRandomUsers(Callback callback) {
        new RetrofitHelper()
                .getObservableService()
                .getRandomUsers("5", "female")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RandomUserObserver(callback));
    }
}
