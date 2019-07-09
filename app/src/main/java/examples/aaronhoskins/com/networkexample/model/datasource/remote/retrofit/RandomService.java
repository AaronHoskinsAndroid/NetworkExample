package examples.aaronhoskins.com.networkexample.model.datasource.remote.retrofit;

import examples.aaronhoskins.com.networkexample.model.randomuser.RandomUserResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static examples.aaronhoskins.com.networkexample.model.datasource.remote.retrofit.UrlConstants.PATH;
import static examples.aaronhoskins.com.networkexample.model.datasource.remote.retrofit.UrlConstants.QUERY_GENDER;
import static examples.aaronhoskins.com.networkexample.model.datasource.remote.retrofit.UrlConstants.QUERY_RESULTS;

public interface RandomService {
    //When we come into service   //results = 5, gender = f
    //      https://randomuser.me
    @GET(PATH)      //https://randomuser.me/api/
    Call<RandomUserResponse> getRandomUsers(
            @Query(QUERY_RESULTS) String results,
            @Query(QUERY_GENDER) String gender);
    //   https://randomuser.me/api/?results=5&gender=f
}
