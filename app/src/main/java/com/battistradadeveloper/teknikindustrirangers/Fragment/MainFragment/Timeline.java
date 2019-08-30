package com.battistradadeveloper.teknikindustrirangers.Fragment.MainFragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import com.battistradadeveloper.teknikindustrirangers.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Timeline extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_timeline, container, false);

        return view;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        WebView webView = view.findViewById(R.id.webView);
        webView.loadUrl("https://battistradadeveloper.com/");
    }

}
