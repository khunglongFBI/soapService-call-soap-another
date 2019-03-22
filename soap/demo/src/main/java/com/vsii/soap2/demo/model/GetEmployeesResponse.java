
package com.vsii.soap2.demo.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Employees" type="{http://localhost:8081/soap}Employees"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "employees"
})
@XmlRootElement(name = "GetEmployeesResponse", namespace = "http://localhost:8081/soap")
public class GetEmployeesResponse {

    @XmlElement(name = "Employees", namespace = "http://localhost:8081/soap", required = true)
    protected Employees employees;

    /**
     * Gets the value of the employees property.
     * 
     * @return
     *     possible object is
     *     {@link Employees }
     *     
     */
    public Employees getEmployees() {
        return employees;
    }

    /**
     * Sets the value of the employees property.
     * 
     * @param value
     *     allowed object is
     *     {@link Employees }
     *     
     */
    public void setEmployees(Employees value) {
        this.employees = value;
    }

}
