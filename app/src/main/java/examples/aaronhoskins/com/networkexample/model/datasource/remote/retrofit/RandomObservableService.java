package examples.aaronhoskins.com.networkexample.model.datasource.remote.retrofit;

import examples.aaronhoskins.com.networkexample.model.randomuser.RandomUserResponse;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static examples.aaronhoskins.com.networkexample.model.datasource.remote.retrofit.UrlConstants.PATH;
import static examples.aaronhoskins.com.networkexample.model.datasource.remote.retrofit.UrlConstants.QUERY_GENDER;
import static examples.aaronhoskins.com.networkexample.model.datasource.remote.retrofit.UrlConstants.QUERY_RESULTS;

public interface RandomObservableService {
    @GET(PATH)
    Observable<RandomUserResponse> getRandomUsers(
            @Query(QUERY_RESULTS) String results,
            @Query(QUERY_GENDER) String gender);
}
