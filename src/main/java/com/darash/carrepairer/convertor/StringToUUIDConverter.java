package com.darash.carrepairer.convertor;

import java.util.UUID;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
final class StringToUUIDConverter implements Converter<String, UUID> {

    @Override
    public UUID convert(String source) {
        return (StringUtils.hasLength(source) ? UUID.fromString(source.trim()) : null);
    }

}