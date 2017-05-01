package hu.elte.cinema.util;


import hu.elte.cinema.response.CustomResponseFactory;
import hu.elte.cinema.service.AdminService;
import hu.elte.cinema.service.interfaces.CrudService;

import java.util.concurrent.ConcurrentHashMap;

public class ServiceProvider {
    private final ConcurrentHashMap<Class<?>, AdminService> services = new ConcurrentHashMap<>();
    private final CustomResponseFactory customResponseFactory;


    public ServiceProvider(CustomResponseFactory customResponseFactory) {
        this.customResponseFactory = customResponseFactory;
    }

    public <T> void registerService(Class<T> entityClass, CrudService crudService) {
        services.put(entityClass, new AdminService(crudService, customResponseFactory));
    }
    public AdminService getService(Class<?> entityClass) {
        return services.get(entityClass);
    }
}
