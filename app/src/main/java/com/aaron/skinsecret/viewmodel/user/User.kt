package com.aaron.skinsecret.viewmodel.user

data class User(
    var account: String = "",
    var password: String = ""
) {
    override fun equals(other: Any?): Boolean {
        return this.account == (other as User).account
    }

    override fun hashCode(): Int {
        return account.hashCode()
    }
}