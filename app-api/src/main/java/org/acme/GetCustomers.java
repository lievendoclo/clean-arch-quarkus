package org.acme;

import java.util.List;

public interface GetCustomers {
    List<Response> getCustomers();

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
