package com.example.kotlin.model;

data class ProductModel(
        var productId : String = "",
        var name : String = "",
        var price : Double = 0.0,
        var description : String = "",
        var categoryId : String = ""
){

}
