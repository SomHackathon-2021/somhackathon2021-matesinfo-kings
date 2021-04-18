package com.MatesInfoKings.localpoint;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FragmentOpt3 extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentOpt3() {
        // Required empty public constructor
    }

    public static FragmentOpt3 newInstance(String param1, String param2) {
        FragmentOpt3 fragment = new FragmentOpt3();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_opt3, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.rv_recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        LocalsData[] localsData = new LocalsData[]{
                new LocalsData("Titol","Subtitol",R.drawable.botiga,"opcioA\nopcioB\nopcioC"),
                new LocalsData("Titol","Subtitol",R.drawable.botiga,"opcioA\nopcioB\nopcioC"),
                new LocalsData("Titol","Subtitol",R.drawable.botiga,"opcioA\nopcioB\nopcioC"),
                new LocalsData("Titol","Subtitol",R.drawable.botiga,"opcioA\nopcioB\nopcioC"),
                new LocalsData("Titol","Subtitol",R.drawable.botiga,"opcioA\nopcioB\nopcioC"),
                new LocalsData("Titol","Subtitol",R.drawable.botiga,"opcioA\nopcioB\nopcioC"),
                new LocalsData("Titol","Subtitol",R.drawable.botiga,"opcioA\nopcioB\nopcioC"),
        };

        LocalsAdapter localsAdapter = new LocalsAdapter(localsData,(MainActivity)getActivity());
        recyclerView.setAdapter(localsAdapter);

        return view;
    }
}