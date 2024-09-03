import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import prog6112poe.Prog;


/**
 *
 * @author kanda
 */
public class Test1 {
    
   
    private Prog prog;

    @Before
    public void setUp() {
        prog = new Prog(); // Initialize the Prog object before each test
        
        
        prog.StudentNumber[0] = 12345;
        prog.StudentName[0] = "Kavi";
        prog.StudentAge[0] = 18;
        prog.StudentEmail[0] = "Kavi.p@example.com";
        prog.StudentCourse[0] = "Computer Science";
        prog.y  = 0;
    }

        @Test
    public void testAddStudent() {
        // Simulate adding a student
        prog.StudentNumber[0] = 12345;
        prog.StudentName[0] = "Kavi";
        prog.StudentAge[0] = 18;
        prog.StudentEmail[0] = "Kavi.p@example.com";
        prog.StudentCourse[0] = "Computer Science";
        
      
        // Check if the information was stored correctly
        Assert.assertEquals(12345, prog.StudentNumber[0]);
        Assert.assertEquals("Kavi", prog.StudentName[0]);
        Assert.assertEquals(18, prog.StudentAge[0]);
        Assert.assertEquals("Kavi.p@example.com", prog.StudentEmail[0]);
        Assert.assertEquals("Computer Science", prog.StudentCourse[0]);
    }
    
    @Test
    public void testSearchStudent(){
    
    int searchNumber = 123; // To store the inutted student value
    
    boolean found = false;
     for (int i = 0; i < prog.y; i++) {
            if (prog.StudentNumber[i] == searchNumber) {
    prog.StudentNumber[0] = 123;
    prog.StudentName[0] = "Kavi";
    prog.StudentAge[0] = 18;
    prog.StudentEmail[0] = "Kavi.p@example.com";
    prog.StudentCourse[0] = "Computer Science";
    
    Assert.assertEquals(123, prog.z);
    Assert.assertEquals(123, prog.StudentNumber[0]);
        Assert.assertEquals("Kavi ", prog.StudentName[0]);
        Assert.assertEquals(18, prog.StudentAge[0]);
        Assert.assertEquals("Kavi.p@example.com", prog.StudentEmail[0]);
        Assert.assertEquals("Computer Science", prog.StudentCourse[0]);
    
     found = true;
                break;
            }
            
         assertTrue("Student has been found", found);
        }
    
    
    }

    
    @Test
    public void testSearchStudent_StudentNotFound(){
    
    int searchNumber = 93;
    boolean found = false;
    
    for (int i = 0; i < prog.y; i++) {
            if (prog.StudentNumber[i] == searchNumber) {
            found = true;  
    
            
            }
            
           
            break;
            
  
    
    }
     assertFalse("Student should not be found", found);
    
    }
    
    
    @Test
    public void TestStudentAge_StudentAgeValid(){
      // Set up the index where the age will be stored
        prog.y = 0; // Assume we're adding the first student

        // Simulate valid age input
        int validAge = 18;

        // Check if the age is within the valid range (>= 16)
        if (validAge >= 16) {
            prog.StudentAge[prog.y] = validAge; // Store the valid age
        }

        // Assert that the age was stored correctly
        assertEquals("Valid age should be stored correctly", validAge, prog.StudentAge[prog.y]);
    }
    
    @Test
    public void TestStudentAge_StudentAgeInvalid(){
      // Set up the index where the age will be stored
        prog.y = 0; // Assume we're adding the first student

        // Simulate valid age input
        int InvalidAge = 15;

        // Check if the age is within the valid range (>= 16)
        if (16 > InvalidAge ) {
            prog.StudentAge[prog.y] = InvalidAge; // Store the valid age
        }

        // Assert that the age was stored correctly
        assertEquals("Invalid Age", InvalidAge, prog.StudentAge[prog.y]);
    }
    
    
    
    @Test(expected = NumberFormatException.class)
    public void TestStudentAge_StudentAgeInvalidCharacter(){
      // Set up the index where the age will be stored
        prog.y = 0; // Assume we're adding the first student

        // Simulate invalid character input
        String invalidCharacter = "W";

        // Attempt to parse the invalid character to an integer (this should throw an exception)
        int age = Integer.parseInt(invalidCharacter);

        // If it does not throw, assign it (but it will throw)
        prog.StudentAge[prog.y] = age;

    }
    
    
    @Test
    public void testDeleteProfile() {
        // Simulate deleting the student profile
        String deleteName = "Kavi";
        boolean studentFound = false;

        for (; -1 < prog.y;) {
            if (prog.StudentName[0].equalsIgnoreCase(deleteName)) {
                prog.StudentName[0] = null; // Simple deletion by nullifying the entry
                prog.StudentNumber[0] = 0;
                prog.StudentAge[0] = 0;
                prog.StudentEmail[0] = null;
                prog.StudentCourse[0] = null;
                studentFound = true;
                break;
            }
        }

        // Assert that the student profile was deleted
        assertTrue("Student profile should be deleted", studentFound);
        assertNull("Student name should be null after deletion", prog.StudentName[0]);
    }
    
    
    
       @Test
    public void testDeleteProfile_StudentNotFound() {
        // Simulate deleting the student profile
        String deleteName = "Kavidhan";
        boolean studentFound = false;

        for (int i = 0; i < prog.y; i++) {
            if (prog.StudentName[i].equalsIgnoreCase(deleteName)) {
                prog.StudentName[i] = null; // Simple deletion by nullifying the entry
                prog.StudentNumber[i] = 0;
                prog.StudentAge[i] = 0;
                prog.StudentEmail[i] = null;
                prog.StudentCourse[i] = null;
                studentFound = true;
                break;
            }
            else{
            studentFound = false;
            
            
            }
        }

        // Assert that the student profile was deleted
        assertFalse("Student can not be found", studentFound);
       
    }
    
    
    
    }

