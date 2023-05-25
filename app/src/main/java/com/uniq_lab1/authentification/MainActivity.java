package com.uniq_lab1.authentification;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    protected TextView birthday_edt = null;
    private Spinner languageSpinner;
    private String[] languages = {"English", "French"};
    private Intent navigation_intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.authentification);

        EditText email_username = findViewById(R.id.email_username_edt);
        TextView login_error = findViewById(R.id.login_error);
        EditText password_edt2 = findViewById(R.id.password_edt2);

        // Find the Spinner view in the layout
        languageSpinner = findViewById(R.id.lang_text_v);
        // Create an ArrayAdapter with the language data
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, languages);
        // Set the dropdown layout resource for the adapter
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Set the adapter on the Spinner
        languageSpinner.setAdapter(adapter);
        // Set the item selection listener on the Spinner
        languageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Retrieve the selected language from the languages array
                String selectedLanguage = languages[position];

                // Display a Toast message with the selected language
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                String selectedLanguage = "English";            }
        });

        Button create_account = findViewById(R.id.create_account_txt_v);
        Button login = findViewById(R.id.login_txt_v);
        View.OnClickListener createAccountListener = view -> {
            Intent create_account_name = new Intent(this, Create_account_name.class);
            startActivity(create_account_name);
        };
        create_account.setOnClickListener(createAccountListener);

        login.setOnClickListener(view -> {
            navigation_intent = new Intent(this, MainNavigation.class);
            startActivity(navigation_intent);

//            login_error.setVisibility(View.VISIBLE);
//            Snackbar snackbar = Snackbar.make(email_username,(login_error.getText().toString()) , Snackbar.LENGTH_LONG);
//            snackbar.setBackgroundTint(Color.RED);
//            snackbar.show();
//            email_username.setBackground(AppCompatResources.getDrawable(this, R.drawable.errox_box_login));
//            password_edt2.setBackground(AppCompatResources.getDrawable(this, R.drawable.errox_box_login));
        });


//        TextView male = findViewById(R.id.male_txt_v);

    }
}