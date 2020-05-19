package akshay.saurav.chandan.exploreyourplace.adapters;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.telecom.Call;
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
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.util.List;

import akshay.saurav.chandan.exploreyourplace.DetailS;
import akshay.saurav.chandan.exploreyourplace.R;
import akshay.saurav.chandan.exploreyourplace.model.FlatsModel;


public class FlatAdapter extends RecyclerView.Adapter<FlatAdapter.VerticalViewHolder>  {

    private List<FlatsModel> property;
    private Context context;
    Bitmap bitmap;



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
            verticalLayout=itemView.findViewById(R.id.categoryak);

            //   regularPlus = itemView.findViewById(R.id.cd_sbi);

        }
    }

    public FlatAdapter(List<FlatsModel> property, int vertical_recyclerview, Context context){
        this.context = context;
        this.property = property;
    }

    @NonNull
    @Override
    public FlatAdapter.VerticalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_bhk, parent, false);
        return new FlatAdapter.VerticalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final VerticalViewHolder holder, final int position) {
        holder.regularTitle.setText(property.get(position).getPropertyType());
        holder.regularRates.setText(property.get(position).getPrice());
        holder.regularlocation.setText(property.get(position).getLocation());
        Glide.with(context)
                .load(property.get(position).getPath())
                .centerCrop()
                .into(holder.regularImage);


       holder.verticalLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailS.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("propertyPrice", property.get(position).getPrice());
                intent.putExtra("propertyLocation", property.get(position).getLocation());
                intent.putExtra("propertyDescription", property.get(position).getDescription());
                intent.putExtra("propertyImage",property.get(position).getPath());
                context.startActivity(intent);
            }
        });


    }

  /*  @Override
    public int getItemCount() {
        return 0;
    }*/

    @Override
    public int getItemCount() {
        return property.size();
    }
}
