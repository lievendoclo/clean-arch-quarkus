package org.acme.app.query

interface GetCustomerQuery {
    fun <T> customer(request: Request, presenter: (Response) -> T): T

    class Request(val id: String)
    class Response(val id: String, val name: String)
}
