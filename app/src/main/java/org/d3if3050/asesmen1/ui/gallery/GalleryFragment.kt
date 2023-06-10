package org.d3if3050.asesmen1.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import org.d3if3050.asesmen1.databinding.GalleryFragmentBinding

class GalleryFragment : Fragment() {

    private val viewModel: GalleryViewModel by lazy {
        ViewModelProvider(this)[GalleryViewModel::class.java]
    }

    private lateinit var binding: GalleryFragmentBinding
    private lateinit var myAdapter: GalleryAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = GalleryFragmentBinding.inflate(layoutInflater, container, false)
        myAdapter = GalleryAdapter()
        with(binding.recyclerGallery) {
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
            adapter = myAdapter
            setHasFixedSize(true)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getData().observe(viewLifecycleOwner) {
            myAdapter.updateData(it)
        }
    }
}