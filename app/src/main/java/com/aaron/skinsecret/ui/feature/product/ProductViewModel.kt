package com.aaron.skinsecret.ui.feature.product

import androidx.lifecycle.ViewModel
import com.aaron.skinsecret.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProductViewModel : ViewModel() {

    // 這裡要放導到 Product Detail 的資訊

    private val _productState = MutableStateFlow(emptyList<Product>())
    val productState: StateFlow<List<Product>> = _productState.asStateFlow()

    init {
        _productState.value = productList()
    }

    private fun productList(): List<Product> {
        return listOf(
            Product("水水瓶", "BFFECT", 450, R.drawable.product_002h_450,4),
            Product("10B修復瓶", "BFFECT", 380, R.drawable.product_10b_380,4),
            Product("Brio", "BFFECT", 540, R.drawable.product_brio_540,4),
            Product("修修瓶", "BFFECT", 990, R.drawable.product_c002_990,4),
            Product("柔膚瓶", "BFFECT", 820, R.drawable.product_c005_820,4),
            Product("撫紋瓶", "BFFECT", 1290, R.drawable.product_h002_1290,4),
            Product("消消瓶", "BFFECT", 990, R.drawable.product_h002_990,4),
            Product("Kira", "BFFECT", 720, R.drawable.product_kira_720,4),
            Product("Luz", "BFFECT", 540, R.drawable.product_luz_540,4),
            )
    }

}