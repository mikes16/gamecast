package com.gamecastonline.gamecast.dashboard.slider

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.gamecastonline.gamecast.base.viewModel.ViewModelFragment
import com.gamecastonline.gamecast.dashboard.DashboardViewModel

/**
 * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
 * sequence.
 */
class SlideMatchesPagerAdapter(fa: ViewModelFragment<DashboardViewModel>) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = 15

    override fun createFragment(position: Int): Fragment = FragmentSlideListMatches()
}