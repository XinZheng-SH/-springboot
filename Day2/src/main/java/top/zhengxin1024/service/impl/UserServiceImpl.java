package top.zhengxin1024.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.zhengxin1024.entity.User;
import top.zhengxin1024.mapper.UserMapper;
import top.zhengxin1024.service.UserService;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
