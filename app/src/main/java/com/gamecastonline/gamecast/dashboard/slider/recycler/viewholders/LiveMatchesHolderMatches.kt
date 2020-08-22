package com.gamecastonline.gamecast.dashboard.slider.recycler.viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.RequestManager
import kotlinx.android.synthetic.main.row_match.view.*
import kotlinx.android.synthetic.main.row_match_live.view.*
import kotlinx.android.synthetic.main.row_match_live.view.imgLocalTeamLogo
import kotlinx.android.synthetic.main.row_match_live.view.imgVisitorTeamLogo
import kotlinx.android.synthetic.main.row_match_live.view.tvLocalTeamName
import kotlinx.android.synthetic.main.row_match_live.view.tvVisitorTeamTitle

class LiveMatchesHolderMatches (
    view: View,
    private val requestManager: RequestManager
) : MatchesBaseViewHolder(view), View.OnClickListener {

    private val titleMatchLive: TextView = view.tvTitleMatchLive
    private val localTeamTitle: TextView = view.tvLocalTeamName
    private val localTeamValue: TextView = view.local_team_value
    private val localTeamLogo: ImageView = view.imgLocalTeamLogo
    private val minutes: TextView = view.tvMinutes
    private val visitorTeamTitle: TextView = view.tvVisitorTeamTitle
    private val visitorTeamValue: TextView = view.visitor_team_value
    private val visitorTeamLogo: ImageView = view.imgVisitorTeamLogo

    init {
        view.see_button.setOnClickListener(this)
        view.imgLocalTeamLogo.setOnClickListener(this)
        view.imgVisitorTeamLogo.setOnClickListener(this)
    }

    override fun bind(value: Map<String, Any>) {
        titleMatchLive.text = value["title"].toString()
        localTeamTitle.text = value["local"].toString()
        localTeamValue.text = value["local_live_score"].toString()
        requestManager
            .load(value["local_logo"])
            .into(localTeamLogo)

        minutes.text = value["minutes"].toString()

        requestManager
            .load(value["visitor_logo"])
            .into(visitorTeamLogo)
        visitorTeamTitle.text = value["visitor"].toString()
        visitorTeamValue.text = value["visitor_live_score"].toString()
    }

    override fun onClick(v: View?) {

        Toast.makeText(v?.context, "En Construcción", Toast.LENGTH_SHORT).show()

//        when(v?.id){
//            R.id.see_button -> Navigation.findNavController(v).navigate(R.id.action_dashboard_screen_to_matchesFragment)
//            R.id.local_team_logo -> Navigation.findNavController(v).navigate(R.id.action_dashboard_screen_to_matchesFragment)
//            R.id.visitor_team_logo -> Navigation.findNavController(v).navigate(R.id.action_dashboard_screen_to_matchesFragment)
//            else -> Toast.makeText(v?.context, "Something went wrong", Toast.LENGTH_SHORT).show()
//        }
    }
}