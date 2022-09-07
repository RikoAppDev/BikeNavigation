package dev.riko.bikenavigation.presentation.features.google_maps

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*
import dev.riko.bikenavigation.R
import dev.riko.bikenavigation.presentation.features.google_maps.composables.MapMarker
import dev.riko.bikenavigation.presentation.features.google_maps.composables.SearchBar

@Composable
fun MapsScreen() {
    val school = LatLng(48.93437873185776, 18.14434901446388)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(school, 15f)
    }
    val focusManager = LocalFocusManager.current
    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize()) {
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
        SearchBar()
    }
}
