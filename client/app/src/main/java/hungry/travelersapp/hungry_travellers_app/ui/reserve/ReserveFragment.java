package hungry.travelersapp.hungry_travellers_app.ui.reserve;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import hungry.travelersapp.hungry_travellers_app.R;

public class ReserveFragment extends Fragment  {

    private ReserveViewModel reserveViewModel;
    public static int yearData;
    public static int monthData;
    public static int dayData;
    public String peopleAmount = "";
    public String reservationName = "";
    public String reservationPhoneNumber = "";
    public String reservationTime = "";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {
        reserveViewModel =
                ViewModelProviders.of(this).get(ReserveViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_reserve, container, false);
        final TextView textView = root.findViewById(R.id.text_reserve);
        final TextView textView2 = root.findViewById(R.id.text_people);
        final TextView textView3 = root.findViewById(R.id.text_name);
        final TextView textView4 = root.findViewById(R.id.text_number);
        final TextView textView5 = root.findViewById(R.id.text_time);
        final EditText userInput = root.findViewById(R.id.reserve_people);
        final EditText userInput2 = root.findViewById(R.id.reserve_name);
        final EditText userInput3 = root.findViewById(R.id.reserve_phoneNumber);
        final EditText userInput4 = root.findViewById(R.id.reserve_time);
        final Button submitBtn = root.findViewById(R.id.ButtonSendFeedback);
        final Button datePickerBtn = root.findViewById(R.id.datePickerButton);
        final TextView datePicked = root.findViewById(R.id.datePickerTextView);

        reserveViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        reserveViewModel.getText2().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView2.setText(s);
            }
        });
        reserveViewModel.getText3().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView3.setText(s);
            }
        });
        reserveViewModel.getText4().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView4.setText(s);
            }
        });

        reserveViewModel.getText5().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView5.setText(s);
            }
        });

        userInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                peopleAmount = userInput.getText().toString().trim();
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
                reservationName = userInput2.getText().toString();
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
                reservationPhoneNumber = userInput3.getText().toString().trim();
            }
        });

        userInput4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                reservationTime = userInput4.getText().toString().trim();
            }
        });


        datePickerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(fragmentManager, "date picker");
            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                if(validationSuccess()){
                    String pickedDateData = String.format("%02d", dayData) + "." + String.format("%02d", monthData + 1) + "." + String.format("%02d", yearData).trim();
                    Log.d(peopleAmount, "Amount of people");
                    Log.d(reservationName, "Name");
                    Log.d(reservationPhoneNumber, "number");
                    Log.d(reservationTime, "Time");
                    Log.d(pickedDateData, "picked date");
                    Toast.makeText(getContext(), "Reservation successful!", Toast.LENGTH_LONG).show();
                    // Validation is working for everything else except picked date because it seems to default to 00.01.00.
                }
            }
        });

        return root;
    }

    public static void displaydate(int year, int monthOfYear, int dayOfMonth) {
        yearData = year;
        monthData = monthOfYear;
        dayData = dayOfMonth;
    }

    private Boolean validationSuccess(){
        if(peopleAmount.isEmpty()){
           Toast.makeText(getContext(),"Please enter amount of people.", Toast.LENGTH_LONG).show();
            return false;
        }

        if(reservationName.isEmpty() || reservationName.length() > 32){
            Toast.makeText(getContext(),"Please enter valid name, maximum characters 32.",Toast.LENGTH_LONG).show();
            return false;
        }

        if(reservationPhoneNumber.isEmpty() || reservationPhoneNumber.length() < 10 || reservationPhoneNumber.length() > 10){
            Toast.makeText(getContext(),"Please enter valid phone number, number should be 10 characters.",Toast.LENGTH_LONG).show();
            return false;
        }
        if(reservationTime.isEmpty()){
            Toast.makeText(getContext(), "Please enter time for the reservation.", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

}
