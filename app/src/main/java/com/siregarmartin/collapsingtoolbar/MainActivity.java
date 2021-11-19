package com.siregarmartin.collapsingtoolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);

        MainAdapter adapter = new MainAdapter(getSupportFragmentManager());
        adapter.addFragment(new PhotosFragment(), "Photos");
        adapter.addFragment(new VideosFragment(), "Videos");
        //set adapter
        viewPager.setAdapter(adapter);
        //connect tablayout with viewpager
        tabLayout.setupWithViewPager(viewPager);
    }

    private class MainAdapter extends FragmentPagerAdapter {

        List<Fragment> fragmentList = new ArrayList<>();
        List<String> stringList = new ArrayList<>();

        public void addFragment(Fragment fragment, String s) {
            fragmentList.add(fragment);
            stringList.add(s);
        }

        public MainAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);

        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return stringList.get(position);
        }
    }
}