package org.d3if3050.asesmen1.model

import org.d3if3050.asesmen1.db.TanamEntity

fun TanamEntity.simpanData(): Tumbuhan {
    val tanaman = namaTanaman
    val tanamanLatin = namaLatin
    val deskripsi = deskripsi
    val rawat = caraMerawat
    return Tumbuhan(tanaman, tanamanLatin, deskripsi, rawat)
}