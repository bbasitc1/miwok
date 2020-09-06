package com.example.miwok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import java.util.List;


public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;

    public WordAdapter(@NonNull Context context, int resource, @NonNull List<Word> words, int ColorResourceId) {
        super(context, 0, words);
        mColorResourceId = ColorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Word currentWord = getItem(position);
        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView miwok_text_view = (TextView) listItemView.findViewById(R.id.miwok_test_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        miwok_text_view.setText(currentWord.getMivokTranslation());
        ImageView img = (ImageView) listItemView.findViewById(R.id.image);

        if(currentWord.hasImage())
        {
            img.setImageResource(currentWord.getImageResourceId());
            img.setVisibility(View.VISIBLE);
        }
        else {
            img.setVisibility(View.GONE);
        }
        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView default_text_view = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        default_text_view.setText(currentWord.getDefaultTranslation());

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

}
