package com.example.basicprogramming.glideappdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.basicprogramming.glideappdemo.R;
import com.example.basicprogramming.glideappdemo.model.Images;

import java.util.ArrayList;

import static com.bumptech.glide.request.RequestOptions.fitCenterTransform;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.Holder> {

    private Context context;
    private ArrayList<Images> imagesArrayList;
    private LayoutInflater inflater;

    public ImageAdapter(Context context, ArrayList<Images> imagesArrayList) {
        this.context = context;
        this.imagesArrayList = imagesArrayList;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int position) {

        View view = inflater.inflate(R.layout.glide_image_list_layout, parent, false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder viewHolder, int position) {

        Images images = imagesArrayList.get(position);

        Glide.with(context)
                .load(images.getGetMovieUrl())
                .apply(fitCenterTransform())
                .into(viewHolder.imageView);
        viewHolder.textView.setText(images.getMovieName());

        viewHolder.setListener(position);
    }

    @Override
    public int getItemCount() {
        return imagesArrayList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        private TextView textView;
        private ImageView imageView;

        public Holder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.movie_name_text_view);
            imageView = itemView.findViewById(R.id.my_image_glide);
        }

        public void setListener(final int position) {

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Images images = imagesArrayList.get(position);

                    Toast.makeText(context,
                            "Movie Name ( " + images.getMovieName() + " )",
                            Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}
