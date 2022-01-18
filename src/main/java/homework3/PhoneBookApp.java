package homework3;

public class PhoneBookApp {
    public static void main (String [] args){

        PhoneBook pb = new PhoneBook();

        pb.add ("Ivanov", "8800");
        pb.add ("Petrov", "8900");
        pb.add ("Sidorov", "8920");

        pb.get ("Ivanov");
    }

}
