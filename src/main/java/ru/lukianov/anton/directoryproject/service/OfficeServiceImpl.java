package ru.lukianov.anton.directoryproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.lukianov.anton.directoryproject.dao.IGenericDao;
import ru.lukianov.anton.directoryproject.model.Office;
import ru.lukianov.anton.directoryproject.model.mapper.MapperFacade;
import ru.lukianov.anton.directoryproject.view.OfficeView;

import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class OfficeServiceImpl implements IService<OfficeView, Integer> {

    private final IGenericDao<Office, Integer> dao;
    private final MapperFacade mapperFacade;

    @Autowired
    public OfficeServiceImpl(IGenericDao<Office, Integer> dao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.dao.setClazz(Office.class);
        this.mapperFacade = mapperFacade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void add(OfficeView view) {
        Office office = new Office(view.name, view.phone, view.address, view.isActive, null);
        dao.save(office);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<OfficeView> findAll() {
        List<Office> all = dao.all();
        return mapperFacade.mapAsList(all, OfficeView.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public OfficeView findById(Integer id) {
        Office office = dao.loadById(id);
        return mapperFacade.map(office, OfficeView.class);
    }
}
