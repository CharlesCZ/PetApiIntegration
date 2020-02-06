package org.czekalski.petapiintegration.apiclient.v1.mapper;

public interface Mapper<S, T> {
    T map(S source);
}
