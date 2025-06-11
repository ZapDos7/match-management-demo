package com.example.demo.domain.enums.converters;

import com.example.demo.domain.enums.SportType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class SportTypeConverter implements AttributeConverter<SportType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(SportType attribute) {
        return attribute != null ? attribute.label : null;
    }

    @Override
    public SportType convertToEntityAttribute(Integer dbData) {
        if (dbData == null) return null;
        for (SportType type : SportType.values()) {
            if (type.label == dbData) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown sport type value: " + dbData);
    }
}
