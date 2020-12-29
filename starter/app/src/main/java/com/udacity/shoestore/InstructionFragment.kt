package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.InstructionFragmentBinding

class InstructionFragment : Fragment() {

  private lateinit var binding: InstructionFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.instruction_fragment,container,false)
        binding.nextButton.setOnClickListener {
            findNavController().navigate(InstructionFragmentDirections.actionInstructionDestinationToShoeListFragment())
        }
        return binding.root
    }

}