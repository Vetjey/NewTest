class Person (val firstName: String = "Peter", val lastName: String = "Parker") {
    var nickName: String? = null

    fun printInfo(){
        val printNickname = nickName ?: "no nickname"
        println("$firstName ($printNickname) $lastName")
    }

}