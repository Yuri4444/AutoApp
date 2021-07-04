package com.example.autoapp.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.autoapp.R
import com.example.autoapp.databinding.FragmentMainBinding
import com.example.autoapp.ui.NavControllerBridge
import com.example.autoapp.ui.detail.DetailFragment
import com.example.autoapp.ui.main.adapter.AutoAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding

    private lateinit var contactNavController: NavControllerBridge
    private val adapter by lazy {
        AutoAdapter(requireContext(), object : AutoAdapter.ClickListener {
            override fun onItemSelected(id: String) {

                val detailFragment = DetailFragment.newInstance(id).requireArguments() 
                contactNavController.navController().navigate(R.id.action_mainFragment_to_detailFragment, detailFragment)
            }
        })
    }
    private val mainFragmentViewModel: MainFragmentViewModel by viewModel()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        contactNavController = context as NavControllerBridge
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        binding?.rvMain?.adapter = adapter

        mainFragmentViewModel.auto.observe(viewLifecycleOwner, { adapter.setData(it) })
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainFragmentViewModel.fetchAutos()

        binding?.fbChange?.setOnClickListener { contactNavController.navController().navigate(R.id.action_mainFragment_to_changeFragment) }
        binding?.fbCreate?.setOnClickListener { contactNavController.navController().navigate(R.id.action_mainFragment_to_createFragment) }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}