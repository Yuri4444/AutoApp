package com.example.autoapp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.autoapp.databinding.FragmentMainBinding
import org.koin.dsl.module
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.autoapp.ui.main.adapter.AutoAdapter

val mainFragmentModule = module {
    factory { MainFragment() }
}

class MainFragment : Fragment() {

    private var _binding : FragmentMainBinding? = null
    private val binding get() = _binding

    private val adapter by lazy { AutoAdapter(requireContext()) }
    private val mainFragmentViewModel: MainFragmentViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)

        binding?.rvMain?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding?.rvMain?.adapter = adapter

//        mViewModel.bookmarksList.observe(viewLifecycleOwner, Observer { adapter.setItems(it) })

        mainFragmentViewModel.auto.observe(viewLifecycleOwner, Observer { adapter.setData(it) } )

        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}