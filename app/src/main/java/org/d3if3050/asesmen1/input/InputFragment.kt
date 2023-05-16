package org.d3if3050.asesmen1.input

import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputLayout
import org.d3if3050.asesmen1.R
import org.d3if3050.asesmen1.databinding.InputFragmentBinding
import org.d3if3050.asesmen1.db.TanamDb

class InputFragment : Fragment() {

    private lateinit var binding: InputFragmentBinding
    private val viewModel: InputViewModel by lazy {
        val db = TanamDb.getInstance(requireContext())
        val factory = InputViewModelFactory(db.dao)
        ViewModelProvider(this, factory)[InputViewModel::class.java]
    }

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
        when (item.itemId) {
            R.id.action_search -> {
                findNavController().navigate(
                    R.id.action_inputFragment_to_searchFragment
                )
                return true
            }
            R.id.action_list -> {
                findNavController().navigate(
                    R.id.action_inputFragment_to_listFragment
                )
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.buttonInput.setOnClickListener { simpanData() }
    }

    fun simpanData() {
        val namaTanaman = binding.inputJudul.text.toString()
        if (TextUtils.isEmpty(namaTanaman)) {
            showError(binding.hintJudul, "Nama Tanaman harus diisi")
            return
        } else {
            showError(binding.hintJudul, "")
        }

        val namaLatin = binding.inputNamaLatin.text.toString()
        if (TextUtils.isEmpty(namaLatin)) {
            showError(binding.hintNamaLatin, "Nama Latin harus diisi")
            return
        } else {
            showError(binding.hintNamaLatin, "")
        }

        val deskripsi = binding.inputDeskripsi.text.toString()
        if (TextUtils.isEmpty(deskripsi)) {
            showError(binding.hintDeskripsi, "Deskripsi harus diisi")
            return
        } else if (deskripsi.length < 25) {
            showError(binding.hintDeskripsi, "Deskripsi harus berisi minimal 20 karakter")
            return
        } else {
            showError(binding.hintDeskripsi, "")
        }

        val rawat = binding.inputRawat.text.toString()
        if (TextUtils.isEmpty(rawat)) {
            showError(binding.hintRawat, "Cara merawat harus diisi")
            return
        } else if (rawat.length < 25) {
            showError(binding.hintRawat, "Cara merawat harus berisi minimal 20 karakter")
            return
        } else {
            showError(binding.hintRawat, "")
        }

        viewModel.simpanData(
            namaTanaman, namaLatin, deskripsi, rawat
        )
        viewModel.data.observe(viewLifecycleOwner) {
            if (it != null) {
                Toast.makeText(context, "Data berhasil disimpan", Toast.LENGTH_LONG).show()
                clearData()
            } else {
                Toast.makeText(context, "Data gagal ditambahkan", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun clearData() {
        binding.inputJudul.text?.clear()
        binding.inputNamaLatin.text?.clear()
        binding.inputDeskripsi.text?.clear()
        binding.inputRawat.text?.clear()
    }

    fun showError(layout: TextInputLayout, error: String) {
        layout.error = error
        layout.requestFocus()
    }
}