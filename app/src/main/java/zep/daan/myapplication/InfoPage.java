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
import android.view.MenuItem;

import java.io.ByteArrayInputStream;

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

        String date = infointent.getStringExtra("date");
        String articleTime = date.split("\\s")[1].split("\\.")[0];
        String articleDate = date.substring(0,10);
        String articleDateTime = articleDate + ", " + articleTime;

        String section = infointent.getStringExtra("section");
        String hsection = section.substring(0, 1).toUpperCase() + section.substring(1);
        TextView text = (TextView) findViewById(R.id.headline);
        text.setText(headline);
        TextView text1 = (TextView) findViewById(R.id.date);
        text1.setText(articleDateTime);
        TextView text2 = (TextView) findViewById(R.id.article);
        text2.setText(article);
        ImageView imageView = (ImageView) findViewById(R.id.articleimage);
        getSupportActionBar().setTitle(hsection);
        ByteArrayInputStream imageStream = new ByteArrayInputStream(infointent.getByteArrayExtra("image"));
        Bitmap theImage= BitmapFactory.decodeStream(imageStream);
        imageView.setImageBitmap(theImage);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.action_share:
                Intent infointent = getIntent();
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, infointent.getStringExtra("headline") + "\n \n" + infointent.getStringExtra("article"));
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_article, menu);
        return true;
    }




}
