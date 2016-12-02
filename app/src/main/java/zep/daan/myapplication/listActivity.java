package zep.daan.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import java.util.ArrayList;

public class listActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

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
        results.add(sr);

        sr = new myArray();
        sr.setName("Jane Doe");
        sr.setCityState("Las Vegas, NV");
        sr.setPhone("702-555-1234");
        results.add(sr);

        sr = new myArray();
        sr.setName("Lauren Sherman");
        sr.setCityState("San Francisco, CA");
        sr.setPhone("415-555-1234");
        results.add(sr);

        sr = new myArray();
        sr.setName("Fred Jones");
        sr.setCityState("Minneapolis, MN");
        sr.setPhone("612-555-8214");
        results.add(sr);

        sr = new myArray();
        sr.setName("Bill Withers");
        sr.setCityState("Los Angeles, CA");
        sr.setPhone("424-555-8214");
        results.add(sr);

        sr = new myArray();
        sr.setName("Donald Fagen");
        sr.setCityState("Los Angeles, CA");
        sr.setPhone("424-555-1234");
        results.add(sr);

        sr = new myArray();
        sr.setName("Steve Rude");
        sr.setCityState("Oakland, CA");
        sr.setPhone("515-555-2222");
        results.add(sr);

        sr = new myArray();
        sr.setName("Roland Bloom");
        sr.setCityState("Chelmsford, MA");
        sr.setPhone("978-555-1111");
        results.add(sr);

        sr = new myArray();
        sr.setName("Sandy Baguskas");
        sr.setCityState("Chelmsford, MA");
        sr.setPhone("978-555-2222");
        results.add(sr);

        sr = new myArray();
        sr.setName("Scott Taylor");
        sr.setCityState("Austin, TX");
        sr.setPhone("512-555-2222");
        results.add(sr);

        return results;
    }
}