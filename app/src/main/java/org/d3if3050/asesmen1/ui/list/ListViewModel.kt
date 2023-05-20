package org.d3if3050.asesmen1.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if3050.asesmen1.db.TanamDao

class ListViewModel(private val db: TanamDao) : ViewModel() {

    val data = db.getLastData()

    fun hapusData() = viewModelScope.launch {
        withContext(Dispatchers.IO){
            db.clearData()
        }
    }
}