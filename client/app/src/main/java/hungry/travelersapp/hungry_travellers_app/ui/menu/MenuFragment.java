package hungry.travelersapp.hungry_travellers_app.ui.menu;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import hungry.travelersapp.hungry_travellers_app.R;
import hungry.travelersapp.hungry_travellers_app.CartData.CartActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {

      RecyclerView MenuRecycler;
      List<Food> MenuList;
      Food food;
      MenuAdapter menuAdapter;

      DatabaseReference FoodRef;

      Button btn;

    public MenuFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_menu, container, false);

        MenuList=new ArrayList<>();
        btn=view.findViewById(R.id.cartbtn);
        MenuRecycler=view.findViewById(R.id.recyclerview);
        MenuRecycler.setHasFixedSize(true);
        MenuRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

        FoodRef= FirebaseDatabase.getInstance().getReference("Food");

        FoodRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {
                    for (DataSnapshot npsnapshot : dataSnapshot.getChildren()) {
                        food = npsnapshot.getValue(Food.class);
                        MenuList.add(food);
                        menuAdapter=new MenuAdapter(getContext(),MenuList);
                        MenuRecycler.setAdapter(menuAdapter);
                    }
                    }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(getContext(), CartActivity.class));
           }
       });
        return view;
    }
}
