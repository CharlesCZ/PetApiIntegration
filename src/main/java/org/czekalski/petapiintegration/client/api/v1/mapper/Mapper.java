package org.czekalski.petapiintegration.client.api.v1.mapper;

public interface Mapper<S, T> {
    T map(S source);
}
