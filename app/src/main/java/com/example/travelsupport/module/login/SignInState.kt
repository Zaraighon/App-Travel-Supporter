package com.example.signinsignup

data class SignInState(
    val isSignInSuccessful: Boolean=false,
    val signInError: String?=null
)
