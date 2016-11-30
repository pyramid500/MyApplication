package zep.daan.myapplication;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class listActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        populateListview();
    }

    private void populateListview() {
        String [] fiilliste={"1","2","3","4","5","6","7","8","9","10","11","12","13"}; //Makes Array
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, fiilliste);;//Sets new Array Adapter
        ListView list = (ListView) findViewById(R.id.menuList); //Sets listview of menuList to list
        list.setAdapter(adapter); //Sets adapter of list to adapter set before
    }
}
