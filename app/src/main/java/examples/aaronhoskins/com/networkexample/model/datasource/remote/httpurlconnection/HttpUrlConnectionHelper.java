package examples.aaronhoskins.com.networkexample.model.datasource.remote.httpurlconnection;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpUrlConnectionHelper {
    public static final String RANDOM_USER_URL = "https://randomuser.me/api/?results=5";
    private static URL urlObject;
    private static HttpURLConnection httpURLConnection;
    public static final int EOF = -1;

    public static String getRandomUserResponse() throws Exception {
        String resultString = "";

        //Open the connection
        urlObject = new URL(RANDOM_USER_URL);
        httpURLConnection = (HttpURLConnection)urlObject.openConnection();

        //Buffer the stream
        InputStream inputStream = httpURLConnection.getInputStream();
        int getIntValueOfCurrentRead = inputStream.read();
        while(getIntValueOfCurrentRead != EOF) {
            char convertedIntToChar = (char)getIntValueOfCurrentRead;
            resultString = resultString + convertedIntToChar;
            getIntValueOfCurrentRead = inputStream.read();
        }
        return resultString;
    }

}
