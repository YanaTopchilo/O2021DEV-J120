package override;

import java.util.Random;
import java.util.ArrayList;
public class User {

        private int id;
        private String name;
        private boolean isAdmin;
        ArrayList<User> list = new ArrayList<>();
        public User() { }
        /** Конструктор, определяющий все поля класса.
         * @param id уникальный идентификатор пользователя.
         * @param name имя пользователя.
         * @param isAdmin задаёт значение true, если
        пользователь
         * является администратором системы.
         * @throws UserException выбрасывается в случаях, когда:
         * - идентификатор пользователя не уникален;
         * - имя пользователя равно null или является пустым.
         * (Класс данного исключения определите самостоятельно).
         */


        public User(int id, String name, boolean isAdmin){
                 this.id = id;
                this.name = name;
                this.isAdmin = isAdmin;

                list.add(User.this);
        }

        public int getId() {
                return id;
        }

        public void setId(int id) throws UserException {
                for (int i = 1; i< list.size(); i++) {
                        if (id == list.get(i).id)
                                throw new UserException("ID is non-unique");
                }
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
                text += "ID " + this.id;
                text += " имя " + this.name;
                if (this.isAdmin = true)
                {  text += " Admin";}
            else
                text += " not Admin";
               return text;
        }


/**throws override.UserException {

        /**
         * Метод клонирует объект данного класса по следующим
         * правилам:
         * - имя пользователя name и поле isAdmin дублируются;
         * - для идентификатора id выбирается новое уникальное
         * значение (в данной задаче можно генерировать случайное
         * значение, например, с помощью метода Math.random()).
         * @return ссылка на клон данного объекта.
         * @throws CloneNotSupportedException выбрасывается в
         * случае, когда имя пользователя равно null или является
         * пустой строкой.
         */
 /**       @Override
        protected Object clone() throws CloneNotSupportedException {
// Реализация метода ...
        }
        /**
         * Метод сравнивает по содержанию текущий объект с объектом
         * obj.
         * @param obj ссылка на объект, с которым сравнивается
         * текущий объект.
         * @return возвращает значение true, если имя пользователя
         * name и значение поля isAdmin у обоих объектов совпадают.
         */
  /**      @Override
        public boolean equals(Object obj) {
            // Реализация метода...
        }
        /**
         * Метод возвращает хэш-код данного объекта. Алгоритм
         * вычисления кода должен учитывать имя пользователя и
         * значение поля isAdmin.
         * @return хэш-код объекта.
         */
   /**     @Override
        public int hashCode() {
            // Реализация метода...
        }
**/


    }
