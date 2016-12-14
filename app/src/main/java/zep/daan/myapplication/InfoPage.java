package zep.daan.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;

import static zep.daan.myapplication.R.id.phonenr;

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


        String headline = infointent.getStringExtra("headline");
        String article = infointent.getStringExtra("article");
        String section = infointent.getStringExtra("section");
        TextView text = (TextView) findViewById(R.id.uname);
        text.setText(headline);
        TextView text1 = (TextView) findViewById(R.id.city_state);
        text1.setText(article);
        TextView text2 = (TextView) findViewById(phonenr);
        text2.setText(section);
    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_article, menu);
        return true;
    }

}
