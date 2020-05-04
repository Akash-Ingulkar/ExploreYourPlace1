package akshay.saurav.chandan.exploreyourplace.services;

import akshay.saurav.chandan.exploreyourplace.model.CategoryList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceApiPMenu {
    @GET("propertymenu.php")
    abstract public Call<CategoryList> getPmenu();
}
