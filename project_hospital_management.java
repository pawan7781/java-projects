import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


interface dashboard 
{

    void new_registration();

    void login_patient();

    void book_appointment();

    void view_appointments();

    void feedback();

}

interface dashboard2 
{
    void welcome();
}

interface dashboard3 
{
    void doctor_list();
}

class doctors implements dashboard3 
{ 
    private String dName;
    private String dCategory;

    public doctors(String dName, String dCategory) 
    {
        this.dName = dName;
        this.dCategory = dCategory;

    }

    public String toString() 
    {
        return dName + "->" + dCategory;
    }

    public void doctor_list() 
    {

        doctors d1 = new doctors("Dr. Ravi", "cardiologist");
        doctors d2 = new doctors("Dr. ramesh", "neurologist");
        doctors d3 = new doctors("Dr. nikhil", "urologist");
        doctors d4 = new doctors("Dr. praveen", "surgeon");
        doctors d5 = new doctors("Dr. lokesh", "Dentist");
        doctors d6 = new doctors("Dr. Gaurav", "Pathologist");
        doctors d7 = new doctors("Dr. kanhaiya", "Orthopedic surgen");
        doctors d8 = new doctors("Dr. Piyush ", "Dermatologist");

        ArrayList dlist = new ArrayList<doctors>();
        dlist.add(d1);
        dlist.add(d2);
        dlist.add(d3);
        dlist.add(d4);
        dlist.add(d5);
        dlist.add(d6);
        dlist.add(d7);
        dlist.add(d8);

        Iterator itr = dlist.iterator();
        while (itr.hasNext()) 
        {
            
            System.out.println(itr.next());
        }
    }
}

class Patient1 implements dashboard 
{
    String name;
    int age;
    String disease;
    int n;

    ArrayList add_patient = new ArrayList();
    LocalDate D = LocalDate.now();
    LocalTime T = LocalTime.now();
    HashMap hm = new HashMap();
    Scanner sc = new Scanner(System.in);
    String user_id = "pawan7";
    int pass_code= 777;
    

    public void dash_b() 
    {
        System.out.println("Are you registered ?");
        System.out.println("enter Y for yes and N for no (Y/N)");

        String choice = sc.next();

        switch (choice) 
        {

            case "N":
                new_registration();
                break;

            case "Y":
                login_patient();
                break;

            default:
                System.out.println("please enter valid input");
        }
    }

    public void new_registration() 
    {
        Patient1 p1 = new Patient1();

        System.out.println("please enter your name");
        p1.name = sc.next();
        System.out.println("please enter your age");
        p1.age = sc.nextInt();
        System.out.println("enter your disease");
        p1.disease = sc.next();
        add_patient.add(p1);
        System.out.println("registration done");
        set_username();
        set_password();
        login();
    }

    public void set_username() 
    {

        System.out.println("enter user_id");
        user_id = sc.next();

    }

    public void set_password() 
    {
        System.out.println("enter password");
        pass_code = sc.nextInt();
    }

    public void login() 
    {
        System.out.println("1. press 1 for login");
        System.out.println("2. press 2 for exit");
        int key = sc.nextInt();

        switch (key) 
        {
            case 1:
                login_patient();
                break;

            case 2:
                reception r = new reception();
                r.welcome();
                break;
            default:
                System.out.println(" enter valid option");
                break;
        }
    }

    public void login_patient() 
    {
        System.out.println("enter username for login");
        String user1 = sc.next();
        System.out.println("enter password for login");
        int pass1 = sc.nextInt();

        if (user1.equals(user_id) && pass_code == pass1) 
        {
            System.out.println("you are logged in");
            book_appointment();
        } 
        else 
        {
            System.out.println("enter correct username and password");
        }
    }

