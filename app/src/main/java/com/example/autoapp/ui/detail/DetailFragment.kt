package com.example.autoapp.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.autoapp.data.AutoDetail
import com.example.autoapp.databinding.FragmentDetailBinding
import com.example.autoapp.utils.constants.Constants.ID_ITEM_AUTO
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding

    private val detailFragmentViewModel: DetailFragmentViewModel by viewModel()

    private fun bindData(itemId: String, list: List<AutoDetail>) {
        val correctList = list.filter { it.id == itemId }[0]

        binding?.imImageAuto?.let { Glide.with(requireContext()).load(correctList.image).into(it) }
        binding?.tvTitle?.text = correctList.title
        binding?.includeAutoDetail?.tvProducer?.text = correctList.producer
        binding?.includeAutoDetail?.tvModel?.text = correctList.model
        binding?.includeAutoDetail?.tvYearOfIssue?.text = correctList.year
        binding?.includeAutoDetail?.tvCost?.text = correctList.cost
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentDetailBinding.inflate(layoutInflater, container, false)

        val args: String? = arguments?.getString(ID_ITEM_AUTO)
        detailFragmentViewModel.autoDetail.observe(viewLifecycleOwner, { autoDetail ->
            args?.let { id ->
                bindData(id, autoDetail)
            }
        })
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailFragmentViewModel.fetchAutosDetail()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}