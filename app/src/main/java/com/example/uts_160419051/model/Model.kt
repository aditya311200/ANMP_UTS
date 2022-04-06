package com.example.uts_160419051.model

data class Kuliner (
    val id:String?,
    val nama:String?,
    val deskripsi:String?,
    val jam_buka:String?,
    val jam_tutup:String?,
    val rating:String?,
    val url:String?
)

data class Review(
    val id:String?,
    val nama:String?,
    val isi:String?,
    val url:String?
)