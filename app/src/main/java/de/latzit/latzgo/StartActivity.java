package de.latzit.latzgo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        // Login-Button
        final Button button = findViewById(R.id.weiterBtn);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText name = findViewById(R.id.nameEditText);
                EditText pass = findViewById(R.id.passEditText);
                if(name.getText().toString().equals("") && pass.getText().toString().equals("")) {
                    Toast.makeText(getBaseContext(), "Anmeldung erfolgreich...",
                            Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(StartActivity.this, MainActivity.class));
                }
                else {
                    Animation shake = AnimationUtils.loadAnimation(StartActivity.this, R.anim.shake);
                    name.startAnimation(shake);
                    pass.startAnimation(shake);
                    name.requestFocus();
                    Toast.makeText(getBaseContext(), "Falsche Anmeldedaten...",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
