package com.battistradadeveloper.teknikindustrirangers.Fragment.MainFragment;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.battistradadeveloper.teknikindustrirangers.FrontApp.Login;
import com.battistradadeveloper.teknikindustrirangers.MainActivity;
import com.battistradadeveloper.teknikindustrirangers.R;
import com.google.firebase.auth.FirebaseAuth;

/**
 * A simple {@link Fragment} subclass.
 */
public class Friend extends Fragment {
    private FirebaseAuth mAuth;
    ProgressDialog progressDialog;
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friends, container, false);

        mAuth = FirebaseAuth.getInstance();
        return view;
    }

}
