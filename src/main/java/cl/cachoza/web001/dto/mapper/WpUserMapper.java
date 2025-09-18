package cl.cachoza.web001.dto.mapper;

import cl.cachoza.web001.dto.WpUserDTO;
import cl.cachoza.web001.entity.WpUserEntity;

public class WpUserMapper {

    public static WpUserEntity toEntity(WpUserDTO dto) {
        WpUserEntity entity = new WpUserEntity();
        entity.setId(dto.getId());
        entity.setUserLogin(dto.getUserLogin());
        entity.setUserPass(dto.getUserPass());
        entity.setUserNicename(dto.getUserNicename());
        entity.setUserEmail(dto.getUserEmail());
        entity.setUserUrl(dto.getUserUrl());
        entity.setUserRegistered(dto.getUserRegistered());
        entity.setUserActivationKey(dto.getUserActivationKey());
        entity.setUserStatus(dto.getUserStatus());
        entity.setDisplayName(dto.getDisplayName());
        return entity;
    }

    public static WpUserDTO toDTO(WpUserEntity entity) {
        return new WpUserDTO(
            entity.getId(),
            entity.getUserLogin(),
            entity.getUserPass(),
            entity.getUserNicename(),
            entity.getUserEmail(),
            entity.getUserUrl(),
            entity.getUserRegistered(),
            entity.getUserActivationKey(),
            entity.getUserStatus(),
            entity.getDisplayName()
        );
    }
}