package com.cobanogluhasan.testing_basics.registrationutil

import com.cobanogluhasan.testing_basics.basics.RegistrationUtil
import org.junit.Assert.*
import org.junit.Test

class RegistrationUtilTest {

    @Test
    fun `empty username return false`() {
        val password = "123"
        val result = RegistrationUtil.validateRegistrationInput(
            "",
            password,
            password
        )
        assertEquals(false, result)
    }

    @Test
    fun `valid username and correctly repeated password returns true`() {
        val password = "123456"
        val result = RegistrationUtil.validateRegistrationInput(
            "abc",
            password,
            password
        )
        assertEquals(true, result)
    }

    @Test
    fun `username exists returns false `() {
        val password = "abcdefg"
        val result = RegistrationUtil.validateRegistrationInput(
            "Peter",
            password,
            password
        )
        assertEquals(false, result)
    }

    @Test
    fun `empty password returns false `() {
        val password = ""
        val result = RegistrationUtil.validateRegistrationInput(
            "abscn",
            password,
            password
        )
        assertEquals(false, result)
    }

    @Test
    fun `password repeated incorrectly`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "abscn",
            "asd12",
            "asd123"
        )
        assertEquals(false, result)
    }

    @Test
    fun `password is less than 6 char`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "abscn",
            "asd12",
            "asd12"
        )
        assertEquals(false, result)
    }
}