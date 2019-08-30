package com.battistradadeveloper.teknikindustrirangers.FrontApp;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.battistradadeveloper.teknikindustrirangers.IntroRegister;
import com.battistradadeveloper.teknikindustrirangers.MainActivity;
import com.battistradadeveloper.teknikindustrirangers.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    TextView txtEmail, txtPassword, txtRecoverPassword, txtLoginUser, txtRegisterUser;
    EditText edtEmail, edtPassword;
    private FirebaseAuth mAuth;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressDialog = new ProgressDialog(Login.this);

        mAuth = FirebaseAuth.getInstance();
        //if user already login
        if(mAuth.getCurrentUser() != null){
            //Go to main activity
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }

        txtEmail = findViewById(R.id.txt_login_email);
        txtPassword = findViewById(R.id.txt_login_password);
        txtRecoverPassword = findViewById(R.id.txt_login_recover_password);

        edtEmail = findViewById(R.id.edt_login_email);
        edtPassword = findViewById(R.id.edt_login_password);

        txtLoginUser = findViewById(R.id.fitur_login_user);
        txtRegisterUser = findViewById(R.id.fitur_login_register);

        txtLoginUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEmail.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    //email is empty
                    Toast.makeText(Login.this,"Masukkan email anda",Toast.LENGTH_SHORT).show();
                    //stopping the function execution
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    //password is empty
                    Toast.makeText(Login.this,"Masukkan password anda",Toast.LENGTH_SHORT).show();
                    //stopping the function execution
                    return;
                }
                //if validation are ok
                //we will first show a progress bar
                progressDialog.setMessage("Login user");
                progressDialog.show();

                mAuth.signInWithEmailAndPassword(email,password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressDialog.dismiss();
                                if (task.isSuccessful()){
                                    //go to main activity
                                    finish();
                                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                }
                            }
                        });
            }
        });

        txtRecoverPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //AlertDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                builder.setTitle("Recover Password");

                //set layout linear layout
                LinearLayout linearLayout = new LinearLayout(Login.this);
                //views to set in dialog
                final EditText emailEt = new EditText(Login.this);
                emailEt.setHint("Email");
                emailEt.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
                /*sets the min width of a Editview to fit a text of n 'M' letters
                regardless of the actual text extension and text size*/
                emailEt.setMinEms(6);

                linearLayout.addView(emailEt);
                linearLayout.setPadding(10,10,10,10);

                builder.setView(linearLayout);

                //buttons recover
                builder.setPositiveButton("Recover", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //input email
                        String email = emailEt.getText().toString().trim();
                        beginRecovery(email);
                    }
                });

                //buttons cancel
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //dismiss dialog
                        dialog.dismiss();
                    }
                });

                //show dialog
                builder.create().show();
            }
        });

        txtRegisterUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent register = new Intent(Login.this, IntroRegister.class);
                startActivity(register);
            }
        });
    }

    private void beginRecovery(String email) {
        //show progress dialog
        progressDialog.setMessage("Sending email...");
        progressDialog.show();
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                progressDialog.dismiss();
                if(task.isSuccessful()){
                    Toast.makeText(Login.this, "Email Sent",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Login.this,"Failed", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
                //get and show proper error, message
                Toast.makeText(Login.this, ""+e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

}
