package com.example.video_player;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import im.ene.toro.widget.PressablePlayerSelector;

public class SimpleAdapter extends RecyclerView.Adapter<SimplePlayerViewHolder> {

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection") //
    private MediaList mediaList = new MediaList();

    @Nullable private final PressablePlayerSelector selector;

    SimpleAdapter(@Nullable PressablePlayerSelector selector) {
        this.selector = selector;
    }

    @NonNull
    @Override
    public SimplePlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(SimplePlayerViewHolder.LAYOUT_RES, parent, false);
        SimplePlayerViewHolder viewHolder = new SimplePlayerViewHolder(view, this.selector);
        if (this.selector != null) viewHolder.itemView.setOnLongClickListener(this.selector);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SimplePlayerViewHolder holder, int position) {
        holder.bind(mediaList.get(position));
    }

    @Override public int getItemCount() {
        return mediaList.size();
    }
}