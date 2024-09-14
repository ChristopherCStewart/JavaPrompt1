import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<User> myUserList = new ArrayList<>();

        List<User> myUserListResults = new ArrayList<>();

        User user1 = new User("John", "Doe", "123-456-7890");
        myUserList.add(user1);

        User user2 = new User("Bob", "Doe", "(456)789-0123");
        myUserList.add(user2);

        User user3 = new User("Frank", "Doe102345", "1234567890");
        myUserList.add(user3);

        myUserListResults = cleanUserData(myUserList);

        for (int i = 0; i < myUserListResults.size(); i++) {
            System.out.println(myUserListResults.get(i).firstName + ", " + myUserListResults.get(i).lastName + ", " + myUserListResults.get(i).telephoneNumber + "\n");
        }
    }



    public static class User
    {
        // constructor
        public User(String fn, String ln, String tn)
        {
            this.firstName = fn;
            this.lastName = ln;
            this.telephoneNumber = tn;
        }
        public String firstName;
        public String lastName;
        public String telephoneNumber;

        public String getFirstName() { return firstName; }
        public void setFirstName(String firstName) { this.firstName = firstName; }

        public String getLastName() { return lastName; }
        public void setLastName(String lastName) { this.lastName = lastName; }

        public String getTelephoneNumber() { return telephoneNumber; }
        public void setTelephoneNumber(String telephoneNumber) { this.telephoneNumber = telephoneNumber; }
    }

    public static List<User> cleanUserData(List<User> users)
    {
        List<User> validUsers = new ArrayList<>();

        for (User user : users) {
            // check for null or empty values
            if (user.firstName != null && !user.firstName.isEmpty() &&
                    user.lastName != null && !user.lastName.isEmpty() &&
                    user.telephoneNumber != null && !user.telephoneNumber.isEmpty()) {

                // check that firstName and LastName are only alphabetic
                if (user.firstName.chars().allMatch(Character::isLetter) &&
                        user.lastName.chars().allMatch(Character::isLetter)) {

                    // remove any non-numeric characters from telephoneNumber
                    user.telephoneNumber = user.telephoneNumber.replaceAll("[^0-9]", "");

                    // if telephoneNumber length is 10 then we are all good. Add user to return list
                    if (user.telephoneNumber.length() == 10) {
                        validUsers.add(user);
                    }
                }
            }
        }
        return validUsers;
    }
}