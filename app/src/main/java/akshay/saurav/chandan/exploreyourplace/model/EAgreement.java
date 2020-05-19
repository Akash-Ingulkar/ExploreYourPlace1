package akshay.saurav.chandan.exploreyourplace.model;

import com.google.gson.annotations.SerializedName;

public class EAgreement {

    @SerializedName("lawyer_name")
    private String lawyer_name;

    @SerializedName("oaadharcard")
    private String oaadharcard;

    @SerializedName("opancard")
    private String opancard;

    @SerializedName("ophoto")
    private String ophoto;

    @SerializedName("taadharcard")
    private String taadharcard;

    @SerializedName("tpancard")
    private String tpancard;

    @SerializedName("tphoto")
    private String tphoto;




    @SerializedName("response")
    private String Response;

    public String getResponse() {
        return Response;
    }


}
