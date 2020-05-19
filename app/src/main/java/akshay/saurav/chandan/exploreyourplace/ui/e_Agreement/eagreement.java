package akshay.saurav.chandan.exploreyourplace.ui.e_Agreement;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import akshay.saurav.chandan.exploreyourplace.MainActivity;
import akshay.saurav.chandan.exploreyourplace.R;
import akshay.saurav.chandan.exploreyourplace.model.EAgreement;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;


public class eagreement extends Fragment implements View.OnClickListener {

    Button Oaadharcard, Opancard, Ophoto, Taadharcard, Tpancard, Tphoto, UploadDoc;
    private static final int IMG_REQEST = 777;
    private Bitmap bitmap;
    EditText lawyername;

    public static eagreement newInstance() {
        return new eagreement();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.eagreement_fragment, container, false);
        lawyername = view.findViewById(R.id.lawyer);
        Oaadharcard = view.findViewById(R.id.oaadhar);
        Opancard = view.findViewById(R.id.opancard);
        Ophoto = view.findViewById(R.id.ophoto);
        Taadharcard = view.findViewById(R.id.tadharcard);
        Tpancard = view.findViewById(R.id.tpancard);
        Tphoto = view.findViewById(R.id.tphoto);
        UploadDoc = view.findViewById(R.id.uploaddoc);

        Oaadharcard.setOnClickListener(this);
        Opancard.setOnClickListener(this);
        Ophoto.setOnClickListener(this);
        Taadharcard.setOnClickListener(this);
        Tpancard.setOnClickListener(this);
        Tphoto.setOnClickListener(this);
        UploadDoc.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.oaadhar:
                selectimage();
                break;

            case R.id.opancard:
                selectimage();
                break;

            case R.id.ophoto:
                selectimage();
                break;

            case R.id.tadharcard:
                selectimage();
                break;

            case R.id.tpancard:
                selectimage();
                break;

            case R.id.tphoto:
                selectimage();
                break;

            case R.id.uploaddoc:
                Toast.makeText(getContext(), "Please Wait", Toast.LENGTH_SHORT).show();
                uploadAgrement();
                break;
        }
    }

        private void uploadAgrement() {

            final String Lawyer_name = lawyername.getText().toString();
            final String Oaadharcard = imgTostring();
            final String Opancard = imgTostring();
            final String Ophoto = imgTostring();
            final String Taadharcard = imgTostring();
            final String Tpancard = imgTostring();
            final String Tphoto = imgTostring();



            Call<EAgreement> call = MainActivity.serviceApiEA.uploadAgrement(Lawyer_name, Oaadharcard, Opancard, Ophoto, Taadharcard, Tpancard, Tphoto);


            call.enqueue(new Callback<EAgreement>() {
                @Override
                public void onResponse(Call<EAgreement> call, Response<EAgreement> response) {


                    if (TextUtils.isEmpty(Lawyer_name)) {
                        Toast.makeText(getContext(), "Please Select Lawyer Name", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(Oaadharcard)) {
                        Toast.makeText(getContext(), "Please upload adharcard", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(Opancard)) {
                        Toast.makeText(getContext(), "Please upload pancard", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(Ophoto)) {
                        Toast.makeText(getContext(), "Please upload photo", Toast.LENGTH_SHORT).show();

                    } else if (TextUtils.isEmpty(Taadharcard)) {
                        Toast.makeText(getContext(), "Please upload aadharcard", Toast.LENGTH_SHORT).show();

                    } else if (TextUtils.isEmpty(Tpancard)) {
                        Toast.makeText(getContext(), "Please upload pancard", Toast.LENGTH_SHORT).show();

                    } else if (TextUtils.isEmpty(Tphoto)) {
                        Toast.makeText(getContext(), "Please upload Photo", Toast.LENGTH_SHORT).show();

                    } else {

                        EAgreement serverResponse = response.body();
                        Toast.makeText(getContext(), "server response: " + serverResponse.getResponse(), Toast.LENGTH_SHORT).show();
                        lawyername.setText("");


                    }
                }

                @Override
                public void onFailure(Call<EAgreement> call, Throwable t) {


                }
            });

        }








        private String imgTostring() {

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            byte[] imgByte = byteArrayOutputStream.toByteArray();
            return Base64.encodeToString(imgByte, Base64.DEFAULT);

        }

        private void selectimage() {

            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(intent, IMG_REQEST);


        }


        @Override
        public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == IMG_REQEST && resultCode == RESULT_OK && data != null) {
                Uri path = data.getData();

                try {
                    bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), path);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

