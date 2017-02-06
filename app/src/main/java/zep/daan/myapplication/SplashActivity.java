package zep.daan.myapplication;

/**
 * Created by Zep on 6-2-2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, NavigationDrawer.class);
        startActivity(intent);
        finish();
    }
}