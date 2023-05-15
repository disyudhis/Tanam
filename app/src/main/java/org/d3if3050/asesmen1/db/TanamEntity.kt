package org.d3if3050.asesmen1.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tanam")
data class TanamEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var tanggal: Long = System.currentTimeMillis(),
    var namaTanaman: String,
    var namaLatin: String,
    var deskripsi: String,
    var caraMerawat: String
)
