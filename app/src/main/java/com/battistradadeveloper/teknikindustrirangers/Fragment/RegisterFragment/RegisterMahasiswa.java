package com.battistradadeveloper.teknikindustrirangers.Fragment.RegisterFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.battistradadeveloper.teknikindustrirangers.FrontApp.Register;
import com.battistradadeveloper.teknikindustrirangers.R;

public class RegisterMahasiswa extends Fragment {
	Button btnRegister;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		setHasOptionsMenu(true);
		return inflater.inflate(R.layout.fragment_register_mahasiswa, container, false);
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		inflater.inflate(R.menu.menu_status, menu);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		btnRegister = view.findViewById(R.id.btn_register_mahasiswa);
		btnRegister.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent register = new Intent(getActivity(), Register.class);
				startActivity(register);
			}
		});
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.action_status) {
			Toast.makeText(getActivity(), "Clicked on " + item.getTitle(), Toast.LENGTH_SHORT)
					.show();
		}
		return true;
	}
}
