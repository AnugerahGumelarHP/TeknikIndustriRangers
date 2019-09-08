package com.battistradadeveloper.teknikindustrirangers.EditProfile;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.battistradadeveloper.teknikindustrirangers.Fragment.MainFragment.Account;
import com.battistradadeveloper.teknikindustrirangers.Model.User;
import com.battistradadeveloper.teknikindustrirangers.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class EditProfile extends AppCompatActivity {
    FirebaseAuth mAuth;
    FirebaseFirestore firebaseFirestore;

    Button btn_cancel, btn_save;
    TextView txt_info;
    TextView txt_name;
    TextView txt_address;
    TextView txt_status;
    TextView txt_company;
    TextView txt_company_address;
    EditText edt_name;
    EditText edt_address;
    EditText edt_company;
    EditText edt_company_address;
    RadioButton rad_mahasiswa, rad_bekerja;

    Map<String, Object> userMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        mAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

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
        btn_cancel.setOnClickListener(v -> {
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
        });

        btn_save = findViewById(R.id.btn_editprofile_save);
        btn_save.setOnClickListener((view) -> {
            Toast.makeText(getApplicationContext(), "Save data to firestore", Toast.LENGTH_SHORT).show();
            String companyAddress = edt_company_address.getText().toString();
            String name = edt_name.getText().toString();
            String address = edt_address.getText().toString();
            String status = "";
            if(rad_mahasiswa.isChecked()){
                status = "mahasiswa";
            }else {
                status = "alumni";
            }
            String company = edt_company.getText().toString();
            User user = new User();
            user.setName(name);
            user.setAddress(address);
            user.setStatus(status);
            user.setCompany(company);
            user.setCompany_address(companyAddress);
            setDataToMap(user);
            saveToFirestore();
        });
    }

    private void setDataToMap(User user) {
        userMap.put("name", user.getName());
        userMap.put("address", user.getAddress());
        userMap.put("status", user.getStatus());
        userMap.put("company", user.getCompany());
        userMap.put("company_address", user.getCompany_address());
    }

//	Long TIME_OUT = 1000L;

    private void saveToFirestore() {
        final Task<DocumentReference> usersReferenceTask = firebaseFirestore.collection("Users")
                .add(userMap);

        usersReferenceTask.addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(EditProfile.this, "Horeee...", Toast.LENGTH_SHORT).show();
            }
        });

        usersReferenceTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(EditProfile.this, "Agum noob", Toast.LENGTH_SHORT).show();
            }
        });

        usersReferenceTask.addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                Toast.makeText(EditProfile.this, "Completed...", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
