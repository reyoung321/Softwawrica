package com.example.e_softwarica.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.e_softwarica.R;
import com.example.e_softwarica.adapter.StudentAdapter;
import com.example.e_softwarica.models.LocalUser;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    List<LocalUser> localUserList=new ArrayList<>();
    LocalUser localUser=new LocalUser();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_home,container,false);
        recyclerView=view.findViewById(R.id.recycleview);
        localUserList=localUser.getUserList();

        StudentAdapter studentAdapter=new StudentAdapter(localUserList);
        recyclerView.setAdapter(studentAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }
}
