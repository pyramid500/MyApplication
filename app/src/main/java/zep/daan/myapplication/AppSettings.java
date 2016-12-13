package zep.daan.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class AppSettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_settings);
        getFragmentManager().beginTransaction()
                .replace(R.id.settings_fragment, new PreferenceFragment())
                .commit();
    }
}
