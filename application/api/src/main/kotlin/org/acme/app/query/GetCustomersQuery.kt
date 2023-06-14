package org.acme.app.query

interface GetCustomersQuery {
    fun customers(): List<Response>

    class Response(val id: String, val name: String)
}
