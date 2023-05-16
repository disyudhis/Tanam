package org.d3if3050.asesmen1.input

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if3050.asesmen1.db.TanamDao
import org.d3if3050.asesmen1.db.TanamEntity
import org.d3if3050.asesmen1.model.Tumbuhan
import org.d3if3050.asesmen1.model.simpanData

class InputViewModel(private val db: TanamDao) : ViewModel() {

    private val hasilTanam = MutableLiveData<Tumbuhan?>()

    val data = db.getLastData()

    fun simpanData(namaTanaman: String, namaLatin: String, deskripsi: String, caraMerawat: String) {

        val dataTanaman = TanamEntity(
            namaTanaman = namaTanaman,
            namaLatin =  namaLatin,
            deskripsi = deskripsi,
            caraMerawat = caraMerawat
        )
        hasilTanam.value = dataTanaman.simpanData()
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                db.insert(dataTanaman)
            }
        }

    }

}