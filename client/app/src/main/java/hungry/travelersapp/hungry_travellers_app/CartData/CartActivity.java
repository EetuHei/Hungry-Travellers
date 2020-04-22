package hungry.travelersapp.hungry_travellers_app.CartData;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import hungry.travelersapp.hungry_travellers_app.MainActivity;
import hungry.travelersapp.hungry_travellers_app.R;
import hungry.travelersapp.hungry_travellers_app.ui.delivery.DeliveryActivity;
import hungry.travelersapp.hungry_travellers_app.ui.delivery.Orders;
import hungry.travelersapp.hungry_travellers_app.ui.menu.Food;

public class CartActivity extends AppCompatActivity {

    public String orderName = "";
    public String orderAddress = "";
    public String orderPhoneNumber = "";
    RecyclerView MenuRecycler;
    List<CartModel> MenuList;
    CartModel cartModel;
    CartAdapter cartAdapter;
    DatabaseReference CartRef;
    DatabaseReference databaseOrders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        databaseOrders = FirebaseDatabase.getInstance().getReference("Orders");

        MenuList = new ArrayList<CartModel>();
        MenuRecycler = findViewById(R.id.recyclerview);
        MenuRecycler.setHasFixedSize(true);
        MenuRecycler.setLayoutManager(new LinearLayoutManager(this));

        Button homeDelivery = findViewById(R.id.homeDelivery);
        Button pickUp = findViewById(R.id.pickUp);

        homeDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDelivery();
            }
        });

        pickUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id = databaseOrders.push().getKey();

                Orders order = new Orders(id, orderName, orderAddress, orderPhoneNumber);

                databaseOrders.child(id).setValue(order);

                openPickUp();
            }
        });

        CartRef = FirebaseDatabase.getInstance().getReference("Cart");
        CartRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                MenuList.clear();

                if (dataSnapshot.exists()) {
                    for (DataSnapshot npsnapshot : dataSnapshot.getChildren()) {
                        cartModel = npsnapshot.getValue(Food.class);
                        MenuList.add(cartModel);
                        cartAdapter = new CartAdapter(CartActivity.this, MenuList);
                        MenuRecycler.setAdapter(cartAdapter);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void openDelivery() {
        Intent intent = new Intent(CartActivity.this, DeliveryActivity.class);
        startActivity(intent);
    }

    public void openPickUp() {

        Toast.makeText(getApplicationContext(), "Order successful!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(CartActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
