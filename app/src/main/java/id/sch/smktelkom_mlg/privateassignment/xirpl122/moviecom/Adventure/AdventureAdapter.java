package id.sch.smktelkom_mlg.privateassignment.xirpl122.moviecom.Adventure;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import id.sch.smktelkom_mlg.privateassignment.xirpl122.moviecom.DetilActivity;
import id.sch.smktelkom_mlg.privateassignment.xirpl122.moviecom.R;

/**
 * Created by User on 13/05/2017.
 */

public class AdventureAdapter extends RecyclerView.Adapter<AdventureAdapter.ViewHolder> {
    private List<AdventureListItem> adventureListItems;
    private Context context; //mode default, hanya bisa diakses dengan dipanggil

    public AdventureAdapter(List<AdventureListItem> adventureListItems, Context context) {
        this.adventureListItems = adventureListItems;
        this.context = context;
    }

    @Override
    public AdventureAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adventure_item, parent, false);
        return new AdventureAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AdventureAdapter.ViewHolder holder, final int position) {
        final AdventureListItem adventureListItem = adventureListItems.get(position);

//        holder.imageViewOtof.setImageResource(R.drawable.ic_memory_black_24dp);
        holder.tvTitle.setText(adventureListItem.getTitle());
        holder.tvPop.setText(adventureListItem.getPopularity());
        Glide
                .with(context)
                .load("http://image.tmdb.org/t/p/w500" + adventureListItem.getImage())
                .into(holder.ivImage);

        holder.llLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context, "Will be released soon", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, DetilActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //addFLags membuka activity dari fragment
                intent.putExtra("id", position); //position untuk menentukan posisi di array
                intent.putExtra("jenis", "Adventure");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return adventureListItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvTitle;
        public LinearLayout llLinear;
        public ImageView ivImage;
        public TextView tvPop;

        public ViewHolder(View itemView) {
            super(itemView);

            tvTitle = (TextView) itemView.findViewById(R.id.textViewAdventure);
            llLinear = (LinearLayout) itemView.findViewById(R.id.LinearLayoutAdventure);
            ivImage = (ImageView) itemView.findViewById(R.id.imageViewAdventure);
            tvPop = (TextView) itemView.findViewById(R.id.textViewAdventurePopularity);
        }
    }
}
