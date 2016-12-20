package zep.daan.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by daan on 12/1/16.
 */


public class myArray {
    private String headline = "";
    private String article = "";
    private String section = "";
    private String frontpage = "";
    private String date = "";
    private Integer image = 0;
    public void setHeadline(String headline) {
        this.headline = headline;
    }
    public String getHeadline() {
        return headline;
    }

    public void setArticle(String article) {
        this.article = article;
    }
    public String getArticle() {
        return article;
    }

    public void setSection(String section) {
        this.section = section;
    }
    public String getSection() {
        return section;
    }

    public void setFrontpage(String frontpage) {
        this.frontpage = frontpage;
    }
    public String getFrontpage() {
        return frontpage;
    }

    public void setDate(String date) {this.date = date;}
    public String getDate() {return date;}

    public void setImage(Integer image){this.image = image;}
    public int getImage() {return image;}






    public ArrayList<myArray> GetSearchResults(Context context){
        DataBaseHelper myDbHelper;
        myDbHelper = new DataBaseHelper(context);
        try {
            myDbHelper.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }
        try {
            myDbHelper.openDataBase();
        }catch(SQLiteException sqle){
            throw sqle;
        }
        SQLiteDatabase database = new DataBaseHelper(context).getReadableDatabase();
        String select = "Select * From articles";
        Cursor cursor = database.query("articlelist", null, null, null, null, null, null);



        ArrayList<myArray> results = new ArrayList<myArray>();

        while( cursor.moveToNext()){
            myArray sr = new myArray();
            sr.setSection(cursor.getString(1));
            sr.setFrontpage(cursor.getString(2));
            sr.setHeadline(cursor.getString(3));
            sr.setDate(cursor.getString(4));
            sr.setArticle(cursor.getString(5));
            sr.setImage(R.drawable.image2);
            results.add(sr);
        }
        return results;



    /*
        ArrayList<myArray> results = new ArrayList<myArray>();
        myArray sr = new myArray();
        sr.setHeadline("Donald Trump");
        sr.setArticle("Is an idiot");
        sr.setSection("415-555-1234");
        sr.setFrontpage("yes");
        sr.setDate("10-12-2016 13:00");
        sr.setImage(R.drawable.image2);
        results.add(sr);

        sr = new myArray();
        sr.setHeadline("Jane Doe");
        sr.setArticle("Las Vegas, NV");
        sr.setSection("702-555-1234");
        sr.setFrontpage("yes");
        sr.setDate("9-12-2016 15:00");
        sr.setImage(R.drawable.ic_action_name);
        results.add(sr);

        sr = new myArray();
        sr.setHeadline("Lauren Sherman");
        sr.setArticle("San Francisco, CA");
        sr.setSection("415-555-1234");
        sr.setFrontpage("yes");
        sr.setDate("8-12-2016 9:00");
        sr.setImage(R.drawable.ic_action_name);
        results.add(sr);

        sr = new myArray();
        sr.setHeadline("Fred Jones");
        sr.setArticle("Minneapolis, MN");
        sr.setSection("612-555-8214");
        sr.setFrontpage("yes");
        sr.setDate("12-11-2016 12:00");
        sr.setImage(R.drawable.ic_action_name);
        results.add(sr);

        sr = new myArray();
        sr.setHeadline("Bill Withers");
        sr.setArticle("Los Angeles, CA");
        sr.setSection("424-555-8214");
        sr.setFrontpage("yes");
        sr.setDate("12-11-2016 12:00");
        sr.setImage(R.drawable.ic_action_name);
        results.add(sr);

        sr = new myArray();
        sr.setHeadline("Donald Fagen");
        sr.setArticle("Los Angeles, CA");
        sr.setSection("424-555-1234");
        sr.setFrontpage("yes");
        sr.setDate("12-11-2016 12:00");
        sr.setImage(R.drawable.ic_action_name);
        results.add(sr);

        sr = new myArray();
        sr.setHeadline("Steve Rude");
        sr.setArticle("Oakland, CA");
        sr.setSection("515-555-2222");
        sr.setFrontpage("yes");
        sr.setDate("12-11-2011 12:00");
        sr.setImage(R.drawable.ic_action_name);
        results.add(sr);

        sr = new myArray();
        sr.setHeadline("Roland Bloom");
        sr.setArticle("Chelmsford, MA");
        sr.setSection("978-555-1111");
        sr.setFrontpage("yes");
        sr.setDate("12-11-2016 12:00");
        sr.setImage(R.drawable.ic_action_name);
        results.add(sr);

        sr = new myArray();
        sr.setHeadline("Sandy Baguskas");
        sr.setArticle("Chelmsford, MA");
        sr.setSection("978-555-2222");
        sr.setFrontpage("yes");
        sr.setDate("12-11-2016 12:00");
        sr.setImage(R.drawable.ic_action_name);
        results.add(sr);

        sr = new myArray();
        sr.setHeadline("Scott Taylor");
        sr.setArticle("Austin, TX");
        sr.setSection("512-555-2222");
        sr.setFrontpage("yes");
        sr.setDate("12-11-2016 12:00");
        sr.setImage(R.drawable.ic_action_name);
        results.add(sr);

        return results;
        */
    }

}
