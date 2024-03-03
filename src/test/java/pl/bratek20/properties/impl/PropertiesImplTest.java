package pl.bratek20.properties.impl;

import pl.bratek20.properties.api.PropertiesApi;
import pl.bratek20.properties.api.PropertiesApiTest;
import pl.bratek20.properties.api.PropertiesSource;

import java.util.List;

class PropertiesImplTest extends PropertiesApiTest {

    @Override
    protected PropertiesApi createInstance(List<PropertiesSource> params) {
        return new PropertiesImpl(params);
    }
}