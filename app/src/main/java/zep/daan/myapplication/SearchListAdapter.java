package zep.daan.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.format.DateTimeFormat;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import static zep.daan.myapplication.R.id.imageView;

public class SearchListAdapter extends android.widget.BaseAdapter {
    private static ArrayList<myArray> searchArrayList;

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
        SearchListAdapter.ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item, null);
            holder = new SearchListAdapter.ViewHolder();
            holder.txtName = (TextView) convertView.findViewById(R.id.name);
            holder.image = (ImageView) convertView.findViewById(imageView);
            holder.time = (TextView) convertView.findViewById(R.id.time);
            convertView.setTag(holder);
        } else {
            holder = (SearchListAdapter.ViewHolder) convertView.getTag();
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

    static class ViewHolder {
        TextView txtName;
        TextView time;
        ImageView image;

    }
}