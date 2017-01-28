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
 * Created by daan on 12/21/16.
 */

public class BinnenlandFragment extends ListFragment implements AdapterView.OnItemClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);
        setRetainInstance(true);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<myArray> searchResults = new myArray().GetSearchResults(getContext(), "binnenland");
        final ListView lv = getListView();
        lv.setAdapter(new MyCustomBaseAdapter(getActivity(), searchResults));
        getListView().setOnItemClickListener(this);
    }




    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent infointent = new Intent(getActivity(), InfoPage.class);
        final ListView lv = getListView();
        Object o = lv.getItemAtPosition(position);
        myArray fullObject = (myArray) o;
        String headline = fullObject.getHeadline();
        infointent.putExtra("headline", headline);
        String article = fullObject.getArticle();
        infointent.putExtra("article", article);
        String section = fullObject.getSection();
        infointent.putExtra("section", section);
        byte[] image = fullObject.getImage();
        infointent.putExtra("image", image);
        startActivity(infointent);
    }

}