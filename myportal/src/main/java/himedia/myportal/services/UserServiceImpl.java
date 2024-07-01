package himedia.myportal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.myportal.repositories.dao.UserDao;
import himedia.myportal.repositories.vo.UserVo;
import jakarta.servlet.http.HttpServletRequest; // Use HttpServletRequest instead of HttpRequest
import jakarta.servlet.http.HttpSession;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    
    @Override
    public boolean join(UserVo vo) {
        int insertedCount = 0;
        insertedCount = userDao.insert(vo);
        return insertedCount == 1;
    }

    @Override
    public UserVo getUser(String email) {
        UserVo userVo = userDao.selectUser(email);
        return userVo;
    }

    @Override
    public UserVo getUser(String email, String password) {
        UserVo userVo = userDao.selectUser(email, password);
        return userVo;
    }

    public boolean isAuthenticated(HttpServletRequest request) {
        // Use HttpServletRequest to check authentication status through the session
        HttpSession session = request.getSession(false);
        if (session != null) {
            UserVo authUser = (UserVo) session.getAttribute("authUser");
            return authUser != null;
        }
        return false;
    }
}