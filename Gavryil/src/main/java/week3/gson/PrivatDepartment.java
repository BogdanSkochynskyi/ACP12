package week3.gson;

/**
 * Created by gavri on 29.04.2016.
 */
public class PrivatDepartment {

    String state;
    String id;
    String country;
    String city;
    String index;
    String phone;
    String email;
    String address;

    public PrivatDepartment(String state, String id,
                            String country, String city,
                            String index, String phone,
                            String email, String address) {
        this.state = state;
        this.id = id;
        this.country = country;
        this.city = city;
        this.index = index;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "PrivatDepartment{" +
                "state='" + state + '\'' +
                ", id='" + id + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", index='" + index + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrivatDepartment that = (PrivatDepartment) o;

        if (!state.equals(that.state)) return false;
        if (!id.equals(that.id)) return false;
        if (!country.equals(that.country)) return false;
        if (!city.equals(that.city)) return false;
        if (!index.equals(that.index)) return false;
        if (!phone.equals(that.phone)) return false;
        if (!email.equals(that.email)) return false;
        return address.equals(that.address);

    }

    @Override
    public int hashCode() {
        int result = state.hashCode();
        result = 31 * result + id.hashCode();
        result = 31 * result + country.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + index.hashCode();
        result = 31 * result + phone.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + address.hashCode();
        return result;
    }
}
