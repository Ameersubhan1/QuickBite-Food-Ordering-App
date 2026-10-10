package com.example.quickbite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.List;

public class SearchAdapter extends ArrayAdapter<SearchItem> {
    public SearchAdapter(Context context, List<SearchItem> items) {
        super(context, 0, items);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.search_item, parent, false);
        }

        SearchItem item = getItem(position);
        
        ImageView imageView = convertView.findViewById(R.id.itemImage);
        TextView nameView = convertView.findViewById(R.id.itemName);
        TextView categoryView = convertView.findViewById(R.id.itemCategory);

        if (item != null) {
            nameView.setText(item.getName());
            categoryView.setText(item.getCategory());
            
            if (item.getImageUrl() != null && !item.getImageUrl().isEmpty()) {
                Glide.with(getContext())
                        .load(item.getImageUrl())
                        .placeholder(R.drawable.food_placeholder)
                        .error(R.drawable.food_placeholder)
                        .into(imageView);
            } else if (item.getImageResId() != 0) {
                imageView.setImageResource(item.getImageResId());
            } else {
                imageView.setImageResource(R.drawable.food_placeholder);
            }
        }

        return convertView;
    }
}