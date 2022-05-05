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
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * @author Keren Weintraub <kv5171@bs.amalnet.k12.il>
 * @version	1
 * @since  27/04/2022
 * The type Sort activity.
 */
public class SortActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ListView lv;
    Spinner options;
    ArrayAdapter<String> adp;

    String [] allOptions = {"choose option", "show just ids", "names by lastName order", "Employees by keyId order"};
    ArrayList<String> idsArray, namesArray, orderEmployeesArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort);

        options = (Spinner) findViewById(R.id.options);
        lv = (ListView) findViewById(R.id.lv);

        options.setOnItemSelectedListener(this);

        ArrayAdapter<String> adp = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, allOptions);
        options.setAdapter(adp);

        idsArray = new ArrayList<>();
        namesArray = new ArrayList<>();
        orderEmployeesArray = new ArrayList<>();

        getIds();
        getNames();
        getEmployees();
    }

    /**
     *  get all id employees from the fb
     */
    private void getIds()
    {
        idsArray.add("id");
        Query query = FBref.refEmployees.orderByKey();
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot data : dataSnapshot.getChildren())
                {
                    idsArray.add(data.getKey());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    /**
     *  get all names employees from fb
     */
    private void getNames()
    {
        namesArray.add("firstName lastName");
        Query query = FBref.refEmployees.orderByChild("lastName");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot data : dataSnapshot.getChildren())
                {
                    namesArray.add(data.child("firstName").getValue() + " " + data.child("lastName").getValue());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    /**
     *  get all the id employees from the fb sorted
     */
    private void getEmployees(){
        orderEmployeesArray.add("id | key | name | phone | company");
        Query query = FBref.refEmployees.orderByChild("keyId");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot data : dataSnapshot.getChildren())
                {
                    orderEmployeesArray.add(data.getKey() + " | " + data.child("keyId").getValue() + " | " + data.child("firstName").getValue() + " " + data.child("lastName").getValue() + " | " + data.child("phone").getValue() + " | " + data.child("company").getValue());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
        switch (pos) {
            case 0:
                lv.setVisibility(View.INVISIBLE);
                break;
            case 1:
                adp = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, idsArray);
                lv.setVisibility(View.VISIBLE);
                break;
            case 2:
                adp = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, namesArray);
                lv.setVisibility(View.VISIBLE);
                break;
            case 3:
                adp = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, orderEmployeesArray);
                lv.setVisibility(View.VISIBLE);
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
        else if (id == R.id.show)
        {
            Intent si = new Intent(this, ShowAllActivity.class);
            startActivity(si);
        }
        else if (id == R.id.home)
        {
            Intent si = new Intent(this, MainActivity.class);
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