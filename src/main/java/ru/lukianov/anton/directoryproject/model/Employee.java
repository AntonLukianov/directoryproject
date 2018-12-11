package ru.lukianov.anton.directoryproject.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * Работник
 */
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     * Имя
     */
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    /**
     * Второе имя
     */
    @Column(name = "second_name", length = 50)
    private String secondName;

    /**
     * Среднее имя
     */
    @Column(name = "middle_name", length = 50)
    private String middleName;

    /**
     * Телефон
     */
    @Column(name = "phone", length = 25)
    private String phone;

    /**
     * Статус
     */
    @Column(name = "is_identified")
    private Boolean isIdentified;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id")
    private Position position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "office_id")
    private Office office;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DocumentEmployee> documentEmployeeSet;

    /**
     * Конструктор для hibernate
     */
    public Employee() {

    }

    public Employee(String firstName, String secondName, String middleName, String phone,
                    Boolean isIdentified, Position position, Country country, Office office) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.phone = phone;
        this.isIdentified = isIdentified;
        this.position = position;
        this.country = country;
        this.office = office;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getIdentified() {
        return isIdentified;
    }

    public void setIdentified(Boolean identified) {
        isIdentified = identified;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Set<DocumentEmployee> getDocumentEmployeeSet() {
        return documentEmployeeSet;
    }

    public void addDocumentEmployee(DocumentEmployee documentEmployee) {
        getDocumentEmployeeSet().add(documentEmployee);
        documentEmployee.setEmployee(this);
    }

    public void removeDocumentEmployee(DocumentEmployee documentEmployee) {
        getDocumentEmployeeSet().remove(documentEmployee);
        documentEmployee.setEmployee(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(secondName, employee.secondName) &&
                Objects.equals(middleName, employee.middleName) &&
                Objects.equals(phone, employee.phone) &&
                Objects.equals(isIdentified, employee.isIdentified) &&
                Objects.equals(position, employee.position) &&
                Objects.equals(country, employee.country) &&
                Objects.equals(office, employee.office);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstName, secondName, middleName, phone, isIdentified, position, country, office);
    }

}
