package lt.salon.booking.userservice.service;

import lt.salon.booking.userservice.exception.UserException;
import lt.salon.booking.userservice.modal.User;

import java.util.List;

public interface UserService {
    User creaeUser(User user);
    User getUserById(Long id) throws UserException;
    List<User> getAllUsers();
    void deleteUser(Long id) throws UserException;
    User updateUser(Long id, User user) throws UserException;
}
