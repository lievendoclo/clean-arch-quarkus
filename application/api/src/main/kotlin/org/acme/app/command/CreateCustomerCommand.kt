package org.acme.app.command

interface CreateCustomerCommand {
    fun create(request: Request): Response
    class Request(val name: String)
    class Response(val id: String)
}