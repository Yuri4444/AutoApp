package com.example.autoapp.ui.create

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.backendless.Backendless
import com.backendless.IDataStore
import com.backendless.async.callback.AsyncCallback
import com.backendless.exceptions.BackendlessFault
import com.example.autoapp.data.model.AutoDetail
import com.example.autoapp.databinding.FragmentCreateBinding
import com.example.autoapp.utils.mbass.Defaults
import java.util.HashMap
import org.koin.androidx.viewmodel.ext.android.viewModel

class CreateFragment : Fragment() {

    private var _binding: FragmentCreateBinding? = null
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentCreateBinding.inflate(layoutInflater, container, false)

        Backendless.setUrl(Defaults.SERVER_URL)
        Backendless.initApp(requireContext(), Defaults.APPLICATION_ID, Defaults.API_KEY)
        binding?.btnCreate?.isEnabled = false

        val titleObject = HashMap<Any?, Any?>()
        titleObject["id"] = "Spider-man"
        titleObject["image"] = "Spider-man1"
        titleObject["title"] = "Spider-man2"
        titleObject["objectId"] = "Spider-man"
        val title = Backendless.Data.of("AutoList")
        title.save(titleObject, object : AsyncCallback<MutableMap<Any?, Any?>> {
            override fun handleResponse(response: MutableMap<Any?, Any?>) {
//                subscribeForObjectUpdate(response, title)
//
//                binding?.btnCreate?.setOnClickListener { updateValue(response, title) }

//                changeSavedValue(response)
//                binding?.btnCreate?.isEnabled = true
                Toast.makeText(requireContext(), "Congratulations! All data saved", Toast.LENGTH_SHORT).show()
            }

            override fun handleFault(fault: BackendlessFault) {
                Toast.makeText(requireContext(), "Fail, try again", Toast.LENGTH_SHORT).show()
//                handleFaultToast(fault)
            }
        })


        return binding?.root
    }

//    private fun updateValue(response: MutableMap<Any?, Any?>, testTableDataStore: IDataStore<Map<Any?, Any?>>) {
//        binding?.btnCreate?.isEnabled = false
//
//        response["Title"] = binding?.includeEditDetail?.etTitle?.text.toString()
//        testTableDataStore.save(response, object : AsyncCallback<Map<Any?, Any?>> {
//            override fun handleResponse(response: Map<Any?, Any?>) {
//                Log.i("MYAPP", "saved $response")
//                binding?.btnCreate?.isEnabled = true
//                binding?.includeEditDetail?.etTitle?.setText("")
//            }
//
//            override fun handleFault(fault: BackendlessFault) {
//                handleFaultToast(fault)
//            }
//        })
//    }
//
//    private fun subscribeForObjectUpdate(response: Map<Any?, Any?>, testTableDataStore: IDataStore<Map<Any?, Any?>>) {
//        testTableDataStore.rt().addUpdateListener("objectId='${response["objectId"]}'",
//            object : AsyncCallback<Map<Any?, Any?>> {
//                override fun handleResponse(response: Map<Any?, Any?>) {
////                    changeSavedValue(response)
//                }
//
//                override fun handleFault(fault: BackendlessFault) {
//                    handleFaultToast(fault)
//                }
//            })
//    }
//
//    private fun handleFaultToast(fault: BackendlessFault) {
//        val msg = "Server reported an error ${fault.message}"
//        Log.e("MYAPP", msg)
//        Toast.makeText(requireContext(), "Saved", Toast.LENGTH_SHORT).show()
//        binding?.btnCreate?.isEnabled = true
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}