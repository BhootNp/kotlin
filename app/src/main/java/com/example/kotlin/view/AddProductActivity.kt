package com.example.kotlin.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlin.model.ProductModel
import com.example.kotlin.repository.ProductRepoImpl
import com.example.kotlin.viewmodel.ProductViewModel
import java.util.UUID


class AddProductActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProductScreen()

        }
    }
}
@Composable
fun ProductScreen(
    viewModel: ProductViewModel = ProductViewModel(ProductRepoImpl())


){
    val context = LocalContext.current

    //val productList by viewModel.productList.observeAsState(emptyList())


    var name by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }



//    LaunchedEffect (Unit) {
//        viewModel.getAllProduct()
//    }

    Scaffold(
        topBar = {
//            TopAppBar(title = {Text("Product Activity")})
        }
    ) { padding->
        Column(
            modifier = Modifier.fillMaxSize()
                .background(Color.White)
                .padding(paddingValues = padding)
                .padding(16.dp)

        ) {
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Product Name") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Product Description") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = price,
                onValueChange = { price = it },
                label = { Text("Product Price") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = {
                    Log.d("PRODUCT", "Add Product button clicked")
                    if (name.isBlank() || description.isBlank() || price.isBlank()) {
                        Toast.makeText(context, "Fill all fields", Toast.LENGTH_SHORT).show()
                        return@Button
                    }
                    val productId = UUID.randomUUID().toString()
                    val product = ProductModel(
                        productId = productId,
                        name = name,
                        description = description,
                        price = price.toDouble(),
                        categoryId = ""
                    )
                    viewModel.addProduct(product) {success, message->
                        if (success){
                            Toast.makeText(context, "Product added successfully", Toast.LENGTH_SHORT).show()
                        }
                    }

                    name = ""
                    description = ""
                    price = ""

                },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("Add Product")
            }

            Spacer(modifier = Modifier.height(20.dp))



        }

    }
}
@Composable
fun ProductItem(product: ProductModel) {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = product.name,
                style = MaterialTheme.typography.titleMedium
            )
            Text(text = product.description)
            Text(text = "Rs. ${product.price}")
        }
    }
}

@Preview
@Composable
fun ProductActivityPreview(){
    ProductScreen()
}