    public void book_appointment() 
    {
        Long mobile;
        System.out.println("enter your username and mobile number ");
        System.out.print("username-> ");
        String user2 = sc.next();
        System.out.println();
        System.out.print("mobile no.-> ");
        System.out.println();
        mobile = sc.nextLong();
        doctors d = new doctors(null, null);
        d.doctor_list();

        System.out.println("enter doctor name according to your desease");

        String doc = sc.next();

        System.out.println("enter date / month / year for appointment");
        int date, month, year;
        date = sc.nextInt();
        month = sc.nextInt();
        year = sc.nextInt();

        System.out.println("__________________________________________________________________________________");
        System.out.println("-----------------------------------------------------------------------------------");

        System.out.println("\t\t\t\tPLG MULTISPECIALIST HOSPITAL");
        System.out.println("\t\t\t\t\tBHOPAL");

        if (date <= 31 && month <= 12 && year > 2022) 
        {

            System.out.println("*************************************************************************************");
            System.out.println("patient name->" + user2);
            System.out.print("mobile number->" + mobile);
            System.out.println("\t\t\t\t\t\t" + D);
            System.out.println("doctor->" + doc);
            System.out.println("************************************************************************************");

            System.out.println("your appointment is booked on " + date + "/" + month + "/" + year);
            System.out.println();
            hm.put(n, user2);
            n++;

            System.out.println("press 1 for view appointments press 2 for exit and press 3 for feedback and press 4 for book another appointment");
            int i = sc.nextInt();
            switch (i) 
            {
                case 1:
                    view_appointments();
                    break;

                case 2:
                    reception r = new reception();
                    r.welcome();
                    break;

                case 3:
                    feedback();
                    break;
                
                case 4:
                    book_appointment();
                    break;

                default:
                    System.out.println("invalid input!");
                    // break;
            }
        } 
        else 
        {
            System.out.println("invalid!");
        }
    }

    public void view_appointments() 
    {
        System.out.println("*******************************************************************************");
        System.out.println("your all appointments are :");
        System.out.println(hm);
        System.out.println("*******************************************************************************");
        System.out.println("press 1 for feedback and press 2 for exit");
        n = sc.nextInt();
        switch (n) 
        {
            case 1: 
            {
                feedback();
                break;
            }
            case 2: 
            {
                reception c = new reception();
                c.welcome();
                break;
            }
            default: 
            {
                System.out.println("enter valid input");
            }

        }

    }

    public void feedback() 
    {
        System.out.println("how much would you like to rate us");
        System.out.println("press 5 for ->\t * * * * *");
        System.out.println("press 4 for ->\t  * * * * ");
        System.out.println("press 3 for ->\t   * * * ");
        System.out.println("press 2 for ->\t    * * ");
        System.out.println("press 1 for ->\t     * ");

        int rate = sc.nextInt();
        switch (rate) 
        {
            case 5:
                System.out.println("thanks for your feedback - 5 star");
                break;

            case 4:
                System.out.println("thanks for your feedback - 4 star");
                break;

            case 3:
                System.out.println("thanks for your feedback - 3 star");
                break;

            case 2:
                System.out.println("thanks for your feedback - 2 star");
                break;

            case 1:
                System.out.println("thanks for your feedback - 1 star");
                break;

            default:
                System.out.println("please enter valid input!");
                // break;
        }

    }

}

class reception extends Patient1 implements dashboard2 
{
    public void welcome() 
    {
        System.out.println("*************************************************************************************");
        System.out.println("\t\t\tPLG MULTISPECIALIST HOSPITAL");
        System.out.println("\t\t\t\t  BHOPAL");
        System.out.println("*************************************************************************************");
        System.out.print(D);
        System.out.println("\t\t\t\t\t\t\t" + T);
        System.out.println("*************************************************************************************");
        dash_b();
    }
}

public class project_HM 
{
    public static void main(String[] args) 
    {
        reception r = new reception();
        int k = 0;
        while (k >= 0) 
        {
            r.welcome();
            k++;
        }

    }
}