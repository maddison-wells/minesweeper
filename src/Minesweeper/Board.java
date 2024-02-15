package Minesweeper;
import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;


public class Board {
    public Boolean hasWon = false;
    private String[][] array2D;
    public String [][] play2D;    
    public Boolean gameLost = false; 
    private int count = 0;


    public void printBoard() {
        String[][] play2D = new String[11][11]; 
        
        for (int j = 1; j < play2D[0].length; j++) {
            play2D[0][j] = " " + (j - 1) + " ";
        }
        
        for (int g = 1; g < play2D.length; g++) {
            play2D[g][0] = " " + (g - 1) + " "; 
        }

        for (int m = 1; m < play2D.length; m++) {
            for (int n = 1; n < play2D[m].length; n++) {
                play2D[m][n] = "[ ]";
                
            }
        }
        
        for (int i = 0; i < play2D.length; i++) {
            for (int j = 0; j < play2D[i].length; j++) {
                if (play2D[i][j] == null) {
                    System.out.print("   "); 
                } else {
                    System.out.print(play2D[i][j]);
                }
            }
            System.out.println();
        }
    }
    
    
    public String[] getMines() {
        String[] mineList = new String[10];
        Set<String> generatedCoordinates = new HashSet<>();

        for (int i = 0; i < mineList.length; i++) {
            int x, y;
            String coordinates;
            do {
                y = (int) (Math.random() * 10 + 1);
                x = (int) (Math.random() * 10 + 1);
                coordinates = x + "," + y;
            } while (generatedCoordinates.contains(coordinates)); 
            mineList[i] = coordinates;
            generatedCoordinates.add(coordinates);
        }
        return mineList;
    }
    
 
    
// 
    public void generateGame() {
        Scanner s = new Scanner(System.in);


    
     array2D = new String[11][11];
     play2D = new String[11][11]; 

        
        for (int m = 0; m < array2D.length; m++) {
            for (int n = 0; n < array2D[m].length; n++) {
                array2D[m][n] = "[0]";
            }
        }
      
        String[] mineList = getMines(); 
        
        for (String mine : mineList) {
            String[] parts = mine.split(",");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);
            array2D[x][y] = "[M]"; 
            

            
            for (int i = x - 1; i <= x + 1; i++) {
                for (int j = y - 1; j <= y + 1; j++) {
                    if (i >= 0 && i < array2D.length && j >= 0 && j < array2D[i].length) {
                        if (!array2D[i][j].equals("[M]")) {
                            if (array2D[i][j].equals("[7]")) {
                                array2D[i][j] = "[8]";
                            }else if (array2D[i][j].equals("[6]")) {
                                array2D[i][j] = "[7]"; 
                            } else if (array2D[i][j].equals("[5]")) {
                                array2D[i][j] = "[6]"; 
                            } else if (array2D[i][j].equals("[4]")) {
                                array2D[i][j] = "[5]"; 
                            } else if (array2D[i][j].equals("[3]")) {
                                array2D[i][j] = "[4]"; 
                            } else if (array2D[i][j].equals("[2]")) {
                                array2D[i][j] = "[3]"; 
                            }  else if (array2D[i][j].equals("[1]")) {
                                array2D[i][j] = "[2]"; 
                            } else {
                                array2D[i][j] = "[1]"; 
                            }
                        }
                    }
                }
            }

        }

  // 		print mine board and location
//        for (int i = 0; i < array2D.length; i++) {
//            for (int j = 0; j < array2D[i].length; j++) {
//                System.out.print(array2D[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println("\nMine Coordinates:");
//        for (String mine : mineList) {
//            System.out.println(mine);
//        }
   
    }   
    
    public void getCoOrdinates() {
        Scanner s = new Scanner(System.in);

        int X = 0;
        while (true) {
            System.out.println("Please enter Y co-ordinates (a number):");
            if (s.hasNextInt()) {
                X = s.nextInt() + 1;
                break; 
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                s.next(); 
            }
        }

    
        int Y = 0;
        while (true) {
            System.out.println("Please enter X co-ordinates (a number):");
            if (s.hasNextInt()) {
                Y = s.nextInt() + 1;
                break; 
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                s.next();
            }
        }

        if (X >= 0 && X < array2D.length && Y >= 0 && Y < array2D[0].length) {
            if (array2D[X][Y].equals("[M]")) {
                gameLost = true;
                return; 
            } else {
                // Increment count and check for win condition
                if (++count == 90) {
                    hasWon = true;
                    return;
                }
                // Continue with other actions for safe squares
                play2D[X][Y] = array2D[X][Y];
            }
        } else {
            System.out.println("Invalid coordinates. Please try again.");
        }


        for (int i = 0; i < play2D.length; i++) {
            for (int j = 0; j < play2D[i].length; j++) {
                if (play2D[i][j] == null) {
                    play2D[i][j] = "[ ]";
                }
            }
        }

        for (int j = 1; j < play2D[0].length; j++) {
            play2D[0][j] = " " + (j - 1) + " ";
        }

        for (int g = 1; g < play2D.length; g++) {
            play2D[g][0] = " " + (g - 1) + " ";
        }

        for (int i = 0; i < play2D.length; i++) {
            for (int j = 0; j < play2D[i].length; j++) {
                System.out.print(play2D[i][j]);
            }
            System.out.println();
        }
    }
    
}


    
        

        


        	
        
        
        

    
