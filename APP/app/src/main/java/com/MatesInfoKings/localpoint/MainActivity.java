package com.MatesInfoKings.localpoint;

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

        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<Fragment> fragmentList = new ArrayList<>();

        arrayList.add("Bescanviar");
        arrayList.add("Historial");
        arrayList.add("Locals");

        fragmentList.add(new FragmentOpt1());
        fragmentList.add(new FragmentOpt2());
        fragmentList.add(new FragmentOpt3());

        prepareViewPager(viewPager,arrayList,fragmentList);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void prepareViewPager(ViewPager viewPager, ArrayList<String> arrayList, ArrayList<Fragment> fragmentList) {
        MainAdapter adapter = new MainAdapter(getSupportFragmentManager());
        for (int i=0; i<arrayList.size(); i++){
            adapter.addFragment(fragmentList.get(i),arrayList.get(i));
        }
        viewPager.setAdapter(adapter);
    }

    private class MainAdapter extends FragmentPagerAdapter {

        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<Fragment> fragmentList = new ArrayList<>();


        public void addFragment(Fragment fragment, String title){
            arrayList.add(title);
            fragmentList.add(fragment);
        }

        public MainAdapter(@NonNull FragmentManager fm) {super(fm); }

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
            return arrayList.get(position);
        }
    }



}