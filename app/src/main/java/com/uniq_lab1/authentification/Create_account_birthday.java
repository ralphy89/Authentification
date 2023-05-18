package com.uniq_lab1.authentification;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Create_account_birthday extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account_birthday);
        Button next_btn = findViewById(R.id.next_button);
        birthday_edt = findViewById(R.id.birthday_edt);

        Intent create_account_gender = new Intent(this, Create_account_gender.class);
        Intent first_last_name_intent = getIntent();

        birthday_edt.setOnClickListener(view -> {
            showDatePickerDialog();
        });

        View.OnClickListener next_btn_listener = view -> {
            create_account_gender.putExtra("birthday_date", birthday_edt.getText().toString());

            create_account_gender.putExtra("first_name",
                    first_last_name_intent.getStringExtra("first_name"));

            create_account_gender.putExtra("last_name",
                    first_last_name_intent.getStringExtra("last_name"));

            startActivity(create_account_gender);
        };
        next_btn.setOnClickListener(next_btn_listener);
    }

    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Calendar selectedCalendar = Calendar.getInstance();
                        selectedCalendar.set(year, month, dayOfMonth);
                        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
                        String selectedDate = dateFormat.format(selectedCalendar.getTime());
                        birthday_edt.setText(selectedDate);
                    }
                }, year, month, dayOfMonth);

        datePickerDialog.show();
    }

    protected TextView birthday_edt;
}