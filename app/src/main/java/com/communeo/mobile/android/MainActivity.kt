package com.communeo.mobile.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.communeo.mobile.android.core.ui.AppEntryPoint
import com.communeo.mobile.android.core.ui.theme.CommuneoAndroidTheme
import com.communeo.mobile.android.features.session.ui.viewmodels.SessionViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CommuneoAndroidTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val sessionViewModel: SessionViewModel by viewModels()
                    AppEntryPoint(
                        sessionViewModel = sessionViewModel,
                    )
                }
            }
        }
    }
}
