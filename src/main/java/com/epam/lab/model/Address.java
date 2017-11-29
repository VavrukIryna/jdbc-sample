package com.epam.lab.model;

public class Address {
  private Integer idAddress;
  private String city;
  private String street;
  private Integer home;

    public Integer getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Integer idAddress) {
        this.idAddress = idAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHome() {
        return home;
    }

    public void setHome(Integer home) {
        this.home = home;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (idAddress != null ? !idAddress.equals(address.idAddress) : address.idAddress != null) return false;
        if (city != null ? !city.equals(address.city) : address.city != null) return false;
        if (street != null ? !street.equals(address.street) : address.street != null) return false;
        return home != null ? home.equals(address.home) : address.home == null;
    }

    @Override
    public int hashCode() {
        int result = idAddress != null ? idAddress.hashCode() : 0;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (home != null ? home.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "idAddress=" + idAddress +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", home=" + home +
                '}';
    }
}
