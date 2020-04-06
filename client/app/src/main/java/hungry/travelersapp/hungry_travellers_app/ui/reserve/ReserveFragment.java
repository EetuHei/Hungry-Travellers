package hungry.travelersapp.hungry_travellers_app.ui.reserve;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.text.CollationElementIterator;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import hungry.travelersapp.hungry_travellers_app.R;

public class ReserveFragment extends Fragment  {

    private ReserveViewModel reserveViewModel;
    public static int yearData;
    public static int monthData;
    public static int dayData;

   DatabaseReference databaseReservations;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        databaseReservations = FirebaseDatabase.getInstance().getReference("Reservations");

        reserveViewModel =
                ViewModelProviders.of(this).get(ReserveViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_reserve, container, false);
        final TextView textView = root.findViewById(R.id.text_reserve);
        final TextView textView2 = root.findViewById(R.id.text_people);
        final TextView textView3 = root.findViewById(R.id.text_name);
        final TextView textView4 = root.findViewById(R.id.text_number);
        //final TextView textView2 = root.findViewById(R.id.text_testi);
        final EditText userInput = root.findViewById(R.id.reserve_people);
        final EditText userInput2 = root.findViewById(R.id.reserve_name);
        final EditText userInput3 = root.findViewById(R.id.reserve_phoneNumber);
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

       /* reserveViewModel.getText2().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView2.setText(s);
            }
        }); */


        datePickerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(fragmentManager, "date picker");
            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pickedDateData = String.format("%02d", dayData) + "." + String.format("%02d", monthData + 1) + "." + String.format("%02d", yearData);
                Log.d(pickedDateData, "is the date here");
                String peopleAmount = userInput.getText().toString();
                String reservationName = userInput2.getText().toString();
                String reservationPhoneNumber = userInput3.getText().toString();
                Log.d(peopleAmount, "dasdsa");
                Log.d(reservationName, "kappa kappa");
                Log.d(reservationPhoneNumber, "numero");


                String id = databaseReservations.push().getKey();

                Reservations reservation = new Reservations(peopleAmount, reservationName, reservationPhoneNumber, pickedDateData);

                databaseReservations.setValue(reservation);

            }
        });


       // final EditText userInput = root.findViewById(R.id.reserve_people);
        return root;
    }

    public static void displaydate(int year, int monthOfYear, int dayOfMonth) {
     //   datePicked.setText(dayData + " " + monthData + " " + yearData);

        yearData = year;
        monthData = monthOfYear;
        dayData = dayOfMonth;
    }

}
