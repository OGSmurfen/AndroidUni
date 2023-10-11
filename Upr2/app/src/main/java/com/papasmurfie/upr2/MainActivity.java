package com.papasmurfie.upr2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView nameAlert = findViewById(R.id.nameTextAlert);
        TextView mailAlert = findViewById(R.id.emailAlert);
        TextView phoneAlert = findViewById(R.id.phoneAlert);
        TextView dobAlert = findViewById(R.id.DOBalert);
        TextView heightAlert = findViewById(R.id.heightAlert);
        nameAlert.setVisibility(View.INVISIBLE);
        mailAlert.setVisibility(View.INVISIBLE);
        phoneAlert.setVisibility(View.INVISIBLE);
        dobAlert.setVisibility(View.INVISIBLE);
        heightAlert.setVisibility(View.INVISIBLE);

        Button submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameAlert.setVisibility(View.INVISIBLE);
                mailAlert.setVisibility(View.INVISIBLE);
                phoneAlert.setVisibility(View.INVISIBLE);
                dobAlert.setVisibility(View.INVISIBLE);
                heightAlert.setVisibility(View.INVISIBLE);

                EditText nameText = findViewById(R.id.nameText);
               // String name = nameText.getText().toString();
                EditText emailText = findViewById(R.id.emailText);
               // String email = emailText.getText().toString();
                EditText phoneText = findViewById(R.id.phoneText);
                EditText dobText = findViewById(R.id.DOBtext);
                EditText heightText = findViewById(R.id.heightText);

                if(!checkName(nameText.getText().toString()))
                {
                    nameText.setError(getText(R.string.nameAlert));
                    nameAlert.setVisibility(View.VISIBLE);
                    nameAlert.setText(getText(R.string.nameAlert));
                    nameAlert.setTextColor(getResources().getColor(R.color.red));
                }

                if(!checkEmail(emailText.getText().toString()))
                {
                    emailText.setError(getText(R.string.mailAlert));
                    mailAlert.setVisibility(View.VISIBLE);

                }
                if(!checkPhone(phoneText.getText().toString()))
                {
                    phoneText.setError(getText(R.string.phoneAlert));
                    phoneAlert.setVisibility(View.VISIBLE);
                }
                if(!checkDOB(dobText.getText().toString()))
                {
                    dobText.setError(getText(R.string.DOBalert));
                    dobAlert.setVisibility(View.VISIBLE);
                }
                if (!TextUtils.isEmpty(heightText.getText().toString())) {
                    double height = Double.parseDouble(heightText.getText().toString());
                    if (!checkHeight(height)) {
                        heightText.setError(getText(R.string.eightAlert));
                        heightAlert.setVisibility(View.VISIBLE);
                    }
                } else {
                    // Handle the case where the field is empty, e.g., display an error message or take appropriate action
                    heightText.setError(getText(R.string.eightAlert));
                    heightAlert.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private boolean checkHeight(double height) {
        // Define the range for valid heights (0.5 to 3.0 meters)
        double minHeight = 0.5;
        double maxHeight = 3.0;

        // Check if the height is within the specified range
        return (height >= minHeight) && (height <= maxHeight);
    }

    private boolean checkDOB(String dob) {
        // Define the regex pattern for a valid date of birth in DD/MM/YYYY format
        String regex = "^(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/(19\\d{2}|20\\d{2})$";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(regex);

        // Create a Matcher object
        Matcher matcher = pattern.matcher(dob);

        // Check if the DOB matches the pattern
        if (!matcher.matches()) {
            return false; // Invalid date format
        }

        // Parse the DOB into a Date object
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dobDate;
        try {
            dobDate = sdf.parse(dob);
        } catch (ParseException e) {
            return false; // Invalid date format
        }

        // Calculate the current date
        Date currentDate = new Date();

        // Calculate a date 150 years ago from the current date
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.YEAR, -150);
        Date minDate = calendar.getTime();

        // Check if the DOB is within the specified range
        return dobDate.before(currentDate) && dobDate.after(minDate);
    }

    private boolean checkPhone(String phone) {
        // Define the regex pattern for a valid phone number
        String regex = "^08\\d{8}$";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(regex);

        // Create a Matcher object
        Matcher matcher = pattern.matcher(phone);

        // Check if the phone number matches the pattern
        return matcher.matches();
    }

    private boolean checkEmail(String mail) {
        // Define the regex pattern for a valid email address
        String regex = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(regex);

        // Create a Matcher object
        Matcher matcher = pattern.matcher(mail);

        // Check if the email matches the pattern
        return matcher.matches();
    }

    private boolean checkName(String name) {
        if(name.length() == 0 || name.length() < 5){
            return false;
        }
        if(name.length() == 5 && name.charAt(3) != ' '){
            return false;
        }
        return true;
    }
}