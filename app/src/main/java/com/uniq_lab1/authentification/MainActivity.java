package com.uniq_lab1.authentification;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    protected TextView birthday_edt = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.authentification);

        Button create_account = findViewById(R.id.create_account_txt_v);
        Button login = findViewById(R.id.login_txt_v);
        View.OnClickListener createAccountListener = view -> {
            Intent create_account_name = new Intent(this, Create_account_name.class);
            startActivity(create_account_name);
        };
        create_account.setOnClickListener(createAccountListener);





//        TextView male = findViewById(R.id.male_txt_v);


    }




}