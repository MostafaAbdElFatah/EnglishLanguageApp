package com.mostafa.fci.languageapp;


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
public class PhrasesFragment extends Fragment {

    ArrayList<Word> words = new ArrayList<>();

    public PhrasesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.words_list, container, false);
        ListView listView = rootView.findViewById(R.id.container);

        String[] arabicWords = getResources().getStringArray(R.array.arabic_phrases);
        String[] englishWords = getResources().getStringArray(R.array.english_phrases);
        for (int i = 0; i < arabicWords.length; i++) {
            words.add(new Word(arabicWords[i], englishWords[i]
                    , -1) );
        }
        WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.category_phrases);
        listView.setAdapter(adapter);
        return rootView;
    }

}
