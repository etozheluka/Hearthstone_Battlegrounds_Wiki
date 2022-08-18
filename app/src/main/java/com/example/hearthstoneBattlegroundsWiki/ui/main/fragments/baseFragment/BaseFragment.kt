package com.example.dota2herowiki.ui.main.fragments.baseFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding



typealias Inflater<T> = (inflater : LayoutInflater,view:ViewGroup?,attach:Boolean) -> T


abstract class BaseFragment<VB : ViewBinding>(private val inflater: Inflater<VB>): Fragment() {

    private var _binding: VB? = null
    protected val binding get() = _binding
    protected abstract val viewModel: ViewModel
    abstract fun initRecycler()
    abstract fun httpResponse()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = this.inflater.invoke(inflater,container,false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        httpResponse()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}