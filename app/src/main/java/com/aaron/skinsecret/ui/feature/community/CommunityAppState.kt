package com.aaron.skinsecret.ui.feature.community

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.aaron.skinsecret.R
import com.aaron.skinsecret.ui.feature.community.detail.getCommunityDetailNavigationRoute
import com.aaron.skinsecret.ui.feature.community.latestnews.getCommunityLatestNewsNavigationRoute
import com.aaron.skinsecret.ui.feature.community.popular.getCommunityPopularNavigationRoute
import com.aaron.skinsecret.ui.feature.community.post.getCommunityPostNavigationRoute

/**
 * todo 1-2 將 BottomBar 的 icon 宣告出來
 * 列出 BottomBar 會出現的 icon
 * @param icon icon
 * @param iconText icon下方的文字
 * @param route 點擊後要導向的路徑/畫面
 * */
enum class TipTopLevelDestination(
    val icon: ImageVector,
    val iconText: String,
    val route: String,
    @StringRes val title: Int
) {
    CommunityMain(
        icon = Icons.Filled.Home,
        iconText = "活動",
        route = getCommunityNavigationRoute(),
        title = R.string.community
    ),
    CommunityPopular(
        icon = Icons.Filled.Home,
        iconText = "活動",
        route = getCommunityPopularNavigationRoute(),
        title = R.string.popular
    ),
    CommunityLatestNews(
        icon = Icons.Filled.Home,
        iconText = "課程",
        route = getCommunityLatestNewsNavigationRoute(),
        title = R.string.latest_news
    ),
    CommunityPost(
        icon = Icons.Filled.Home,
        iconText = "詳細資料",
        route = getCommunityPostNavigationRoute(),
        title = R.string.post
    ),
    CommunityDetail(
        icon = Icons.Filled.Home,
        iconText = "詳細資料",
        route = getCommunityDetailNavigationRoute(),
        title = R.string.detail
    ),
}

/**
 * todo 1-2 宣告 AppState 是處理 NavHostController 的類別
 * */
@Stable
class CommunityAppState(
    private val navController: NavHostController
) {

    /**
     * 這裡是將所有的 TopLevelDestination( BottomBar 裡的 icon ) 都列出來
     * */
    val tipTopLevelDestinations: List<TipTopLevelDestination> = TipTopLevelDestination.entries

    /**
     * 取得當前的路徑
     * */
    private val currentDestination: String?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination?.route


    /**
     * 將當前的路徑轉換成 TopLevelDestination （屬於哪個 BottomBar 分類）
     * */
    val currentTipTopLevelDestination: TipTopLevelDestination?
        @Composable get() {
            return getTopLevelDestination(currentDestination)
        }

    /**
     * 將每個路徑做區分，
     * 例如： HOME / DETAIL 都屬於 HOME 分類，而 SEARCH 屬於 SEARCH 分類
     * */
    private fun getTopLevelDestination(route: String?): TipTopLevelDestination? {
        return when (route) {
            getCommunityNavigationRoute() -> TipTopLevelDestination.CommunityMain
            getCommunityPopularNavigationRoute() -> TipTopLevelDestination.CommunityPopular
            getCommunityLatestNewsNavigationRoute() -> TipTopLevelDestination.CommunityLatestNews
            getCommunityPostNavigationRoute() -> TipTopLevelDestination.CommunityPost
            getCommunityDetailNavigationRoute() -> TipTopLevelDestination.CommunityDetail
            else -> null
        }
    }

    /**
     * 根據目前的路徑，判斷是否顯示 BottomBar
     * */
    val isShowBottomBar: Boolean
        @Composable get() {
            return when (currentDestination) {
                getCommunityNavigationRoute() -> true
                else -> false
            }
        }
}
