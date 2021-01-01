package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.ShoeDetailFragmentBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: ShoeDetailFragmentBinding
    private val viewModel by activityViewModels<ShoeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.shoe_detail_fragment, container, false)
        binding.lifecycleOwner = this
        binding.shoeModel = Shoe("",0.0,"","")
//        binding.saveButton.setOnClickListener {
//            viewModel.addShoe(binding.shoeModel!!)
//        }
        binding.cancelButton.setOnClickListener {
            findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }

        viewModel.eventAddShoe.observe(viewLifecycleOwner , Observer { isAddShoeComplete ->
            if(isAddShoeComplete){
                findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
                viewModel.onEventAddShoeComplete()
            }
        })

        return binding.root
    }

}