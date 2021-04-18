package com.MatesInfoKings.localpoint;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    TextView nPoints;
    Button btScan;

    FragmentOpt2 historial;
    private static int points = 20;

    public static String SHARED_PREFS = "sharedPrefs";
    public static String HISTORIAL_STRING = new String();
    public static String HISTORIAL = new String();
    public static String POINTS_STRING = new String();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nPoints = findViewById(R.id.textPoints);
        String newText = String.valueOf(points) + nPoints.getText();
        nPoints.setText(newText);

        historial = new FragmentOpt2();

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);

        loadData();
        updateView();

        btScan = findViewById(R.id.btScan);

        btScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator intentIntegrator = new IntentIntegrator(
                        MainActivity.this
                );
                intentIntegrator.setPrompt("Per activar el flash pugeu el volum");
                intentIntegrator.setBeepEnabled(true);
                intentIntegrator.setOrientationLocked(true);
                intentIntegrator.setCaptureActivity(Capture.class);
                intentIntegrator.initiateScan();
            }
        });

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult intentResult = IntentIntegrator.parseActivityResult(
                requestCode,resultCode,data
        );
        if(intentResult.getContents() != null){
            AlertDialog.Builder builder = new AlertDialog.Builder(
                    MainActivity.this
            );
            builder.setTitle("Resultat Escanejat");
            String resultat = intentResult.getContents();
            int nous_punts = Integer.parseInt(resultat.substring(resultat.length()-3));
            points += nous_punts;

            String newText = String.valueOf(points) + "\nPunts";
            nPoints.setText(newText);
            saveData();
            builder.setMessage("Has aconseguit " + String.valueOf(nous_punts) + " punts! Felicitats!!!");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int which) {
                    dialogInterface.dismiss();
                }
            });
            builder.show();

            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
            String strDate = dateFormat.format(date);
            historial.updateHistory(strDate+" Has conseguit " + String.valueOf(nous_punts) + " punts",viewPager);

        }else{
            Toast.makeText(getApplicationContext(),
                    "OOPS... No has escanejat res", Toast.LENGTH_LONG)
                    .show();
        }
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

    public int getPoints(){
        return points;
    }

    public void subPoints(int pointsToSub){
        points -= pointsToSub;
        String newText = String.valueOf(points) + "\nPunts";

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        String strDate = dateFormat.format(date);
        historial.updateHistory(strDate+" Has gastat " + String.valueOf(pointsToSub) + " punts",viewPager);
        nPoints.setText(newText);
        saveData();
    }

    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(HISTORIAL_STRING, (historial.getTextView(viewPager).getText()).toString());
        editor.putInt(POINTS_STRING, points);
        editor.apply();
    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        points = sharedPreferences.getInt(POINTS_STRING, 0);
        HISTORIAL = sharedPreferences.getString(HISTORIAL_STRING,"");
    }

    public void updateView(){
        //nPoints.setText(points);
        //historial.setTextView(HISTORIAL, viewPager);
    }
}