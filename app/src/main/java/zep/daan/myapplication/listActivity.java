package zep.daan.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import java.util.ArrayList;

public class listActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // my_child_toolbar is defined in the layout file
        Toolbar myChildToolbar =
                (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myChildToolbar);
        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();




        ArrayList<myArray> searchResults = GetSearchResults();

        final ListView lv = (ListView) findViewById(R.id.srListView);
        lv.setAdapter(new MyCustomBaseAdapter(this, searchResults));


        lv.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Intent infointent = new Intent(listActivity.this, InfoPage.class);
                Object o = lv.getItemAtPosition(position);
                myArray fullObject = (myArray) o;
                String name = fullObject.getName();
                infointent.putExtra("name", name);
                String cityandstate = fullObject.getCityState();
                infointent.putExtra("cs", cityandstate);
                String phonenr = fullObject.getPhone();
                infointent.putExtra("phonenr", phonenr);
                startActivity(infointent);
            }
        });
    }



    private ArrayList<myArray> GetSearchResults(){
        ArrayList<myArray> results = new ArrayList<myArray>();
        myArray sr = new myArray();
        sr.setName("Justin Schultz");
        sr.setCityState("San Francisco, CA");
        sr.setPhone("415-555-1234");
        sr.setImage(R.drawable.image2);
        results.add(sr);

        sr = new myArray();
        sr.setName("Jane Doe");
        sr.setCityState("Las Vegas, NV");
        sr.setPhone("702-555-1234");
        sr.setImage(R.drawable.ic_action_name);
        results.add(sr);

        sr = new myArray();
        sr.setName("Lauren Sherman");
        sr.setCityState("San Francisco, CA");
        sr.setPhone("415-555-1234");
        sr.setImage(R.drawable.ic_action_name);
        results.add(sr);

        sr = new myArray();
        sr.setName("Fred Jones");
        sr.setCityState("Minneapolis, MN");
        sr.setPhone("612-555-8214");
        sr.setImage(R.drawable.ic_action_name);
        results.add(sr);

        sr = new myArray();
        sr.setName("Bill Withers");
        sr.setCityState("Los Angeles, CA");
        sr.setPhone("424-555-8214");
        sr.setImage(R.drawable.ic_action_name);
        results.add(sr);

        sr = new myArray();
        sr.setName("Donald Fagen");
        sr.setCityState("Los Angeles, CA");
        sr.setPhone("424-555-1234");
        sr.setImage(R.drawable.ic_action_name);
        results.add(sr);

        sr = new myArray();
        sr.setName("Steve Rude");
        sr.setCityState("Oakland, CA");
        sr.setPhone("515-555-2222");
        sr.setImage(R.drawable.ic_action_name);
        results.add(sr);

        sr = new myArray();
        sr.setName("Roland Bloom");
        sr.setCityState("Chelmsford, MA");
        sr.setPhone("978-555-1111");
        sr.setImage(R.drawable.ic_action_name);
        results.add(sr);

        sr = new myArray();
        sr.setName("Sandy Baguskas");
        sr.setCityState("Chelmsford, MA");
        sr.setPhone("978-555-2222");
        sr.setImage(R.drawable.ic_action_name);
        results.add(sr);

        sr = new myArray();
        sr.setName("Scott Taylor");
        sr.setCityState("Austin, TX");
        sr.setPhone("512-555-2222");
        sr.setImage(R.drawable.ic_action_name);
        results.add(sr);

        return results;
    }
}