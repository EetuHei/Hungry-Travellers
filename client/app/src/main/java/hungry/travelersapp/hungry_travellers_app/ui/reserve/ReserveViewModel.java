package hungry.travelersapp.hungry_travellers_app.ui.reserve;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ReserveViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<String> mText2;


    public ReserveViewModel() {
        mText = new MutableLiveData<>();
        mText2 = new MutableLiveData<>();

        mText.setValue("This is reservation fragment");
        mText2.setValue("This is the test");
    }

    public LiveData<String> getText() {
        return mText;
    }
    public LiveData<String> getText2() {
        return mText2;
    }

}