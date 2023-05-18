package com.uniq_lab1.authentification;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Create_account_gender extends AppCompatActivity {
    protected String gender_value = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account_gender);
        Button next_btn = findViewById(R.id.next_button);

        TextView male = findViewById(R.id.male_txt_v);
        TextView female = findViewById(R.id.female_txt_v);
        TextView other = findViewById(R.id.other_txt_v);
        Intent birthday_intent = getIntent();

        male.setOnClickListener(view -> {
            male.setBackground(getDrawable(R.drawable.shape_green_bg_gender_on_select));
            female.setBackground(getDrawable(R.drawable.shape_for_create_account_edt));
            other.setBackground(getDrawable(R.drawable.shape_for_create_account_edt));
            gender_value = "Male";
        });
        female.setOnClickListener(view -> {
            female.setBackground(getDrawable(R.drawable.shape_green_bg_gender_on_select));
            male.setBackground(getDrawable(R.drawable.shape_for_create_account_edt));
            other.setBackground(getDrawable(R.drawable.shape_for_create_account_edt));
            gender_value = "Female";
        });
        other.setOnClickListener(view -> {
            other.setBackground(getDrawable(R.drawable.shape_green_bg_gender_on_select));
            male.setBackground(getDrawable(R.drawable.shape_for_create_account_edt));
            female.setBackground(getDrawable(R.drawable.shape_for_create_account_edt));
            gender_value = "Other";
        });




        Intent create_account_email_phone = new Intent(this,
                Create_account_email_phone.class);

        View.OnClickListener next_btn_listener = view -> {
            create_account_email_phone.putExtra("gender_value", gender_value);

            create_account_email_phone.putExtra("first_name",
                    birthday_intent.getStringExtra("first_name"));

            create_account_email_phone.putExtra("last_name",
                    birthday_intent.getStringExtra("last_name"));

            create_account_email_phone.putExtra("birthday_date",
                    birthday_intent.getStringExtra("birthday_date"));
            startActivity(create_account_email_phone);
        };
        next_btn.setOnClickListener(next_btn_listener);
    }
}