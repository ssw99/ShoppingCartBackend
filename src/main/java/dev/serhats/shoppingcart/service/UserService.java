package dev.serhats.shoppingcart.service;

import dev.serhats.shoppingcart.exception.EntityNotFoundException;
import dev.serhats.shoppingcart.model.User;
import dev.serhats.shoppingcart.model.repo.UserRepo;
import org.springframework.transaction.annotation.Transactional;

public interface UserService extends BaseService<User, UserRepo> {
    @Transactional
    User updatePassword(long userId, String oldPassword, String newPassword) throws EntityNotFoundException;
    @Transactional
    User updateEmail(long userId, String email) throws EntityNotFoundException;
}
