package id.sch.smktelkom_mlg.privateassignment.xirpl122.moviecom.Action;

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

public class ActionAdapter extends RecyclerView.Adapter<ActionAdapter.ViewHolder> {
    private List<ActionListItem> actionListItems;
    private Context context; //mode default, hanya bisa diakses dengan dipanggil

    public ActionAdapter(List<ActionListItem> actionListItems, Context context) {
        this.actionListItems = actionListItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.action_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final ActionListItem actionListItem = actionListItems.get(position);

//        holder.imageViewOtof.setImageResource(R.drawable.ic_memory_black_24dp);
        holder.tvTitle.setText(actionListItem.getTitle());
        holder.tvPop.setText(actionListItem.getPopularity());
        Glide
                .with(context)
                .load("http://image.tmdb.org/t/p/w500" + actionListItem.getImage())
                .into(holder.ivImage);

        holder.llLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(context, "Will be released soon", Toast.LENGTH_LONG).show();

                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();

                Intent intent = new Intent(context, DetilActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //addFLags membuka activity dari fragment
                intent.putExtra("id", position); //position untuk menentukan posisi di array
                intent.putExtra("jenis", "Action");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return actionListItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvTitle;
        public LinearLayout llLinear;
        public ImageView ivImage;
        public TextView tvPop;

        public ViewHolder(View itemView) {
            super(itemView);

            tvTitle = (TextView) itemView.findViewById(R.id.textViewAction);
            llLinear = (LinearLayout) itemView.findViewById(R.id.LinearLayoutAction);
            ivImage = (ImageView) itemView.findViewById(R.id.imageViewAction);
            tvPop = (TextView) itemView.findViewById(R.id.textViewActionPopularity);
        }
    }

}
