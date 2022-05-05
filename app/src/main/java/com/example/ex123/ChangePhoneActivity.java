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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Keren Weintraub <kv5171@bs.amalnet.k12.il>
 * @version	1
 * @since  27/04/2022
 * The type Change phone activity.
 */
public class ChangePhoneActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText phone;
    Spinner options;
    Button btn;

    String employeeId;
    ArrayList<String> phones; // <id,phone>, <id,phone>
    ArrayList<String> ids;
    ArrayAdapter<String> adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_phone);

        options = (Spinner) findViewById(R.id.options);
        phone = (EditText) findViewById(R.id.phone);
        btn = (Button) findViewById(R.id.btn);

        options.setOnItemSelectedListener(this);

        ids = new ArrayList<>();
        phones = new ArrayList<>();

        ids.add("Your Id");
        getIds();

        adp = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, ids);
        options.setAdapter(adp);

        phone.setTransformationMethod(null);
    }

    /**
     * get all employees id from fb
     */
    private void getIds()
    {
        FBref.refEmployees.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dS) {
                for (DataSnapshot data : dS.getChildren())
                {
                    phones.add((String) data.child("phone").getValue());
                    ids.add(data.getKey());
                }

                adp.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    /**
     * Apply the phone in fb
     *
     * @param view the view
     */
    public void apply(View view) {
        String phoneString = phone.getText().toString();

        if (phoneString.equals(""))
        {
            Toast.makeText(this, "Phone cant be null", Toast.LENGTH_SHORT).show();
        }
        else if (phones.get(ids.indexOf(employeeId) - 1).equals(phoneString))
        {
            Toast.makeText(this, "This is the same phone", Toast.LENGTH_SHORT).show();
        }
        else {
            FBref.refEmployees.child(employeeId + "/phone").setValue(phoneString);
            Toast.makeText(this, "Phone has changed!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
        if (pos == 0)
        {
            phone.setVisibility(View.INVISIBLE);
            btn.setVisibility(View.INVISIBLE);
        }
        else
        {
            phone.setVisibility(View.VISIBLE);
            btn.setVisibility(View.VISIBLE);

            employeeId = (String) adapterView.getAdapter().getItem(pos);
            phone.setText(phones.get(ids.indexOf(employeeId) - 1));
        }
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
        else if (id == R.id.sort)
        {
            Intent si = new Intent(this, SortActivity.class);
            startActivity(si);
        }
        else if (id == R.id.home)
        {
            Intent si = new Intent(this, MainActivity.class);
            startActivity(si);
        }

        return true;
    }
}