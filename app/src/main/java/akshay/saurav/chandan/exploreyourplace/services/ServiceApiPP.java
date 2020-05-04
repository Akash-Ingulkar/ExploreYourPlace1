package akshay.saurav.chandan.exploreyourplace.services;

import akshay.saurav.chandan.exploreyourplace.model.PostMyProperty;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ServiceApiPP {

    @FormUrlEncoded
    @POST("upload_image.php")
    Call<PostMyProperty> uploadProperty(
            @Field("price") String price, @Field("image") String image, @Field("proptype") String proptype, @Field("location") String location, @Field("description") String description
    );
}
