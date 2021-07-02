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
import com.example.autoapp.data.model.CollectionList
import com.example.autoapp.ui.NavControllerBridge
import com.example.autoapp.ui.backendless.adapter.AdapterMbaas
import com.example.autoapp.ui.detailsBackendlessAuto.adapter.SwipeListAdapter

class ListMbaasFragment : Fragment() {

    private var _binding: FragmentListMbaasBinding? = null
    private val binding get() = _binding
    private var contactNavController: NavControllerBridge? = null

    private val adapter by lazy { AdapterMbaas(requireContext()) }

    private val adapterSwipe by lazy { SwipeListAdapter(requireContext()) }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        contactNavController = context as NavControllerBridge
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentListMbaasBinding.inflate(layoutInflater, container, false)

        binding?.rvMain?.adapter = adapter

        setMainRecyclerView()
        setDaughterRecyclerView()

        return binding?.root
    }

    private fun setMainRecyclerView() {
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
    }

    private fun setDaughterRecyclerView() {
        Backendless.setUrl(Defaults.SERVER_URL)
        Backendless.initApp(requireContext(), Defaults.APPLICATION_ID, Defaults.API_KEY)

        Backendless.Persistence.of(CollectionList::class.java)
            .find(object : AsyncCallback<List<CollectionList>> {
                override fun handleResponse(response: List<CollectionList>?) {
                    adapterSwipe.setData(response)
                    Log.e("Success", "response -> $response")
                }

                override fun handleFault(fault: BackendlessFault?) {

                }

            })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}