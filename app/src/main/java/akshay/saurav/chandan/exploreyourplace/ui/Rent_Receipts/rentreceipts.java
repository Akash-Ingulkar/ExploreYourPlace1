package akshay.saurav.chandan.exploreyourplace.ui.Rent_Receipts;

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
import akshay.saurav.chandan.exploreyourplace.model.RentReceipt;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class rentreceipts extends Fragment {

    private EditText tenname_crr, ownername_crr, tenphone_crr, ownerphone_crr,rent_crr;
    private Button button_crr;



    public  rentreceipts() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.rentreceipts_fragment, container, false);

        tenname_crr = view.findViewById(R.id.crr_edtenentname);
        ownername_crr = view.findViewById(R.id.crr_edownername);
        tenphone_crr = view.findViewById(R.id.crr_edtenphone);
        ownerphone_crr = view.findViewById(R.id.crr_edownerphone);
        rent_crr = view.findViewById(R.id.crr_edrent);
        button_crr= view.findViewById(R.id.crr_button);

        String Name = MainActivity.appPreference.getDisplayName();
        ownername_crr.setText(Name);


        button_crr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.appPreference.showToast("button clicked");
                //Toast.makeText(getContext(), "button clicked", Toast.LENGTH_SHORT).show();
                createreceipt();
                Log.e("gen button", "clicked");
            }
        });


        return view;
    }

    private void createreceipt() {
        String tenname = tenname_crr.getText().toString();
        String ownername = ownername_crr.getText().toString();
        String tenphone = tenphone_crr.getText().toString();
        String ownerphone = ownerphone_crr.getText().toString();
        String rent = rent_crr.getText().toString();

        if (TextUtils.isEmpty(tenname)){
            MainActivity.appPreference.showToast("Tenent name is required.");
        } else if (TextUtils.isEmpty(ownername)){
            MainActivity.appPreference.showToast("Your name is required.");
        } else if (TextUtils.isEmpty(tenphone)) {
            MainActivity.appPreference.showToast("Tenent Phone is required.");
        } else if (TextUtils.isEmpty(ownerphone)){
            MainActivity.appPreference.showToast("Your Phone is required.");
        } else if (TextUtils.isEmpty(rent)){
            MainActivity.appPreference.showToast("Rent amount is required");
        }
        else {
            Call<RentReceipt> rentReceiptCall = MainActivity.serviceApiCRR.generatereceipt(tenname, ownername, tenphone, ownerphone,rent);
            rentReceiptCall.enqueue(new Callback<RentReceipt>() {
                @Override
                public void onResponse(Call<RentReceipt> call, Response<RentReceipt> response)
                {
                    if (response.body() != null) {
                        switch (response.body().getResponse()) {
                            case "inserted":
                                Log.e("response", response.body().getResponse());
                                tenname_crr.setText("");
                                ownername_crr.setText("");
                                tenphone_crr.setText("");
                                ownerphone_crr.setText("");
                                rent_crr.setText("");
                                MainActivity.appPreference.showToast("Rent-Receipt Created Successfully");
                                break;
                            case "error":
                                MainActivity.appPreference.showToast("Oops! something went wrong.");
                                break;
                        }
                    }
                }
                @Override
                public void onFailure(Call<RentReceipt> call, Throwable t) {
                }
            });
        }


    }


}
