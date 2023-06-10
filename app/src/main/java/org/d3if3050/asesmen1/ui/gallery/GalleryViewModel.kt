package org.d3if3050.asesmen1.ui.gallery

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if3050.asesmen1.model.Galeri
import org.d3if3050.asesmen1.network.ApiStatus
import org.d3if3050.asesmen1.network.TanamanApi

class GalleryViewModel : ViewModel() {

    private val data = MutableLiveData<List<Galeri>>()
    private val status = MutableLiveData<ApiStatus>()

    init {
        retrieveData()
    }

    private fun retrieveData() {
        viewModelScope.launch(Dispatchers.IO) {
            status.postValue(ApiStatus.LOADING)
            try {
                data.postValue(TanamanApi.service.getTanaman())
                status.postValue(ApiStatus.SUCCESS)
            } catch (e: java.lang.Exception) {
                Log.d("GalleryViewModel", "Failure: ${e.message}")
                status.postValue(ApiStatus.FAILED)
            }
        }
    }

    fun getData(): LiveData<List<Galeri>> = data
    fun getStatus(): LiveData<ApiStatus> = status


}