package mars_rover;

/*
 * The MIT License
 *
 * Copyright 2017 brijendra98.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

 import java.io.*;

 /**
  *
  * @author Brijendra Nag
  */

 public class Mars_Rover {

     /*Three variables which determine the
     state of a particular Mars Rover*/
     int direction; //indicates where the rover is pointing
                    // 1:North ; 2:East ; 3:South ; 4:West
     int x; //x-coordinate of the rover
     int y; //y-coordinate of the rover

     static int grid_x; //stores x-coordinate for the plateau size
     static int grid_y; //stores y-coordinate for the plateau size


     // Mars_Rover(dir,X,Y) creates an instance of the
     // Mars_Rover and sets its direction, x and y
     // co-ordinates to dir, X, Y respectively
     // requires: X,Y are valid points on the plateau
     //           dir >= 1 and dir <= 4
     Mars_Rover(int dir, int X, int Y) {
       assert((X>=0 && X<=grid_x) && (Y>=0 && Y<=grid_x)) :
               "The point "+"("+X+","+Y+")"+" does not lie on the plateau.";
       assert(dir>=1 && dir<=4):
               "Not a valid direction for the rover to point at";

       direction = dir;
         x = X;
         y = Y;
     }

     // dir_char_to_int(ch) consumes a character representing direction
     // of the rover and returns the corresponding number to represent
     // the same thing.
     // requires: ch should be one of 'N', 'E', 'S', or 'W'
     static int dir_char_to_int(char ch) {
         assert(ch=='N' || ch=='E' || ch=='S' || ch=='W'):
                 ch+" is not a valid direction";

         switch (ch) {
             case 'N':
                 return 1;
             case 'E':
                 return 2;
             case 'S':
                 return 3;
             case 'W':
                 return 4;
             default:
                 return 0;
         }
     }

     // dir_int_to_char(n) consumes an integer representing direction
     // of the rover and returns the corresponding character to represent
     // the same thing.
     // requires: n>=1 and n<=4
     static char dir_int_to_char(int n) {
         assert(n>=1 && n<=4):
                 "Not a valid direction";

         switch (n) {
             case 1:
                 return 'N';
             case 2:
                 return 'E';
             case 3:
                 return 'S';
             case 4:
                 return 'W';
             default:
                 return ' ';
         }
     }

     // move(mr) consumes a Mars_Rover, moves it one step in its
     // direction and returns the modified Mars_Rover
     // requires: mr should be a valid Mars_Rover
     static Mars_Rover move(Mars_Rover mr) {
         // Using a switch statement to check for rover's
         // direction and then making a move accordingly
         switch (mr.direction) {
             case 1:
                 mr.y ++;
                 break;
             case 2:
                 mr.x ++;
                 break;
             case 3:
                 mr.y --;
                 break;
             case 4:
                 mr.x --;
                 break;
             default:
               break;
         }
         return mr; //returning the modified rover
     }

     // change_dir(mr, direction) consumes a Mars_Rover, a direction,
     // and turns the rover 90 degrees in the given direction,
     // and returns the modified rover
     // requires: mr should be a valid Mars_Rover
     //           direction should be one of 'L' or 'R'
     static Mars_Rover change_dir(Mars_Rover mr, char direction) {
       assert(direction == 'L' || direction == 'R'):
               direction + " is not a valid command for the rover";

       // A series of if-else statements to check the rover's current
       // orientation and then change it according to the given command
         if(direction == 'L') {
             if(mr.direction == 1) {
                 mr.direction = 4;
             }
             else {
                 mr.direction --;
             }
         }
         else if(direction == 'R') {
             if(mr.direction == 4) {
                 mr.direction = 1;
             }
             else {
                 mr.direction ++;
             }
         }
         return mr; //returning the modified rover
     }

     // respond_to_command(ch, mr) consumes a Mars_Rover, a command,
     // and returns the modified Mars_Rover after performing
     // the command on it
     // requires: mr should be a valid Mars_Rover
     //           ch should be one of 'M', 'L', or 'R'
     static Mars_Rover respond_to_command(char ch, Mars_Rover mr) {
          assert(ch == 'L' || ch == 'R' || ch == 'M'):
               ch + " is not a valid command for the rover";

         // A switch statement to check for the command and then modify the 
         // state of the rover accordingly, and return the modified rover
         switch (ch) {
             case 'M':
                 return move(mr);
             case 'L':
             case 'R':
                 return change_dir(mr,ch);
             default:
                 return mr;
         }
     }
     

      public static void main(String[] args) throws IOException {
          // Initializing the BufferedReader which will be used to
          // take input from the user
          BufferedReader br = new BufferedReader
         (new InputStreamReader(System.in));
         
         // Taking the grid size from the user and storing it 
         // to the global variables
         String grid_size = br.readLine();
         grid_x = grid_size.charAt(0);
         grid_y = grid_size.charAt(3);
         
         // Creating an array which will store and 
         // keep track of all 5 Mars_Rover
         Mars_Rover arr[] = new Mars_Rover[5];
         int cur_len = 0;

         // Loop which will one-by-one take commands for
         // each rover and then perform commands on it
         for(int i = 0;i<arr.length;i++) {
             // Taking in the initial state of a rover and 
             // then creating a Mars_Rover object out of it
             String input = br.readLine();
             if (input.equals("")) {break;} //breaking in case of invalid input
             int x = Integer.parseInt(input.charAt(0) + "");
             int y = Integer.parseInt(input.charAt(2) + "");
             int dir = dir_char_to_int(input.charAt(4));
             Mars_Rover rv = new Mars_Rover(dir,x,y);
             cur_len++;
             
             // Taking in commands to be performed on the rover,
             // performing each command using previously defined functions
             String commands = br.readLine();
             for(int j = 0;j<commands.length();j++) {
                 char ch = commands.charAt(j);
                 rv = respond_to_command(ch,rv);
             }
             
             // Storing the final state of the rover in the array
             arr[i] = rv;
         }

         // A loop which goes through the array and prints
         // the present state of each rover
         for(int i = 0;i<cur_len;i++) {
             char direc = dir_int_to_char(arr[i].direction);
             System.out.println(arr[i].x + " " + arr[i].y + " " + direc);
         }
     }

 }

