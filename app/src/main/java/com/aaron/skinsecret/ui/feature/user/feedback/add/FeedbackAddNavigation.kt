package com.aaron.skinsecret.ui.feature.user.feedback.add

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.aaron.skinsecret.ui.TabVM

const val FEEDBACK_ADD_NAVIGATION_ROUTE = "feedback_add"

fun getFeedbackAddNavigationRoute() = FEEDBACK_ADD_NAVIGATION_ROUTE

fun NavGraphBuilder.feedbackAddScreenRoute(
    navController: NavHostController,
    tabVM: TabVM
) {
    composable(
        route = FEEDBACK_ADD_NAVIGATION_ROUTE,
    ) {
        FeedbackAddScreen(
            navController = navController,
            tabVM = tabVM
        )
    }
}
