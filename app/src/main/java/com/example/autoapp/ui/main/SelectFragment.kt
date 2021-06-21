package com.example.autoapp.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.autoapp.R
import com.example.autoapp.databinding.FragmentSelectBinding
import com.example.autoapp.ui.NavControllerBridge

class SelectFragment : Fragment() {

    private lateinit var contactNavController: NavControllerBridge
    private var _binding : FragmentSelectBinding? = null
    private val binding get() = _binding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        contactNavController = context as NavControllerBridge
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentSelectBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.btnMock?.setOnClickListener {
            contactNavController.navController().navigate(R.id.action_selectFragment_to_mainFragment)
        }
        binding?.btnBackendless?.setOnClickListener {
            contactNavController.navController().navigate(R.id.action_selectFragment_to_testFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}