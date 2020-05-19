package akshay.saurav.chandan.exploreyourplace;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import akshay.saurav.chandan.exploreyourplace.R;
import akshay.saurav.chandan.exploreyourplace.model.FlatsModel;

public class DetailS extends AppCompatActivity implements View.OnClickListener {
    FlatsModel mFood = new FlatsModel();
    TextView propertyPrice, propertyLocation, propertyDescription;
    ImageView propertyImage;
    Button book,bookforrent;
    String imgurl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailsofproperty);

        propertyPrice = findViewById(R.id.dpprice);
        propertyLocation = findViewById(R.id.dplocation);
        propertyDescription = findViewById(R.id.dpaddress);
        propertyImage = findViewById(R.id.food_image);
        book=findViewById(R.id.bookforvisit);
        bookforrent=findViewById(R.id.bookforrent);

        propertyPrice.setText(getIntent().getStringExtra("propertyPrice"));
        propertyLocation.setText(getIntent().getStringExtra("propertyLocation"));
        propertyDescription.setText(getIntent().getStringExtra("propertyDescription"));
        imgurl = getIntent().getStringExtra("propertyImage");
        Glide.with(getApplicationContext())
                .load(imgurl)
                .into(propertyImage);


        mFood.setPrice(getIntent().getStringExtra("propertyPrice"));
        mFood.setLocation(getIntent().getStringExtra("propertyLocation"));
        mFood.setDescription(getIntent().getStringExtra("propertyDescription"));


        book.setOnClickListener(this);
        bookforrent.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bookforvisit:
                Toast.makeText(DetailS.this, "Your Visit is Scheduled Successfully", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bookforrent:
                Intent intent = new Intent(getApplicationContext(), BookForRent.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("propertyPrice",propertyPrice.getText().toString());
                intent.putExtra("propertyLocation", propertyLocation.getText().toString());
                intent.putExtra("propertyDescription", propertyDescription.getText().toString());
                intent.putExtra("propertyImage",imgurl);
                getApplicationContext().startActivity(intent);
                break;
        }
    }
}
