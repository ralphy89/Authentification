package com.uniq_lab1.authentification;

import androidx.activity.result.ActivityResult;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Create_account_name extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account_name);
        EditText first_name_edt = findViewById(R.id.firstname_edt);
        EditText last_name_edt = findViewById(R.id.lastname_edt);
        Button next_btn = findViewById(R.id.next_button);

        Intent create_account_birthday = new Intent(this,
                Create_account_birthday.class);

        View.OnClickListener next_btn_listener = view -> {
            create_account_birthday.putExtra("first_name", first_name_edt.getText().toString());
            create_account_birthday.putExtra("last_name", last_name_edt.getText().toString());
            startActivity(create_account_birthday);
        };
        next_btn.setOnClickListener(next_btn_listener);
    }


}