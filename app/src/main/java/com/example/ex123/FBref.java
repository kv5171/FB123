package com.example.ex123;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * @author Keren Weintraub <kv5171@bs.amalnet.k12.il>
 * @version	1
 * @since  27/04/2022
 * The type Fb reference
 */
public class FBref {
    /**
     * The constant FBDB.
     */
    public static FirebaseDatabase FBDB = FirebaseDatabase.getInstance("https://fb123-f0099-default-rtdb.firebaseio.com/");

    /**
     * The constant refCompanies.
     */
    public static DatabaseReference refCompanies = FBDB.getReference("companies");
    /**
     * The constant refEmployees.
     */
    public static DatabaseReference refEmployees = FBDB.getReference("employees");
    /**
     * The constant refMeals.
     */
    public static DatabaseReference refMeals = FBDB.getReference("meals");
    /**
     * The constant refOrders.
     */
    public static DatabaseReference refOrders = FBDB.getReference("orders");
    /**
     * The constant refCounters.
     */
    public static DatabaseReference refCounters = FBDB.getReference("counters");
}
