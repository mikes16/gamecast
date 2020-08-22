package com.gamecastonline.gamecast.dashboard.slider.recycler.viewholders

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.gamecast.utils.extensions.dp
import com.gamecast.utils.extensions.px
import com.gamecast.utils.extensions.waitForScroll
import com.gamecastonline.gamecast.R
import kotlin.math.floor
import kotlin.math.roundToInt

abstract class MatchesBaseViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    companion object {
        private const val BOX_SIZE = 25
        private const val LOCAL_BOX_MULTIPLIER = 0.4
        private const val VISITOR_BOX_MULTIPLIER = 0.8
    }

    abstract fun bind(value: Map<String, Any>)

    protected fun createBoxes(container: LinearLayout, value: Map<String, Any>) {

        view.waitForScroll { listener ->

            if (container.measuredWidth > 0) {
                view.viewTreeObserver.removeOnScrollChangedListener(listener)

                val containerWidth = container.measuredWidth.px.toInt()
                val numberOfBoxes = howManyInContainer(containerWidth)
                val localBoxPosition = (numberOfBoxes * LOCAL_BOX_MULTIPLIER).roundToInt()
                val visitorBoxPosition = (numberOfBoxes * VISITOR_BOX_MULTIPLIER).roundToInt()

                for (i in 1..numberOfBoxes) {
                    when (i) {
                        localBoxPosition -> addTextViewBox(
                            container,
                            value["local_prediction"].toString()
                        )
                        visitorBoxPosition -> addTextViewBox(
                            container,
                            value["visitor_prediction"].toString()
                        )
                        else -> addTextViewBox(container)
                    }

                }
            }
        }
    }

    private fun howManyInContainer(containerWidth: Int): Int =
        floor((containerWidth / BOX_SIZE).toDouble()).toInt()

    private fun addTextViewBox(container: LinearLayout, value: String = "") {
        val scoreBox = TextView(view.context)
        scoreBox.setBackgroundResource(R.color.color02_15)
        val param = LinearLayout.LayoutParams(
            BOX_SIZE.dp.toInt(),
            ViewGroup.LayoutParams.MATCH_PARENT
        )

        param.marginStart = 1.dp.toInt()
        scoreBox.layoutParams = param
        scoreBox.width = BOX_SIZE.dp.toInt()
        scoreBox.gravity = Gravity.CENTER
        scoreBox.typeface = ResourcesCompat.getFont(view.context, R.font.digital7)
        scoreBox.textSize = 30f
        scoreBox.text = value
        container.addView(scoreBox)
    }
}