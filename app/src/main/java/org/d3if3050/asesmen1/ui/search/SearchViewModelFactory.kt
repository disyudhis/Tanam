package org.d3if3050.asesmen1.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if3050.asesmen1.db.TanamDao

class SearchViewModelFactory(private val db: TanamDao) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SearchViewModel::class.java)) {

            return SearchViewModel(db) as T
        }
        throw java.lang.IllegalArgumentException("Unknown ViewModel Class")
    }

}