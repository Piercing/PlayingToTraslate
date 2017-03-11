package com.example.android.miwok.adapters;


import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.miwok.R;
import com.example.android.miwok.Models.Word;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;
    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context          The current context. Used to inflate the layout file.
     * @param words            A List of Words objects to display in a list
     * @param colorResourceId
     */
    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId) {
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Chech if the existing view is being resused, otherwise inflate the view.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list.
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view.
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);

        // Get the miwok traslation from the current Word object and set this text on the name TextView.
        assert currentWord != null;
        miwokTextView.setText(currentWord.getmMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID default_text_view.
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);

        // Get the default word from the current Word object and set this text on the number TextView.
        defaultTextView.setText(currentWord.getmDefaultTranslation());

        // Find de ImageView in the list_item layout with the ID image_resource_image_view.
        ImageView imageRsource = (ImageView) listItemView.findViewById(R.id.image);

        if (currentWord.hasImage()) {
            // Get the image resource from the current Word object and set this image on the image ImageView.
            imageRsource.setImageResource(currentWord.getmImageResourceId());
            imageRsource.setVisibility(View.VISIBLE);
        } else {
            imageRsource.setVisibility(View.GONE);// GONE, que desaparezca la imagen, vamos que oculte la vista y no ocupe espacio.
        }

        // Set the theme color for the list item.
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to.
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View.
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextView) so that it can be show in the listView.
        return listItemView;
    }
}















