package com.example.autoapp.ui.detailsBackendlessAuto

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.backendless.Backendless
import com.backendless.async.callback.AsyncCallback
import com.backendless.exceptions.BackendlessFault
import com.backendless.persistence.DataQueryBuilder
import com.example.autoapp.data.model.CollectionList
import com.example.autoapp.databinding.FragmentAutoDetailsMbaasBinding
import com.example.autoapp.ui.detailsBackendlessAuto.adapter.SwipeListAdapter
import com.example.autoapp.utils.mbass.Defaults


class AutoDetailsMbaasFragment : Fragment() {

    private var _binding: FragmentAutoDetailsMbaasBinding? = null
    private val binding get() = _binding
    private val adapter by lazy {
        SwipeListAdapter(requireContext())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentAutoDetailsMbaasBinding.inflate(layoutInflater, container, false)
        binding?.rvAutoHorizontal?.adapter = adapter

        val args: String? = arguments?.getString("Good")

        val whereClause = "idCar = $args"
        val queryBuilder = DataQueryBuilder.create()
        queryBuilder.whereClause = whereClause

        Backendless.setUrl(Defaults.SERVER_URL)
        Backendless.initApp(requireContext(), Defaults.APPLICATION_ID, Defaults.API_KEY)

        Backendless.Persistence.of(CollectionList::class.java)
            .find(queryBuilder, object : AsyncCallback<List<CollectionList>> {
                override fun handleResponse(response: List<CollectionList>) {

                    adapter.setData(response)
                    Log.e("BackendlessDetails", "success -> ${response.count()}")
                }

                override fun handleFault(fault: BackendlessFault?) {
                    Log.e("Backendless", "fail -> $fault")
                }

            })

        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}