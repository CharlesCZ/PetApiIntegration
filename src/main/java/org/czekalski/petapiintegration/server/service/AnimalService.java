package org.czekalski.petapiintegration.server.service;

import org.czekalski.petapiintegration.server.api.resource.v1.dto.AnimalResourcesListDto;

public interface AnimalService {
    AnimalResourcesListDto findDogsByCityIdAndStateId(String stateId, String cityId, int size, int page);
}
