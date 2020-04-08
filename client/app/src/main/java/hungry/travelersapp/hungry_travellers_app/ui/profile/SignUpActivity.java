package hungry.travelersapp.hungry_travellers_app.ui.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import hungry.travelersapp.hungry_travellers_app.R;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        final EditText signUpInput = findViewById(R.id.write_nameOfUser);
        final EditText signUpInput2 = findViewById(R.id.write_email);
        final EditText signUpInput3 = findViewById(R.id.write_phone);
        final EditText signUpInput4 = findViewById(R.id.write_address);
        final EditText signUpInput5 = findViewById(R.id.login_password);
        final Button signUpBtn = findViewById(R.id.ButtonSignUp);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usersName = signUpInput.getText().toString();
                String usersEmail = signUpInput2.getText().toString();
                String usersPhone = signUpInput3.getText().toString();
                String usersAddress = signUpInput4.getText().toString();
                String usersPassword = signUpInput5.getText().toString();

                Log.d(usersName, "test");
                Log.d(usersEmail, "test email");
                Log.d(usersPhone, "123");
                Log.d(usersAddress, "test address");
                Log.d(usersPassword, "password");
            }
        });
    }
}
