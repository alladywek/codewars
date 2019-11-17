package org.alladywekjd.http4k.proxy

import org.http4k.client.JavaHttpClient
import org.http4k.core.Request
import org.http4k.server.SunHttp
import org.http4k.server.asServer


fun main() {
    val client = JavaHttpClient()
    val app = { request: Request ->
        val originalUri = request.uri
        println("Original: $request")
        val newRequest = request.uri(originalUri.host("football.ua").scheme("https"))
        println("New: $newRequest")
        client(newRequest)
    }

    app.asServer(SunHttp()).start()
}