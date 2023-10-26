package jpabook.jpashop.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Address {
    @Column(length = 10) //공통 관리가 가능해진다.
    private String city;
    @Column(length=20)
    private String street;
    @Column(length=5)
    private String zipcode;

    private String fullAddress(){ //비즈니스 메서드 생성하여 사용 가능, 값 타입을 의미있게 객체 지향적으로 사용가능
        return getCity()+getStreet()+getZipcode();
    }
    public String getCity() {
        return city;
    }

    private void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    private void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    private void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public boolean equals(Object o) { //getter를 호출함으로써 필드에 직접 접근을 막아서, 프록시일 때도 계산할 수 있게끔 한다.
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(getCity(), address.getCity()) && Objects.equals(getStreet(), address.getStreet()) && Objects.equals(getZipcode(), address.getZipcode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getStreet(), getZipcode());
    }
}
