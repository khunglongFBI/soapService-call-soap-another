package com.vsii.soap2.demo.config;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurationSupport;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;


@EnableWs
@Configuration
@EnableAutoConfiguration
class Webconfig extends WsConfigurationSupport {
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
        messageDispatcherServlet.setApplicationContext(context);
        messageDispatcherServlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(messageDispatcherServlet, "/ws/*");
    }

    @Bean(name = "employees")
    public DefaultWsdl11Definition defaultWsdl1Definition(XsdSchema EmployeesSchema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setPortTypeName("EmployeesPort");
        definition.setTargetNamespace("http://localhost:8081/soap");
        definition.setLocationUri("/ws");
        definition.setSchema(EmployeesSchema);
        return definition;
    }

    @Bean
    public XsdSchema EmployeesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("nhanvien.xsd"));
    }
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource bean = new ReloadableResourceBundleMessageSource();
        bean.addBasenames("classpath:messages");
        return bean;
}
}
