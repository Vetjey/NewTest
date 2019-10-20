interface PersonInfoProvider {
    val providerInfo:String
    fun printInfo(person: Person){
        println(providerInfo)
        person.printInfo()
    }
}

interface SessionInfoProvider{
    fun getSessionId(): String
}

open class BasicInfoProvider: PersonInfoProvider, SessionInfoProvider{
    protected open val sessionIdPrefix = "Session"
    override val providerInfo: String
        get() = "basicInfoProvider"

    override fun getSessionId(): String {
        return sessionIdPrefix
    }

}

fun main(){
    val provider = object : PersonInfoProvider {
        override val providerInfo: String
            get() = "New Info Provider"
        fun getSessionId() = "id"
    }
    provider.printInfo(Person())
    provider.getSessionId()
    checkTypes(provider)
}

fun checkTypes(infoProvider: PersonInfoProvider){
    if (infoProvider is SessionInfoProvider)
        println("is a session provider")
    else
        println("not a session provider")

}