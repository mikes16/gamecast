package com.gamecastonline.gamecast.base.viewModel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gamecastonline.gamecast.base.annotation.VMFragment
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.core.parameter.DefinitionParameters
import org.koin.core.parameter.emptyParametersHolder
import kotlin.reflect.KClass

@VMFragment(0)
abstract class ViewModelFragment<ModelT : BaseViewModel>(
    viewModelClass: KClass<ModelT>
) : Fragment() {

    protected val viewModel: ModelT by lazy {
        getViewModel(clazz = viewModelClass)
    }

    //override in case custom params needed
    protected open val viewModelParams: DefinitionParameters = emptyParametersHolder()

    private fun getLayoutId(): Int
            = javaClass.getAnnotation(VMFragment::class.java)?.layoutId
        ?: throw IllegalArgumentException("Missing VMFragment Annotation")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater.inflate(getLayoutId(), container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupViews(savedInstanceState)
        subscribeToViewModel(viewModel)
    }

    /**
     * View setup goes here.
     */
    protected abstract fun setupViews(savedInstanceState: Bundle?)

    /**
    * ViewModel observes goes here.
    */
    protected abstract fun subscribeToViewModel(viewModel: ModelT)
}