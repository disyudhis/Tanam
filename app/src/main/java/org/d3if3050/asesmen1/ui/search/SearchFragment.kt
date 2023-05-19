package org.d3if3050.asesmen1.ui.search


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputLayout
import org.d3if3050.asesmen1.databinding.SearchFragmentBinding
import org.d3if3050.asesmen1.db.TanamDb
import org.d3if3050.asesmen1.db.TanamEntity

class SearchFragment : Fragment() {
    private lateinit var binding: SearchFragmentBinding

    private val viewModel: SearchViewModel by lazy {
        val db = TanamDb.getInstance(requireContext())
        val factory = SearchViewModelFactory(db.dao)
        ViewModelProvider(this, factory)[SearchViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SearchFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.button.setOnClickListener { cariTanaman() }
        viewModel.hasilTanaman.observe(viewLifecycleOwner) {
            updateUI(it)
        }
    }

    fun cariTanaman() {
        val namaTanaman = binding.tanamanInp.text ?: return
        if (namaTanaman.isEmpty()) {
        }
        viewModel.getTanaman(namaTanaman.toString())
    }

    fun showError(layout: TextInputLayout, error: String) {
        layout.error = error
        layout.requestFocus()
    }

    private fun updateUI(filtered: TanamEntity?) {
        if (filtered == null) {
            return showError(binding.tanamanHint, "Data tidak ditemukan")
        }
        Log.d("update", filtered.namaTanaman)
        binding.gambar.isVisible = true
        binding.card.isVisible = true
        binding.judulTanaman.isVisible = true
        binding.deskripsiTanaman.isVisible = true
        binding.cara.isVisible = true
        binding.namaLatin.isVisible = true
        binding.judulTanaman.text = filtered.namaTanaman
        binding.deskripsiTanaman.text = filtered.deskripsi
        binding.cara.text = filtered.caraMerawat
        binding.namaLatin.text = filtered.namaLatin
    }
}
