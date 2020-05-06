package akshay.saurav.chandan.exploreyourplace.services;

import akshay.saurav.chandan.exploreyourplace.model.PaYRenT;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServiceApiPR {

    @GET("payrent.php")
    Call<PaYRenT> dopayment(@Query("Tname") String tenname, @Query("Tphone") String tenphone, @Query("Temail") String tenemail, @Query("Oname") String ownname, @Query("Ophone") String ownphone);
}
