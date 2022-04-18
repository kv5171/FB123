package com.example.ex123;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FBref {
    public static FirebaseDatabase FBDB = FirebaseDatabase.getInstance("https://fb123-f0099-default-rtdb.firebaseio.com/");

    public static DatabaseReference refCompanies = FBDB.getReference("companies");
    public static DatabaseReference refEmployees = FBDB.getReference("employees");
    public static DatabaseReference refMeals = FBDB.getReference("meals");
    public static DatabaseReference refOrders = FBDB.getReference("orders");
    public static DatabaseReference refCounters = FBDB.getReference("counters");
}
