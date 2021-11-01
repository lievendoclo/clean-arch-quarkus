package org.acme.infra.web.model;

public class JsonCustomer {
    private String name;

    public JsonCustomer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
