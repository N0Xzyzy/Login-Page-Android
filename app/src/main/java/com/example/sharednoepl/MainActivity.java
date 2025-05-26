package com.example.sharednoepl;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText Username, Password;
    Button loginBtn;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "myPref";
    private static final String KEY_NAME = "name";
    private static final String KEY_PASS = "pass";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Username = findViewById(R.id.Usn);
        Password = findViewById(R.id.Pw);
        loginBtn = findViewById(R.id.loginBtn);
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        String name = sharedPreferences.getString(KEY_NAME, null);
        String sandi = sharedPreferences.getString(KEY_PASS, null);
        if (name != null && sandi != null){
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
        }

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_NAME,Username.getText().toString());
                editor.putString(KEY_PASS,Password.getText().toString());
                editor.apply();

                Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();

            }
        });

    }
}