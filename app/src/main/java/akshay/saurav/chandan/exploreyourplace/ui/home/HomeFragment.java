package akshay.saurav.chandan.exploreyourplace.ui.home;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.Nullable;

import java.util.List;

import akshay.saurav.chandan.exploreyourplace.R;
import akshay.saurav.chandan.exploreyourplace.adapters.CategoryAdapter;
import akshay.saurav.chandan.exploreyourplace.constants.Constant;
import akshay.saurav.chandan.exploreyourplace.model.CategoryList;
import akshay.saurav.chandan.exploreyourplace.model.PMenu;
import akshay.saurav.chandan.exploreyourplace.services.RetrofitClient;
import akshay.saurav.chandan.exploreyourplace.services.ServiceApiPMenu;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {
    RecyclerView recyclerViewHorizontal;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    GridView gridView;



    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_home, container, false);

        mLayoutManager=new GridLayoutManager(getContext(),2);

        /* *//*  recyclerViewHorizontal = findViewById(R.id.horizontal_recyclerview);*//*
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewHorizontal.setLayoutManager(linearLayoutManager);*/

        recyclerView = view.findViewById(R.id.mRecyclerViewOfr);
        recyclerView.setLayoutManager(mLayoutManager);
      /*  LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewVertical.setLayoutManager(linearLayoutManager2);
*/
        ServiceApiPMenu retrofitService = RetrofitClient.getApiClient(Constant.baseUrl.BASE_URL).create(ServiceApiPMenu.class);
        Call<CategoryList> call = retrofitService.getPmenu();
        call.enqueue(new Callback<CategoryList>() {
            @Override
            public void onResponse(Call<CategoryList> call, Response<CategoryList> response) {
             /*   List<GeneralFood> popularFoods = response.body().getPopularFood();
                recyclerViewHorizontal.setAdapter(new HorizontalAdapter(popularFoods, R.layout.recyclerview_horizontal, MainActivity.this));
*/
                List<PMenu> regularFoods = response.body().getPMenu();
                recyclerView.setNestedScrollingEnabled(false);
                recyclerView.setAdapter(new CategoryAdapter(regularFoods, R.layout.data_category, getContext()));
            }

            @Override
            public void onFailure(Call<CategoryList> call, Throwable t) {

            }
        });


        return view;
    }


}

