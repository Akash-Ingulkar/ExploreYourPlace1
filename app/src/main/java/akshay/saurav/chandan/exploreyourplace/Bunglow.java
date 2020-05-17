package akshay.saurav.chandan.exploreyourplace;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import akshay.saurav.chandan.exploreyourplace.adapters.FlatAdapter;
import akshay.saurav.chandan.exploreyourplace.constants.Constant;
import akshay.saurav.chandan.exploreyourplace.model.BHKlist;
import akshay.saurav.chandan.exploreyourplace.model.FlatsModel;
import akshay.saurav.chandan.exploreyourplace.services.RetrofitClient;
import akshay.saurav.chandan.exploreyourplace.services.ServiceApiBHK;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Bunglow extends AppCompatActivity {
    RecyclerView recyclerViewHorizontal;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bunglow);


        mLayoutManager=new GridLayoutManager(getApplicationContext(),2);

        /* *//*  recyclerViewHorizontal = findViewById(R.id.horizontal_recyclerview);*//*
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewHorizontal.setLayoutManager(linearLayoutManager);*/

        recyclerView = findViewById(R.id.mRecyclerViewOfr);
        recyclerView.setLayoutManager(mLayoutManager);
      /*  LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewVertical.setLayoutManager(linearLayoutManager2);
*/
        ServiceApiBHK retrofitService = RetrofitClient.getApiClient(Constant.baseUrl.BASE_URL).create(ServiceApiBHK.class);

        Call<BHKlist> call = retrofitService.getBunglow1();
        call.enqueue(new Callback<BHKlist>() {
            @Override
            public void onResponse(Call<BHKlist> call, Response<BHKlist> response) {
             /*   List<GeneralFood> popularFoods = response.body().getPopularFood();
                recyclerViewHorizontal.setAdapter(new HorizontalAdapter(popularFoods, R.layout.recyclerview_horizontal, MainActivity.this));
*/
                List<FlatsModel> property = response.body().getBunglow();
                recyclerView.setNestedScrollingEnabled(false);
                recyclerView.setAdapter(new FlatAdapter(property, R.layout.content_bhk, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<BHKlist> call, Throwable t) {

            }
        });
    }
}
