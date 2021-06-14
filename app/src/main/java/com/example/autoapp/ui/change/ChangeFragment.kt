package com.example.autoapp.ui.change

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
import com.example.autoapp.databinding.FragmentChangeBinding
import java.util.HashMap
import com.example.autoapp.utils.mbass.Defaults

class ChangeFragment : Fragment() {

    private var _binding: FragmentChangeBinding? = null
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentChangeBinding.inflate(layoutInflater, container, false)

        return binding?.root
    }


}