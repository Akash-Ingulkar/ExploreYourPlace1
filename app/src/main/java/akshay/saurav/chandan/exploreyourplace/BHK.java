package akshay.saurav.chandan.exploreyourplace;

import android.os.Bundle;
import android.widget.AdapterView;

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


public class BHK extends AppCompatActivity {
    RecyclerView recyclerViewHorizontal;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager mLayoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_h_k);
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

        Call<BHKlist> call = retrofitService.getBHK1();
        call.enqueue(new Callback<BHKlist>() {
            @Override
            public void onResponse(Call<BHKlist> call, Response<BHKlist> response) {
             /*   List<GeneralFood> popularFoods = response.body().getPopularFood();
                recyclerViewHorizontal.setAdapter(new HorizontalAdapter(popularFoods, R.layout.recyclerview_horizontal, MainActivity.this));
*/
                List<FlatsModel> property = response.body().getBHK();
                recyclerView.setNestedScrollingEnabled(false);
                recyclerView.setAdapter(new FlatAdapter(property, R.layout.content_bhk, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<BHKlist> call, Throwable t) {

            }
        });
        /*Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BhkApi.BASE_URL) // Specify your api here
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BhkApi api = retrofit.create(BhkApi.class);

        Call<List<BhkApi>> call = api.getdatabkh();*/

        /*Call<List<BhkApi>> call = MainActivity.bhkApi.getdatabkh();
        call.enqueue(new Callback<List<BhkApi>>() {
            @Override
            public void onResponse(Call<List<BhkApi>> call, Response<List<BhkApi>> response) {
                List<BhkApi> adslist = response.body();
                adapter=new BHKAdapter(adslist,BHK.this);
                rv.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<BhkApi>> call, Throwable t) {
                Toast.makeText(BHK.this, "Something Went wrong!!!!", Toast.LENGTH_SHORT).show();
            }
        });*/



    }
}


