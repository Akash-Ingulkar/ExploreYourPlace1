package akshay.saurav.chandan.exploreyourplace.ui.Post_My_Property;

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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import akshay.saurav.chandan.exploreyourplace.MainActivity;
import akshay.saurav.chandan.exploreyourplace.R;
import akshay.saurav.chandan.exploreyourplace.model.PostMyProperty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;

public class postmyproperty extends Fragment implements View.OnClickListener {

    private EditText price_pp,location_pp,description_pp;
    private Button browse_pp,submit_pp;
    private ImageView preview_pp;
    private static final int IMG_REQEST = 777;
    private Bitmap bitmap;
    Spinner prop_type_pp;
    String[] types={"Select The Property Type","RK","BHK","Cot Basis","Bunglow"};



    public static postmyproperty newInstance() {
        return new postmyproperty();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.postmyproperty_fragment, container, false);
        prop_type_pp=view.findViewById(R.id.spinner);
        ArrayAdapter<String> myAdapter2=new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item,types);
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        prop_type_pp.setAdapter(myAdapter2);




        price_pp = view.findViewById(R.id.pp_price);
        location_pp = view.findViewById(R.id.pp_location);
        description_pp = view.findViewById(R.id.pp_description);
        browse_pp = view.findViewById(R.id.pp_browse);
        submit_pp = view.findViewById(R.id.pp_submit);
        preview_pp = view.findViewById(R.id.pp_preview);

        browse_pp.setOnClickListener(this);
        submit_pp.setOnClickListener(this);

        return view;

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.pp_browse:
                selectimage();
                break;

            case R.id.pp_submit:
                Toast.makeText(getContext(), "Please Wait", Toast.LENGTH_SHORT).show();
                uploadProperty();
                break;
        }
    }

    private void uploadProperty()
    {
        final String Image = imgTostring();
        final String Price = price_pp.getText().toString();
        final String PropType = prop_type_pp.getSelectedItem().toString();
        final String Location = location_pp.getText().toString();
        final String Description = description_pp.getText().toString();

        Call<PostMyProperty> call = MainActivity.serviceApiPP.uploadProperty(Price,Image,PropType,Location,Description);

        call.enqueue(new Callback<PostMyProperty>() {
            @Override
            public void onResponse(Call<PostMyProperty> call, Response<PostMyProperty> response) {
                if (TextUtils.isEmpty(Price)) {
                    Toast.makeText(getContext(), "Please Enter Price", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(Image)) {
                    Toast.makeText(getContext(), "Please Select Image", Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(PropType) ) {
                    Toast.makeText(getContext(), "Please Select Property Type", Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(Location)) {
                    Toast.makeText(getContext(), "Please Enter Location", Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(Description)) {
                    Toast.makeText(getContext(), "Please Enter Description", Toast.LENGTH_SHORT).show();
                }
                else {

                    PostMyProperty serverResponse = response.body();
                    Toast.makeText(getContext(), "server response: " + serverResponse.getResponse(), Toast.LENGTH_SHORT).show();
                    preview_pp.setImageResource(R.drawable.ic_launcher_background);
                    description_pp.setText("");
                    location_pp.setText("");
                    price_pp.setText("");
                    ArrayAdapter<String> myAdapter2=new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item,types);
                    myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    prop_type_pp.setAdapter(myAdapter2);
                }
            }

            @Override
            public void onFailure(Call<PostMyProperty> call, Throwable t) {

            }
        });
    }

    private void selectimage() {
        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,IMG_REQEST);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==IMG_REQEST && resultCode==RESULT_OK && data!=null)
        {
            Uri path = data.getData();

            try {
                bitmap= MediaStore.Images.Media.getBitmap(getContext().getContentResolver(),path);
                preview_pp.setImageBitmap(bitmap);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }




    private String imgTostring()
    {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        byte[] imgByte = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(imgByte,Base64.DEFAULT);

    }

}
