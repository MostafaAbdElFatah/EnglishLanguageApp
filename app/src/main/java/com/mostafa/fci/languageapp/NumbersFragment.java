package com.mostafa.fci.languageapp;


import android.content.Context;
import android.content.res.TypedArray;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersFragment extends Fragment {

    ArrayList<Word> words = new ArrayList<>();

    public NumbersFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.words_list, container, false);
        ListView listView = rootView.findViewById(R.id.container);

        String[] arabicWords = getResources().getStringArray(R.array.arabic_numbers_words);
        String[] englishWords = getResources().getStringArray(R.array.english_numbers_words);
        TypedArray images = getResources().obtainTypedArray(R.array.numbers_images);
        for (int i = 0; i < arabicWords.length; i++) {
            words.add(new Word(arabicWords[i], englishWords[i]
                    , images.getResourceId(i, R.color.default_color)));
        }
        WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.category_numbers);
        listView.setAdapter(adapter);
        return rootView;
    }

}
