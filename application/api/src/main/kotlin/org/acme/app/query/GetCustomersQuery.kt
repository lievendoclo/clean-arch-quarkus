package org.acme.app.query

interface GetCustomersQuery {
    fun <T> customers(presenter: (List<Response>) -> T): T

    class Response(val id: String, val name: String)
}
