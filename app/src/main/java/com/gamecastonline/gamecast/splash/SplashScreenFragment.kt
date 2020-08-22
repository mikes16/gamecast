package com.gamecastonline.gamecast.splash

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.gamecast.utils.extensions.hideSystemUI
import com.gamecast.utils.extensions.showSystemUI
import com.gamecastonline.gamecast.R
import com.gamecastonline.gamecast.base.annotation.VMFragment
import com.gamecastonline.gamecast.base.viewModel.ViewModelFragment
import kotlinx.android.synthetic.main.fragment_splash_screen.*

@VMFragment(R.layout.fragment_splash_screen)
class SplashScreenFragment : ViewModelFragment<SplashScreenViewModel>(SplashScreenViewModel::class) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().window.hideSystemUI()
    }

    override fun onDestroyView() {
        requireActivity().window.showSystemUI()
        super.onDestroyView()
    }

    override fun setupViews(savedInstanceState: Bundle?) {
        //Noop
    }

    override fun subscribeToViewModel(viewModel: SplashScreenViewModel) {
        viewModel.screenLoadingEnd().observe(viewLifecycleOwner, Observer {
            tvLetterC.text = "C"
            tvLetterG.text = "G"
            tvTitle
                .animate()
                .alpha(1f)
                .setDuration(1000)
                .withEndAction {
                    findNavController().navigate(R.id.action_splashScreenFragment_to_dashboardFragment)
                }
        })

        viewModel.letterUpdate().observe(viewLifecycleOwner, Observer { letter ->
            tvLetterC.text = letter
        })
    }

}