package akshay.saurav.chandan.exploreyourplace.services;

import akshay.saurav.chandan.exploreyourplace.model.EAgreement;
import akshay.saurav.chandan.exploreyourplace.model.PostMyProperty;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
public interface ServiceApiEA {

    @FormUrlEncoded
    @POST("agreement.php")
    Call<EAgreement> uploadAgrement(
            @Field("lawyer_name") String lawyer_name, @Field("oaadharcard") String oaadharcard, @Field("opancard") String opancard, @Field("ophoto") String ophoto, @Field("taadharcard") String taadharcard, @Field("tpancard") String tpancard, @Field("tphoto") String tphoto);

}
