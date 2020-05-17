package akshay.saurav.chandan.exploreyourplace;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import akshay.saurav.chandan.exploreyourplace.R;
import akshay.saurav.chandan.exploreyourplace.model.FlatsModel;

public class DetailS extends AppCompatActivity {
    FlatsModel mFood = new FlatsModel();

    TextView propertyPrice, propertyLocation, propertyDescription;
    ImageView propertyImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailsofproperty);

        propertyPrice = findViewById(R.id.dpprice);
        propertyLocation = findViewById(R.id.dplocation);
        propertyDescription = findViewById(R.id.dpaddress);
        propertyImage = findViewById(R.id.food_image);

        propertyPrice.setText(getIntent().getStringExtra("propertyPrice"));
        propertyLocation.setText(getIntent().getStringExtra("propertyLocation"));
        propertyDescription.setText(getIntent().getStringExtra("propertyDescription"));

        Glide.with(getApplicationContext())
              .load(mFood.getPath())
              .into(propertyImage);





        mFood.setPrice(getIntent().getStringExtra("propertyPrice"));
        mFood.setLocation(getIntent().getStringExtra("propertyLocation"));
        mFood.setDescription(getIntent().getStringExtra("propertyDescription"));
       // mFood.setPath((getIntent().getStringExtra("foodImage")));



    }
}
