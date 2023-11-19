package com.example.blocknotas2023

import android.app.Application
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import com.example.blocknotas2023.DataBase.Mnotas.NotasDataBase
import com.example.blocknotas2023.navegation.Navegacion
import com.example.blocknotas2023.ui.theme.BlockNotas2023Theme
import com.example.blocknotas2023.viewModel.AudioViewModel
import com.example.blocknotas2023.viewModel.FotosViewModel
import com.example.blocknotas2023.viewModel.NotasDescriptivasViewModel
import com.example.blocknotas2023.viewModel.NotasViewModel
import com.example.blocknotas2023.viewModel.VideosViewModel

class MainActivity : ComponentActivity() {
    private lateinit var db: NotasDataBase
    private val notasViewModel: NotasViewModel by viewModels()
    private val videosViewModel: VideosViewModel by viewModels()
    private val notasDescriptivasViewModel: NotasDescriptivasViewModel by viewModels()
    private val fotosViewModel: FotosViewModel by viewModels()
    private val audioViewModel: AudioViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = NotasDataBase.getDatabase(applicationContext)
        setContent {
            BlockNotas2023Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navegacion(
                        notasViewModel = notasViewModel,
                        videosViewModel = videosViewModel,
                        notasDescriptivasViewModel = notasDescriptivasViewModel,
                        fotosViewModel = fotosViewModel,
                        audioViewModel = audioViewModel
                    )
                }
            }
        }
    }
}
/*
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BlockNotas2023Theme {
        Navegacion()
    }
}
*/
@Composable
fun rememberNotasViewModel(): NotasViewModel {
    val context = LocalContext.current
    val viewModelStoreOwner = LocalViewModelStoreOwner.current
    val factory = viewModelFactory(context)

    return remember(viewModelStoreOwner, factory) {
        ViewModelProvider(viewModelStoreOwner!!, factory).get(NotasViewModel::class.java)
    }
}
fun viewModelFactory(context: Context): ViewModelProvider.Factory {
    return ViewModelProvider.AndroidViewModelFactory.getInstance(context.applicationContext as Application)
}