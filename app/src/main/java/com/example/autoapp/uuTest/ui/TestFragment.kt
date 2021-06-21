package com.example.autoapp.uuTest.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.backendless.Backendless
import com.backendless.async.callback.AsyncCallback
import com.backendless.exceptions.BackendlessFault
import com.example.autoapp.R
import com.example.autoapp.databinding.FragmentTestBinding
import com.example.autoapp.ui.NavControllerBridge
import com.example.autoapp.utils.mbass.Defaults
import com.example.autoapp.uuTest.model.AutoList

class TestFragment : Fragment() {

    private var _binding: FragmentTestBinding? = null
    private val binding get() = _binding

    private lateinit var contactNavController: NavControllerBridge

    override fun onAttach(context: Context) {
        super.onAttach(context)
        contactNavController = context as NavControllerBridge
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentTestBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.btnSave?.setOnClickListener { saveAuto() }
        binding?.btnGoToList?.setOnClickListener {
            contactNavController.navController()
                .navigate(R.id.action_testFragment_to_listMbaasFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun saveAuto() {

        Backendless.setUrl(Defaults.SERVER_URL)
        Backendless.initApp(requireContext(), Defaults.APPLICATION_ID, Defaults.API_KEY)

        val autoList = AutoList()
        autoList.id = binding?.etId?.editableText.toString()
        autoList.image = binding?.etImage?.editableText.toString()
        autoList.title = binding?.etTitle?.editableText.toString()


        Backendless.Data.of(AutoList::class.java).save(autoList, object : AsyncCallback<AutoList> {
            override fun handleResponse(response: AutoList?) {
                Toast.makeText(
                    requireContext(),
                    "Congratulations! All data saved",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun handleFault(fault: BackendlessFault?) {
                Toast.makeText(requireContext(), "Fail, try again", Toast.LENGTH_SHORT).show()
            }

        })

    }

}