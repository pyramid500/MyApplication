package zep.daan.myapplication;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.format.DateTimeFormat;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import static zep.daan.myapplication.R.id.imageView;

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
                    RelativeLayout layout = (RelativeLayout) findViewById(R.id.content_search_results);

                    TextView noResult = (TextView) findViewById(R.id.no_result);
                    noResult.setText("Geen resultaten gevonden voor '" + query + "'.");

                    getSupportActionBar().setTitle("Geen zoekresultaten");
                    return;

                }
            }

        }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class SearchListAdapter extends android.widget.BaseAdapter {
        private  ArrayList<myArray> searchArrayList;

        private LayoutInflater mInflater;

        public SearchListAdapter(Context context, ArrayList<myArray> results) {
            searchArrayList = results;
            mInflater = LayoutInflater.from(context);
        }

        public int getCount() {
            return searchArrayList.size();
        }

        public Object getItem(int position) {
            return searchArrayList.get(position);
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            SearchResults.SearchListAdapter.ViewHolder holder;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.list_item, null);
                holder = new SearchResults.SearchListAdapter.ViewHolder();
                holder.txtName = (TextView) convertView.findViewById(R.id.name);
                holder.image = (ImageView) convertView.findViewById(imageView);
                holder.time = (TextView) convertView.findViewById(R.id.time);
                convertView.setTag(holder);
            } else {
                holder = (SearchResults.SearchListAdapter.ViewHolder) convertView.getTag();
            }

            String someDate = searchArrayList.get(position).getDate();
            String dateResult = "";
            DateTime dateTimearticle = DateTime.parse(someDate, DateTimeFormat.forPattern("yyyy-MM-dd kk:mm"));
            DateTime presentTime = DateTime.now();
            int days = Days.daysBetween(dateTimearticle, presentTime).getDays();
            if (days > 2) {
                dateResult = dateTimearticle.toString("dd-MM-yy, kk:mm");
            } else if (days == 2) {
                dateResult = "Eergisteren, " + dateTimearticle.toString("kk:mm");
            } else if (days == 1) {
                dateResult = "Gisteren, " + dateTimearticle.toString("kk:mm");
            } else if (days < 1) {
                int hours = Hours.hoursBetween(dateTimearticle, presentTime).getHours();
                dateResult = Integer.toString(hours) + " uur geleden";
            }

            holder.txtName.setText(searchArrayList.get(position).getHeadline());
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            ByteArrayInputStream imageStream = new ByteArrayInputStream(searchArrayList.get(position).getImage());
            Bitmap theImage= BitmapFactory.decodeStream(imageStream);
            holder.image.setImageBitmap(theImage);
            holder.time.setText(dateResult);
            return convertView;
        }

         class ViewHolder {
            TextView txtName;
            TextView time;
            ImageView image;

        }
    }
    }

