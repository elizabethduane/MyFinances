package com.elizabethduane.myfinances;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        //get the current date
        final Calendar c = Calendar.getInstance();

        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH)+1;
        int day = c.get(Calendar.DAY_OF_MONTH);

        String date = Integer.toString(day) + "/" + Integer.toString(month) + "/" +Integer.toString(year);

        TextView tv_date = (TextView)findViewById(R.id.textView_date);
        tv_date.setText(date);


        setupSpinner();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_save) {

            Toast.makeText(getApplicationContext(),"Saved", Toast.LENGTH_SHORT).show();

            EditActivity.this.finish();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");

    }


    private void setupSpinner() {
        // Create adapter for spinner. The list options are from the String array it will use
        // the spinner will use the default layout

        Spinner categorySpinner = findViewById(R.id.spinner_category);
        Spinner accountSpinner = findViewById(R.id.spinner_account);

        ArrayList<String> category = new ArrayList<>();
        ArrayList<String> account = new ArrayList<>();

        category.add("Investimento");
        category.add("Lazer");
        category.add("Gastos em Geral");

        account.add("BB");
        account.add("Inter");
        account.add("Easy");

        ArrayAdapter<String> categorySpinnerAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, category);

        ArrayAdapter<String> accountSpinnerAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, account);

        // Specify dropdown layout style - simple list view with 1 item per line
        categorySpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        accountSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // Apply the adapter to the spinner
        categorySpinner.setAdapter(categorySpinnerAdapter);

        accountSpinner.setAdapter(accountSpinnerAdapter);


        /*
        // Set the integer mSelected to the constant values
        mGenderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(getString(R.string.gender_male))) {
                        mGender = PetEntry.MALE; // Male
                    } else if (selection.equals(getString(R.string.gender_female))) {
                        mGender = PetEntry.FEMALE; // Female
                    } else {
                        mGender = PetEntry.UNKNOW; // Unknown
                    }
                }
            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mGender = 0; // Unknown
            }
        });*/
    }
}
