package zep.daan.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by bisma on 8/31/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Articles.db";
    public static final String TABLE_NAME = "articlelist";
    public static final String COL_1 = "_id";
    public static final String COL_2 = "Section";
    public static final String COL_3 = "Frontpage";
    public static final String COL_4 = "Headline";
    public static final String COL_5 = "Date";
    public static final String COL_6 = "Article";
    public static final String COL_7 = "Image";

    private static DatabaseHelper mInstance = null;

    public static DatabaseHelper getInstance(Context activityContext) {

        // Get the application context from the activityContext to prevent leak
        if (mInstance == null) {
            mInstance = new DatabaseHelper (activityContext.getApplicationContext());
        }
        return mInstance;
    }



    public DatabaseHelper(Context applicationContext) {
        super(applicationContext, DATABASE_NAME, null, 1);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT, SURNAME TEXT, MARKS INTEGER) ");




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(db);

    }


    public Cursor getAllData(){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery(" SELECT * FROM " + TABLE_NAME, null);
        return res;

    }

}