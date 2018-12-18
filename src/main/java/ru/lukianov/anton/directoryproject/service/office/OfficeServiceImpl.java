package ru.lukianov.anton.directoryproject.service.office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.lukianov.anton.directoryproject.controller.EntityNotFoundException;
import ru.lukianov.anton.directoryproject.dao.office.OfficeDao;
import ru.lukianov.anton.directoryproject.model.Office;
import ru.lukianov.anton.directoryproject.model.mapper.MapperFacade;
import ru.lukianov.anton.directoryproject.view.OfficeView;

import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class OfficeServiceImpl implements OfficeService {

    private final OfficeDao dao;
    private final MapperFacade mapperFacade;

    @Autowired
    public OfficeServiceImpl(OfficeDao dao, MapperFacade mapperFacade) {
        this.dao = dao;
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
    public List<OfficeView> offices() {
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
