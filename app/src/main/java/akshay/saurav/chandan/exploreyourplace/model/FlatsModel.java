package akshay.saurav.chandan.exploreyourplace.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FlatsModel {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("propertytype_id")
    @Expose
    private String propertytypeId;
    @SerializedName("property_type")
    @Expose
    private String propertyType;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("path")
    @Expose
    private String path;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPropertytypeId() {
        return propertytypeId;
    }

    public void setPropertytypeId(String propertytypeId) {
        this.propertytypeId = propertytypeId;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
