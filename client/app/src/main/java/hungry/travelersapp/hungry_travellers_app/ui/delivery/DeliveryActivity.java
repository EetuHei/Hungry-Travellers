package hungry.travelersapp.hungry_travellers_app.ui.delivery;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import hungry.travelersapp.hungry_travellers_app.MainActivity;
import hungry.travelersapp.hungry_travellers_app.R;
import hungry.travelersapp.hungry_travellers_app.ui.home.HomeFragment;
import hungry.travelersapp.hungry_travellers_app.ui.reserve.Reservations;


public class DeliveryActivity extends AppCompatActivity {


    public String orderName = "";
    public String orderAddress = "";
    public String orderPhoneNumber = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);

        final EditText userInput = findViewById(R.id.order_name);
        final EditText userInput2 = findViewById(R.id.order_address);
        final EditText userInput3 = findViewById(R.id.order_phoneNumber);
        final Button orderBtn = findViewById(R.id.ButtonOrder);
        final Button cancelBtn = findViewById(R.id.ButtonCancel);

        userInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                orderName = userInput.getText().toString().trim();
            }
        });

        userInput2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                orderAddress = userInput2.getText().toString().trim();
            }
        });

        userInput3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                orderPhoneNumber = userInput3.getText().toString().trim();
            }
        });

        orderBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                if(validationSuccess()){
                    Log.d(orderName, "Name");
                    Log.d(orderAddress, "Address");
                    Log.d(orderPhoneNumber, "number");

                    Toast.makeText(getApplicationContext(), "Order successful!", Toast.LENGTH_LONG).show();
                    // Validation is working for everything else except picked date because it seems to default to 00.01.00.
                }
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelDelivery();
            }
        });


    }

    public void cancelDelivery(){
        Intent intent = new Intent(DeliveryActivity.this, MainActivity.class);
        startActivity(intent);
    }

    private Boolean validationSuccess(){
        if(orderName.isEmpty()){
            Toast.makeText(getApplicationContext(),"Please enter your name.", Toast.LENGTH_LONG).show();
            return false;
        }

        if(orderAddress.isEmpty() || orderAddress.length() > 32){
            Toast.makeText(getApplicationContext(),"Please enter your address",Toast.LENGTH_LONG).show();
            return false;
        }

        if(orderPhoneNumber.isEmpty() || orderPhoneNumber.length() < 10 || orderPhoneNumber.length() > 10){
            Toast.makeText(getApplicationContext(),"Please enter valid phone number, number should be 10 characters.",Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}
