package com.example.autoapp.ui.backendless

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.backendless.Backendless
import com.backendless.async.callback.AsyncCallback
import com.backendless.exceptions.BackendlessFault
import com.example.autoapp.R
import com.example.autoapp.databinding.FragmentListMbaasBinding
import com.example.autoapp.utils.mbass.Defaults
import com.example.autoapp.data.model.AutoList
import com.example.autoapp.ui.NavControllerBridge
import com.example.autoapp.ui.backendless.adapter.AdapterMbaas

class ListMbaasFragment : Fragment() {

    private var _binding: FragmentListMbaasBinding? = null
    private val binding get() = _binding
    private var contactNavController: NavControllerBridge? = null

    private val adapter by lazy { AdapterMbaas(requireContext()) }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        contactNavController = context as NavControllerBridge
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentListMbaasBinding.inflate(layoutInflater, container, false)

        binding?.rvMain?.adapter = adapter

        Backendless.setUrl(Defaults.SERVER_URL)
        Backendless.initApp(requireContext(), Defaults.APPLICATION_ID, Defaults.API_KEY)

        Backendless.Persistence.of(AutoList::class.java)
            .find(object : AsyncCallback<List<AutoList>> {
                override fun handleResponse(response: List<AutoList>?) {
                    adapter.setData(response)
                    Log.e("Success", "response -> $response")
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