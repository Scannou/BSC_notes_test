package com.marekfeifrlik.bscnotes.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.marekfeifrlik.bscnotes.R

/**
 * Created by Marek Feifrlik on 05/03/2020.
 */
abstract class BaseFragment : Fragment() {

    @LayoutRes
    protected abstract fun getLayoutResId(): Int

    private var navControllerMain: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutResId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        navControllerMain = Navigation.findNavController(requireActivity(), R.id.navHostFragment)
    }

    protected fun navControllerMain(): NavController? {
        return navControllerMain
    }

    /**
     * Called inside onCreateView method.
     */
    protected open fun initViews() {
        //by default does nothing
    }

}