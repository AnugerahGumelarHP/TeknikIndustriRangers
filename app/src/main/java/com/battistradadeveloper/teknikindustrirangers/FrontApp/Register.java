package com.battistradadeveloper.teknikindustrirangers.FrontApp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.battistradadeveloper.teknikindustrirangers.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    TextView txtEmail, txtPassword, txtRegister;
    EditText edtEmail, edtPassword;

    private ProgressDialog progressDialog ;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);

        txtEmail = findViewById(R.id.txt_register_email);
        txtPassword = findViewById(R.id.txt_register_password);
        txtRegister = findViewById(R.id.fitur_register_user);

        edtEmail = findViewById(R.id.edt_register_email);
        edtPassword = findViewById(R.id.edt_register_password);

        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEmail.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                if (TextUtils.isEmpty(email)){
                    //email is empty
                    Toast.makeText(Register.this,"Masukkan email anda",Toast.LENGTH_SHORT).show();
                    //stopping the function execution
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    //password is empty
                    Toast.makeText(Register.this,"Masukkan password anda",Toast.LENGTH_SHORT).show();
                    //stopping the function execution
                    return;
                }
                //if validation are ok
                //we will first show a progress bar
                progressDialog.setMessage("Registering user");
                progressDialog.show();

                mAuth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    //user is successfull registered and logged in
                                    //we will start the profile activity here
                                    Toast.makeText(Register.this,"Registered Successfully",Toast.LENGTH_SHORT).show();
                                    Intent success = new Intent(Register.this, Login.class);
                                    startActivity(success);
                                } else {
                                    Toast.makeText(Register.this,"Could not Registered",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}
