package com.example.termproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText username,email,password,confirmPassword;
    Button btnRegister;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        username = findViewById(R.id.inputPasswordLogin);
        email = findViewById(R.id.inputUsernameLogin);
        password= findViewById(R.id.inputPassword);
        confirmPassword= findViewById(R.id.inputConfirmPassword);
        btnRegister = findViewById(R.id.btnRegister);
        DB = new DBHelper(this);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String mail = email.getText().toString();
                String pass = password.getText().toString();
                String repass = confirmPassword.getText().toString();

                if (TextUtils .isEmpty(user) || TextUtils .isEmpty(pass) || TextUtils .isEmpty(repass)||TextUtils .isEmpty(mail) ){
                    Toast.makeText(RegisterActivity.this, "All fields are required",Toast.LENGTH_SHORT).show();
                }else{
                    if (pass.equals(repass)){
                        Boolean checkUser  = DB.checkUsername(user);
                        if (checkUser == false){
                            Boolean insert = DB.insertData(user, pass);
                            if (insert == true){
                                Toast.makeText(RegisterActivity.this, "Register Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(RegisterActivity.this,"Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(RegisterActivity.this,"User already exists", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(RegisterActivity.this,"Passwords are not mathcing", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        TextView txtAlreadyHaveAccount = findViewById(R.id.txtAlreadyHaveAccount);
        txtAlreadyHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}