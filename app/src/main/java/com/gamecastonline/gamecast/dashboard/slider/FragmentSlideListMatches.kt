package com.gamecastonline.gamecast.dashboard.slider

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.RequestManager
import com.gamecastonline.gamecast.R
import com.gamecastonline.gamecast.dashboard.slider.recycler.MatchesListAdapter
import kotlinx.android.synthetic.main.fragment_list_matches.view.*
import org.koin.android.ext.android.inject

class FragmentSlideListMatches : Fragment() {

    private val requestManager: RequestManager by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_list_matches, container, false)
        view.rvMatches.adapter = MatchesListAdapter(requestManager)

        return view
    }
}