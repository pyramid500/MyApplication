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
        String [] fiilliste={"A","Ağlamak","Almak","B","Bulmak"};
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, fiilliste);
        ListView list = (ListView) findViewById(R.id.menuList);
        list.setAdapter(adapter);
    }
}
