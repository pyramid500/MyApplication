package zep.daan.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class InfoPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_page);
        Intent infointent = getIntent();
        String message = infointent.getStringExtra("name");
        String citystate = infointent.getStringExtra("cs");
        String phonenr = infointent.getStringExtra("phonenr");
        TextView text = (TextView) findViewById(R.id.uname);
        text.setText(message);
        TextView text1 = (TextView) findViewById(R.id.city_state);
        text1.setText(citystate);
        TextView text2 = (TextView) findViewById(R.id.phonenr);
        text2.setText(phonenr);
    }
}
