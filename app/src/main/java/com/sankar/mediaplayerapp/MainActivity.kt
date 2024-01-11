package com.sankar.mediaplayerapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.sankar.mediaplayerapp.databinding.ActivityMainBinding
import com.sankar.mediaplayerapp.service.MusicService

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onDestroy() {
        super.onDestroy()
        val intent = Intent(this,MusicService::class.java)
        intent.putExtra("key","STOP")
        startForegroundService(intent)
    }
}