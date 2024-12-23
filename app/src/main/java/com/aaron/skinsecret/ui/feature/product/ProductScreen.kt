package com.aaron.skinsecret.ui.feature.product

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.aaron.skinsecret.R
import com.aaron.skinsecret.ui.feature.TabVM
import com.aaron.skinsecret.ui.feature.product.productDetail.getProductDetailNavigationRoute


@Composable
fun ProductScreen(
    navController: NavHostController = rememberNavController(),
    tabVM: TabVM,
    productVM: ProductViewModel = ProductViewModel()
) {
//    var 這裡應該放四個篩選器的按鈕 by remember { mutableStateOf() }
    val products by productVM.productState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(28.dp)
                .background(colorResource(R.color.green_main)),
        ) {
            Text(text = "這裡要放 Filter 會有四顆按鈕")
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
                .background(colorResource(R.color.green_pale))
        ) {
//            這裡要放篩選器
            ProductList(
                products,
                onItemClick = {
                    navController.navigate(getProductDetailNavigationRoute())
                }
            )
        }
    }
}

@Composable
fun ProductList(
    products: List<Product>,
    onItemClick: (Product) -> Unit,
// 要呼應上面傳入的參數 onItemClick:
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(3.dp)
            .background(colorResource(R.color.white))

    ) {
        items(products) { product ->
            Card(
                modifier = Modifier
                    .padding(5.dp)
                    .clickable { onItemClick(product) },
                shape = RoundedCornerShape(3.dp),
                /*colors = CardColors(
                    cont
                ),*/
                //elevation = CardElevation()
            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    Image(
                        painter = painterResource(id = product.image),
                        contentDescription = "",
                        modifier = Modifier.fillMaxWidth(1.0f)
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.weight(0.5f),
                            horizontalAlignment = Alignment.Start
                        ) {
                            Text(text = product.productName)
                            Text(text = product.brandName)
                            Text(text = "${product.star.toString()} 顆星")
                        }
                        Column(
                            modifier = Modifier.weight(0.5f),
                            horizontalAlignment = Alignment.End,
                            verticalArrangement = Arrangement.Bottom
                        ) {
                            Text(text = "點愛心")
                            Text(text = "$ ${product.price.toString()}")
                        }
                    }
                }

            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProductScreen(
        tabVM = viewModel()
    )
}
