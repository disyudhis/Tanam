package org.d3if3050.asesmen1.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TanamDao {

    @Insert
    fun insert(tanam: TanamEntity)

    @Query("SELECT * FROM tanam ORDER BY id DESC")
    fun getLastData(): LiveData<List<TanamEntity>>

    @Query("SELECT * FROM tanam WHERE namaTanaman LIKE '%' || :nama || '%'")
    fun getTanaman(nama: String): TanamEntity

    @Query("DELETE FROM tanam")
    fun clearData()
}