package hungry.travelersapp.hungry_travellers_app.ui.reserve;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ReserveViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ReserveViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is reservation fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}