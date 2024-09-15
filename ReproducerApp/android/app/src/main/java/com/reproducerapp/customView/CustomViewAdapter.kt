package com.reproducerapp.customView

import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target

class CustomViewAdapter(private val mediaList: List<UserMedia>) : RecyclerView.Adapter<CustomViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val frameLayout = FrameLayout(parent.context)
        frameLayout.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)

        val imageView = ImageView(parent.context)
        imageView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)

        frameLayout.addView(imageView)

        val holder = ViewHolder(frameLayout, imageView)

        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val media = mediaList[position]
        val imageUrl = media.url

        val options = RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .override(Target.SIZE_ORIGINAL)
                .dontTransform()

        Glide.with(holder.image)
                .load(imageUrl)
                .apply(options)
                .into(holder.image)
    }

    override fun getItemCount(): Int {
        return mediaList.size
    }

    class ViewHolder(container: ViewGroup, val image: ImageView) : RecyclerView.ViewHolder(container)

}