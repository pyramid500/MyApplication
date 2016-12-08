package zep.daan.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;

import java.util.Calendar;

public class InfoPage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_page);


        // my_child_toolbar is defined in the layout file
        Toolbar myChildToolbar =
                (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myChildToolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);

        Intent infointent = getIntent();


        Calendar thatDay = Calendar.getInstance();
        thatDay.set(Calendar.DAY_OF_MONTH,25);
        thatDay.set(Calendar.MONTH,7); // 0-11 so 1 less
        thatDay.set(Calendar.YEAR, 1985);

        Calendar today = Calendar.getInstance();

        long diff = today.getTimeInMillis() - thatDay.getTimeInMillis(); //result in millis



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
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_article, menu);
        return true;
    }

}
