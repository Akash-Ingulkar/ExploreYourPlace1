package akshay.saurav.chandan.exploreyourplace.model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PaYRenT implements Serializable
{

    @SerializedName("tenname")
    @Expose
    private String tenname;
    @SerializedName("tenphone")
    @Expose
    private String tenphone;
    @SerializedName("tenemail")
    @Expose
    private String tenemail;
    @SerializedName("ownphone")
    @Expose
    private String ownphone;
    @SerializedName("ownname")
    @Expose
    private String ownname;
    @SerializedName("response")
    @Expose
    private String response;
    private final static long serialVersionUID = 5420993784695851913L;

    public String getTenname() {
        return tenname;
    }

    public void setTenname(String tenname) {
        this.tenname = tenname;
    }

    public String getTenphone() {
        return tenphone;
    }

    public void setTenphone(String tenphone) {
        this.tenphone = tenphone;
    }

    public String getTenemail() {
        return tenemail;
    }

    public void setTenemail(String tenemail) {
        this.tenemail = tenemail;
    }

    public String getOwnphone() {
        return ownphone;
    }

    public void setOwnphone(String ownphone) {
        this.ownphone = ownphone;
    }

    public String getOwnname() {
        return ownname;
    }

    public void setOwnname(String ownname) {
        this.ownname = ownname;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

}