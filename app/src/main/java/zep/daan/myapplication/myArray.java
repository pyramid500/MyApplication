package zep.daan.myapplication;

/**
 * Created by daan on 12/1/16.
 */


public class myArray {
    private String name = "";
    private String cityState = "";
    private String phone = "";
    private Integer image = 0;
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setCityState(String cityState) {
        this.cityState = cityState;
    }
    public String getCityState() {
        return cityState;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPhone() {
        return phone;
    }
    public void setImage(Integer image){this.image = image;}
    public int getImage() {return image;}
}