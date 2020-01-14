package com.example.company1;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class Fragment1 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_first,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ImageButton head=getActivity().findViewById(R.id.head);
        DrawerLayout drawerLayout=getActivity().findViewById(R.id.draw_layout);
        FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
        Navi navi= (Navi)fragmentManager.findFragmentById(R.id.first_fragment);
        head.setOnClickListener(v->{drawerLayout.openDrawer(Gravity.LEFT);});
    }
}
