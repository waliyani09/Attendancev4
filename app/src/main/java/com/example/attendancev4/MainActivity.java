package com.example.attendancev4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    public EditText user;
    public EditText pass;
    public Button login;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFirebaseAuth = FirebaseAuth.getInstance();
        user = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        login = findViewById(R.id.button);
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFireBaseUser = mFirebaseAuth.getCurrentUser();
                if(mFireBaseUser!=null){
                    Toast.makeText(MainActivity.this,"Login Successful!",Toast.LENGTH_SHORT).show();
                    Intent i= new Intent(MainActivity.this,Homescreen.class);
                    startActivity(i);
                }
                else{
                 Toast.makeText(MainActivity.this,"Please enter valid credentials...", Toast.LENGTH_SHORT).show();
                }
            }
        };
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = user.getText().toString();
                String password = pass.getText().toString();
                if(username.isEmpty()){
                    user.setError("Please enter valid email");
                    user.requestFocus();
                }
                else if(password.isEmpty()){
                    pass.setError("Please enter valid password");
                    pass.requestFocus();
                }
                else if(username.isEmpty() && password.isEmpty()){
                    Toast.makeText(MainActivity.this,"Please enter valid credentaials.",Toast.LENGTH_SHORT).show();
                }
                else if(!(username.isEmpty() && password.isEmpty())){
                    mFirebaseAuth.signInWithEmailAndPassword(username,password).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                       if(task.isSuccessful()){
                           Intent homescreen = new Intent(MainActivity.this,Homescreen.class);
                           startActivity(homescreen);
                       }
                        }
                    });
                }
            }
        });

    }
}
