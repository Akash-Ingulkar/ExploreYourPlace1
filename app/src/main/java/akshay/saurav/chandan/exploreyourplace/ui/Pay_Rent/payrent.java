package akshay.saurav.chandan.exploreyourplace.ui.Pay_Rent;

import android.os.Bundle;
import android.text.TextUtils;
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
import akshay.saurav.chandan.exploreyourplace.model.PaYRenT;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class payrent extends Fragment {
    EditText tenname_pr,tenphone_pr,tenemail_pr,ownname_pr,ownphone_pr;
    Button paynow;

    public static payrent newInstance() {
        return new payrent();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.payrent_fragment, container, false);

        tenname_pr = view.findViewById(R.id.pr_tennname);
        tenphone_pr = view.findViewById(R.id.pr_tenphone);
        tenemail_pr = view.findViewById(R.id.pr_tenemail);
        ownname_pr = view.findViewById(R.id.pr_ownname);
        ownphone_pr = view.findViewById(R.id.pr_ownphone);
        paynow = view.findViewById(R.id.pr_button);

        String Name = MainActivity.appPreference.getDisplayName();
        tenname_pr.setText(Name);
        String Email = MainActivity.appPreference.getDisplayEmail();
        tenemail_pr.setText(Email);

        paynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                payRent();


            }
        });


        return view;
    }

    private void payRent() {
        final String Tname = tenname_pr.getText().toString();
        final String Tphone = tenphone_pr.getText().toString();
        final String Temail = tenemail_pr.getText().toString();
        final String Oname = ownname_pr.getText().toString();
        final String Ophone = ownphone_pr.getText().toString();
        Call<PaYRenT> call = MainActivity.serviceApiCRR.dopayment(Tname,Tphone,Temail,Oname,Ophone);
        call.enqueue(new Callback<PaYRenT>() {
            @Override
            public void onResponse(Call<PaYRenT> call, Response<PaYRenT> response) {
                if (TextUtils.isEmpty(Tname)) {
                    Toast.makeText(getContext(), "Please Enter Tenent Name", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(Tphone)) {
                    Toast.makeText(getContext(), "Please Enter Tenent Phone", Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(Temail) ) {
                    Toast.makeText(getContext(), "Please Enter Tenent Email", Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(Oname)) {
                    Toast.makeText(getContext(), "Please Enter Owner Name", Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(Ophone)) {
                    Toast.makeText(getContext(), "Please Enter Owner Phone", Toast.LENGTH_SHORT).show();
                }
                else {

                    PaYRenT serverResponse = response.body();
                    Toast.makeText(getContext(), "server response: " + serverResponse.getResponse(), Toast.LENGTH_SHORT).show();
                    tenname_pr.setText("");
                    tenphone_pr.setText("");
                    tenemail_pr.setText("");
                    ownname_pr.setText("");
                    ownphone_pr.setText("");

                    /*Intent intent=new Intent(getContext(),Payment.class);
                    startActivity(intent);*/
                }
            }

            @Override
            public void onFailure(Call<PaYRenT> call, Throwable t) {

            }
        });
    }


}
