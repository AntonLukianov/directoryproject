package ru.lukianov.anton.directoryproject.view;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class EmployeeView {

    public String id;

    @Size(max = 50)
    @NotEmpty(message = "name cannot be null")
    public String first_name;

    @Size(max = 50)
    public String second_name;

    @Size(max = 50)
    public String middle_name;

    @Size(max = 25)
    public String phone;

    public Boolean isIdentified;

    public String position_id;

    public String country_id;

    public String office_id;

    public EmployeeView() {
    }

    //конструктор для заглушки
    public EmployeeView(String id, @Size(max = 50) @NotEmpty(message = "name cannot be null") String first_name,
                        @Size(max = 50) String second_name, @Size(max = 50) String middle_name, @Size(max = 25) String phone,
                        Boolean isIdentified, String position_id, String country_id, String office_id) {
        this.id = id;
        this.first_name = first_name;
        this.second_name = second_name;
        this.middle_name = middle_name;
        this.phone = phone;
        this.isIdentified = isIdentified;
        this.position_id = position_id;
        this.country_id = country_id;
        this.office_id = office_id;
    }
}
