package dev.riko.bikenavigation.presentation.features.google_maps

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.android.gms.maps.UiSettings
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*
import dev.riko.bikenavigation.R
import dev.riko.bikenavigation.presentation.features.google_maps.composables.BikeNavDrawer
import dev.riko.bikenavigation.presentation.features.google_maps.composables.MapMarker
import dev.riko.bikenavigation.presentation.features.google_maps.composables.SearchBar
import dev.riko.bikenavigation.presentation.ui.theme.Shapes
import kotlinx.coroutines.launch

@Composable
fun MapsScreen(navController: NavController) {
    val school = LatLng(48.93437873185776, 18.14434901446388)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(school, 15f)
    }
    val focusManager = LocalFocusManager.current
    val context = LocalContext.current

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {
            BikeNavDrawer(navController = navController)
        },
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        drawerElevation = 8.dp,
        drawerShape = RoundedCornerShape(
            topStart = 0.dp,
            topEnd = 16.dp,
            bottomEnd = 16.dp,
            bottomStart = 0.dp
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            GoogleMap(
                modifier = Modifier.matchParentSize(),
                cameraPositionState = cameraPositionState,
                properties = MapProperties(isBuildingEnabled = true),
                onMapClick = {
                    focusManager.clearFocus()
                }
            ) {
                MapMarker(
                    context = context,
                    position = school,
                    title = "Spojená škola sv. Jána Bosca\n- MŠ, ZŠ, Gymnázium, SOŠ",
                    snippet = "Trenčianska 66/28,\n018 51 Nová Dubnica Slovakia",
                    iconResourceId = R.drawable.ic_ssnd
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                Card(
                    modifier = Modifier
                        .padding(22.dp)
                        .size(58.dp),
                    backgroundColor = MaterialTheme.colors.background,
                    shape = Shapes.large,
                    elevation = 8.dp
                ) {
                    IconButton(onClick = {
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "menu",
                            tint = MaterialTheme.colors.primary
                        )
                    }
                }
                SearchBar()
            }
        }
    }
}
