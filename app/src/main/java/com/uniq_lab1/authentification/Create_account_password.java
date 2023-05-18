package com.uniq_lab1.authentification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Create_account_password extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account_password);
        Button next_btn = findViewById(R.id.next_button);
        EditText password_edt_1 = findViewById(R.id.password_edt);
        EditText password_edt_2 = findViewById(R.id.password2_edt);
        Intent after_create_account_activity = new Intent(this,
                After_create_account_activity.class);

        Intent final_intent = getIntent();



        View.OnClickListener next_btn_listener = view -> {

            String password = password_edt_1.getText().toString();
            String password2 = password_edt_2.getText().toString();
            int size1 = password.length();
            int size2 = password2.length();
            if(size1 >= 8 && size1 == size2)
            {
                if(password.equals(password2))
                {
//                    Drawable bg_btn = next_btn.getBackground();
//                    GradientDrawable draw_bg_btn = (GradientDrawable) bg_btn;
//                    draw_bg_btn.setColor(ContextCompat.getColor(this, R.color.bg_gender_select));
//                    next_btn.setText("Submitted successfully!!");

                    after_create_account_activity.putExtra("mobile_number",
                            final_intent.getStringExtra("mobile_number"));

                    after_create_account_activity.putExtra("email",
                            final_intent.getStringExtra("email"));

                    after_create_account_activity.putExtra("gender_value",
                            final_intent.getStringExtra("gender_value"));

                    after_create_account_activity.putExtra("first_name",
                            final_intent.getStringExtra("first_name"));

                    after_create_account_activity.putExtra("last_name",
                            final_intent.getStringExtra("last_name"));

                    after_create_account_activity.putExtra("birthday_date",
                            final_intent.getStringExtra("birthday_date"));

                }
            }
            else
            {

            }
        };
        next_btn.setOnClickListener(next_btn_listener);
    }
}
