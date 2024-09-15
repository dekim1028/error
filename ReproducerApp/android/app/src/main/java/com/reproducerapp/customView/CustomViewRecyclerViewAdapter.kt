package com.reproducerapp.customView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.reproducerapp.R

class CustomViewRecyclerViewAdapter(private val mediaList: List<UserMedia>): RecyclerView.Adapter<CustomViewRecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mediaslider_thumbnail, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mediaList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val options = RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .override(Target.SIZE_ORIGINAL)
                .dontTransform()

        val imageUrl = mediaList[position].url

        Glide.with(holder.thumbnailImageView)
                .load(imageUrl)
                .apply(options)
                .into(holder.thumbnailImageView)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val thumbnailImageView: ImageView = itemView.findViewById(R.id.mediaslider_thumbnail_iv)
    }
}