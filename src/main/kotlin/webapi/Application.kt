package webapi

import com.sun.xml.internal.ws.client.ContentNegotiation
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import webapi.plugins.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

fun main()
{
    embeddedServer(Netty, port = 8080, host = "127.0.0.1")
    {
        configureRouting()
    }.start(wait = true)
}
