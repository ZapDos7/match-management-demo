package com.example.demo.domain.enums.converters;

import com.example.demo.domain.enums.Specifier;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class SpecifierConverter implements AttributeConverter<Specifier, String> {

    @Override
    public String convertToDatabaseColumn(Specifier specifier) {
        return specifier != null ? specifier.label : null;
    }

    @Override
    public Specifier convertToEntityAttribute(String dbData) {
        return dbData != null ? Specifier.fromLabel(dbData) : null;
    }
}
