package hungry.travelersapp.hungry_travellers_app.ui.reserve;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
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
    private DatePickerFragment.OnDateReceiveCallBack mListener;
    private Context context;

    public interface OnDateReceiveCallBack {
        void onDateReceive(int year, int month, int day);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;

        try {
            mListener = (DatePickerFragment.OnDateReceiveCallBack) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnDateSetListener");
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        TextView pickedDate = (TextView) getActivity().findViewById(R.id.datePickerTextView);
        String pickedDateData = String.format("Picked date:\n" + "%02d", dayOfMonth) + "." + String.format("%02d", month + 1) + "." + String.format("%02d", year);
        pickedDate.setText(pickedDateData);
        mListener.onDateReceive(year, month, dayOfMonth);
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

