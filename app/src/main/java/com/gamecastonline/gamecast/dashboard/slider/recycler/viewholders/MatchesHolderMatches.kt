package com.gamecastonline.gamecast.dashboard.slider.recycler.viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.RequestManager
import kotlinx.android.synthetic.main.row_match.view.*

class MatchesHolderMatches(
    view: View,
    private val requestManager: RequestManager
): MatchesBaseViewHolder(view), View.OnClickListener{

    private val titleMatch: TextView = view.tvTitleMatch
    private val localTeamTitle: TextView = view.tvLocalTeamName
    private val localTeamScore: TextView = view.tvLocalTeamScore
    private val localTeamLogo: ImageView = view.imgLocalTeamLogo
    private val visitorTeamTitle: TextView = view.tvVisitorTeamTitle
    private val visitorTeamScore: TextView = view.tvVisitorTeamScore
    private val visitorTeamLogo: ImageView = view.imgVisitorTeamLogo

    init {
        view.edit_btn.setOnClickListener(this)
        view.imgLocalTeamLogo.setOnClickListener(this)
        view.imgVisitorTeamLogo.setOnClickListener(this)
    }

    override fun bind(value: Map<String, Any>) {
        titleMatch.text = value["title"].toString()
        localTeamTitle.text = value["local"].toString()
        localTeamScore.text = value["local_prediction"].toString()
        requestManager
            .load(value["local_logo"])
            .into(localTeamLogo)
        requestManager
            .load(value["visitor_logo"])
            .into(visitorTeamLogo)
        visitorTeamTitle.text = value["visitor"].toString()
        visitorTeamScore.text = value["visitor_prediction"].toString()
//        createBoxes(scoreContainer, value)
    }

    override fun onClick(v: View?) {

        Toast.makeText(v?.context, "Something went wrong", Toast.LENGTH_SHORT).show()

//        when(v?.id){
//            R.id.edit_btn -> Navigation.findNavController(v).navigate(R.id.action_dashboard_screen_to_matchesFragment)
//            R.id.local_team_logo -> Navigation.findNavController(v).navigate(R.id.action_dashboard_screen_to_matchesFragment)
//            R.id.visitor_team_logo -> Navigation.findNavController(v).navigate(R.id.action_dashboard_screen_to_matchesFragment)
//            else -> Toast.makeText(v?.context, "Something went wrong", Toast.LENGTH_SHORT).show()
//        }
    }
}