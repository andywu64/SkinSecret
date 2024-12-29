package com.aaron.skinsecret.ui.feature.user

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.aaron.skinsecret.R
import com.aaron.skinsecret.ui.feature.user.feedback.add.getFeedbackAddNavigationRoute
import com.aaron.skinsecret.ui.feature.user.feedback.getFeedbackNavigationRoute
import com.aaron.skinsecret.ui.feature.user.maintain.add.getMaintainAddNavigationRoute
import com.aaron.skinsecret.ui.feature.user.maintain.getMaintainNavigationRoute
import com.aaron.skinsecret.ui.feature.user.myfavorites.getMyFavoritesNavigationRoute
import com.aaron.skinsecret.ui.feature.user.userInfo.accountinfo.getAccountInfoNavigationRoute
import com.aaron.skinsecret.ui.feature.user.userInfo.introduce.getIntroduceNavigationRoute
import com.aaron.skinsecret.ui.feature.user.userInfo.skintestinfo.getSkinTestInfoNavigationRoute

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
    Settings(
        icon = Icons.Filled.Home,
        iconText = "首頁",
        route = getSettingsNavigationRoute(),
        title = R.string.settings
    ),
    Introduce(
        icon = Icons.Filled.Home,
        iconText = "首頁",
        route = getIntroduceNavigationRoute(),
        title = R.string.introduce
    ),
    AccountInfo(
        icon = Icons.Filled.Home,
        iconText = "首頁",
        route = getAccountInfoNavigationRoute(),
        title = R.string.account_info
    ),
    SkinTestInfo(
        icon = Icons.Filled.Home,
        iconText = "首頁",
        route = getSkinTestInfoNavigationRoute(),
        title = R.string.skinTestInfo
    ),
    MyFavorites(
        icon = Icons.Filled.Search,
        iconText = "搜尋",
        route = getMyFavoritesNavigationRoute(),
        title = R.string.my_favorites
    ),
    Maintain(
        icon = Icons.Filled.Search,
        iconText = "保養通知",
        route = getMaintainNavigationRoute(),
        title = R.string.maintain_notify
    ),
    MaintainAdd(
        icon = Icons.Filled.Search,
        iconText = "新增保養通知",
        route = getMaintainAddNavigationRoute(),
        title = R.string.maintain_notify_add
    ),
    Feedback(
        icon = Icons.Filled.Search,
        iconText = "搜尋",
        route = getFeedbackNavigationRoute(),
        title = R.string.feedback
    ),
    FeedbackAdd(
        icon = Icons.Filled.Search,
        iconText = "搜尋",
        route = getFeedbackAddNavigationRoute(),
        title = R.string.feedback_add
    ),
}

/**
 * todo 1-2 宣告 AppState 是處理 NavHostController 的類別
 * */
@Stable
class SettingsAppState(
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
            getSettingsNavigationRoute() -> TipTopLevelDestination.Settings
            getIntroduceNavigationRoute() -> TipTopLevelDestination.Introduce
            getAccountInfoNavigationRoute() -> TipTopLevelDestination.AccountInfo
            getSkinTestInfoNavigationRoute() -> TipTopLevelDestination.SkinTestInfo
            getMyFavoritesNavigationRoute() -> TipTopLevelDestination.MyFavorites
            getMaintainNavigationRoute() -> TipTopLevelDestination.Maintain
            getMaintainAddNavigationRoute() -> TipTopLevelDestination.MaintainAdd
            getFeedbackNavigationRoute() -> TipTopLevelDestination.Feedback
            getFeedbackAddNavigationRoute() -> TipTopLevelDestination.FeedbackAdd
            else -> null
        }
    }

    /**
     * 根據目前的路徑，判斷是否顯示 BottomBar
     * */
    val isShowBottomBar: Boolean
        @Composable get() {
            return when (currentDestination) {
                getSettingsNavigationRoute() -> true
                else -> false
            }
        }


}