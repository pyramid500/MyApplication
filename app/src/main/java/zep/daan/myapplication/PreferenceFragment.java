package zep.daan.myapplication;

import android.os.Bundle;

/**
 * Created by daan on 12/13/16.
 */

public class PreferenceFragment extends android.preference.PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.app_settings);
    }
}
