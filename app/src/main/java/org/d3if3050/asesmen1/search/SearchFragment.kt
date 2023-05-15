package org.d3if3050.asesmen1.search


import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputLayout
import org.d3if3050.asesmen1.R
import org.d3if3050.asesmen1.databinding.SearchFragmentBinding
import org.d3if3050.asesmen1.model.Tumbuhan

class SearchFragment : Fragment() {
    private lateinit var binding: SearchFragmentBinding

    private val viewModel: SearchViewModel by lazy { ViewModelProvider(requireActivity())[SearchViewModel::class.java] }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SearchFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.button.setOnClickListener { cariTanaman(binding.tanamanInp.text.toString()) }
        viewModel.listData().observe(requireActivity(), { filtered -> updateUI(filtered) })
    }

    fun cariTanaman(namaTanaman: String) {
        if (TextUtils.isEmpty(namaTanaman)) {
            showError(binding.tanamanHint, "Harap isi data")
            return
        }
        showError(binding.tanamanHint, "")
        val filtered =
            viewModel.fullListData().filter { namaTanaman.equals(it.nama, ignoreCase = true) }
        viewModel._listData.value = filtered
    }

    fun showError(layout: TextInputLayout, error: String) {
        layout.error = error
        layout.requestFocus()
    }

    private fun updateUI(filtered: List<Tumbuhan>) {
        if (filtered.isNotEmpty()) {
            filtered.forEach { tumbuhan ->
                binding.details.visibility = View.VISIBLE
                binding.details.text = context?.getString(R.string.details)
                binding.gambar.visibility = View.VISIBLE
                binding.judulTanaman.visibility = View.VISIBLE
                binding.judulTanaman.text = tumbuhan.nama
                binding.deskripsiTanaman.visibility = View.VISIBLE
                binding.deskripsiTanaman.text = tumbuhan.deskripsi
                binding.cara.visibility = View.VISIBLE
                binding.cara.text = tumbuhan.caraMerawat
                binding.namaLatin.visibility = View.VISIBLE
                binding.namaLatin.text = tumbuhan.namaLatin
            }
            return
        } else {
            showError(binding.tanamanHint, "Data tidak ditemukan")
            binding.details.visibility = View.VISIBLE
            binding.details.text = context?.getString(R.string.data_invalid)
            binding.gambar.visibility = View.GONE
            binding.judulTanaman.visibility = View.GONE
            binding.deskripsiTanaman.visibility = View.GONE
            binding.cara.visibility = View.GONE
            binding.namaLatin.visibility = View.GONE
        }
        return
    }
}
