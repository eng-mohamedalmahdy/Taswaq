package com.example.taswaq.domain.model

import com.example.taswaq.domain.dummyDomainProducts
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import kotlin.test.BeforeTest
import kotlin.test.assertEquals

private const val TAG = "DomainCartTest"

class DomainCartTest {

    @BeforeTest
    fun resetCart() {
    }



    @Test
    fun `get item of id`() {
        repeat(7) {
            val expected = dummyDomainProducts[it]
            val actual = DomainCart.getItemWithId(it)
            assertEquals(expected.id, actual.id)
        }
    }

}