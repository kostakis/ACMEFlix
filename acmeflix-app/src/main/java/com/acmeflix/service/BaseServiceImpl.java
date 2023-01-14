package com.acmeflix.service;

import com.acmeflix.base.AbstractLogComponent;
import com.acmeflix.domain.BaseModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public abstract  class BaseServiceImpl<T extends BaseModel>
        extends AbstractLogComponent
        implements BaseService<T, Long> {

    abstract JpaRepository<T, Long> getRepository(); //Will be implemented by each service to get the relevant service

    @Override
    public T create(final T element) { //Simle insertion to the DB of an entity, a new record
        logger.trace("Creating {}.", element);
        return getRepository().save(element);
    }

    @Override
    public List<T> createAll(final T... element) { //Many records insertion
        logger.trace("CreateAll with T... element");
        return createAll(List.of(element)); //It will just create a list with all the records
    }

    @Override
    public List<T> createAll(final List<T> elements) {
        logger.trace("Create all with List<T> categories");

        final List<T> updatedEntities = new ArrayList<>();

        for (final T element : elements) { //For each record
            updatedEntities.add(create(element)); //Call the single record insertion
        }
        return updatedEntities;
    }

    @Override
    public void update(final T element) { //Update DB
        logger.trace("Updating {}.", element);
        getRepository().save(element);
    }

    @Override
    public void delete(final T element) { //Delete from DB
        logger.trace("Deleting {}.", element);
        getRepository().delete(element);
    }

    private boolean exists(Long id) { //Check if the current ID exist in the DB
        return getRepository().existsById(id);
    }

    @Override
    public void deleteById(final Long id) {
        logger.trace("Deleting entity with id {}.", id);
        if (exists(id))
        {
            getRepository().deleteById(id);
            logger.info("User with id: {} deleted", id);
        }
        else
        {
			throw new NoSuchElementException("Id: " + id + " you are tyring to delete does not exist");
		}
    }

    @Override
    public boolean exists(final T element) {
        logger.trace("Checking whether {} exists.", element);
        return getRepository().existsById(element.getId());
    }

    @Override
    public List<T> findAll() { //Get all the records as a list of a DB table
        logger.trace("Retrieving all data.");
        return getRepository().findAll();
    }

    @Override
    public T find(Long id) { //Get a record of the db using the ID, maybe each service could override to be more specific excpetion
        return getRepository().findById(id)
                .orElseThrow(() -> new NoSuchElementException("Can not find id: " + id));
    }

    public T get(Long id) {
        return getRepository().getReferenceById(id);
    }
}
