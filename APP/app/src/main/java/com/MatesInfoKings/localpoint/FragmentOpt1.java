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

public class FragmentOpt1 extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentOpt1() {
        // Required empty public constructor
    }

    public static FragmentOpt1 newInstance(String param1, String param2) {
        FragmentOpt1 fragment = new FragmentOpt1();
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
        View view = inflater.inflate(R.layout.fragment_opt1, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.rv_recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        BescanviarData[] bescanviarData = new BescanviarData[]{
                new BescanviarData("Bossa de Tela","Reutilitzable",R.drawable.bosa,"40"),
                new BescanviarData("Entrada Museu","Can Serra",R.drawable.museu,"50"),
                new BescanviarData("Sopar Comú","1r dll / mes",R.drawable.cena,"70"),
                new BescanviarData("T10","Abonament T.P",R.drawable.t10,"80"),
                new BescanviarData("Carrito","Carro Compra",R.drawable.carrito,"100"),
        };

        BescanviarAdapter bescanviarAdapter = new BescanviarAdapter(bescanviarData,(MainActivity)getActivity());
        recyclerView.setAdapter(bescanviarAdapter);

        return view;
    }
}