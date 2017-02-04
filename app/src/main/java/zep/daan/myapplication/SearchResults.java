package zep.daan.myapplication;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
            ArrayList<myArray> searchResults2 = new myArray().GetSearchResults(getApplicationContext(), null);
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
                if(!results.isEmpty()) {
                    ListView listView1 = (ListView) findViewById(R.id.search_list);
                    listView1.setAdapter(new SearchListAdapter(this, results));
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
                    //LinearLayout layout = (LinearLayout) findViewById(R.id.info);

                    TextView valueTV = new TextView(this);
                    valueTV.setText("No Results");
                    valueTV.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT));

                    ((RelativeLayout) Layout).addView(valueTV);

                }
            }

        }
    }

}
