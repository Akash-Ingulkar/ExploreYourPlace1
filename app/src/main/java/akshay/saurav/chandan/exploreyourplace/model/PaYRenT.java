package akshay.saurav.chandan.exploreyourplace.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PaYRenT implements Serializable {
    @SerializedName("response")
    @Expose
    private String response;

    @SerializedName("tenname")
    @Expose
    private String tenname;

    @SerializedName("tenphone")
    @Expose
    private String tenphone;

    @SerializedName("tenemail")
    @Expose
    private String tenemail;


    @SerializedName("ownname")
    @Expose
    private String ownname;

    @SerializedName("ownphone")
    @Expose
    private String ownphone;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getTenname() {
        return tenname;
    }

    public void setTenname(String tenname) {
        this.tenname = tenname;
    }

    public String getOwnname() {
        return ownname;
    }

    public void setOwnname(String ownname) {
        this.ownname = ownname;
    }

    public String getTenphone() {
        return tenphone;
    }

    public void setTenphone(String tenphone) {
        this.tenphone = tenphone;
    }

    public String getOwnphone() {
        return ownphone;
    }

    public void setOwnphone(String ownphone) {
        this.ownphone = ownphone;
    }

    public String getTenemail() {
        return tenemail;
    }

    public void setTenemail(String tenemail) {
        this.tenemail = tenemail;
    }



}
