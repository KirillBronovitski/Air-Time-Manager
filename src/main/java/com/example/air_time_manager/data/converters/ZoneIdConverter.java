package com.example.air_time_manager.data.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.ZoneId;

@Converter(autoApply = true)
public class ZoneIdConverter implements AttributeConverter<ZoneId, String> {

    @Override
    public String convertToDatabaseColumn(ZoneId zoneId) {
        return zoneId == null ? null : zoneId.getId();
    }

    @Override
    public ZoneId convertToEntityAttribute(String zoneId) {
        return zoneId == null ? null : ZoneId.of(zoneId);
    }

}
