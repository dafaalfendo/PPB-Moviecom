package id.sch.smktelkom_mlg.privateassignment.xirpl122.moviecom.Family;

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

public class FamilyAdapter extends RecyclerView.Adapter<FamilyAdapter.ViewHolder> {
    private List<FamilyListItem> familyListItems;
    private Context context; //mode default, hanya bisa diakses dengan dipanggil

    public FamilyAdapter(List<FamilyListItem> familyListItems, Context context) {
        this.familyListItems = familyListItems;
        this.context = context;
    }

    @Override
    public FamilyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.family_item, parent, false);
        return new FamilyAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FamilyAdapter.ViewHolder holder, final int position) {
        final FamilyListItem familyListItem = familyListItems.get(position);

//        holder.imageViewOtof.setImageResource(R.drawable.ic_memory_black_24dp);
        holder.tvTitle.setText(familyListItem.getTitle());
        holder.tvPop.setText(familyListItem.getPopularity());
        Glide
                .with(context)
                .load("http://image.tmdb.org/t/p/w500" + familyListItem.getImage())
                .into(holder.ivImage);

        holder.llLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetilActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //addFLags membuka activity dari fragment
                intent.putExtra("id", position); //position untuk menentukan posisi di array
                intent.putExtra("jenis", "Family");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return familyListItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvTitle;
        public LinearLayout llLinear;
        public ImageView ivImage;
        public TextView tvPop;

        public ViewHolder(View itemView) {
            super(itemView);

            tvTitle = (TextView) itemView.findViewById(R.id.textViewFamily);
            llLinear = (LinearLayout) itemView.findViewById(R.id.LinearLayoutFamily);
            ivImage = (ImageView) itemView.findViewById(R.id.imageViewFamily);
            tvPop = (TextView) itemView.findViewById(R.id.textViewFamilyPopularity);
        }
    }
}
