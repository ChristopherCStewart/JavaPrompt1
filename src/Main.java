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
            System.out.println(myUserListResults.get(i).FirstName + ", " + myUserListResults.get(i).LastName + ", " + myUserListResults.get(i).TelephoneNumber + "\n");
        }
    }



    public static class User
    {
        // constructor
        public User(String fn, String ln, String tn)
        {
            this.FirstName = fn;
            this.LastName = ln;
            this.TelephoneNumber = tn;
        }
        public String FirstName;
        public String LastName;
        public String TelephoneNumber;

        public String getFirstName() { return FirstName; }
        public void setFirstName(String firstName) { this.FirstName = FirstName; }

        public String getLastName() { return LastName; }
        public void setLastName(String LastName) { this.LastName = LastName; }

        public String getTelephoneNumber() { return TelephoneNumber; }
        public void setTelephoneNumber(String telephoneNumber) { this.TelephoneNumber = TelephoneNumber; }
    }

    public static List<User> cleanUserData(List<User> users)
    {
        List<User> validUsers = new ArrayList<>();

        for (User user : users) {
            // check for null or empty values
            if (user.FirstName != null && !user.FirstName.isEmpty() &&
                    user.LastName != null && !user.LastName.isEmpty() &&
                    user.TelephoneNumber != null && !user.TelephoneNumber.isEmpty()) {

                // check that FirstName and LastName are only alphabetic
                if (user.FirstName.chars().allMatch(Character::isLetter) &&
                        user.LastName.chars().allMatch(Character::isLetter)) {

                    // remove any non-numeric characters from TelephoneNumber
                    user.TelephoneNumber = user.TelephoneNumber.replaceAll("[^0-9]", "");

                    // if TelephoneNumber length is 10 then we are all good. Add user to return list
                    if (user.TelephoneNumber.length() == 10) {
                        validUsers.add(user);
                    }
                }
            }
        }
        return validUsers;
    }
}