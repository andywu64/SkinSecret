package com.aaron.skinsecret.ui.feature.user.feedback

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.aaron.skinsecret.ui.TabVM

const val FEEDBACK_NAVIGATION_ROUTE = "feedback"

fun getFeedbackNavigationRoute() = FEEDBACK_NAVIGATION_ROUTE

fun NavGraphBuilder.feedbackScreenRoute(
    navController: NavHostController,
    tabVM: TabVM
) {
    composable(
        route = FEEDBACK_NAVIGATION_ROUTE,
    ) {
        FeedbackScreen(
            navController = navController,
            tabVM = tabVM
        )
    }
}
