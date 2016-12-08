package zep.daan.myapplication;

import java.util.ArrayList;

/**
 * Created by daan on 12/1/16.
 */


public class myArray {
    private String name = "";
    private String cityState = "";
    private String phone = "";
    private String date = "";
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

    public void setDate(String date) {this.date = date;}
    public String getDate() {return date;}

    public void setImage(Integer image){this.image = image;}
    public int getImage() {return image;}


    public static ArrayList<myArray> GetSearchResults(){
        ArrayList<myArray> results = new ArrayList<myArray>();
        myArray sr = new myArray();
        sr.setName("Donald Trump");
        sr.setCityState("San Francisco, CA");
        sr.setPhone("415-555-1234");
        sr.setDate("7-12-2016 12:00");
        sr.setImage(R.drawable.image2);
        results.add(sr);

        sr = new myArray();
        sr.setName("Jane Doe");
        sr.setCityState("Las Vegas, NV");
        sr.setPhone("702-555-1234");
        sr.setDate("6-12-2016 12:00");
        sr.setImage(R.drawable.ic_action_name);
        results.add(sr);

        sr = new myArray();
        sr.setName("Lauren Sherman");
        sr.setCityState("San Francisco, CA");
        sr.setPhone("415-555-1234");
        sr.setDate("8-12-2016 1:00");
        sr.setImage(R.drawable.ic_action_name);
        results.add(sr);

        sr = new myArray();
        sr.setName("Fred Jones");
        sr.setCityState("Minneapolis, MN");
        sr.setPhone("612-555-8214");
        sr.setDate("12-11-2016 12:00");
        sr.setImage(R.drawable.ic_action_name);
        results.add(sr);

        sr = new myArray();
        sr.setName("Bill Withers");
        sr.setCityState("Los Angeles, CA");
        sr.setPhone("424-555-8214");
        sr.setDate("12-11-2016 12:00");
        sr.setImage(R.drawable.ic_action_name);
        results.add(sr);

        sr = new myArray();
        sr.setName("Donald Fagen");
        sr.setCityState("Los Angeles, CA");
        sr.setPhone("424-555-1234");
        sr.setDate("12-11-2016 12:00");
        sr.setImage(R.drawable.ic_action_name);
        results.add(sr);

        sr = new myArray();
        sr.setName("Steve Rude");
        sr.setCityState("Oakland, CA");
        sr.setPhone("515-555-2222");
        sr.setDate("12-11-2011 12:00");
        sr.setImage(R.drawable.ic_action_name);
        results.add(sr);

        sr = new myArray();
        sr.setName("Roland Bloom");
        sr.setCityState("Chelmsford, MA");
        sr.setPhone("978-555-1111");
        sr.setDate("12-11-2016 12:00");
        sr.setImage(R.drawable.ic_action_name);
        results.add(sr);

        sr = new myArray();
        sr.setName("Sandy Baguskas");
        sr.setCityState("Chelmsford, MA");
        sr.setPhone("978-555-2222");
        sr.setDate("12-11-2016 12:00");
        sr.setImage(R.drawable.ic_action_name);
        results.add(sr);

        sr = new myArray();
        sr.setName("Scott Taylor");
        sr.setCityState("Austin, TX");
        sr.setPhone("512-555-2222");
        sr.setDate("12-11-2016 12:00");
        sr.setImage(R.drawable.ic_action_name);
        results.add(sr);

        return results;
    }

}
