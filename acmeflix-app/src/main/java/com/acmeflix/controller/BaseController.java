package com.acmeflix.controller;

import com.acmeflix.base.AbstractLogComponent;
import com.acmeflix.domain.BaseModel;
import com.acmeflix.service.BaseService;

public abstract class BaseController<T extends BaseModel> extends AbstractLogComponent {
    abstract BaseService<T, Long> getBaseService();
}
