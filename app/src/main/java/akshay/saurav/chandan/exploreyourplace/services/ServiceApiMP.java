package akshay.saurav.chandan.exploreyourplace.services;

import akshay.saurav.chandan.exploreyourplace.model.PamData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ServiceApiMP {
    @GET("packersandmovers.php")
    Call<PamData> packmove(@Query("name") String clientname, @Query("phone") String clientphone, @Query("city") String city, @Query("moving_from") String movingfrm, @Query("moving_to") String movingto);
}
