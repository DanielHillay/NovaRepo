//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.11.21 at 02:40:23 PM WAT 
//


package com.spearhead.nova.model.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AccountDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AccountDetails"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AccountTitle" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="AccountNumber" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Nuban" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Branch" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="AccountType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ActualBalance" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="AvailableBalance" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="HasLien" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="Dormancy" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccountDetails", propOrder = {
    "accountTitle",
    "accountNumber",
    "nuban",
    "branch",
    "accountType",
    "actualBalance",
    "availableBalance",
    "hasLien",
    "dormancy"
})
public class AccountDetails {

    @XmlElement(name = "AccountTitle", required = true)
    protected String accountTitle;
    @XmlElement(name = "AccountNumber", required = true)
    protected String accountNumber;
    @XmlElement(name = "Nuban", required = true)
    protected String nuban;
    @XmlElement(name = "Branch", required = true)
    protected String branch;
    @XmlElement(name = "AccountType", required = true)
    protected String accountType;
    @XmlElement(name = "ActualBalance", required = true)
    protected String actualBalance;
    @XmlElement(name = "AvailableBalance", required = true)
    protected String availableBalance;
    @XmlElement(name = "HasLien", defaultValue = "false")
    protected boolean hasLien;
    @XmlElement(name = "Dormancy", required = true)
    protected String dormancy;

    /**
     * Gets the value of the accountTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountTitle() {
        return accountTitle;
    }

    /**
     * Sets the value of the accountTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountTitle(String value) {
        this.accountTitle = value;
    }

    /**
     * Gets the value of the accountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the value of the accountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountNumber(String value) {
        this.accountNumber = value;
    }

    /**
     * Gets the value of the nuban property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNuban() {
        return nuban;
    }

    /**
     * Sets the value of the nuban property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNuban(String value) {
        this.nuban = value;
    }

    /**
     * Gets the value of the branch property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBranch() {
        return branch;
    }

    /**
     * Sets the value of the branch property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBranch(String value) {
        this.branch = value;
    }

    /**
     * Gets the value of the accountType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * Sets the value of the accountType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountType(String value) {
        this.accountType = value;
    }

    /**
     * Gets the value of the actualBalance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActualBalance() {
        return actualBalance;
    }

    /**
     * Sets the value of the actualBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActualBalance(String value) {
        this.actualBalance = value;
    }

    /**
     * Gets the value of the availableBalance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAvailableBalance() {
        return availableBalance;
    }

    /**
     * Sets the value of the availableBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAvailableBalance(String value) {
        this.availableBalance = value;
    }

    /**
     * Gets the value of the hasLien property.
     * 
     */
    public boolean isHasLien() {
        return hasLien;
    }

    /**
     * Sets the value of the hasLien property.
     * 
     */
    public void setHasLien(boolean value) {
        this.hasLien = value;
    }

    /**
     * Gets the value of the dormancy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDormancy() {
        return dormancy;
    }

    /**
     * Sets the value of the dormancy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDormancy(String value) {
        this.dormancy = value;
    }

}
