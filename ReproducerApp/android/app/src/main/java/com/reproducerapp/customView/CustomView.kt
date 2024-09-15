package com.reproducerapp.customView

import android.content.Context
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.reproducerapp.R

class CustomView(context: Context, mediaList: List<UserMedia>) : FrameLayout(context) {

    private val viewPager: ViewPager2
    private val thumbnailRecyclerView: RecyclerView

    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val frameLayout = inflater.inflate(R.layout.layout_custom_view, this, true) as FrameLayout

        viewPager = frameLayout.findViewById(R.id.customview_vp)
        viewPager.adapter = CustomViewAdapter(mediaList)
        viewPager.offscreenPageLimit = 2

        thumbnailRecyclerView = frameLayout.findViewById(R.id.customview_thumbnail_rv)
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        thumbnailRecyclerView.layoutManager = layoutManager

        thumbnailRecyclerView.adapter = CustomViewRecyclerViewAdapter(mediaList)
    }
}