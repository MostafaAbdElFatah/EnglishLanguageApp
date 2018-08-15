package com.mostafa.fci.languageapp;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {

    ArrayList<Word> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        ViewPager viewPager = findViewById(R.id.viewPager);
        TabLayout tabLayout = findViewById(R.id.tab_layout);


        CategoryAdapter adapter = new CategoryAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        String sectionName = getIntent().getStringExtra(Constants.SECTION_NAME);
        switch (sectionName){
            case Constants.NUMBERS_SECTION:
                viewPager.setCurrentItem(0);
                break;
            case Constants.FAMILY_SECTION:
                viewPager.setCurrentItem(1);
                break;
            case Constants.COLORS_SECTION:
                viewPager.setCurrentItem(2);
                break;
            case Constants.PHRASES_SECTION:
                viewPager.setCurrentItem(3);
                break;
             default:
                viewPager.setCurrentItem(0);
        }

    }

    public void setToolBarTitle(int title){
        getSupportActionBar().setTitle(title);
    }
}
