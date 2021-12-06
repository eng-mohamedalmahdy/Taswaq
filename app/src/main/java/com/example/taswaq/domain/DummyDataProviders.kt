package com.example.taswaq.domain

import com.example.taswaq.presentation.common.model.Category
import com.example.taswaq.presentation.common.model.Product
import com.example.taswaq.presentation.myorders.model.Order
import com.example.taswaq.presentation.productdetails.model.ProductDetailsModel

val dummyCategories = listOf(
    Category("Electronics", "#91b945", "https://picsum.photos/500/300?random=1"),
    Category("Clothes", "#1234FF", "https://picsum.photos/500/300?random=2"),
    Category("Mobiles", "#F0F651", "https://picsum.photos/500/300?random=3"),
    Category("Food", "#917ABD", "https://picsum.photos/500/300?random=4"),
    Category("Accessories", "#888AAA", "https://picsum.photos/500/300?random=5"),
)
val dummyProducts = listOf(
    Product("Product", 10.0, "https://picsum.photos/500/300?random=1"),
    Product("Another", 12.20, "https://picsum.photos/500/300?random=2"),
    Product("IDK", 20.0, "https://picsum.photos/500/300?random=4"),
    Product("Maybe", 30.0, "https://picsum.photos/500/300?random=5"),
    Product("HAHA", 25.0, "https://picsum.photos/500/300?random=16"),
    Product("42", 42.99, "https://picsum.photos/500/300?random=7"),
    Product("Product?", 5.50, "https://picsum.photos/500/300?random=8"),
)
val dummyProductDetails = ProductDetailsModel(
    listOf(
        "https://picsum.photos/500/300?random=1",
        "https://picsum.photos/500/300?random=2",
        "https://picsum.photos/500/300?random=3",
        "https ://picsum.photos/500/300?random=4",
    ),
    "Product",
    20.00,
    10.00,
    "A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart. I am alone, and feel the charm of existence in this spot, which was created for the bliss of souls like mine.",
    7.5,
    10
)

val dummyOrders = listOf<Order>()