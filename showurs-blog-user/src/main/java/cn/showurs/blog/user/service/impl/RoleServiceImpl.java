package cn.showurs.blog.user.service.impl;

import cn.showurs.blog.common.constant.RoleInfo;
import cn.showurs.blog.common.core.impl.EntityServiceImpl;
import cn.showurs.blog.user.entity.RoleEntity;
import cn.showurs.blog.user.entity.RolePowerEntity;
import cn.showurs.blog.user.service.PowerService;
import cn.showurs.blog.user.service.RoleService;
import cn.showurs.blog.common.vo.user.Power;
import cn.showurs.blog.common.vo.user.Role;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by CJ on 2018/12/24 16:23.
 */
@Service
public class RoleServiceImpl extends EntityServiceImpl<RoleEntity, Role> implements RoleService {
    @Resource
    private PowerService powerService;

    @Override
    public Optional<Role> poToVoOptional(RoleEntity po) {
        if (super.poToVoOptional(po).isPresent()) {
            Role role = super.poToVoOptional(po).get();
            Set<Power> powers = powerService.posToVos(po.getRolePowers().stream().map(RolePowerEntity::getPower).collect(Collectors.toSet()));
            role.setPowers(powers);
            return Optional.of(role);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Role poToVo(RoleEntity po) {
        if (po == null) {
            return null;
        }
        Role role = super.poToVo(po);
        Set<Power> powers = powerService.posToVos(po.getRolePowers().stream().map(RolePowerEntity::getPower).collect(Collectors.toSet()));
        role.setPowers(powers);
        return role;
    }
}
