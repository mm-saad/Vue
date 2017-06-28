package com.vuejs.dao;

import com.vuejs.dao.db.DAOFacade;
import com.vuejs.domain.users.Users;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceException;
import java.util.List;

import static com.vuejs.dao.db.DAOFacade.Parameter.param;

@Repository
public class UsersDAO {

    @Inject
    DAOFacade daoFacade;

    @Transactional
    public Users addUsers (Users users) throws PersistenceException {
        daoFacade.persist(users);
        daoFacade.flush();
        return users;
    }

    @Transactional
    public Users updateUsers (Users users) throws PersistenceException{
        users = daoFacade.merge(users);
        daoFacade.flush();
        return users;
    }

    @Transactional
    public Users getUserById (Long user_id){
        daoFacade.setFlushMode(FlushModeType.COMMIT);
        Users registredUser = (Users) daoFacade.getSingle(
                "select u from Users u where u.id =:id",
                param("id", user_id));
        return registredUser;
    }

    public List<Users> getAllUsers(){
        return daoFacade.getList("select u from Users u");
    }

    public Users getUser (long id) {
        return daoFacade.find (Users.class, id);
    }


}
