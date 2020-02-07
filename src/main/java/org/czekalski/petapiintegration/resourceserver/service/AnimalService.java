package org.czekalski.petapiintegration.resourceserver.service;

import org.czekalski.petapiintegration.resourceserver.apiresource.v1.dto.AnimalResourcesListDto;

public interface AnimalService {
    AnimalResourcesListDto findDogsByCityIdAndStateId(String stateId, String cityId, int size, int page);
}
