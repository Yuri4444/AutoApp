package com.example.autoapp.uuTest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.backendless.Backendless
import com.backendless.async.callback.AsyncCallback
import com.backendless.exceptions.BackendlessFault
import com.example.autoapp.databinding.FragmentListMbaasBinding
import com.example.autoapp.utils.mbass.Defaults
import com.example.autoapp.uuTest.model.AutoList
import com.example.autoapp.uuTest.ui.adapter.AdapterMbaas

class ListMbaasFragment : Fragment() {

    private var _binding: FragmentListMbaasBinding? = null
    private val binding get() = _binding

    private val adapter by lazy { AdapterMbaas(requireContext()) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentListMbaasBinding.inflate(layoutInflater, container, false)

        binding?.rvMain?.adapter = adapter

        Backendless.setUrl(Defaults.SERVER_URL)
        Backendless.initApp(requireContext(), Defaults.APPLICATION_ID, Defaults.API_KEY)

        Backendless.Persistence.of(AutoList::class.java)
            .find(object : AsyncCallback<List<AutoList>> {
                override fun handleResponse(response: List<AutoList>?) {
                    adapter.setData(response)
                }

                override fun handleFault(fault: BackendlessFault?) {

                }

            })
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}