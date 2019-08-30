package com.battistradadeveloper.teknikindustrirangers.EditProfile;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.battistradadeveloper.teknikindustrirangers.Fragment.MainFragment.Account;
import com.battistradadeveloper.teknikindustrirangers.R;

public class EditProfile extends AppCompatActivity {
	Button btn_cancel, btn_save;
	TextView txt_info, txt_name, txt_address,
			txt_status, txt_company, txt_company_address;
	EditText edt_name, edt_address,
			edt_company, edt_company_address;
	RadioButton rad_mahasiswa, rad_bekerja;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_profile);

		// Memanggil seluruh field pada TextView
		txt_info = findViewById(R.id.txt_edtprofile_info);
		txt_name = findViewById(R.id.txt_edtprofile_name);
		txt_address = findViewById(R.id.txt_edtprofile_address);
		txt_status = findViewById(R.id.txt_edtprofile_work);
		txt_company = findViewById(R.id.txt_edtprofile_company);
		txt_company_address = findViewById(R.id.txt_edtprofile_companyaddress);

		// Memanggil seluruh field pada EditText
		edt_name = findViewById(R.id.edt_editprofile_name);
		edt_address = findViewById(R.id.edt_editprofile_address);
		edt_company = findViewById(R.id.edt_editprofile_company);
		edt_company_address = findViewById(R.id.edt_editprofile_companyaddress);

		// Memanggil seluruh field pada Radio Button
		rad_mahasiswa = findViewById(R.id.radiomahasiswa);
		rad_bekerja = findViewById(R.id.radiopekerjaan);

		//Memanggil seluruh field pada button
		btn_cancel = findViewById(R.id.btn_editprofile_cancel);
		btn_cancel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(EditProfile.this);
				builder.setMessage("Apakah anda yakin ingin keluar, tanpa menyimpan data?")
						.setCancelable(false)
						.setPositiveButton("Yakin", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								Intent cancel = new Intent(EditProfile.this, Account.class);
								startActivity(cancel);
							}
						})
						.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dialog.cancel();
							}
						});
				AlertDialog alert = builder.create();
				alert.show();
			}
		});
		btn_save =findViewById(R.id.btn_editprofile_save);
		btn_save.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "Button Save clicked", Toast.LENGTH_SHORT).show();
			}
		});
	}
}
