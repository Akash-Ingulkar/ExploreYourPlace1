package akshay.saurav.chandan.exploreyourplace.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryList {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("PMenu")
    @Expose
    private List<PMenu> pMenu = null;

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

    public List<PMenu> getPMenu() {
        return pMenu;
    }

    public void setPMenu(List<PMenu> pMenu) {
        this.pMenu = pMenu;
    }

}