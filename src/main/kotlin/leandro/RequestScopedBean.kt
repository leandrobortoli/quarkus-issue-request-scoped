package leandro

import javax.enterprise.context.RequestScoped

@RequestScoped
open class RequestScopedBean {

    var myProperty: Int? = null
    var myStringProperty: String? = null

    init {
        println("Initializing RequestScopedBean")
    }
}