package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.ShoeListFragmentBinding
import com.udacity.shoestore.databinding.ShoeItemBinding


class ShoeListFragment : Fragment() {

    private val viewModel by activityViewModels<ShoeViewModel>()
    private lateinit var binding: ShoeListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.shoe_list_fragment, container, false)
        setHasOptionsMenu(true)
        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }

        viewModel.shoeList.observe(viewLifecycleOwner, Observer {
            it.forEach {
                val itemBinding: ShoeItemBinding =
                    DataBindingUtil.inflate(inflater, R.layout.shoe_item, container, false)
                itemBinding.shoeItem = it
                binding.shoeListLayout.addView(itemBinding.root)
            }
        })

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.navdrawer_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId ){
            R.id.logout_menu -> findNavController().navigate(ShoeListFragmentDirections.actionShoelistDestinationToLoginFragment())
        }
        return super.onOptionsItemSelected(item)
    }
}