import java.util.Scanner;

public class ArrayClientProgram {
   public static void main (String [] args) {
      Scanner scan = new Scanner(System.in);
      int choices, again, element, input;
      System.out.print("How many elements would you like to start with? ");
      element = scan.nextInt();
      arrayQueue array = new arrayQueue(element);
      System.out.print("Enter the elements you want to start with (separate by space): ");
      
      for (int i = 1; i <= element; i++) {
         int starter = scan.nextInt();
         array.enqueue(starter);
      }
      
      do {
         System.out.print("What do you wish to do:\n");
         do {
            System.out.print("[1] Enqueue\n");
            System.out.print("[2] Dequeue\n");
            System.out.print("[3] Show front\n");
            System.out.print("[4] Show all\n");
            choices = scan.nextInt();
            
            if (choices != 1 && choices != 2 && choices != 3 && choices != 4) {
               System.out.print("Input error. Please try again.\n");
            }
         }
         while (choices != 1 && choices != 2 && choices != 3 && choices != 4);
         
         if (choices == 1) {
            System.out.println("Enter item to enqueue: ");
            input = scan.nextInt();
            array.enqueue(input);                                                     //call enqueue function
            System.out.println("\nCurrent queue/s: ");
            array.display();
         }
         
         if (choices == 2) {
            array.dequeue();                                                     //call enqueue function
            System.out.println("\nCurrent queue/s: ");
            array.display();
         }
         
         if (choices == 3) {
            array.front();
         }
         
         if (choices == 4) {
            System.out.println("\nCurrent queue/s: ");
            array.display();
         }
         do {
            System.out.println("\nWould you like to start again? ");
            System.out.println("[1] Yes \n[2] No");
            System.out.print("Enter input: ");
            again = scan.nextInt();
            
            if (again != 1 && again != 2) {
               System.out.print("Input error. Please try again.");
            }
         }
         while (again != 1 && again != 2);
      }
      while (again == 1);
   }
}

class arrayQueue {
   private static int front, back, size, array[];
   
   arrayQueue(int element) {
      back = 0;
      front = back;
      size = 100;
      array = new int[size];
   }
   
   static void enqueue(int item) {
      if(size == back) {                                                                
         System.out.println("Queue is full.");
      }
      
      else {
         array[back] = item;
         back++;
      }
      
      return;
   }
   
   static void dequeue() {
      if(front == back) {                                                                
         System.out.println("Queue is empty.");
         return;
      }
      
      else {
         for(int i = 0; i < back - 1; i++) {
            array[i] = array[i + 1];
         }
         if(back < size) {
            array[back] = 0;
         }
         back--;
      }
      
      return;
   }
    
   static void display() {
      int i; 
      if(front == back) {
         System.out.println("Queue is empty.");
         return;
      }
   
      for(i = front; i < back; i++) {
         System.out.print(array[i] + " < ");
      }
      
      return;
   }
   
   static void front() {
      if(front == back) {
         System.out.println("Queue is empty.");
         return;
      }
      System.out.println("Front element: " + array[front]);
      return;
   }
}