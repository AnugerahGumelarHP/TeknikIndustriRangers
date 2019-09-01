package com.battistradadeveloper.teknikindustrirangers.Fragment.MainFragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.battistradadeveloper.teknikindustrirangers.EditProfile.EditProfile;
import com.battistradadeveloper.teknikindustrirangers.FrontApp.Login;
import com.battistradadeveloper.teknikindustrirangers.R;
import com.google.firebase.auth.FirebaseAuth;

/**
 * A simple {@link Fragment} subclass.
 */
public class Account extends Fragment {
    TextView txt_name, txt_jobs, txt_address;
    Button btn_edit, btn_lougout;
    FirebaseAuth mAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        return view;
    }

    // Method ini dipanggil sesaat setelah onCreateView().
    // Semua pembacaan view dan penambahan listener dilakukan disini (atau // bisa juga didalam onCreateView)
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();

        txt_name = view.findViewById(R.id.txt_profile_name);
        txt_jobs = view.findViewById(R.id.txt_profile_jobs);
        txt_address = view.findViewById(R.id.txt_profile_from);

        btn_edit = view.findViewById(R.id.btn_profile_edit);
        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent edit_profile = new Intent(getActivity(), EditProfile.class);
                startActivity(edit_profile);
                Toast.makeText(getActivity(),"Button edit clicked",Toast.LENGTH_SHORT).show();
            }
        });

        btn_lougout = view.findViewById(R.id.btn_logout_account);
        btn_lougout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Intent new_app = new Intent(getContext(), Login.class);
                startActivity(new_app);
                getActivity().finish();
            }
        });
    }

}
