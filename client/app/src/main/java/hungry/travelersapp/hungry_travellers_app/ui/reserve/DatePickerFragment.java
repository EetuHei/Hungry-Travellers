package hungry.travelersapp.hungry_travellers_app.ui.reserve;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.text.DateFormat;
import java.util.Calendar;

import hungry.travelersapp.hungry_travellers_app.R;

public class DatePickerFragment extends DialogFragment implements
        DatePickerDialog.OnDateSetListener {
    private int year, month, day;
    private Button btn;

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        this.year = year;
        this.month = month;
        this.day = dayOfMonth;

        String yearStr = String.valueOf(this.year);
        String monthStr = String.valueOf(this.month + 1);
        String dayStr = String.valueOf(this.day);

        Log.d(yearStr + " " + monthStr + " " + dayStr, "selected date");
    }



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }




}

