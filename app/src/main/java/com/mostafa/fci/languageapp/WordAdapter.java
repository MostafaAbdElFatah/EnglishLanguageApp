package com.mostafa.fci.languageapp;

import android.content.Context;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Locale;

public class WordAdapter extends ArrayAdapter<Word> {

    int bg;
    TextToSpeech textToSpeech;

    public WordAdapter(final Context context, ArrayList<Word> words , int bg) {
        super(context, R.layout.list_item,words);
        this.bg = bg;
        textToSpeech = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR)
                    textToSpeech.setLanguage(Locale.US);
                else
                    Toast.makeText(context , "Some thing is wrong\nYour Device not Supported"
                            ,Toast.LENGTH_SHORT).show();

            }
        });
    }
    @NonNull
    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        final Word word = getItem(position);
        TextView arabicWord = listItemView.findViewById(R.id.arabic_word);
        TextView englishWord = listItemView.findViewById(R.id.english_word);
        ImageView iconView = listItemView.findViewById(R.id.list_item_icon);
        LinearLayout playAudio = listItemView.findViewById(R.id.bg);

        playAudio.setBackgroundResource(bg);
        arabicWord.setText(word.getArabic());
        englishWord.setText(word.getEnglish());
        if (word.getImageResourceId() == -1) {
            iconView.setVisibility(View.GONE);
        }else if (bg == R.color.category_colors){
            iconView.setImageResource(word.getImageResourceId());
        }else {
            Picasso.get()
                    .load(word.getImageResourceId())
                    .into(iconView);
        }
        playAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playAudio(word.getEnglish());
            }
        });
        return listItemView;
    }

    private void playAudio(String englishPhrases) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            textToSpeech.speak(englishPhrases , TextToSpeech.QUEUE_FLUSH,null,null);
        }else {
            textToSpeech.speak(englishPhrases , TextToSpeech.QUEUE_FLUSH,null);
        }
        Toast.makeText(this.getContext() , "talking",Toast.LENGTH_SHORT).show();
    }
}
