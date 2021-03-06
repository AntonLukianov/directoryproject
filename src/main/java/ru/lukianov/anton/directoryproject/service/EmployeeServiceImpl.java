package ru.lukianov.anton.directoryproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.lukianov.anton.directoryproject.dao.IGenericDao;
import ru.lukianov.anton.directoryproject.model.Employee;
import ru.lukianov.anton.directoryproject.model.mapper.MapperFacade;
import ru.lukianov.anton.directoryproject.view.EmployeeView;

import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class EmployeeServiceImpl  implements IService<EmployeeView, Integer> {

    private final IGenericDao<Employee, Integer> dao;
    private final MapperFacade mapperFacade;

    @Autowired
    public EmployeeServiceImpl(IGenericDao<Employee, Integer> dao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.dao.setClazz(Employee.class);
        this.mapperFacade = mapperFacade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void add(EmployeeView view) {
        Employee employee = new Employee(view.firstName, view.secondName, view.middleName, view.phone,
                view.isIdentified, null, null, null);
        dao.save(employee);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<EmployeeView> findAll() {
        List<Employee> all = dao.all();
        return mapperFacade.mapAsList(all, EmployeeView.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public EmployeeView findById(Integer id) {
        Employee employee = dao.loadById(id);
        return mapperFacade.map(employee, EmployeeView.class);
    }
}
