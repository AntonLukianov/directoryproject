package ru.lukianov.anton.directoryproject.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.lukianov.anton.directoryproject.controller.EntityNotFoundException;
import ru.lukianov.anton.directoryproject.dao.employee.EmployeeDao;
import ru.lukianov.anton.directoryproject.model.Employee;
import ru.lukianov.anton.directoryproject.model.mapper.MapperFacade;
import ru.lukianov.anton.directoryproject.view.EmployeeView;

import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class EmployeeServiceImpl  implements EmployeeService {

    private final EmployeeDao dao;
    private final MapperFacade mapperFacade;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao dao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void add(EmployeeView view) {
        Employee employee = new Employee(view.first_name, view.second_name, view.middle_name, view.phone,
                view.isIdentified, null, null, null);
        dao.save(employee);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<EmployeeView> employees() {
        List<Employee> all = dao.all();
        return mapperFacade.mapAsList(all, EmployeeView.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public EmployeeView findById(Integer id) {
        if(id!=2) {
            throw new EntityNotFoundException("Not found employee with id is " + id);
        }
        return new EmployeeView("2", "Иван", "Иванов", "Иванович",
                "+7 (495) 995-2575", false, "1", "1", "2");
    }
}
