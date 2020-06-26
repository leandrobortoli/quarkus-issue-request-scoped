package leandro

import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/ping")
class PingController {

    @Inject
    lateinit var requestScopedBean: RequestScopedBean

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun ping(): String {
        if(requestScopedBean.myProperty == null) {
            println("Setting requestScopedBean.myProperty")
            requestScopedBean.myProperty = java.util.Random().nextInt()
        }
        if(requestScopedBean.myStringProperty == null) {
            println("Setting requestScopedBean.myStringProperty")
            requestScopedBean.myStringProperty = StringUtils.randomString()
        }
        println("requestScopedBean ref: $requestScopedBean")
        println("requestScopedBean.myProperty: ${requestScopedBean.myProperty}")
        println("requestScopedBean.myStringProperty: ${requestScopedBean.myStringProperty}")
        return "pong"
    }
}