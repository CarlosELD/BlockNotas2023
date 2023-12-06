package com.example.blocknotas2023

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.blocknotas2023.DataBase.Mnotas.MensajesDataBase
import com.example.blocknotas2023.DataBase.Mnotas.RepositorioMsg
import com.example.blocknotas2023.navegation.Navegacion
import com.example.blocknotas2023.ui.theme.BlockNotas2023Theme
import com.example.blocknotas2023.viewModel.AudioViewModel
import com.example.blocknotas2023.viewModel.FotosViewModel
import com.example.blocknotas2023.viewModel.MensajesViewModel
import com.example.blocknotas2023.viewModel.VideosViewModel

class MainActivity : ComponentActivity() {
    private lateinit var db: MensajesDataBase
    lateinit var notasViewModel: MensajesViewModel
    private val videosViewModel: VideosViewModel by viewModels()
    private val fotosViewModel: FotosViewModel by viewModels()
    private val audioViewModel: AudioViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = MensajesDataBase.getDatabase(applicationContext)
        notasViewModel = MensajesViewModel(RepositorioMsg(db.msgDao()))
        setContent {
            BlockNotas2023Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navegacion(
                        mensajesViewModel = notasViewModel,
                        videosViewModel = videosViewModel,
                        fotosViewModel = fotosViewModel,
                        audioViewModel = audioViewModel
                    )
                }
            }
        }
    }
}