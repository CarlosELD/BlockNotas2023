@file:Suppress("DEPRECATION", "NAME_SHADOWING")

package com.example.blocknotas2023

import android.net.Uri
import android.widget.VideoView
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.blocknotas2023.DataBase.Mcamara.MediaItem
import com.example.blocknotas2023.DataBase.Mcamara.MediaType
import com.example.blocknotas2023.components.ComposeFileProvider
import com.example.blocknotas2023.viewModel.MediaViewModel

@Composable
fun TomarFoto(
    modifier: Modifier = Modifier,
    navController: NavController,
    mediaViewModel: MediaViewModel,
) {
    var uri: Uri? = null
    var hasImage by remember { mutableStateOf(false) }
    var hasVideo by remember { mutableStateOf(false) }
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val mediaItems by mediaViewModel.mediaItems.collectAsState()
    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            hasImage = uri != null
            imageUri = uri
            imageUri?.let {
                mediaViewModel.insertMediaItem(MediaItem(uri = it.toString(), type = MediaType.IMAGE))
            }
        }
    )

    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture(),
        onResult = { success ->
            if (success) imageUri = uri
            hasImage = success
            imageUri?.let {
                mediaViewModel.insertMediaItem(MediaItem(uri = it.toString(), type = MediaType.IMAGE))
            }
        }
    )

    val videoLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.CaptureVideo(),
        onResult = { success ->
            hasVideo = success
            imageUri?.let {
                mediaViewModel.insertMediaItem(MediaItem(uri = it.toString(), type = MediaType.VIDEO))
            }
        }
    )

    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        LazyColumn {
            items(mediaItems) { mediaItem ->
                Text(text = mediaItem.uri)
            }
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
        ) {
            if ((hasImage or hasVideo) && imageUri != null) {
                if (hasImage) {
                    AsyncImage(
                        model = imageUri,
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1f),
                        contentDescription = "Imagen seleccionada",
                    )
                }
                if (hasVideo) {
                    VideoPlayer(videoUri = imageUri!!, modifier = Modifier.fillMaxSize())
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Button(
                onClick = { imagePicker.launch("image/*") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                Text(text = "seleccionar foto", color = Color.Black)
            }
            Button(
                onClick = {
                    uri = ComposeFileProvider.getImageUri(context)
                    cameraLauncher.launch(uri)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                Text(text = "Tomar foto", color = Color.Black)
            }
            Button(
                onClick = {
                    val uri = ComposeFileProvider.getImageUri(context)
                    videoLauncher.launch(uri)
                    imageUri = uri
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Grabar video", color = Color.Black)
            }
        }
    }
}

@Composable
fun VideoPlayer(videoUri: Uri, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val videoView = remember { VideoView(context) }
    AndroidView(
        factory = { videoView },
        modifier = modifier
    ) { view ->
        view.setVideoURI(videoUri)
        view.start()
    }
}