package com.example.sharednoepl;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {
    TextView namaUsr, sandi;
    Button btn_Logout;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "myPref";
    private static final String KEY_NAME = "name";
    private static final String KEY_PASS = "pass";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        namaUsr = findViewById(R.id.namaUser);
        sandi = findViewById(R.id.sandi);
        btn_Logout = findViewById(R.id.btnLogout);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String nama = sharedPreferences.getString(KEY_NAME, null);
        String pw = sharedPreferences.getString(KEY_PASS, null);

        if (nama != null && pw != null){
            namaUsr.setText("Halo -"+nama);
            sandi.setText("Pw -"+pw);
        }

        btn_Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                Toast.makeText(HomeActivity.this, "LogOut Berhasil", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}