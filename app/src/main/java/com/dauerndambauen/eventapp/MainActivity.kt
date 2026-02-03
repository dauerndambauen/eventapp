package com.dauerndambauen.eventapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.dauerndambauen.eventapp.ui.theme.EventappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EventappTheme {
                EventappApp()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@PreviewScreenSizes
@Composable
fun EventappApp() {
    var currentDestination by rememberSaveable { mutableStateOf(AppDestinations.Current) }

    Scaffold(
        bottomBar = {
            BottomAppBar {
                AppDestinations.entries.forEach {

                    NavigationBarItem(
                        onClick = { currentDestination = it},
                        selected = it == currentDestination,
                        icon = { Icon(
                            it.icon,
                            contentDescription = it.label
                        )},
                        label = { Text(it.label)}
                    )
                }
            }
        }
    ) { contentPadding ->
        CallenderImport(
            Modifier.padding(contentPadding)
        )
    }

}

enum class AppDestinations(
    val label: String,
    val icon: ImageVector,
) {
    History("History", Icons.Default.Refresh),
    Current("Plans", Icons.Default.DateRange),
    Settings("Settings", Icons.Default.Settings),
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EventappTheme {
        Greeting("Android")
    }
}

@Composable
fun CallenderImport(
    modifier: Modifier = Modifier
){
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize(),
    ) {
        Callender.date(1, 1, 2023)
    }
}
