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
        View view = inflater.inflate(R.layout.fragment1, container, false);
        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<myArray> searchResults = myArray.GetSearchResults();

        final ListView lv = getListView();
        lv.setAdapter(new MyCustomBaseAdapter(getActivity(), searchResults));
        getListView().setOnItemClickListener(this);
    }




    public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
        Intent infointent = new Intent(getActivity(), InfoPage.class);
        final ListView lv = getListView();
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

}