package akshay.saurav.chandan.exploreyourplace.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BHKlist {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("BHK")
    @Expose
    private List<FlatsModel> bHK = null;
    @SerializedName("RK")
    @Expose
    private List<FlatsModel> rK = null;
    @SerializedName("bunglow")
    @Expose
    private List<FlatsModel> bunglow = null;

    @SerializedName("cotbasis")
    @Expose
    private List<FlatsModel> cotbasis = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<FlatsModel> getBHK() {
        return bHK;
    }

    public void setBHK(List<FlatsModel> bHK) {
        this.bHK = bHK;
    }

    public List<FlatsModel> getRK() {
        return rK;
    }

    public void setRK(List<FlatsModel> rK) {
        this.rK = rK;
    }
    public List<FlatsModel> getCotbasis() {
        return cotbasis;
    }

    public void setCotbasis(List<FlatsModel> cotbasis) {
        this.cotbasis = cotbasis;
    }
    public List<FlatsModel> getBunglow() {
        return bunglow;
    }

    public void setBunglow(List<FlatsModel> bunglow) {
        this.bunglow = bunglow;
    }
}