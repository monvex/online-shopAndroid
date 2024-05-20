package com.example.online_shop.data

import android.app.DownloadManager
import android.content.Context
import android.os.Environment
import androidx.core.net.toUri
import com.example.online_shop.data.dataStore.TokenManager
import com.example.online_shop.data.remote.Downloader
import javax.inject.Inject

class AndroidDownloader(
    private val context: Context

): Downloader {
    private val downloadManager = context.getSystemService(DownloadManager::class.java)

    override fun downloadFile(url: String , token: String): Long {
        val request = DownloadManager.Request(url.toUri())
            .setMimeType("image/jpeg")
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            .addRequestHeader("Authorization", token)
        return downloadManager.enqueue(request)
    }

}