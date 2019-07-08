
package examples.aaronhoskins.com.networkexample.model.randomuser;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RandomUserResponse implements Parcelable
{

    @SerializedName("results")
    @Expose
    private List<Result> results = null;
    @SerializedName("info")
    @Expose
    private Info info;
    public final static Creator<RandomUserResponse> CREATOR = new Creator<RandomUserResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public RandomUserResponse createFromParcel(Parcel in) {
            return new RandomUserResponse(in);
        }

        public RandomUserResponse[] newArray(int size) {
            return (new RandomUserResponse[size]);
        }

    }
    ;

    protected RandomUserResponse(Parcel in) {
        in.readList(this.results, (Result.class.getClassLoader()));
        this.info = ((Info) in.readValue((Info.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public RandomUserResponse() {
    }

    /**
     * 
     * @param results
     * @param info
     */
    public RandomUserResponse(List<Result> results, Info info) {
        super();
        this.results = results;
        this.info = info;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(results);
        dest.writeValue(info);
    }

    public int describeContents() {
        return  0;
    }

}
