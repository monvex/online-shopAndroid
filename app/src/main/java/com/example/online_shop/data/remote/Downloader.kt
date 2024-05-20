package com.example.online_shop.data.remote

interface Downloader {
    fun downloadFile(url: String, token: String): Long
}