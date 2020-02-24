package no.knips.models

class AuthenticationRequest(username: String, password: String) {
    private var username = username
    private var password = password

    fun getUsername(): String = this.username

    fun setUsername(username: String) {this.username = username}

    fun getPassword(): String = this.password

    fun setPassword(password: String) {this.password = password}

}