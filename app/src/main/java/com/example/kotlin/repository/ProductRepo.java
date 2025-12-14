package com.example.kotlin.repository;

import com.example.kotlin.model.ProductModel


interface ProductRepo {

    //    {
//    "success" : true
//    "message": "Product fetched succesfully"
//}
//
    fu addProduct
    (model: ProductModel,callback:(Boolean,String) -> Unit)

    fun updateProduct
            (model: ProductModel,callback: (Boolean, String) -> Unit)

    fun deleteProduct
            (productId:String,callback: (Boolean, String) -> Unit)

    fun getAllProduct
            (callback: (Boolean, String, List<ProductModel>?) -> Unit)

    fun getProductById
            (productId: String,callback: (Boolean, String, ProductModel?) -> Unit)

    fun getProductByCategory
            (categoryId:String, callback: (Boolean, String, List<ProductModel>?) -> Unit)
}