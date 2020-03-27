package hungry.travelersapp.hungry_travellers_app.ui.reserve;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Calendar;

public class ReserveViewModel extends ViewModel {

    private MutableLiveData<String> mText;
   // private MutableLiveData<String> mText2;
    private MutableLiveData<String> mText2;
    private MutableLiveData<String> mText3;
    private MutableLiveData<String> mText4;


    public ReserveViewModel() {
        mText = new MutableLiveData<>();
       // mText2 = new MutableLiveData<>();
        mText2 = new MutableLiveData<>();
        mText3 = new MutableLiveData<>();
        mText4 = new MutableLiveData<>();

        mText.setValue("Reserve a table");
       // mText2.setValue("This is the test");
        mText2.setValue("People");
        mText3.setValue("Your name");
        mText4.setValue("Your phone number");

    }


    public LiveData<String> getText() {
        return mText;
    }
   /* public LiveData<String> getText2() {
        return mText2;
    }*/
   public LiveData<String> getText2() { return mText2; }
    public LiveData<String> getText3() { return mText3; }
    public LiveData<String> getText4() { return mText4; }

}