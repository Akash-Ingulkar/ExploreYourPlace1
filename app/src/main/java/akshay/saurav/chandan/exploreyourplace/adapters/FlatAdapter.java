package akshay.saurav.chandan.exploreyourplace.adapters;


import android.content.Context;
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

import akshay.saurav.chandan.exploreyourplace.R;
import akshay.saurav.chandan.exploreyourplace.model.FlatsModel;


public class FlatAdapter extends RecyclerView.Adapter<FlatAdapter.VerticalViewHolder> {

    private List<FlatsModel> regularFoods;
    private Context context;



    public static class VerticalViewHolder extends RecyclerView.ViewHolder{

        ConstraintLayout verticalLayout;
        TextView regularTitle,regularlocation,regularRates;
        TextView regularPrice;
        ImageView regularImage;
        Button regularPlus;

        public VerticalViewHolder(View itemView) {
            super(itemView);

            regularlocation=itemView.findViewById(R.id.tv3);
            regularRates=itemView.findViewById(R.id.tv2);
            regularTitle = itemView.findViewById(R.id.tv1);
            regularImage = itemView.findViewById(R.id.imageView3);

            //   regularPlus = itemView.findViewById(R.id.cd_sbi);

        }
    }

    public FlatAdapter(List<FlatsModel> regularFoods, int vertical_recyclerview, Context context){
        this.context = context;
        this.regularFoods = regularFoods;
    }

    @NonNull
    @Override
    public FlatAdapter.VerticalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_bhk, parent, false);
        return new FlatAdapter.VerticalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final FlatAdapter.VerticalViewHolder holder, final int position) {
        holder.regularTitle.setText(regularFoods.get(position).getPropertyType());
        holder.regularRates.setText(regularFoods.get(position).getPrice());
        holder.regularlocation.setText(regularFoods.get(position).getLocation());
        Glide.with(context)
                .load(regularFoods.get(position).getPath())
                .centerCrop()
                .into(holder.regularImage);



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
