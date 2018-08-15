package com.mostafa.fci.languageapp;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FamilyFragment extends Fragment {

    ArrayList<Word> words = new ArrayList<>();

    public FamilyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.words_list, container, false);
        ListView listView = rootView.findViewById(R.id.container);

        String[] arabicWords = getResources().getStringArray(R.array.arabic_family_words);
        String[] englishWords = getResources().getStringArray(R.array.english_family_words);
        TypedArray images = getResources().obtainTypedArray(R.array.family_images);
        for (int i = 0; i < arabicWords.length; i++) {
            words.add(new Word(arabicWords[i], englishWords[i]
                    , images.getResourceId(i, R.color.default_color)));
        }
        WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.category_family);
        listView.setAdapter(adapter);
        return rootView;
    }

}
