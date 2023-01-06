package com.acmeflix.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Abstract class used to provide logging functionality to all components.
 * Extend this class to get easy and quick logger functionality
 */
public abstract class AbstractLogComponent {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @PostConstruct
    private void init() {
        logger.trace("Loaded {}.", getClass().getName());
    }

    @PreDestroy
    private void destroy() {
        logger.trace("Ready to destroy {}.", getClass().getName());
    }
}
