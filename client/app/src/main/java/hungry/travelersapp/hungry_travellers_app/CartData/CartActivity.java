package hungry.travelersapp.hungry_travellers_app.CartData;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import hungry.travelersapp.hungry_travellers_app.R;
import hungry.travelersapp.hungry_travellers_app.ui.menu.Food;

public class CartActivity extends AppCompatActivity {

    RecyclerView MenuRecycler;
    List<CartModel> MenuList;
    CartModel cartModel;
    CartAdapter cartAdapter;
    DatabaseReference CartRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        MenuList=new ArrayList<CartModel>();
        MenuRecycler=findViewById(R.id.recyclerview);
        MenuRecycler.setHasFixedSize(true);
        MenuRecycler.setLayoutManager(new LinearLayoutManager(this));

        CartRef= FirebaseDatabase.getInstance().getReference("Cart");
        CartRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                MenuList.clear();

                if (dataSnapshot.exists()) {
                    for (DataSnapshot npsnapshot : dataSnapshot.getChildren()) {
                        cartModel = npsnapshot.getValue(Food.class);
                        MenuList.add(cartModel);
                        cartAdapter=new CartAdapter(CartActivity.this,MenuList);
                        MenuRecycler.setAdapter(cartAdapter);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
