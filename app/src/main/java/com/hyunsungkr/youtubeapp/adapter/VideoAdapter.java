package com.hyunsungkr.youtubeapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hyunsungkr.youtubeapp.MainActivity;
import com.hyunsungkr.youtubeapp.PhotoActivity;
import com.hyunsungkr.youtubeapp.R;
import com.hyunsungkr.youtubeapp.model.Video;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {

    Context context;
    ArrayList<Video> videoList;

    public VideoAdapter(Context context, ArrayList<Video> videoList) {
        this.context = context;
        this.videoList = videoList;
    }

    @NonNull
    @Override
    public VideoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_row,parent,false);
        return new VideoAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoAdapter.ViewHolder holder, int position) {
        Video video = videoList.get(position);

        holder.txtTitle.setText(video.title);
        holder.txtDescription.setText(video.description);
        Glide.with(context).load(video.mediumUrl).placeholder(R.drawable.baseline_ondemand_video_24).into(holder.imgThumb);

    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        TextView txtTitle;
        TextView txtDescription;
        ImageView imgThumb;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtDescription = itemView.findViewById(R.id.txtDescription);
            imgThumb = itemView.findViewById(R.id.imgThumb);

            imgThumb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int index = getAdapterPosition();

                    Video video = videoList.get(index);

                    Intent intent = new Intent(context, PhotoActivity.class);
                    intent.putExtra("highUrl",video.highUrl);

                    context.startActivity(intent);

                }
            });
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int index = getAdapterPosition();

                    Video video = videoList.get(index);
                    //https://www.youtube.com/watch?v=tnUslFhxRTs
                    String url = "https://www.youtube.com/watch?v="+video.videoId;

                    ((MainActivity)context).openWebPage(url);



                }
            });
        }
    }
}
