package id.sch.smktelkom_mlg.privateassignment.xirpl122.moviecom.War;

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

public class WarAdapter extends RecyclerView.Adapter<WarAdapter.ViewHolder> {
    private List<WarListItem> warListItems;
    private Context context; //mode default, hanya bisa diakses dengan dipanggil

    public WarAdapter(List<WarListItem> warListItems, Context context) {
        this.warListItems = warListItems;
        this.context = context;
    }

    @Override
    public WarAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.war_item, parent, false);
        return new WarAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(WarAdapter.ViewHolder holder, final int position) {
        final WarListItem warListItem = warListItems.get(position);

//        holder.imageViewOtof.setImageResource(R.drawable.ic_memory_black_24dp);
        holder.tvTitle.setText(warListItem.getTitle());
        holder.tvPop.setText(warListItem.getPopularity());
        Glide
                .with(context)
                .load("http://image.tmdb.org/t/p/w500" + warListItem.getImage())
                .into(holder.ivImage);

        holder.llLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetilActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //addFLags membuka activity dari fragment
                intent.putExtra("id", position); //position untuk menentukan posisi di array
                intent.putExtra("jenis", "War");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return warListItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvTitle;
        public LinearLayout llLinear;
        public ImageView ivImage;
        public TextView tvPop;

        public ViewHolder(View itemView) {
            super(itemView);

            tvTitle = (TextView) itemView.findViewById(R.id.textViewWar);
            llLinear = (LinearLayout) itemView.findViewById(R.id.LinearLayoutWar);
            ivImage = (ImageView) itemView.findViewById(R.id.imageViewWar);
            tvPop = (TextView) itemView.findViewById(R.id.textViewWarPopularity);
        }
    }
}
