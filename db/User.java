package db;

import service.ServiceImpl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by apple on 16.12.14.
 */
public class User implements IUser {
    private int id;
    private String login;
    private String password;
    private boolean online;

    Set<IUser> users = new HashSet<IUser>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = 31 * hash + id;
        return hash;
    }


    //returns User(IUser) object by login
    //If such user absents, throws NoSuchUserExeption
    public IUser getUserByLogin(String login) throws NoSuchUserExeption{
        for (Iterator<IUser> it = users.iterator(); it.hasNext(); ) {
            IUser f = it.next();
            if (f.getLogin().equals(login)) {
                return f;
            }
            else throw new NoSuchUserExeption();
        }
        return null;
    }

    //returns true if login & password equals login and password from DB
    //throws exeption if no such user
    public boolean login(String login, String password) throws NoSuchUserExeption{
        IUser user;
        user = getUserByLogin(login);
        if (login.equals(user.getLogin()) && (password.equals(user.getPassword()))){
            return true;
        }
        return false;
    }
}
