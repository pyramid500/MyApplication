package zep.daan.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static zep.daan.myapplication.R.id.imageView;

public class MyCustomBaseAdapter extends android.widget.BaseAdapter {

    private static ArrayList<myArray> searchArrayList;

    private LayoutInflater mInflater;

    private static ArrayList<myArray> getImagepath;

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
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.txtName.setText(searchArrayList.get(position).getName());
        holder.image.setImageResource(searchArrayList.get(position).getImage());
        return convertView;
    }

    static class ViewHolder {
        TextView txtName;
        ImageView image;

    }
}