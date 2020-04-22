package hungry.travelersapp.hungry_travellers_app.CartData;

import android.content.Context;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hungry.travelersapp.hungry_travellers_app.R;
import hungry.travelersapp.hungry_travellers_app.ui.menu.Food;
import hungry.travelersapp.hungry_travellers_app.ui.menu.MenuAdapter;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    Context context;
    List<CartModel> menuList;

    public CartAdapter(Context context, List<CartModel> menuList) {
        this.context = context;
        this.menuList = menuList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_items_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        CartModel cartModel=menuList.get(position);
        holder.Name.setText(cartModel.getName());
        holder.Description.setText(cartModel.getDescription());
        holder.Price.setText(cartModel.getPrice());
        //Picasso.get().load("https://www.google.fi/url?sa=i&url=https%3A%2F%2Fwww.cookstr.com%2FSide-Dishes%2FCouscous-with-Vegetables&psig=AOvVaw2rLJkupIVis2ZyQYhPbaoW&ust=1587513124745000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCOCY_rGZ-OgCFQAAAAAdAAAAABAV").into(holder.imageView);


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

}


