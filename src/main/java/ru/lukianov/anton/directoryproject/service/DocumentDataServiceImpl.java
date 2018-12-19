package ru.lukianov.anton.directoryproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.lukianov.anton.directoryproject.dao.IGenericDao;
import ru.lukianov.anton.directoryproject.model.DocumentEmployee;
import ru.lukianov.anton.directoryproject.model.mapper.MapperFacade;
import ru.lukianov.anton.directoryproject.view.DocumentEmployeeView;

import javax.validation.Valid;
import java.util.List;

/**
 * Сервис персональных данных работника
 */
@Service
public class DocumentDataServiceImpl implements IService<DocumentEmployeeView, Integer> {

    private final IGenericDao<DocumentEmployee, Integer> dao;
    private final MapperFacade mapperFacade;

    @Autowired
    public DocumentDataServiceImpl(IGenericDao<DocumentEmployee, Integer> dao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.dao.setClazz(DocumentEmployee.class);
        this.mapperFacade = mapperFacade;
    }

    @Override
    public void add(@Valid DocumentEmployeeView view) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<DocumentEmployeeView> findAll() {
        List<DocumentEmployee> all = dao.all();
        return mapperFacade.mapAsList(all, DocumentEmployeeView.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public DocumentEmployeeView findById(Integer id) {
        DocumentEmployee documentEmployee = dao.loadById(id);
        return mapperFacade.map(documentEmployee, DocumentEmployeeView.class);
    }

}
