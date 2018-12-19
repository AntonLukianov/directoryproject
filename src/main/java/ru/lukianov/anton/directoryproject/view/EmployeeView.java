package ru.lukianov.anton.directoryproject.view;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.lukianov.anton.directoryproject.model.Country;
import ru.lukianov.anton.directoryproject.model.DocumentEmployee;
import ru.lukianov.anton.directoryproject.model.Position;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

public class EmployeeView {

    public String id;

    @Size(max = 50)
    @NotEmpty(message = "name cannot be null")
    public String firstName;

    @Size(max = 50)
    public String secondName;

    @Size(max = 50)
    public String middleName;

    @Size(max = 25)
    public String phone;

    public Boolean isIdentified;

    public Position position;

    public Country country;

    @JsonIgnore
    public OfficeView office;

    public Set<DocumentEmployeeView> documentEmployeeSet;

    public EmployeeView() {
    }

    //конструктор для заглушки
    public EmployeeView(String id, @Size(max = 50) @NotEmpty(message = "name cannot be null") String firstName,
                        @Size(max = 50) String secondName, @Size(max = 50) String middleName, @Size(max = 25) String phone,
                        Boolean isIdentified, Position position, Country country, OfficeView office) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.phone = phone;
        this.isIdentified = isIdentified;
        this.position = position;
        this.country = country;
        this.office = office;
    }

    @Override
    public String toString() {
        return "EmployeeView{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", phone='" + phone + '\'' +
                ", isIdentified=" + isIdentified +
                ", position=" + position +
                ", country=" + country +
                ", office=" + office +
                '}';
    }

}
