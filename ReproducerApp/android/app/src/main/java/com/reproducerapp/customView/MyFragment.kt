package com.reproducerapp.customView

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class MyFragment : Fragment() {
    private lateinit var customView: CustomView
    private var mediaList: List<UserMedia> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            mediaList = it.getString(MyFragment.ARG_MEDIA_LIST)?.let { Json.decodeFromString<List<UserMedia>>(it) }
                ?: emptyList()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        customView = CustomView(requireNotNull(context), mediaList)
        return customView // this CustomView could be any view that you want to render
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // do any logic that should happen in an `onCreate` method, e.g:
        // customView.onCreate(savedInstanceState);
    }

    override fun onPause() {
        super.onPause()
        // do any logic that should happen in an `onPause` method
        // e.g.: customView.onPause();
    }

    override fun onResume() {
        super.onResume()
        // do any logic that should happen in an `onResume` method
        // e.g.: customView.onResume();
    }

    override fun onDestroy() {
        super.onDestroy()
        // do any logic that should happen in an `onDestroy` method
        // e.g.: customView.onDestroy();
    }


    companion object {
        private const val ARG_MEDIA_LIST = "media_list"

        @JvmStatic
        fun newInstance(mediaList: List<UserMedia>) =
            MyFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_MEDIA_LIST, Json.encodeToString(mediaList))
                }
            }
    }
}