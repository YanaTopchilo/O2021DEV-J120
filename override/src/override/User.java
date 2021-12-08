package override;

import java.util.Random;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User implements Cloneable {
    private int id;
    private String name;
    private boolean isAdmin;
    static ArrayList<User> list = new ArrayList<>();
    public User() { }

    public User(int id, String name, boolean isAdmin) throws UserException{
        setId(id);
        setName(name);
        this.isAdmin = isAdmin;
        list.add(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws UserException {
        if (!list.isEmpty())
        {
            for (int i = 0; i < list.size(); i++ ) {
                if (id == list.get(i).id)
                    throw new UserException("ID is non-unique");
            }}

        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws UserException {
        if(name == null)
            throw new UserException("Name can't be null");
        this.name = name;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String toString() {
        String text = "";
        text += "ID " + id;
        text += " имя " + name;
        if (isAdmin == true)
            text += " Admin";
        else
            text += " not Admin";
        return text;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException{

        User copyUser = new User();
        try {
            copyUser.setId(new Random().nextInt(999));
        } catch (UserException ex) {
            while (list.contains(id)){
            copyUser.id = new Random().nextInt(999);}
        }
        try {
            copyUser.setName(name);
        }   catch (UserException ex1){
            System.out.println(ex1.getMessage());
            System.exit(0);
        }
        copyUser.isAdmin = this.isAdmin;
        return copyUser;
    }

    @Override
    public boolean equals(Object obj) {
        User user;
        if (obj instanceof User) {
            user = (User)obj;
        } else return false;
        if (obj==null) {
            return false;
        }
        if (this==obj) return true;

        if (!name.equals(user.name)) return false;
        if (isAdmin!= user.isAdmin) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        int admin;
        if (isAdmin == true)
            admin = 1;
        else admin = 0;
        hash = name.hashCode() + admin ;
        return super.hashCode();
    }
}