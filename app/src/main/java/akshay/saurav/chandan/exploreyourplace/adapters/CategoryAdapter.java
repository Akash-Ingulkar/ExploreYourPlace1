package akshay.saurav.chandan.exploreyourplace.adapters;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import akshay.saurav.chandan.exploreyourplace.BHK;
import akshay.saurav.chandan.exploreyourplace.Bunglow;
import akshay.saurav.chandan.exploreyourplace.CotBasis;
import akshay.saurav.chandan.exploreyourplace.R;
import akshay.saurav.chandan.exploreyourplace.RK;
import akshay.saurav.chandan.exploreyourplace.model.PMenu;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.VerticalViewHolder> {

    private List<PMenu> regularFoods;
    private Context context;



    public static class VerticalViewHolder extends RecyclerView.ViewHolder{

        ConstraintLayout verticalLayout;
        TextView regularTitle;
        TextView regularPrice;
        ImageView regularImage;
        Button regularPlus;

        public VerticalViewHolder(View itemView) {
            super(itemView);

           verticalLayout = itemView.findViewById(R.id.categoryjk);
            regularTitle = itemView.findViewById(R.id.textcategory);
            regularImage = itemView.findViewById(R.id.imgcate);

            //   regularPlus = itemView.findViewById(R.id.cd_sbi);

        }
    }

    public CategoryAdapter(List<PMenu> regularFoods, int vertical_recyclerview, Context context){
        this.context = context;
        this.regularFoods = regularFoods;
    }

    @NonNull
    @Override
    public CategoryAdapter.VerticalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_category, parent, false);
        return new CategoryAdapter.VerticalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CategoryAdapter.VerticalViewHolder holder, final int position) {
        holder.regularTitle.setText(regularFoods.get(position).getPropertytype());
        Glide.with(context)
                .load(regularFoods.get(position).getPropertyphoto())
                .centerCrop()
                .into(holder.regularImage);

        holder.verticalLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position){
                    case 0:

                        Intent rkintent=new Intent(context, RK.class);
                        context.startActivity(rkintent);
                        break;

                    case 1:
                        Intent bhkintent=new Intent(context, BHK.class);
                        context.startActivity(bhkintent);
                        break;

                    case 3:
                        Intent bunglowintent=new Intent(context, Bunglow.class);
                        context.startActivity(bunglowintent);
                        break;


                    case 2:
                        Intent cotintent=new Intent(context, CotBasis.class);
                        context.startActivity(cotintent);
                        break;

                }
            }
        });

    }

  /*  @Override
    public int getItemCount() {
        return 0;
    }*/

    @Override
    public int getItemCount() {
        return regularFoods.size();
    }
}
