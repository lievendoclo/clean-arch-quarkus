package org.acme.app.query

interface GetCustomerQuery {
    fun customer(request: Request): Response

    class Request(val id: String)
    class Response(val id: String, val name: String)
}
