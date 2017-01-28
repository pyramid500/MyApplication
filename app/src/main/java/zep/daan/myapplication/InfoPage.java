package zep.daan.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayInputStream;

import static zep.daan.myapplication.R.id.phonenr;

public class InfoPage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_page);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }

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
        String hsection = section.substring(0, 1).toUpperCase() + section.substring(1);
        TextView text = (TextView) findViewById(R.id.uname);
        text.setText(headline);
        TextView text1 = (TextView) findViewById(R.id.city_state);
        text1.setText(article);
        TextView text2 = (TextView) findViewById(phonenr);
        text2.setText(hsection);
        ImageView imageView = (ImageView) findViewById(R.id.articleimage);
        getSupportActionBar().setTitle(hsection);
        ByteArrayInputStream imageStream = new ByteArrayInputStream(infointent.getByteArrayExtra("image"));
        Bitmap theImage= BitmapFactory.decodeStream(imageStream);
        imageView.setImageBitmap(theImage);
    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_article, menu);
        return true;
    }

}
