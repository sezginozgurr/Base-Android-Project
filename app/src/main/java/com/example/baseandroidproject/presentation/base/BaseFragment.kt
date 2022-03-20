package com.example.baseandroidproject.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<Binding : ViewBinding> : Fragment() {

    private lateinit var binding: Binding
    abstract val layoutResId: Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (::binding.isInitialized.not()) {
            binding = DataBindingUtil.inflate(inflater, layoutResId, container, false)
            initBinding()
            onInit(savedInstanceState)
        }
        return binding.root
    }

    open fun initBinding() {}

    open fun onInit(savedInstanceState: Bundle?) {}

}