package com.example.ex123;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * @author Keren Weintraub <kv5171@bs.amalnet.k12.il>
 * @version	1
 * @since  27/04/2022
 * The type Show all activity.
 */
public class ShowAllActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner options;
    ListView lv;
    ArrayAdapter<String> adp;

    String [] allOptions = {"employees", "companies", "meals", "orders"};
    ArrayList<String> employeesArray, companiesArray, mealsArray, ordersArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all);

        options = (Spinner) findViewById(R.id.options);
        lv = (ListView) findViewById(R.id.lv);

        options.setOnItemSelectedListener(this);

        ArrayAdapter<String> adp = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, allOptions);
        options.setAdapter(adp);

        employeesArray = new ArrayList<>();
        companiesArray = new ArrayList<>();
        mealsArray = new ArrayList<>();
        ordersArray = new ArrayList<>();

        getEmployees();
        getCompanies();
        getMeals();
        getOrders();
    }

    /**
     * get all employees from fb
     */
    private void getEmployees()
    {
        employeesArray.add("id | key | name | phone | company");

        FBref.refEmployees.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot data : dataSnapshot.getChildren())
                {
                    employeesArray.add(data.getKey() + " | " + data.child("keyId").getValue() + " | " + data.child("firstName").getValue() + " " + data.child("lastName").getValue() + " | " + data.child("phone").getValue() + " | " + data.child("company").getValue());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    /**
     * get all companies from fb
     */
    private void getCompanies()
    {
        companiesArray.add("id | name | phone1 | phone2");

        FBref.refCompanies.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot data : dataSnapshot.getChildren())
                {
                    companiesArray.add(data.getKey() + " | " + data.child("name").getValue() + " | " + data.child("firstPhone").getValue() + " | " + data.child("secondPhone").getValue());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    /**
     * get all meals from fb
     */
    private void getMeals()
    {
        mealsArray.add("id | meal1 | meal2 | extra | dessert | drink");

        FBref.refMeals.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot data : dataSnapshot.getChildren())
                {
                    mealsArray.add(data.getKey() + " | " + data.child("firstMeal").getValue() + " | " + data.child("mainMeal").getValue() + " | " + data.child("extra").getValue() + " | " + data.child("dessert").getValue() + " | " + data.child("drink").getValue());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    /**
     * get all orders from fb
     */
    private void getOrders()
    {
        ordersArray.add("date | time | worker | mealId | company");

        FBref.refOrders.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot data : dataSnapshot.getChildren())
                {
                    ordersArray.add(data.getKey().replace("@", " | ") + " | " + data.child("employeeId").getValue() + " | " + data.child("mealId").getValue() + " | " + data.child("company").getValue());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
        switch (pos)
        {
            case 0:
                adp = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, employeesArray);
                break;
            case 1:
                adp = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, companiesArray);
                break;
            case 2:
                adp = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, mealsArray);
                break;
            case 3:
                adp = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, ordersArray);
                break;
        }
        lv.setAdapter(adp);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
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
        else if (id == R.id.home)
        {
            Intent si = new Intent(this, MainActivity.class);
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