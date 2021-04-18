package com.MatesInfoKings.localpoint;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentOpt2 extends Fragment {
    public FragmentOpt2() {
        // Required empty public constructor
    }

    public static FragmentOpt2 newInstance(String param1, String param2) {
        FragmentOpt2 fragment = new FragmentOpt2();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_opt2, container, false);

        return view;
    }

    public void updateHistory(String s2, View view){
        TextView textView = view.findViewById(R.id.tv_history);
        String s1 = (String)textView.getText();
        textView.setText(s2+"\n"+s1);
    }

    public TextView getTextView(View view){
        TextView textView = view.findViewById(R.id.tv_history);
        return textView;
    }

    public void setTextView(String s, View view){
        TextView textView = view.findViewById(R.id.tv_history);
        textView.setText(s);
    }
}