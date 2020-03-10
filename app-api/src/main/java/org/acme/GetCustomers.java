package org.acme;

import java.util.List;

public interface GetCustomers {

    List<Response> getCustomer();

    class Response {
        private String name;

        public Response(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
