package com.battistradadeveloper.teknikindustrirangers.Fragment.MainFragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.battistradadeveloper.teknikindustrirangers.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Friend extends Fragment {
//    private FirebaseAuth mAuth;
//    ProgressDialog progressDialog;
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friends, container, false);

//        mAuth = FirebaseAuth.getInstance();
        return view;
    }

}
