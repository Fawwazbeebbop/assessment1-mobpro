package org.d3if3051.assessmen1.navigation

sealed class ScreenApp(val route: String) {
    data object Home: ScreenApp("firstScreen")
    data object Content: ScreenApp("appScreen")
    data object List: ScreenApp("historyScreen")
}