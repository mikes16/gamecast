package com.gamecastonline.gamecast.dashboard.slider.recycler

import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.gamecast.utils.DummyData.Companion.sampleLiveJson
import com.gamecast.utils.DummyData.Companion.sampleMatchJson
import com.gamecast.utils.DummyData.Companion.sampleMatchJson2
import com.gamecast.utils.DummyData.Companion.sampleMatchJson3
import com.gamecast.utils.extensions.dp
import com.gamecast.utils.extensions.px
import com.gamecast.utils.extensions.waitForScroll
import com.gamecastonline.gamecast.R
import com.gamecastonline.gamecast.dashboard.slider.recycler.viewholders.MatchesBaseViewHolder
import com.gamecastonline.gamecast.dashboard.slider.recycler.viewholders.LiveMatchesHolderMatches
import com.gamecastonline.gamecast.dashboard.slider.recycler.viewholders.MatchesHolderMatches
import kotlin.math.floor
import kotlin.math.roundToInt

class MatchesListAdapter(private val requestManager: RequestManager) :
    RecyclerView.Adapter<MatchesBaseViewHolder>() {

    companion object {
        private const val TYPE_LIVE = 0
        private const val TYPE_NOT_LIVE = 1
    }

    private val sampleArray =
        arrayOf(
            sampleLiveJson,
            sampleMatchJson,
            sampleMatchJson2,
            sampleMatchJson3
        )
    private lateinit var mRecyclerView: RecyclerView

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchesBaseViewHolder {
        return when (viewType) {
            TYPE_LIVE -> LiveMatchesHolderMatches(
                LayoutInflater.from(mRecyclerView.context).inflate(
                    R.layout.row_match_live, parent, false
                ),
                requestManager
            )
            else -> MatchesHolderMatches(
                LayoutInflater.from(mRecyclerView.context).inflate(
                    R.layout.row_match, parent, false
                ),
                requestManager
            )
        }
    }

    override fun getItemViewType(position: Int): Int =
        if (sampleArray[position]["isLive"] == true) TYPE_LIVE else TYPE_NOT_LIVE


    override fun getItemCount() = sampleArray.size


    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)

        mRecyclerView = recyclerView
    }

    override fun onBindViewHolder(holder: MatchesBaseViewHolder, position: Int) {
        holder.bind(sampleArray[position])
    }

}