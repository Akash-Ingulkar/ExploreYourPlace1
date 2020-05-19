package akshay.saurav.chandan.exploreyourplace;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.zip.Inflater;

public class BookForRent extends AppCompatActivity {
   private TextView propertyPrice, propertyLocation, propertyDescription,total;
    private ImageView propertyImage;
    Button police,eagree;
    private String imgurl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_for_rent);

        propertyPrice = findViewById(R.id.dpprice);
        propertyLocation = findViewById(R.id.dplocation);
        propertyDescription = findViewById(R.id.dpaddress);
        propertyImage = findViewById(R.id.food_image);
        total=findViewById(R.id.total);
        police=findViewById(R.id.policeveri);
        eagree=findViewById(R.id.eagree);


        propertyPrice.setText(getIntent().getStringExtra("propertyPrice"));
        propertyLocation.setText(getIntent().getStringExtra("propertyLocation"));
        propertyDescription.setText(getIntent().getStringExtra("propertyDescription"));
        imgurl=getIntent().getStringExtra("propertyImage");
        Glide.with(getApplicationContext())
                .load(imgurl)
                .into(propertyImage);

        String test=propertyPrice.getText().toString();

        int a= Integer.parseInt(test);
        int c =a*2;

        total.setText("Total : "+c);


    }
}
