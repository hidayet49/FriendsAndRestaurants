package io.codecooker.hidayet.friends.util;

import java.util.List;
import java.util.stream.Collectors;

public interface Converter<Entity, DTO> {

    DTO convert(Entity entity);

    default List<DTO> convertAll(List<Entity> entities) {
        return entities.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
