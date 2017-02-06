package zep.daan.myapplication;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class SearchResults extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);

        // Get the intent, verify the action and get the query
        Intent intent = getIntent().setData(null);
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            getSupportActionBar().setTitle("Zoekresultaten voor '" + query + "'");
            ArrayList<myArray> searchResults2 = new myArray().GetSearchResults(getApplicationContext(), "searchstring:"+query);
                if(!searchResults2.isEmpty()) {
                    ListView listView1 = (ListView) findViewById(R.id.search_list);
                    listView1.setAdapter(new SearchListAdapter(this, searchResults2));
                    listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent infointent = new Intent(SearchResults.this, InfoPage.class);
                            final ListView lv = (ListView) findViewById(R.id.search_list);
                            Object o = lv.getItemAtPosition(position);
                            myArray fullObject = (myArray) o;

                            String section = fullObject.getSection();
                            infointent.putExtra("section", section);

                            byte[] image = fullObject.getImage();
                            infointent.putExtra("image", image);

                            String headline = fullObject.getHeadline();
                            infointent.putExtra("headline", headline);

                            String date = fullObject.getDate();
                            infointent.putExtra("date", date);

                            String article = fullObject.getArticle();
                            infointent.putExtra("article", article);

                            startActivity(infointent);
                        }
                    });
                }
                else{
                    View Layout =  findViewById(R.id.content_navigation_drawer);
                    LinearLayout layout = (LinearLayout) findViewById(R.id.content_search_results);

                    TextView noResult = (TextView) findViewById(R.id.no_result);
                    noResult.setText("Geen resultaten gevonden voor '" + query + "'.");

                    getSupportActionBar().setTitle("Geen zoekresultaten");
                    return;

                }
            }

        }
    }

