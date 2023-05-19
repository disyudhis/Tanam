package org.d3if3050.asesmen1.ui.about

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import org.d3if3050.asesmen1.R
import org.d3if3050.asesmen1.databinding.AboutFragmentBinding

class AboutFragment : Fragment() {
    private lateinit var binding: AboutFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AboutFragmentBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.about_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_bagi) {
            shareApp()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    fun shareApp() {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_SUBJECT, requireActivity().getString(R.string.app_name))
        intent.putExtra(
            Intent.EXTRA_TEXT,
            "Ayo dapatkan informasi lebih lanjut tentang tanaman di aplikasi Tanam"
        )
        requireActivity().startActivity(Intent.createChooser(intent, "Bagikan melalui"))
    }
}