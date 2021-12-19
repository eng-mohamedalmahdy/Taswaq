package com.example.taswaq.domain

import com.example.taswaq.domain.model.DomainAddress
import com.example.taswaq.domain.model.DomainProduct
import com.example.taswaq.presentation.common.model.PresentationCategory
import com.example.taswaq.presentation.myorders.model.PresentationOrder

val dummyPresentationCategories = listOf(
    PresentationCategory("Electronics", "#91b945", "https://picsum.photos/500/300?random=1"),
    PresentationCategory("Clothes", "#1234FF", "https://picsum.photos/500/300?random=2"),
    PresentationCategory("Mobiles", "#F0F651", "https://picsum.photos/500/300?random=3"),
    PresentationCategory("Food", "#917ABD", "https://picsum.photos/500/300?random=4"),
    PresentationCategory("Accessories", "#888AAA", "https://picsum.photos/500/300?random=5"),
)


val dummyDomainProducts = listOf(
    DomainProduct(
        id = 0,
        name = "Ezreal",
        brand = "League of legends",
        images = listOf(
            "https://picsum.photos/500/300?random=1",
            "https://picsum.photos/500/300?random=2",
            "https://picsum.photos/500/300?random=3",
            "https ://picsum.photos/500/300?random=4",
        ),
        priceAfterDiscount = 20.0,
        priceBeforeDiscount = 500.0,
        description = "Very very very",
        rate = 3.0,
        rateCount = 20
    ),
    DomainProduct(
        id = 1,
        name = "Ezreal",
        brand = "League of legends",
        images = listOf(
            "https://picsum.photos/500/300?random=1",
            "https://picsum.photos/500/300?random=2",
            "https://picsum.photos/500/300?random=3",
            "https ://picsum.photos/500/300?random=4",
        ),
        priceAfterDiscount = 20.0,
        priceBeforeDiscount = 300.0,
        description = "Very very very",
        rate = 5.0,
        rateCount = 50
    ),
    DomainProduct(
        id = 2,
        name = "jarro Lightfeather ",
        brand = "League of legends",
        images = listOf(
            "https://picsum.photos/500/300?random=5",
            "https://picsum.photos/500/300?random=6",
            "https://picsum.photos/500/300?random=7",
            "https ://picsum.photos/500/300?random=8",
        ),
        priceAfterDiscount = 30.0,
        priceBeforeDiscount = 200.0,
        description = "Very very very",
        rate = 6.0,
        rateCount = 30
    ),
    DomainProduct(
        id = 3,
        name = "Time dude",
        brand = "League of legends",
        images = listOf(
            "https://picsum.photos/500/300?random=9",
            "https://picsum.photos/500/300?random=10",
            "https://picsum.photos/500/300?random=11",
            "https ://picsum.photos/500/300?random=12",
        ),
        priceAfterDiscount = 40.0,
        priceBeforeDiscount = 600.0,
        description = "Very very very",
        rate = 9.0,
        rateCount = 90
    ),
    DomainProduct(
        id = 4,
        name = "Cool guy",
        brand = "League of legends",
        images = listOf(
            "https://picsum.photos/500/300?random=13",
            "https://picsum.photos/500/300?random=14",
            "https://picsum.photos/500/300?random=15",
            "https ://picsum.photos/500/300?random=16",
        ),
        priceAfterDiscount = 2.0,
        priceBeforeDiscount = 700.0,
        description = "Very very very",
        rate = 8.5,
        rateCount = 70
    ),
    DomainProduct(
        id = 5,
        name = "No one",
        brand = "No one",
        images = listOf(
            "https://picsum.photos/500/300?random=17",
            "https://picsum.photos/500/300?random=18",
            "https://picsum.photos/500/300?random=19",
            "https ://picsum.photos/500/300?random=20",
        ),
        priceAfterDiscount = 20.0,
        priceBeforeDiscount = 200.0,
        description = "Very very very",
        rate = 7.0,
        rateCount = 8
    ),
    DomainProduct(
        id = 6,
        name = "42",
        brand = "42?",
        images = listOf(
            "https://picsum.photos/500/300?random=21",
            "https://picsum.photos/500/300?random=22",
            "https://picsum.photos/500/300?random=23",
            "https ://picsum.photos/500/300?random=24",
        ),
        priceAfterDiscount = 100000.0,
        priceBeforeDiscount = 500.0,
        description = "Very very very",
        rate = 3.0,
        rateCount = 20
    ),
)

val dummyOrders = listOf<PresentationOrder>()
var dummyAddressList = mutableListOf<DomainAddress>(
    DomainAddress("America","Albany Street",50.9,120.5,""),
    DomainAddress("London","Baker Street",77.03,90.04,""),
    DomainAddress("London","Robber Street",65.0,130.6,"")
)