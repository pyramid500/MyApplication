package zep.daan.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.format.DateTimeFormat;

import java.util.ArrayList;

import static zep.daan.myapplication.R.id.imageView;

public class MyCustomBaseAdapter extends android.widget.BaseAdapter {

    private static ArrayList<myArray> searchArrayList;

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
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.txtName = (TextView) convertView.findViewById(R.id.name);
            holder.image = (ImageView) convertView.findViewById(imageView);
            holder.time = (TextView) convertView.findViewById(R.id.time);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }




        String someDate = searchArrayList.get(position).getDate();

        String dateResult;
            DateTime dateTimearticle = DateTime.parse(someDate, DateTimeFormat.forPattern("dd-MM-yyyy kk:mm"));
            DateTime presentTime = DateTime.now();
            dateResult ="Error";
            int days = Days.daysBetween(dateTimearticle, presentTime).getDays();
            if(days>2) {
                dateResult = someDate;
            }
            else if(days == 2){
                dateResult = "Eergisteren";
            }
            else if(days == 1){
                dateResult = "Gisteren";
            }
            else if (days<1){
                int hours = Hours.hoursBetween(dateTimearticle, presentTime).getHours();
                dateResult = Integer.toString(hours) + " uur geleden";
            }






        holder.txtName.setText(searchArrayList.get(position).getHeadline());
        holder.image.setImageResource(searchArrayList.get(position).getImage());
        holder.time.setText(dateResult);
        return convertView;
    }

    static class ViewHolder {
        TextView txtName;
        TextView time;
        ImageView image;

    }
}