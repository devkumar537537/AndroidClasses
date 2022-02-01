package com.example.myapplication.usermodels

data class UserModel(
    var id :Int ? = 0,
    var name: String? = " ",
    var username: String? = " ",
    var email: String? = " ",
    var address: Address? = null,
    var phone: String? = " ",
    var website: String? =" ",
    var company: Company? = null

) {

}