package akshay.saurav.chandan.exploreyourplace;

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

    TextView foodTitle, foodPrice, foodCalories;
    ImageView foodImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailsofproperty);

        foodTitle = findViewById(R.id.dpprice);
        foodPrice = findViewById(R.id.dplocation);
        foodCalories = findViewById(R.id.dpaddress);
        foodImage = findViewById(R.id.food_image);

        foodTitle.setText(getIntent().getStringExtra("foodTitle"));
        foodPrice.setText(getIntent().getStringExtra("foodPrice"));
        foodCalories.setText(getIntent().getStringExtra("foodCalories"));


        mFood.setPrice(getIntent().getStringExtra("foodTitle"));
        mFood.setLocation(getIntent().getStringExtra("foodPrice"));
        mFood.setDescription(getIntent().getStringExtra("foodCalories"));



    }
}
