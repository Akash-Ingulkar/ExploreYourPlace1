package akshay.saurav.chandan.exploreyourplace.services;

import akshay.saurav.chandan.exploreyourplace.model.BHKlist;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceApiBHK {
    @GET("bhk.php")
    abstract public Call<BHKlist> getBHK1();

    @GET("rk.php")
    abstract public Call<BHKlist> getRK1();


    @GET("cotbasis.php")
    abstract public Call<BHKlist> getCotbasis1();


    @GET("bunglow.php")
    abstract public Call<BHKlist> getBunglow1();
}
