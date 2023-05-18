package org.d3if3050.asesmen1.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.d3if3050.asesmen1.db.TanamDao
import org.d3if3050.asesmen1.db.TanamEntity

class SearchViewModel(private val db: TanamDao) : ViewModel() {

    private val hasilTanaman = MutableLiveData<TanamEntity?>()
    fun getHasilTanaman(): LiveData<TanamEntity?> = hasilTanaman

    fun getTanaman(nama: String)  : LiveData<TanamEntity>{
        return db.getTanaman(nama)
    }
}



