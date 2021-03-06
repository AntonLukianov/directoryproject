package ru.lukianov.anton.directoryproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.lukianov.anton.directoryproject.dao.IGenericDao;
import ru.lukianov.anton.directoryproject.model.Position;
import ru.lukianov.anton.directoryproject.model.mapper.MapperFacade;
import ru.lukianov.anton.directoryproject.view.PositionView;

import javax.validation.Valid;
import java.util.List;

/**
 * Сервис справочника должностей
 */
@Service
public class PositionServiceImpl implements IService<PositionView, Short> {

    private final IGenericDao<Position, Short> dao;
    private final MapperFacade mapperFacade;

    @Autowired
    public PositionServiceImpl(IGenericDao<Position, Short> dao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.dao.setClazz(Position.class);
        this.mapperFacade = mapperFacade;
    }

    @Override
    public void add(@Valid PositionView view) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<PositionView> findAll() {
        List<Position> all = dao.all();
        return mapperFacade.mapAsList(all, PositionView.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public PositionView findById(Short id) {
        Position position = dao.loadById(id);
        return mapperFacade.map(position, PositionView.class);
    }
}
