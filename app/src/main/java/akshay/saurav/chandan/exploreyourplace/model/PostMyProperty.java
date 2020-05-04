package akshay.saurav.chandan.exploreyourplace.model;

/**
 * Created by delaroystudios on 10/5/2016.
 */

import com.google.gson.annotations.SerializedName;


public class PostMyProperty {

    // variable name should be same as in the json response from php
    @SerializedName("price")
    private String Price;

    @SerializedName("proptype")
    private String Proptype;

    @SerializedName("location")
    private String Location;

    @SerializedName("description")
    private String Description;

    @SerializedName("image")
    private String Image;


    @SerializedName("response")
    private String Response;

    public String getResponse() {
        return Response;
    }


}