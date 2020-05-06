package akshay.saurav.chandan.exploreyourplace.ui.Packers_Movers;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import akshay.saurav.chandan.exploreyourplace.MainActivity;
import akshay.saurav.chandan.exploreyourplace.R;
import akshay.saurav.chandan.exploreyourplace.model.PamData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class packersmovers extends Fragment {

    private EditText client_name_pm, client_phone_pm, city_pm, moving_from_pm,moving_to_pm;
    private Button button_pm;



    public packersmovers() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.packersmovers_fragment, container, false);

        client_name_pm = view.findViewById(R.id.pm_edclient_name);
        client_phone_pm = view.findViewById(R.id.pm_edclient_phone);
        city_pm = view.findViewById(R.id.pm_edcity);
        moving_from_pm = view.findViewById(R.id.pm_edmoving_from);
        moving_to_pm = view.findViewById(R.id.pm_edmoving_to);

        button_pm = view.findViewById(R.id.pm_button);

        button_pm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                packersmov();
                Log.e("gen button", "clicked");
            }
        });
        return view;
    }

    private void packersmov() {
        String clientname = client_name_pm.getText().toString();
        String clientphone = client_phone_pm.getText().toString();
        String city = city_pm.getText().toString();
        String movingfrm = moving_from_pm.getText().toString();
        String movingto = moving_to_pm.getText().toString();

        if (TextUtils.isEmpty(clientname)){
            MainActivity.appPreference.showToast("Tenent name is required.");
        } else if (TextUtils.isEmpty(clientphone)){
            MainActivity.appPreference.showToast("Your name is required.");
        } else if (TextUtils.isEmpty(city)) {
            MainActivity.appPreference.showToast("Tenent Phone is required.");
        } else if (TextUtils.isEmpty(movingfrm)){
            MainActivity.appPreference.showToast("Your Phone is required.");
        } else if (TextUtils.isEmpty(movingto)){
            MainActivity.appPreference.showToast("Rent amount is required");
        }
        else {
            Call<PamData> pamDataCall = MainActivity.serviceApiMP.packmove(clientname, clientphone, city, movingfrm,movingto);
            pamDataCall.enqueue(new Callback<PamData>() {
                @Override
                public void onResponse(Call<PamData> call, Response<PamData> response)
                {
                    if (response.body() != null) {
                        switch (response.body().getResponse()) {
                            case "inserted":
                                Log.e("response", response.body().getResponse());
                                client_name_pm.setText("");
                                client_phone_pm.setText("");
                                city_pm.setText("");
                                moving_from_pm.setText("");
                                moving_to_pm.setText("");
                                MainActivity.appPreference.showToast("Thank You");
                                break;
                            case "error":
                                MainActivity.appPreference.showToast("Oops! something went wrong.");
                                break;
                        }
                    }
                }
                @Override
                public void onFailure(Call<PamData> call, Throwable t) {
                }
            });
        }

    }


}
