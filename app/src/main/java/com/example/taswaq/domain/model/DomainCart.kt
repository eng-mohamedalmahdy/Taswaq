package com.example.taswaq.domain.model

import android.util.Log
import com.example.taswaq.domain.dummyDomainProducts
import com.example.taswaq.presentation.cart.model.PresentationCartItem
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*


private const val TAG = "DomainCart"

object DomainCart {


    //The products and it's QTY
    private val products = MutableStateFlow(mapOf<DomainProduct, Int>())

    private val mutableCartItems =
        products.asStateFlow().map {
            it.toList().map { (product, qty) ->
                PresentationCartItem(
                    id = product.id,
                    productName = product.name,
                    productImageUrl = product.images.firstOrNull() ?: "",
                    productBrand = product.brand,
                    productUnitPrice = product.priceAfterDiscount,
                    productQty = qty
                )
            }
        }
    val cartItems = mutableCartItems

    val itemsCount = cartItems.map {
        it.fold(0) { acc, product -> acc + product.productQty }
    }

    fun addToCart(itemId: Int) {
        val product: DomainProduct = getItemWithId(itemId)
        val newCartProducts = products.value.toMutableMap()
        if (newCartProducts[product] == null) {
            newCartProducts[product] = 1
        } else {
            newCartProducts[product] = (newCartProducts[product] ?: 0) + 1
        }
        CoroutineScope(Dispatchers.IO).launch {
            products.emit(newCartProducts.toMap())
        }
    }

    fun getItemWithId(itemId: Int): DomainProduct =
        dummyDomainProducts.first { itemId == it.id }

    fun removeOneFromCart(itemId: Int) {
        val product: DomainProduct = getItemWithId(itemId)
        val newCartProducts = products.value.toMutableMap()
        if (newCartProducts[product] ?: 0 > 1) {
            newCartProducts[product] = (newCartProducts[product] ?: 0) - 1
        } else {
            newCartProducts.remove(product)
        }
        CoroutineScope(Dispatchers.IO).launch {
            products.emit(newCartProducts.toMap())
        }
    }

    fun removeAllFromCart(itemId: Int) {
        val product: DomainProduct = getItemWithId(itemId)
        val newCartProducts = products.value.toMutableMap()
        newCartProducts.remove(product)
        CoroutineScope(Dispatchers.IO).launch {
            products.emit(newCartProducts.toMap())
        }
    }
}
