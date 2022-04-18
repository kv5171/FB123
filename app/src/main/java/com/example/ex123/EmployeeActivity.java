package com.example.ex123;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * @author Keren Weintraub <kv5171@bs.amalnet.k12.il>
 * @version	1
 * @since  17/02/2022
 * The type Employee activity.
 */
public class EmployeeActivity extends AppCompatActivity {
    EditText lastName, firstName, company, id, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

        lastName = (EditText) findViewById(R.id.lastName);
        firstName = (EditText) findViewById(R.id.firstName);
        company = (EditText) findViewById(R.id.company);
        id = (EditText) findViewById(R.id.id);
        phone = (EditText) findViewById(R.id.phone);

        // all the numeric fields accepts just numbers
        id.setTransformationMethod(null);
        phone.setTransformationMethod(null);
    }

    /**
     * Add employee to db.
     *
     * @param view the view
     */
    public void addEmployee(View view) {
        String lastNameString = lastName.getText().toString();
        String firstNameString = firstName.getText().toString();
        String companyString = company.getText().toString();
        String idString = id.getText().toString();
        String phoneString = phone.getText().toString();

        // all parameters != null ""
        if (lastNameString.equals("") || firstNameString.equals("") || companyString.equals("") || idString.equals("") || phoneString.equals(""))
        {
            Toast.makeText(EmployeeActivity.this, "Inputs must have a value!", Toast.LENGTH_SHORT).show();
        }
        else if(!goodId(idString)) { // not good id
            Toast.makeText(EmployeeActivity.this, "Wrong employee ID syntax", Toast.LENGTH_SHORT).show();
        }
        else
        {
            FBref.refEmployees.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dS) {
                    boolean dataNotInDB = true;
                    for (DataSnapshot data : dS.getChildren())
                    {
                        if ((data.child("phone").getValue().equals(phoneString)) || (data.getKey().equals(idString)))
                        {
                            dataNotInDB = false;
                            break;
                        }
                    }

                    if (dataNotInDB)
                    {
                        FBref.refCounters.child("employeeKeyID").addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                Long keyID = (Long) dataSnapshot.getValue();

                                // update the employeeKeyID (for next usage)
                                FBref.refCounters.child("employeeKeyID").setValue(keyID + 1);

                                Employee employee = new Employee(Math.toIntExact(keyID), lastNameString, firstNameString, companyString, idString, phoneString);
                                FBref.refEmployees.child(idString).setValue(employee);
                                Toast.makeText(EmployeeActivity.this, "Add Employee completed", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                    }
                    else
                        Toast.makeText(EmployeeActivity.this, "Data is in the db already!", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    }

    /**
     * Check if the ID is correct
     *
     * @param id the String employee id to check
     * @return true if id is correct, else false
     */
    private boolean goodId(String id)
    {
        int sumIdNumbers = 0;
        int currDigit = 0;

        if (id.equals("") || (id.length() > 9))
            return false;
        else{
            char[] tzNumbers = (String.format("%09d", Integer.parseInt(id))).toCharArray();

            for (int i = 0; i < 9; i++)
            {
                currDigit = Character.getNumericValue(tzNumbers[i]);
                currDigit *= (i % 2) + 1;

                if (currDigit > 9)
                    currDigit -= 9;

                sumIdNumbers += currDigit;
            }

            return (sumIdNumbers % 10 == 0);
        }
    }


    /**
     * Create the options menu
     *
     * @param menu the menu
     * @return true if success
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * Go where clicked
     *
     * @param item the item in menu that was clicked
     *  @return true if success
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.credits)
        {
            Intent si = new Intent(this, CreditsActivity.class);
            startActivity(si);
        }
        else if (id == R.id.company)
        {
            Intent si = new Intent(this, CompanyActivity.class);
            startActivity(si);
        }
        else if (id == R.id.home)
        {
            Intent si = new Intent(this, MainActivity.class);
            startActivity(si);
        }
        else if (id == R.id.order)
        {
            Intent si = new Intent(this, OrderActivity.class);
            startActivity(si);
        }
        else if (id == R.id.show)
        {
            Intent si = new Intent(this, ShowAllActivity.class);
            startActivity(si);
        }
        else if (id == R.id.sort)
        {
            Intent si = new Intent(this, SortActivity.class);
            startActivity(si);
        }
        else if (id == R.id.change)
        {
            Intent si = new Intent(this, ChangePhoneActivity.class);
            startActivity(si);
        }

        return true;
    }
}