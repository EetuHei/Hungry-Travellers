package hungry.travelersapp.hungry_travellers_app.ui.menu;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hungry.travelersapp.hungry_travellers_app.R;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {


    int i=0;
     Context context;
     List<Food> menuList;

    public MenuAdapter(Context context, List<Food> menuList) {
        this.context = context;
        this.menuList = menuList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_items_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final Food food=menuList.get(position);
        holder.Name.setText(food.getName());
        holder.Description.setText(food.getDescription());
        holder.Price.setText(food.getPrice());
        //Picasso.get().load("https://www.google.fi/url?sa=i&url=https%3A%2F%2Fwww.cookstr.com%2FSide-Dishes%2FCouscous-with-Vegetables&psig=AOvVaw2rLJkupIVis2ZyQYhPbaoW&ust=1587513124745000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCOCY_rGZ-OgCFQAAAAAdAAAAABAV").into(holder.imageView);
        holder.add_to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=food.getName();
                String desc=food.getDescription();
                String price=food.getPrice();
                String imgUrl=food.getImage();

                AddToCart(name,desc,price,imgUrl);

            }
        });

    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView Name;
        TextView Description;
        ImageView imageView;
        TextView Price;
        Button add_to_cart;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Name=itemView.findViewById(R.id.name);
            Description=itemView.findViewById(R.id.desc);
            Price=itemView.findViewById(R.id.price);
            imageView=itemView.findViewById(R.id.foodimg);
            add_to_cart=itemView.findViewById(R.id.addtocartbtn);


        }
    }

    //This Function Save data to firebase that we will see in cart activity.
    public void AddToCart(String name, String desc, String price, String imgUrl){

        Food food=new Food();

       ++i;
        String item="Item"+i;
        Toast.makeText(context, "food =: "+item, Toast.LENGTH_SHORT).show();

        DatabaseReference CartRef= FirebaseDatabase.getInstance().getReference("Cart");

        Map<String,Object> taskMap = new HashMap<>();
        taskMap.put("name", name);
        taskMap.put("description",desc);
        taskMap.put("price", price);
        taskMap.put("imgUrl", imgUrl);
        CartRef.child(item).updateChildren(taskMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){

                    Toast.makeText(context, "Item Added to Cart", Toast.LENGTH_SHORT).show();
                }
            }
        });






    }
}
