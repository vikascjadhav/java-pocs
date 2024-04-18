package com.camel.camelrest;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class WebRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        restConfiguration()
                // to use servlet component and run on port 8080
                .component("servlet")
                .port(8080)
                .bindingMode(RestBindingMode.json);

        rest("/payments")
                .get()
                .to("bean:serviceImpl?method=userPayment");
    }
}
