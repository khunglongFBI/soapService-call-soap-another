package com.vsii.soap.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class Config {
    private static final String BEAN_NAME_EMPLOYEE_MARSHALLER = "employeeMarshaller";
    @Bean(name = BEAN_NAME_EMPLOYEE_MARSHALLER)
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this is the package name specified in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("com.vsii.soap.model");
        return marshaller;
    }

    @Bean
    public SOAPConnector soapConnector(@Qualifier(BEAN_NAME_EMPLOYEE_MARSHALLER) Jaxb2Marshaller marshaller) {
        SOAPConnector client = new SOAPConnector();
        client.setDefaultUri("http://localhost:8081/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
  /* @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
        messageDispatcherServlet.setApplicationContext(context);
        messageDispatcherServlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(messageDispatcherServlet, "/*");
    }

    @Bean(name = "employees")
    public DefaultWsdl11Definition defaultWsdl1Definition(XsdSchema EmployeesSchema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setPortTypeName("EmployeesPort");
        definition.setTargetNamespace("http://localhost:8081/soap");
        definition.setLocationUri("/");
        definition.setSchema(EmployeesSchema);
        return definition;
    }

    @Bean
    public XsdSchema EmployeesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("employees.wsdl"));
    }*/
}