package akshay.saurav.chandan.exploreyourplace.ui.Refer_Earn;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import akshay.saurav.chandan.exploreyourplace.MainActivity;
import akshay.saurav.chandan.exploreyourplace.R;
import akshay.saurav.chandan.exploreyourplace.model.ReferEarn;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class referearn extends Fragment {

   EditText name_re,phone_re,add_re;
   Button button_re;

    public static referearn newInstance() {
        return new referearn();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.referearn_fragment, container, false);
        name_re = view.findViewById(R.id.re_name);
        String Name = MainActivity.appPreference.getDisplayName();
        name_re.setText(Name);
        phone_re = view.findViewById(R.id.re_phone);
        add_re = view.findViewById(R.id.re_address);
        button_re = view.findViewById(R.id.re_button);

        button_re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                referEarn();
            }
        });


        return view;
    }

    private void referEarn() {
        String Name = name_re.getText().toString();
        String Phone = phone_re.getText().toString();
        String Address = add_re.getText().toString();

        Call<ReferEarn> call = MainActivity.serviceApiRE.refearn(Name,Phone,Address);

        call.enqueue(new Callback<ReferEarn>() {
            @Override
            public void onResponse(Call<ReferEarn> call, Response<ReferEarn> response) {

                ReferEarn serverResponse=response.body();
                Toast.makeText(getContext(), "server response: "+serverResponse.getResponse(), Toast.LENGTH_SHORT).show();

                name_re.setText("");
                phone_re.setText("");
                add_re.setText("");

            }

            @Override
            public void onFailure(Call<ReferEarn> call, Throwable t) {

            }


        });
    }


}
