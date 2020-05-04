package akshay.saurav.chandan.exploreyourplace.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PMenu {

    @SerializedName("propertytype_id")
    @Expose
    private String propertytypeId;
    @SerializedName("propertytype")
    @Expose
    private String propertytype;
    @SerializedName("propertyphoto")
    @Expose
    private String propertyphoto;

    public String getPropertytypeId() {
        return propertytypeId;
    }

    public void setPropertytypeId(String propertytypeId) {
        this.propertytypeId = propertytypeId;
    }

    public String getPropertytype() {
        return propertytype;
    }

    public void setPropertytype(String propertytype) {
        this.propertytype = propertytype;
    }

    public String getPropertyphoto() {
        return propertyphoto;
    }

    public void setPropertyphoto(String propertyphoto) {
        this.propertyphoto = propertyphoto;
    }

}