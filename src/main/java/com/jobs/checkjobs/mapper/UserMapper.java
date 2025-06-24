package com.jobs.checkjobs.mapper;

import com.jobs.checkjobs.dto.OfertaEmpleoDto;
import com.jobs.checkjobs.dto.UserDto;
import com.jobs.checkjobs.entity.Empresa;
import com.jobs.checkjobs.entity.OfertaEmpleo;
import com.jobs.checkjobs.entity.User;

import java.util.stream.Collectors;

public class UserMapper {

    public static UserDto toDto(User user) {
        if (user == null) return null;

        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setNombre(user.getNombre());
        dto.setEmail(user.getEmail());
        dto.setTelefono(user.getTelefono());

        if (user.getOfertasPublicadas() != null) {
            dto.setOfertasPublicadas(
                    user.getOfertasPublicadas().stream()
                            .map(UserMapper::toDto)
                            .collect(Collectors.toList())
            );
        }

        return dto;
    }

    public static User toEntity(UserDto dto) {
        if (dto == null) return null;

        User user = new User();
        user.setId(dto.getId());
        user.setNombre(dto.getNombre());
        user.setEmail(dto.getEmail());
        user.setTelefono(dto.getTelefono());

        if (dto.getOfertasPublicadas() != null) {
            user.setOfertasPublicadas(
                    dto.getOfertasPublicadas().stream()
                            .map(UserMapper::toEntity)
                            .collect(Collectors.toList())
            );
            // Para cada oferta, también hay que setear el creador
            user.getOfertasPublicadas().forEach(oferta -> oferta.setCreador(user));
        }

        return user;
    }

    public static OfertaEmpleoDto toDto(OfertaEmpleo oferta) {
        if (oferta == null) return null;

        OfertaEmpleoDto dto = new OfertaEmpleoDto();
        dto.setId(oferta.getId());
        dto.setTitulo(oferta.getTitulo());
        dto.setDescripcion(oferta.getDescripcion());
        dto.setEmpresa(oferta.getEmpresa().name());
        dto.setUbicacion(oferta.getUbicacion());
        dto.setSalario(oferta.getSalario());

        return dto;
    }

    public static OfertaEmpleo toEntity(OfertaEmpleoDto dto) {
        if (dto == null) return null;

        OfertaEmpleo oferta = new OfertaEmpleo();
        oferta.setId(dto.getId());
        oferta.setTitulo(dto.getTitulo());
        oferta.setDescripcion(dto.getDescripcion());
        // Si usas enum Empresa:
        oferta.setEmpresa(Enum.valueOf(Empresa.class, dto.getEmpresa()));
        oferta.setUbicacion(dto.getUbicacion());
        oferta.setSalario(dto.getSalario());

        return oferta;
    }

}
