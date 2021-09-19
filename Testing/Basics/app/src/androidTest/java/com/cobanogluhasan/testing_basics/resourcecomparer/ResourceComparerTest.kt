package com.cobanogluhasan.testing_basics.resourcecomparer

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.cobanogluhasan.testing_basics.R
import com.cobanogluhasan.testing_basics.basics.ResourceComparer
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class ResourceComparerTest {

    private lateinit var resourceComparer: ResourceComparer

    @Before
    fun setup() {
        //do something before the test run such as create instance
        resourceComparer = ResourceComparer()
    }

    @After
    fun tearDown() {
        //do something after the test ran
    }

    @Test
    fun stringResourceSameAsGivenString_returnsTrue() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.isStringEqual(context, R.string.app_name, "testing-basics")
        assertEquals(true, result)
    }

    @Test
    fun stringResourceDifferentAsGivenString_returnsFalse() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.isStringEqual(context, R.string.app_name, "testing")
        assertEquals(false, result)
    }
}