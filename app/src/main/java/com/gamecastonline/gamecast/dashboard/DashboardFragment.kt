package com.gamecastonline.gamecast.dashboard

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce.*
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.gamecast.utils.extensions.dp
import com.gamecast.utils.extensions.or
import com.gamecastonline.gamecast.R
import com.gamecastonline.gamecast.base.annotation.VMFragment
import com.gamecastonline.gamecast.base.viewModel.ViewModelFragment
import com.gamecastonline.gamecast.dashboard.slider.SlideMatchesPagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.menu_top.*
import kotlinx.android.synthetic.main.toolbar_menu.*

@VMFragment(R.layout.fragment_dashboard)
class DashboardFragment : ViewModelFragment<DashboardViewModel>(DashboardViewModel::class),
    View.OnClickListener, TabLayout.OnTabSelectedListener {

    private var isMenuShowing:Boolean = false
    private var currentAnimation: SpringAnimation? = null

    override fun setupViews(savedInstanceState: Bundle?) {
        val navController = findNavController()
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.dashboardFragment))
        toolbar.setupWithNavController(navController, appBarConfiguration)
        toolbar.setNavigationIcon(R.drawable.ic_toolbar_ham)
        toolbar.setNavigationOnClickListener {
            if(!isMenuShowing) animateMenuIn() else animateMenuOut()
        }

        vpMatchesContainer.adapter = SlideMatchesPagerAdapter(this)
    }

    override fun subscribeToViewModel(viewModel: DashboardViewModel) {
        //noop
    }

    override fun onClick(v: View?) {
        when(v){
            ibCloseMenu, vBackgroundBlack -> animateMenuOut()
            llProfileContainer, btnEditProfile -> {
                animateMenuOut()
//                Navigation.findNavController(v).navigate(R.id.action_dashboardFragment_to_profile_nav)
            }
            llConfigContainer -> {
                animateMenuOut()
                Toast.makeText(requireActivity().applicationContext, "En Construcción", Toast.LENGTH_SHORT).show()
            }
            llPoolsContainer -> {
                animateMenuOut()
                Toast.makeText(requireActivity().applicationContext, "En Construcción", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        if (vpMatchesContainer.currentItem != tab?.position.or(0)) {
            vpMatchesContainer.currentItem = tab?.position.or(0)
        }
    }

    override fun onTabUnselected(p0: TabLayout.Tab?) {
        //noop
    }

    override fun onTabReselected(p0: TabLayout.Tab?) {
        //noop
    }

    /**
     * A simple function to animate in the menu top
     */
    private fun animateMenuOut() {
        vBackgroundBlack.visibility = View.GONE
        vBackgroundBlack.alpha = 0f
        isMenuShowing = false
        setAnimation(0f, DAMPING_RATIO_LOW_BOUNCY, STIFFNESS_LOW)
        removeMenuListeners()
    }

    /**
     * A simple function to animate out the menu top
     */
    private fun animateMenuIn() {
        vBackgroundBlack.visibility = View.VISIBLE
        vBackgroundBlack.alpha = 0.5f
        isMenuShowing = true
        setAnimation(300.dp, DAMPING_RATIO_MEDIUM_BOUNCY, STIFFNESS_MEDIUM)
        addMenuListeners()
    }

    /**
     * Sets the animation to avoid repeating this login in both in/out animations
     */
    private fun setAnimation(destination: Float, damping: Float, stiffness: Float){
        // Cancel the last animation
        currentAnimation?.cancel()

        // Init the animation with the damping and stiffness effects
        val anim = SpringAnimation(rlMenuContainer, DynamicAnimation.TRANSLATION_Y, destination)
        anim.spring.dampingRatio = damping
        anim.spring.stiffness = stiffness
        anim.start()
        currentAnimation = anim
    }

    /**
     * Remove listener to avoid multiple clicks in the same item
     */
    private fun removeMenuListeners(){
        llProfileContainer.setOnClickListener(null)
        llConfigContainer.setOnClickListener(null)
        llPoolsContainer.setOnClickListener(null)
    }

    /**
     * Add all the menu listener once the view is ready and the animation is already finished
     */
    private fun addMenuListeners(){
        llProfileContainer.setOnClickListener(this)
        llConfigContainer.setOnClickListener(this)
        llPoolsContainer.setOnClickListener(this)
    }
}