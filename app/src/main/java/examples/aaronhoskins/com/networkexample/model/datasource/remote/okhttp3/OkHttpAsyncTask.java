package examples.aaronhoskins.com.networkexample.model.datasource.remote.okhttp3;

import android.os.AsyncTask;
import android.util.Log;

import examples.aaronhoskins.com.networkexample.model.randomuser.RandomUserResponse;

public class OkHttpAsyncTask extends AsyncTask<String, String, RandomUserResponse> {
    @Override
    protected RandomUserResponse doInBackground(String... strings) {
        try {
            return OkhttpHelper.getSyncroniousOkHttpResponse();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(RandomUserResponse response) {
        super.onPostExecute(response);
        Log.d("TAG_ASYNC", response.getResults().get(0).getEmail());
    }
}
