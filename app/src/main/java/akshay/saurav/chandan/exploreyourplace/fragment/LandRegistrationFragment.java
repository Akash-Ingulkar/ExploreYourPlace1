package akshay.saurav.chandan.exploreyourplace.fragment;


import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import akshay.saurav.chandan.exploreyourplace.MainActivity;
import akshay.saurav.chandan.exploreyourplace.R;
import akshay.saurav.chandan.exploreyourplace.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static akshay.saurav.chandan.exploreyourplace.MainActivity.appPreference;

public class LandRegistrationFragment extends Fragment {

    private EditText nameInput, emailInput, phoneInput, passwordInput;

    public LandRegistrationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Button regBtn;
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_landreg, container, false);
        nameInput = view.findViewById(R.id.landeditName);
        emailInput = view.findViewById(R.id.landeditEmail);
        phoneInput = view.findViewById(R.id.landeditMobile);
        passwordInput = view.findViewById(R.id.landeditpassword);
        regBtn = view.findViewById(R.id.landlordSubmit);
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();

                Log.e("reg button", "clicked");
            }
        });
        return view;
    }

    public void registerUser() {
        String name = nameInput.getText().toString();
        String email = emailInput.getText().toString();
        String phone = phoneInput.getText().toString();
        String password = passwordInput.getText().toString();

        if (TextUtils.isEmpty(name)) {
            MainActivity.appPreference.showToast("Your name is required.");
        } else if (TextUtils.isEmpty(email)) {
            MainActivity.appPreference.showToast("Your email is required.");
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            MainActivity.appPreference.showToast("Invalid email");
        } else if (TextUtils.isEmpty(password)) {
            MainActivity.appPreference.showToast("Password required");
        } else if (password.length() < 6) {
            MainActivity.appPreference.showToast("Create a password at least 6 characters long.");
        } else {
            Call<User> userCall = MainActivity.serviceApiL.doRegistration(name, email, phone, password);
            userCall.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    User serverResponse = response.body();
                    if (serverResponse != null) {
                        switch (serverResponse.getResponse()) {
                            case "inserted":
                                Log.e("response", serverResponse.getResponse());
                                nameInput.setText("");
                                emailInput.setText("");
                                phoneInput.setText("");
                                passwordInput.setText("");
                                Toast.makeText(getContext(), "Successfully Registered", Toast.LENGTH_SHORT).show();
                                break;
                            case "exists":
                                Toast.makeText(getContext(), "This email already exists", Toast.LENGTH_SHORT).show();
                               // MainActivity.appPreference.showToast("This email already exists");
                                break;
                            case "error":
                                Toast.makeText(getContext(), "Oops! something went wrong.", Toast.LENGTH_SHORT).show();
                              //  MainActivity.appPreference.showToast("Oops! something went wrong.");
                                break;
                        }
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                }
            });
        }

    }

}
