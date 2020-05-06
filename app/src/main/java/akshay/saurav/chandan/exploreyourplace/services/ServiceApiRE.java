package akshay.saurav.chandan.exploreyourplace.services;


import akshay.saurav.chandan.exploreyourplace.model.ReferEarn;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServiceApiRE {
    @GET("refer.php")
    Call<ReferEarn> refearn(@Query("name") String name, @Query("phone") String phone, @Query("address") String address);

}
