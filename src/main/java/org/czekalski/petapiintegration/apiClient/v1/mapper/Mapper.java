package org.czekalski.petapiintegration.apiClient.v1.mapper;

public interface Mapper<S, T> {
    T map(S source);
}
