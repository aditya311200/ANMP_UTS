package com.example.uts_160419051.model

data class Kuliner (
    val id:String?,
    val nama:String?,
    val deskripsi:String?,
    val jam_buka:String?,
    val jam_tutup:String?,
    val rating:String?,
    val review:List<Review>
)

data class Review(
    val id:String?,
    val nama:String?,
    val isi:String?
)