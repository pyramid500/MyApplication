package zep.daan.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.format.DateTimeFormat;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import static zep.daan.myapplication.R.id.imageView;

/**
 * Created by daan on 12/21/16.
 */

public class BuitenlandFragment extends ListFragment implements AdapterView.OnItemClickListener {
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

        ArrayList<myArray> searchResults = new myArray().GetSearchResults(getContext(), "buitenland");
        final ListView lv = getListView();
        lv.setAdapter(new MyCustomBaseAdapter(getActivity(), searchResults));
        getListView().setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent infointent = new Intent(getActivity(), InfoPage.class);
        final ListView lv = getListView();
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
    public class MyCustomBaseAdapter extends android.widget.BaseAdapter {

        private ArrayList<myArray> searchArrayList;

        private LayoutInflater mInflater;

        public MyCustomBaseAdapter(Context context, ArrayList<myArray> results) {
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
            BuitenlandFragment.MyCustomBaseAdapter.ViewHolder holder;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.list_item, null);
                holder = new MyCustomBaseAdapter.ViewHolder();
                holder.txtName = (TextView) convertView.findViewById(R.id.name);
                holder.image = (ImageView) convertView.findViewById(imageView);
                holder.time = (TextView) convertView.findViewById(R.id.time);
                convertView.setTag(holder);
            } else {
                holder = (BuitenlandFragment.MyCustomBaseAdapter.ViewHolder) convertView.getTag();
            }

            String someDate = searchArrayList.get(position).getDate();
            String dateResult = "";
            DateTime dateTimearticle = DateTime.parse(someDate, DateTimeFormat.forPattern("yyyy-MM-dd kk:mm"));
            DateTime presentTime = DateTime.now();
            int days = Days.daysBetween(dateTimearticle, presentTime).getDays();
            if (days > 2) {
                dateResult = dateTimearticle.toString("dd-MM-yyyy, kk:mm");
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
            options.inSampleSize = 2;
            ByteArrayInputStream imageStream = new ByteArrayInputStream(searchArrayList.get(position).getImage());
            Bitmap theImage = BitmapFactory.decodeStream(imageStream, null, options);
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