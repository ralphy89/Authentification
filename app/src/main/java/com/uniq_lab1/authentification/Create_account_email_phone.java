package com.uniq_lab1.authentification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Create_account_email_phone extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account_email);
        Button next_btn = findViewById(R.id.next_button);

        EditText phone_edt = findViewById(R.id.phone_edt);
        TextView phone_number_txt = findViewById(R.id.whats_your_phone);
        Button sign_with_phone_btn = findViewById(R.id.sign_with_phone_btn);

        EditText email_edt = findViewById(R.id.email_edt);
        TextView email_txt = findViewById(R.id.whats_your_email);
        Button sign_with_email_btn = findViewById(R.id.sign_with_email_btn);

        Intent gender_intent = getIntent();
        Intent create_account_password = new Intent(this,
                Create_account_password.class);

        sign_with_email_btn.setOnClickListener(view -> {
            phone_edt.setVisibility(View.INVISIBLE);
            phone_number_txt.setVisibility(View.INVISIBLE);
            sign_with_email_btn.setVisibility(View.INVISIBLE);

            email_edt.setVisibility(View.VISIBLE);
            email_txt.setVisibility(View.VISIBLE);
            sign_with_phone_btn.setVisibility(View.VISIBLE);
        });

        sign_with_phone_btn.setOnClickListener(view -> {
            email_edt.setVisibility(View.INVISIBLE);
            email_txt.setVisibility(View.INVISIBLE);
            sign_with_phone_btn.setVisibility(View.INVISIBLE);

            phone_edt.setVisibility(View.VISIBLE);
            phone_number_txt.setVisibility(View.VISIBLE);
            sign_with_email_btn.setVisibility(View.VISIBLE);
        });


        View.OnClickListener next_btn_listener = view -> {
            create_account_password.putExtra("mobile_number", phone_edt.getText().toString());
            create_account_password.putExtra("email", email_edt.getText().toString());

            create_account_password.putExtra("gender_value",
                    gender_intent.getStringExtra("gender_value"));

            create_account_password.putExtra("first_name",
                    gender_intent.getStringExtra("first_name"));

            create_account_password.putExtra("last_name",
                    gender_intent.getStringExtra("last_name"));

            create_account_password.putExtra("birthday_date",
                    gender_intent.getStringExtra("birthday_date"));

            startActivity(create_account_password);
        };
        next_btn.setOnClickListener(next_btn_listener);
    }
}