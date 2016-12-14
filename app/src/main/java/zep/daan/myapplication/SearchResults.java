package zep.daan.myapplication;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class SearchResults extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        // Get the intent, verify the action and get the query
        Intent intent = getIntent().setData(null);
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            ArrayList<myArray> searchResults2 = myArray.GetSearchResults();
            ArrayList<myArray> results = new ArrayList<myArray>();
            for(myArray d : searchResults2){
                String article = (d.getArticle()).toLowerCase();
                String headline = (d.getHeadline()).toLowerCase();
                String section = (d.getSection()).toLowerCase();
                String lquery = query.toLowerCase();
                if(article.contains(lquery) || headline.contains(lquery) || section.contains(lquery)){
                    myArray sr = new myArray();
                    sr.setHeadline(d.getHeadline());
                    sr.setArticle(d.getArticle());
                    sr.setSection(d.getSection());
                    sr.setDate(d.getDate());
                    sr.setImage(d.getImage());
                    results.add(sr);
                }
                if(results != null) {
                    ListView listView1 = (ListView) findViewById(R.id.search_list);
                    listView1.setAdapter(new SearchListAdapter(this, results));
                }
                else{

                }
            }

        }
    }
}
