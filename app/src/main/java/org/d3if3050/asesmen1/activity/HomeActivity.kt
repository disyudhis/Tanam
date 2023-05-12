package org.d3if3050.asesmen1.activity


import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import org.d3if3050.asesmen1.R
import org.d3if3050.asesmen1.databinding.ActivityHomeBinding
import org.d3if3050.asesmen1.model.Tumbuhan
import org.d3if3050.asesmen1.viewModel.HomeViewModel

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    private val viewModel: HomeViewModel by lazy { ViewModelProvider(this)[HomeViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener { viewModel.cariTanaman(binding.tanamanInp.text.toString()) }
        viewModel.listData.observe(this, { filtered -> updateUI(filtered) })
    }

        private fun updateUI(filtered: List<Tumbuhan>) {
            if (filtered.isNotEmpty()) {
                filtered.forEach { tumbuhan ->
                    binding.details.visibility = View.VISIBLE
                    binding.details.text = getString(R.string.details)
                    binding.gambar.visibility = View.VISIBLE
                    binding.gambar.setImageResource(tumbuhan.imageResId)
                    binding.judulTanaman.visibility = View.VISIBLE
                    binding.judulTanaman.text = tumbuhan.nama
                    binding.deskripsiTanaman.visibility = View.VISIBLE
                    binding.deskripsiTanaman.text = tumbuhan.deskripsi
                    binding.cara.visibility = View.VISIBLE
                    binding.cara.text = tumbuhan.caraMerawat
                    binding.namaLatin.visibility = View.VISIBLE
                    binding.namaLatin.text = tumbuhan.namaLatin
                }
            } else {
                binding.details.visibility = View.VISIBLE
                binding.details.text = getString(R.string.data_invalid)
                binding.gambar.visibility = View.GONE
                binding.judulTanaman.visibility = View.GONE
                binding.deskripsiTanaman.visibility = View.GONE
                binding.cara.visibility = View.GONE
                binding.namaLatin.visibility = View.GONE
            }
        }
    }
