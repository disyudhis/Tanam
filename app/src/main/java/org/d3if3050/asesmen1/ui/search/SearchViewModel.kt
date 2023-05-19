package org.d3if3050.asesmen1.ui.search

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if3050.asesmen1.db.TanamDao
import org.d3if3050.asesmen1.db.TanamEntity

class SearchViewModel(private val db: TanamDao) : ViewModel() {

    var hasilTanaman = MutableLiveData<TanamEntity>()

    val data = db.getLastData()

    fun getTanaman(nama: String) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            hasilTanaman.value = db.getTanaman(nama)
        }

    }


}



