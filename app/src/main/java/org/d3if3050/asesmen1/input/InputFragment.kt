package org.d3if3050.asesmen1.input

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.d3if3050.asesmen1.databinding.InputFragmentBinding

class InputFragment : Fragment() {

    private lateinit var binding: InputFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = InputFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


}