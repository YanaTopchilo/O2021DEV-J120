package override;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException  {

        try {
            User user1 = new User(100, "Ivanov", true);
            User user2 = new User(101, "Petrov", false);
            User user3 = new User(102, "Kuznecov", false);
            User user4 = (User) user1.clone();
            System.out.println(user1);
            System.out.println(user2);
            System.out.println(user3);
            System.out.println(user4);
            System.out.println(user1.equals(user2));
            System.out.println(user4.equals(user1));
            System.out.println(user3.hashCode());

        }

        catch (UserException ex){
            System.out.println(ex.getMessage());
            System.exit(0);
        }

    }
    }



