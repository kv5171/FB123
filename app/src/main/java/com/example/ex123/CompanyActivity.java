package com.example.ex123;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
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

/**
 * @author Keren Weintraub <kv5171@bs.amalnet.k12.il>
 * @version	1
 * @since  27/04/2022
 * The type Company activity.
 */
public class CompanyActivity extends AppCompatActivity {
    EditText companyNumber, companyName, firstPhone, secondPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);

        companyNumber = (EditText) findViewById(R.id.companyNumber);
        companyName = (EditText) findViewById(R.id.companyName);
        firstPhone = (EditText) findViewById(R.id.firstPhone);
        secondPhone = (EditText) findViewById(R.id.secondPhone);

        // all the numeric fields accepts just numbers
        companyNumber.setTransformationMethod(null);
        firstPhone.setTransformationMethod(null);
        secondPhone.setTransformationMethod(null);
    }

    /**
     * Add company to fb.
     *
     * @param view the view
     */
    public void addCompany(View view) {
        String companyNumberString = companyNumber.getText().toString();
        String companyNameString = companyName.getText().toString();
        String firstPhoneString = firstPhone.getText().toString();
        String secondPhoneString = secondPhone.getText().toString();

        // all parameters != null ""
        if (companyNumberString.equals("") || companyNameString.equals("") || firstPhoneString.equals("") || secondPhoneString.equals(""))
        {
            Toast.makeText(CompanyActivity.this, "Inputs must have a value!", Toast.LENGTH_SHORT).show();
        }
        else {
            FBref.refCompanies.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dS) {
                    boolean dataNotInDB = true;
                    for (DataSnapshot data : dS.getChildren()) {
                        if ((data.child("name").getValue().equals(companyNameString)) || (String.valueOf(data.child("companyNumber").getValue()).equals(companyNumberString)) || (data.child("firstPhone").getValue().equals(firstPhoneString)) || (data.child("secondPhone").getValue().equals(secondPhoneString))) {
                            dataNotInDB = false;
                            break;
                        }
                    }

                    if (dataNotInDB) {
                        Company company = new Company(Integer.parseInt(companyNumberString), companyNameString, firstPhoneString, secondPhoneString);
                        FBref.refCompanies.child(companyNumberString).setValue(company);
                        Toast.makeText(CompanyActivity.this, "Add company completed", Toast.LENGTH_SHORT).show();
                    } else
                        Toast.makeText(CompanyActivity.this, "Data is in the db already!", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
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
        else if (id == R.id.home)
        {
            Intent si = new Intent(this, MainActivity.class);
            startActivity(si);
        }
        else if (id == R.id.employee)
        {
            Intent si = new Intent(this, EmployeeActivity.class);
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