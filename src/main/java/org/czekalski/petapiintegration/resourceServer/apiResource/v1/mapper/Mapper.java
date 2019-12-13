package org.czekalski.petapiintegration.resourceServer.apiResource.v1.mapper;

public interface Mapper<S, T> {
    T map(S source);
}
