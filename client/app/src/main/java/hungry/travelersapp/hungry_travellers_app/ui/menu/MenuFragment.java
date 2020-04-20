package hungry.travelersapp.hungry_travellers_app.ui.menu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import hungry.travelersapp.hungry_travellers_app.R;


public class MenuFragment extends Fragment  {

     private MenuViewModel menuViewModel;
     private View FoodsView;
     private RecyclerView myFoodList;

     private DatabaseReference FoodRef , foodRef;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        menuViewModel = ViewModelProviders.of(this).get(MenuViewModel.class);
        FoodsView = inflater.inflate(R.layout.fragment_menu, container, false);

        myFoodList = (RecyclerView) FoodsView.findViewById(R.id.Menu_list);
        myFoodList.setLayoutManager(new LinearLayoutManager(getContext()));

        FoodRef = FirebaseDatabase.getInstance().getReference().child("Food");

        /*
        menuViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        }); */
        return FoodsView;
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseRecyclerOptions options =
                new FirebaseRecyclerOptions.Builder<Food>()
                        .setQuery(FoodRef, Food.class)
                        .build();

        FirebaseRecyclerAdapter<Food, FoodViewHolder> adapter
                = new FirebaseRecyclerAdapter<Food, FoodViewHolder>() {
            @Override
            protected void onBindViewHolder(@NonNull FoodViewHolder holder, int position, @NonNull Food model) {

            }

            @NonNull
            @Override
            public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return null;
            }
        };
    }
      public static class FoodViewHolder  extends RecyclerView.ViewHolder {
          public FoodViewHolder(@NonNull View itemView) {
              super(itemView);
          }
      }
/*
        @Override
        protected void onBindViewHolder(@NonNull MenuViewHolder holder, int position, @NonNull Food model){
            String foodIDs = getRef(position).getKey();
            foodRef.child(foodIds).addValueEventListener(new ValueEventListener )
        }

        @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup,int i){
        View view = LayoutInflater.from(viewgroup.getContext()).inflate(R.layout.fragment_menu, viewGroup, false);
        MenuViewHolder viewHolder =new MenuViewHolder(view);
        return viewHolder;

    }

    public static class MenuViewHolder extends RecyclerView.ViewHolder {
        TextView Name, Description, Price;
        CircleImageView Image;

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);

            Name=itemView.findViewById(R.id.name);
            Description= itemView.findViewById(R.id.description);
            Price=itemView.findViewById(R.id.price);
            Image=itemView.findViewById(R.id.image);
        }
    } */
}
