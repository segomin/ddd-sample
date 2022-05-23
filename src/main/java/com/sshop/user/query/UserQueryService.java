package com.sshop.user.query;

import com.sshop.user.command.application.NoUserException;
import org.springframework.stereotype.Service;

@Service
public class UserQueryService {
    private UserDataDao userDataDao;

    public UserQueryService(UserDataDao userDataDao) {
        this.userDataDao = userDataDao;
    }

    public UserData getUserData(String userId) {
        UserData userData = userDataDao.findById(userId);
        if (userData == null) {
            throw new NoUserException();
        }
        return userData;
    }
}
