package dev.riko.bikenavigation.presentation.navigation

sealed class Screen(val route: String) {

    object MapsScreen : Screen("maps_screen")
    object AboutScreen : Screen("about_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
