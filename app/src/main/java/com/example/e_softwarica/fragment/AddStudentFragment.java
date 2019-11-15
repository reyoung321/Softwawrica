package com.example.e_softwarica.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.e_softwarica.R;
import com.example.e_softwarica.models.LocalUser;

import java.util.ArrayList;
import java.util.List;

public class AddStudentFragment extends Fragment implements View.OnClickListener {

    private EditText etname, etage, etadddress;
    private RadioButton rbmale, rbfemale, rbothers;
    String gender;
    Button btnsave;
    static List<LocalUser> localUsers = new ArrayList<>();
    LocalUser localUser = new LocalUser();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_student, container, false);
        etname = view.findViewById(R.id.etname);
        etage = view.findViewById(R.id.etage);
        etadddress = view.findViewById(R.id.etaddress);
        rbmale = view.findViewById(R.id.rbmale);
        rbfemale = view.findViewById(R.id.rbfemale);
        rbothers = view.findViewById(R.id.rbothers);
        btnsave = view.findViewById(R.id.btnsave);


        btnsave.setOnClickListener(this);
        rbothers.setOnClickListener(this);
        rbmale.setOnClickListener(this);
        rbfemale.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rbmale:
                gender = "Male";
                break;
            case R.id.rbfemale:
                gender = "Female";
                break;

            case R.id.rbothers:
                gender = "Others";
                break;

            case R.id.btnsave:
                if (TextUtils.isEmpty(etname.getText().toString())) {
                    etname.setError("please enter name");
                } else if (TextUtils.isEmpty(etage.getText().toString())) {
                    etage.setError("please enter age");
                } else if (TextUtils.isEmpty(etadddress.getText().toString())) {
                    etadddress.setError("please enter address");
                } else {

                    localUser.setName(etname.getText().toString());
                    localUser.setAge(etage.getText().toString());
                    localUser.setAddress(etadddress.getText().toString());
                    localUser.setGender(gender);
                    localUsers.add(localUser);
                    localUser.setUserList(localUsers);
                    etname.setText("");
                    etage.setText("");
                    etadddress.setText("");
                    rbfemale.setSelected(false);
                    rbmale.setSelected(false);
                    rbothers.setSelected(false);
                    Toast.makeText(getActivity(), "User added!!!! " + localUsers.size(), Toast.LENGTH_SHORT).show();


                }
                break;
        }

    }
}
