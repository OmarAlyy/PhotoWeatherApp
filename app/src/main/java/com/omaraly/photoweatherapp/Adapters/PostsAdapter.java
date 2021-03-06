package com.omaraly.photoweatherapp.Adapters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.omaraly.photoweatherapp.Activities.MainActivity;
import com.omaraly.photoweatherapp.Activities.ShowImageActivity;
import com.omaraly.photoweatherapp.Models.Post;
import com.omaraly.photoweatherapp.R;
import com.omaraly.photoweatherapp.Utilities.GlobalVariables;
import com.omaraly.photoweatherapp.Utilities.IntentClass;
import com.omaraly.photoweatherapp.Utilities.Utilities;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;


public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {


    public List<Post> list;
    MainActivity activity;


    public PostsAdapter(MainActivity activity, List<Post> list) {
        super ();
        this.list = list;
        this.activity = activity;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from (parent.getContext ())
                .inflate (R.layout.item_weather, parent, false);
        ViewHolder viewHolder = new ViewHolder (v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        Post model = list.get (position);

        Utilities.downLoadImageLocal (holder.image, model.getPath ());
        holder.delete.setOnClickListener (view -> activity.mainViewModel.deleteOnePost (model));


        holder.image.setOnClickListener (view -> {


            Bundle bundle = new Bundle ();
            bundle.putString (GlobalVariables.IMAGE_PATH, model.getPath ());
            IntentClass.goToActivity (activity, ShowImageActivity.class, bundle);
        });

        holder.linShare.setOnClickListener (view -> Utilities.shareImage (activity, model.getPath ()));
    }

    @Override
    public int getItemCount() {
        return list.size ();
    }


    class ViewHolder extends RecyclerView.ViewHolder {


        private ImageView image;
        private ImageView delete;
        private LinearLayout linShare;

        public ViewHolder(View itemView) {
            super (itemView);


            image = itemView.findViewById (R.id.image);
            delete = itemView.findViewById (R.id.delete);
            linShare = itemView.findViewById (R.id.linShare);
        }
    }

}
