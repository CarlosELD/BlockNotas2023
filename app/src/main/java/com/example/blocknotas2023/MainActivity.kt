package com.example.blocknotas2023

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.blocknotas2023.DataBase.Mcamara.MediaDatabase
import com.example.blocknotas2023.DataBase.Mcamara.MediaRepository
import com.example.blocknotas2023.DataBase.Mnotas.MensajesDataBase
import com.example.blocknotas2023.DataBase.Mnotas.RepositorioMsg
import com.example.blocknotas2023.navegation.Navegacion
import com.example.blocknotas2023.ui.theme.BlockNotas2023Theme
import com.example.blocknotas2023.viewModel.AudioViewModel
import com.example.blocknotas2023.viewModel.MediaViewModel
import com.example.blocknotas2023.viewModel.MensajesViewModel

class MainActivity : ComponentActivity() {
    private lateinit var db: MensajesDataBase
    private lateinit var db1: MediaDatabase
    lateinit var notasViewModel: MensajesViewModel
    lateinit var fotosViewModel: MediaViewModel
    private val audioViewModel: AudioViewModel by viewModels()
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = MensajesDataBase.getDatabase(applicationContext)
        db1 = MediaDatabase.getDatabase(applicationContext)
        notasViewModel = MensajesViewModel(RepositorioMsg(db.msgDao()))
        fotosViewModel = MediaViewModel(MediaRepository(db1.mediaDao()))
        setContent {
            BlockNotas2023Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        Navegacion(
                            mensajesViewModel = notasViewModel,
                            fotosViewModel = fotosViewModel,
                            audioViewModel = audioViewModel
                        )
                    }
                }
            }
        }
    }
}