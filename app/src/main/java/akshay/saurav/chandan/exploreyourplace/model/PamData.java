package akshay.saurav.chandan.exploreyourplace.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PamData implements Serializable
{

    @SerializedName("response")
    @Expose
    private String response;

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("moving_from")
    @Expose
    private String movingFrom;
    @SerializedName("moving_to")
    @Expose
    private String movingTo;

    @SerializedName("created_at")
    @Expose
    private String created_at;


    private final static long serialVersionUID = -9165276971980801713L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMovingFrom() {
        return movingFrom;
    }

    public void setMovingFrom(String movingFrom) {
        this.movingFrom = movingFrom;
    }

    public String getMovingTo() {
        return movingTo;
    }

    public void setMovingTo(String movingTo) {
        this.movingTo = movingTo;
    }
    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
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
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", city='" + city + '\'' +
                ", moving_from='" + movingFrom + '\'' +
                ", moving_to='" + movingTo + '\'' +
                ", created_at='" + created_at + '\'' +
                '}';
    }

}