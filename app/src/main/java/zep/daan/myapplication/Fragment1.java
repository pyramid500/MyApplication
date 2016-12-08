package zep.daan.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by daan on 12/4/16.
 */

public class Fragment1 extends ListFragment implements AdapterView.OnItemClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = (ViewGroup) inflater.inflate(R.layout.fragment1, null, false);
        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<myArray> searchResults = GetSearchResults();

        final ListView lv = getListView();
        lv.setAdapter(new MyCustomBaseAdapter(getActivity(), searchResults));
        getListView().setOnItemClickListener(this);
    }



    public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
        final ListView lv = getListView();
        Intent infointent = new Intent(getActivity(), InfoPage.class);
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