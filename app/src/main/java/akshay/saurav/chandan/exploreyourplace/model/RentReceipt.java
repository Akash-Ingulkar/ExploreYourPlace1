package akshay.saurav.chandan.exploreyourplace.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RentReceipt implements Serializable
{
    @SerializedName("response")
    @Expose
    private String response;

    @SerializedName("tenname")
    @Expose
    private String tenname;
    @SerializedName("ownername")
    @Expose
    private String ownername;
    @SerializedName("tenphone")
    @Expose
    private String tenphone;
    @SerializedName("ownerphone")
    @Expose
    private String ownerphone;
    @SerializedName("rent")
    @Expose
    private String rent;

    @SerializedName("created_at")
    @Expose
    private String created_at;

    private final static long serialVersionUID = -2724885181788171577L;

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

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    public String getTenphone() {
        return tenphone;
    }

    public void setTenphone(String tenphone) {
        this.tenphone = tenphone;
    }

    public String getOwnerphone() {
        return ownerphone;
    }

    public void setOwnerphone(String ownerphone) {
        this.ownerphone = ownerphone;
    }

    public String getRent() {
        return rent;
    }

    public void setRent(String rent) {
        this.rent = rent;
    }

    public String getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(String created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "RentReceipt{" +
                "response='" + response + '\'' +
                ", tenname='" + tenname + '\'' +
                ", ownername='" + ownername + '\'' +
                ", tenphone='" + tenphone + '\'' +
                ", ownerphone='" + ownerphone + '\'' +
                ", rent='" + rent + '\'' +
                ", created_at='" + created_at + '\'' +
                '}';
    }

}