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
    private byte[] image = null;
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
    public String getFrontpage() {return frontpage;}

    public void setDate(String date) {this.date = date;}
    public String getDate() {return date;}

    public void setImage(byte[] image){this.image = image;}
    public byte[] getImage() {return image;}






    public ArrayList<myArray> GetSearchResults(Context context, String filter){
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
        String whereClause;
        SQLiteDatabase database = new DataBaseHelper(context).getReadableDatabase();
        if(filter == "front"){
            whereClause = "`Frontpage` = 'yes'";
        }
        else if(filter ==null){
            whereClause = null;
        }
        else{
            whereClause = "`Section` LIKE '"+ filter+"'";
        }
        Cursor cursor = database.query("articlelist", null, whereClause, null, null, null, null);

        ArrayList<myArray> results = new ArrayList<myArray>();

        while( cursor.moveToNext()){
            myArray sr = new myArray();
            sr.setSection(cursor.getString(1));
            sr.setFrontpage(cursor.getString(2));
            sr.setHeadline(cursor.getString(3));
            sr.setDate(cursor.getString(4));
            sr.setArticle(cursor.getString(5));
            byte[] imageblob = cursor.getBlob(6);
            sr.setImage(imageblob);
            results.add(sr);
        }
        cursor.close();
        database.close();
        return results;
    }

}
