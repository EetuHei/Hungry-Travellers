package hungry.travelersapp.hungry_travellers_app.ui.reserve;

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
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.TimeZone;

import hungry.travelersapp.hungry_travellers_app.R;

public class ReserveFragment extends Fragment {

    private ReserveViewModel reserveViewModel;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
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

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String peopleAmount = userInput.getText().toString();
                String reservationName = userInput2.getText().toString();
                String reservationPhoneNumber = userInput3.getText().toString();
                Log.d(peopleAmount, "dasdsa");
                Log.d(reservationName, "kappa kappa");
                Log.d(reservationPhoneNumber, "numero");
            }
        });

       // final EditText userInput = root.findViewById(R.id.reserve_people);



        return root;
    }

}
