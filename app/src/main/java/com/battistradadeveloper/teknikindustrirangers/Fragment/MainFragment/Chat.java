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
public class Chat extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        return view;
    }

}
