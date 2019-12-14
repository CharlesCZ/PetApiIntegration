package org.czekalski.petapiintegration.resourceServer.service;

import org.czekalski.petapiintegration.resourceServer.apiResource.v1.dto.AnimalResourcesListDto;

public interface AnimalService {
    AnimalResourcesListDto findDogsByCityIdAndDogsQuantity(String cityId, int size);
}
