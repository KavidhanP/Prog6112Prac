package prog6112poe;

import javax.swing.JOptionPane;

public class Prog {

    int x = 0; //for question
   public String[] Student = new String[10];
   public String[] StudentName = new String[10];
   public String[] StudentEmail = new String[10];
   public  String[] StudentCourse = new String[10];
   public int[] StudentNumber = new int[10];
   public  int[] StudentAge = new int[10];

   public int y = 0; // to store promt valie
   public  int z;
    int w = 0;
    String q;

    public void Launch() {

        x = Integer.parseInt(JOptionPane.showInputDialog("Student Management Application\n ******************************************\n Enter 1 to launch or any other key to exit"));

        if (x == 1) {
            JOptionPane.showMessageDialog(null, "Welcome to the Student Manager");

        } else {

            System.exit(0);
        }

    }
    
    public void savestudent(){
      while (x == 1) {

                boolean validInput = false;
                while (!validInput) {
                    try {
                        StudentNumber[y] = Integer.parseInt(JOptionPane.showInputDialog("Please enter student id"));
                        validInput = true;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Invalid input! Please enter a number.");

                    }

                }

                StudentName[y] = JOptionPane.showInputDialog("Enter Student Name");

                StudentAges();

                StudentEmail[y] = JOptionPane.showInputDialog("Enter Student Email");

                StudentCourse[y] = JOptionPane.showInputDialog("Enter Student Course");

                y++;
                
                JOptionPane.showMessageDialog(null, "Student information captured ");

                x = 0;

            }
    
    
    
    }

    public void menu() {
        while (x != 5) {
            x = Integer.parseInt(JOptionPane.showInputDialog("Menu Options: \n1) Capture a new Student \n2) Search for a Student \n3) Delete a Student \n4) Print student report \n5) Exit"));

           savestudent();

            searchstudents();

            createreport();
            
            
            
            
            deletestudent();
                    

        }

    }

    public void StudentAges() {

        boolean validInput = false;
        while (!validInput) {

            try {
                StudentAge[y] = Integer.parseInt(JOptionPane.showInputDialog("Please enter student Age "));
                if (StudentAge[y] >= 16) {
                    validInput = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Age, Please re-enter age ");

                    StudentAge[y] = Integer.parseInt(JOptionPane.showInputDialog("Please enter student Age "));
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter a number, Please re-enter age ");
            }

        }
    }

    public void searchstudents() {

        while (x == 2) {
            z = Integer.parseInt(JOptionPane.showInputDialog("Enter Student id"));
            boolean StudentNum = false;

            for (w = 0; w < y; w++) {
                if (z == StudentNumber[w]) {
                    JOptionPane.showMessageDialog(null, "Student ID : " + StudentNumber[w] + "\nStudent Name : " + StudentName[w] + "\nStudent Age : " + StudentAge[w] + "\nStudent Email : " + StudentEmail[w] + "\nStudent Course : " + StudentCourse[w]);
                    x = 0;
                    StudentNum = true;

                }

                if (!StudentNum) {

                    int st = Integer.parseInt(JOptionPane.showInputDialog("Invalid Student ID, Please press 1 to launch menu or any other key to exit"));
                    if (st == 1) {
                        x = 0;
                    } else {
                        x = 5;

                    }

                }

            }

        }
    }
    
    
         public static String[] removeElement(String[] array, int index) {
        if (array == null || index < 0 || index >= array.length) {
            return array;
        }
        String[] newArray = new String[array.length - 1];
        for (int i = 0, k = 0; i < array.length; i++) {
            if (i == index) {
                continue;
            }
            newArray[k++] = array[i];
        }
        return newArray;
    }

    // Method to remove an element from an int array
    public static int[] removeElement(int[] array, int index) {
        if (array == null || index < 0 || index >= array.length) {
            return array;
        }
        int[] newArray = new int[array.length - 1];
        for (int i = 0, k = 0; i < array.length; i++) {
            if (i == index) {
                continue;
            }
            newArray[k++] = array[i];
        }
        return newArray;
    }
    
    public void deletestudent(){
    while(x == 3){
        int deletestudent =  Integer.parseInt(JOptionPane.showInputDialog("Enter the student id to delete:"));
        int indexToDelete = -1;

        for (int i = 0; i < y; i++) {
            if (StudentNumber[i] == (deletestudent)) {
               q = JOptionPane.showInputDialog(" Are you sure you want to delete this student from the system? Yes(y) to delete. ");
                if(q.equalsIgnoreCase("y")){
                indexToDelete = i;
                break;
                }
                else{
                x = 0;
                }
            }
        }

        if (indexToDelete != -1) {
            for (int i = indexToDelete; i < y - 1; i++) {
                StudentName[i] = StudentName[i + 1];
                StudentAge[i] = StudentAge[i + 1];
                StudentNumber[i] = StudentNumber[i + 1];
                StudentEmail[i] = StudentEmail[i + 1];
                StudentCourse[i] = StudentCourse[i + 1];
            }

            y--; // Reduce the number of students
            JOptionPane.showMessageDialog(null, deletestudent + " has been deleted.");
            x = 0;
        } else {
            JOptionPane.showMessageDialog(null, "student not found.");
            x = 0;
        }

    
    
    
    }
    
    }
    
    

    public void createreport() {
        while (x == 4) {

            for (w = 0; w < y; w++) {
                {
                    JOptionPane.showMessageDialog(null, "Student ID : " + StudentNumber[w] + "\nStudent Name : " + StudentName[w] + "\nStudent Age : " + StudentAge[w] + "\nStudent Email : " + StudentEmail[w] + "\nStudent Course : " + StudentCourse[w]);

                }
                x = 0;
            }
        }
    }

}
