package org.d3if3050.asesmen1.input

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import org.d3if3050.asesmen1.R
import org.d3if3050.asesmen1.databinding.InputFragmentBinding

class InputFragment : Fragment() {

    private lateinit var binding: InputFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = InputFragmentBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.action_search) {
            findNavController().navigate(
                R.id.action_inputFragment_to_searchFragment
            )
            return true
        }
        return super.onOptionsItemSelected(item)
    }


}