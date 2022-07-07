package com.example.baseandroidproject.presentation.util

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

fun <T : ViewDataBinding> ViewGroup.inflateDataBinding(
    @LayoutRes layoutResId: Int,
    attachToParent: Boolean = false,
): T {
    return DataBindingUtil.inflate(LayoutInflater.from(context), layoutResId, this, attachToParent)
}

fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}