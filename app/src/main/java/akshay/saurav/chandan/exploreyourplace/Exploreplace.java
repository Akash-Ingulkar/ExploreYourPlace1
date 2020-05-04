package akshay.saurav.chandan.exploreyourplace;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Exploreplace extends AppCompatActivity implements View.OnClickListener {

    Button findmehome,managehouse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exploreplace);

        findmehome = findViewById(R.id.ep_button1);
        managehouse= findViewById(R.id.ep_button2);

        findmehome.setOnClickListener(this);
        managehouse.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ep_button1:
                startActivity(new Intent(Exploreplace.this, MainActivity.class));
                break;
            case R.id.ep_button2:
                startActivity(new Intent(Exploreplace.this, MainActivity.class));
                break;
        }
    }
}
