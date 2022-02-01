package com.example.myapplication.usermodels

data class Address(
    var street: String? = " ",
    var suite: String? = " ",
    var city: String? = " ",
    var zipcode: String? = " ",
    var geo: Geo? = null
) {

}