package ru.lukianov.anton.directoryproject.view;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class OrganizationView {

    public Integer id;

    @Size(max = 50)
    @NotEmpty(message = "name cannot be null")
    public String name;

    @Size(max = 80)
    @NotEmpty(message = "full name cannot be null")
    public String fullName;

    @Size(max = 10)
    @NotEmpty(message = "inn cannot be null")
    public String inn;

    @Size(max = 9)
    @NotEmpty(message = "kpp cannot be null")
    public String kpp;

    @Size(max = 25)
    public String phone;

    @Size(max = 100)
    @NotEmpty(message = "address cannot be null")
    public String address;

    public Boolean isActive;

    public OrganizationView() {
    }

    //конструктор для заглушки
    public OrganizationView(Integer id, @Size(max = 50) @NotEmpty(message = "name cannot be null") String name, @Size(max = 80) @NotEmpty(message = "full name cannot be null") String fullName, @Size(max = 10) @NotEmpty(message = "inn cannot be null") String inn, @Size(max = 9) @NotEmpty(message = "kpp cannot be null") String kpp, @Size(max = 25) String phone, @Size(max = 100) @NotEmpty(message = "address cannot be null") String address, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.phone = phone;
        this.address = address;
        this.isActive = isActive;
    }
}
