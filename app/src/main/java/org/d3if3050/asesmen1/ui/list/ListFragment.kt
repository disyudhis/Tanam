package org.d3if3050.asesmen1.ui.list

import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.coroutines.launch
import org.d3if3050.asesmen1.R
import org.d3if3050.asesmen1.databinding.ListFragmentBinding
import org.d3if3050.asesmen1.db.SettingsDataStore
import org.d3if3050.asesmen1.db.TanamDb
import org.d3if3050.asesmen1.db.dataStore

class ListFragment : Fragment(){


    private val viewModel: ListViewModel by lazy {
        val db = TanamDb.getInstance(requireContext())
        val factory = ListViewModelFactory(db.dao)
        ViewModelProvider(this, factory)[ListViewModel::class.java]
    }

    private lateinit var binding: ListFragmentBinding
    private lateinit var myAdapter: ListAdapter
    private var isLinearLayout = true
    private val layoutDataStore: SettingsDataStore by lazy {
        SettingsDataStore(requireContext().dataStore)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ListFragmentBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myAdapter = ListAdapter()
        with(binding.recyclerView) {
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
            adapter = myAdapter
            setHasFixedSize(true)
        }
        layoutDataStore.preferenceFlow.asLiveData().observe(viewLifecycleOwner) {
            isLinearLayout = it
            setLayout()
            activity?.invalidateOptionsMenu()
        }
        viewModel.data.observe(viewLifecycleOwner) {
            binding.emptyView.visibility = if (it.isEmpty())
                View.VISIBLE else View.GONE
            myAdapter.submitList(it)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.list_menu, menu)

        val menuItem = menu.findItem(R.id.switch_layout)
        setIcon(menuItem)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_hapus) {
            lifecycleScope.launch {
                hapusData()
            }
        }
        if (item.itemId == R.id.switch_layout) {
            lifecycleScope.launch {
                layoutDataStore.saveLayout(!isLinearLayout, requireContext())
            }
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    fun hapusData() {
        MaterialAlertDialogBuilder(requireContext())
            .setMessage(R.string.konfirmasi_hapus)
            .setPositiveButton(getString(R.string.hapus)) { _, _ ->
                viewModel.hapusData()
            }
            .setNegativeButton(getString(R.string.batal)) { dialog, _ ->
                dialog.cancel()
            }
            .show()
    }

    fun setLayout() {
        binding.recyclerView.layoutManager = if (isLinearLayout)
            LinearLayoutManager(context)
        else
            GridLayoutManager(context, 2)
    }

    fun setIcon(menuItem: MenuItem) {
        val iconId = if (isLinearLayout)
            R.drawable.ic_grid
        else
            R.drawable.ic_view
        menuItem.icon = ContextCompat.getDrawable(requireContext(), iconId)
    }

}