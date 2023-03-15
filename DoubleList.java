// todo: Double Linked List Implementation using Stack Data Structure...

import java.util.Scanner;
import java.util.Stack;
public class DoubleList
{
    //! Inserting Node at the End of the Linked List... O(1) time...
    public void InsertNode(int value, Stack<Integer> sck)
    {
        sck.push(value);
        System.out.println("The Node is added !! ");
        return;
    }
    //! Removing Node from End of the Linked List... O(1) time... 
    public void RemoveNode(Stack<Integer> sck)
    {
        sck.pop();
        System.out.println("The Node is removed !! ");
        return;
    }
    //! Removing Node by value of a particular Node in the Linked List... O(n) time...
    public void RemoveNodeByValue(Stack<Integer> sck, Stack<Integer> sck1, int data)
    {
        while(sck.peek() != data)
        {
            int pop = sck.pop();    // Popping to Second Stack...
            sck1.push(pop);
        }
        sck.pop();
        while(!sck1.isEmpty())
        {
            int pop1 = sck1.pop();     // Again popping from Second Stack to First Stack...
            sck.push(pop1);
        }
        System.out.println("The Required Node has been removed !!");
        return;
    }
    //! Printing Nodes of the Linked List... O(n) time...
    public void PrintNodes(Stack<Integer> sck, Stack<Integer> sck1)
    {
        System.out.println("The Double Linked List Implemented as a Stack is : ");
        while(!sck.isEmpty())
        {
            int pop = sck.pop();    // Popping to Second Stack...
            sck1.push(pop);
        }
        while(!sck1.isEmpty())
        {
            System.out.print(sck1.peek() + " -> ");
            int pop = sck1.pop();     // Again Popping back...
            sck.push(pop);
        }
        System.out.println();
        return;
    }
    //! Inserting Nodes by value in the Linked List... O(n) time...
    public void InsertNodeByValue(Stack<Integer> sck, Stack<Integer> sck1, int val, int value)
    {
        while(sck.peek() != val)
        {
            int pop = sck.pop();        // Nodes checked by Value...
            sck1.push(pop);
        }
        sck.push(value);   //? Data Inserted in the Linked List...
        System.out.println("The Node has been Inserted !!");
        while(!sck1.isEmpty())
        {
            int pop1 = sck1.pop();     // Data again retrieved from the Second Stack...
            sck.push(pop1);
        }
        return;
    }
    //! Searching a Node in the Linked List... O(n) time...
    public void SearchNode(Stack<Integer> sck, Stack<Integer> sck1, int t)
    {
        while(!sck.isEmpty())
        {
            if(sck.peek() != t)
            {
                int pop = sck.pop();
                sck1.push(pop);
            }
        }
        if(sck.isEmpty())   // If the Stack is Empty... The Node was not present...
        {
            System.out.println("The Element is Not Present in the Linked List !!");
            while(!sck1.isEmpty())
            {
                int pop1 = sck1.pop();
                sck.push(pop1);
            }
            return;
        }      // Otherwise the Node was present in the Linked List...
        System.out.println("The Element is Present in the Linked List !!");
        while(!sck1.isEmpty())
        {
            int pop1 = sck1.pop();
            sck.push(pop1);
        }
        return;
    }
    //! Main function begins...
    public static void main (String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        DoubleList doublelist = new DoubleList();
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> stack1 = new Stack<Integer>();
        int x, a, n;
        System.out.print("Enter the number of Operations ot be performed : ");
        x = scanner.nextInt();
        for(int i = 0; i < x; i++)
        {
            System.out.print("Enter 1 to add node, 2 to remove node, 3 to print, 4 to add node by value, 5 to remove node by value, 6 to search for a Node : ");
            a = scanner.nextInt();
            switch(a)
            {
                case 1:
                System.out.print("Enter Node value : ");
                n = scanner.nextInt();
                doublelist.InsertNode(n, stack);    //? Function call... O(1) time...
                break;
                case 2:
                doublelist.RemoveNode(stack);     //? Function call... O(1) time...
                break;
                case 3:
                doublelist.PrintNodes(stack, stack1);    //? Function Call 0(n) time...
                break;
                case 4:
                System.out.print("Enter Node data where to be Inserted : ");
                n = scanner.nextInt();
                System.out.print("Enter Node data : ");
                int n1 = scanner.nextInt();
                doublelist.InsertNodeByValue(stack, stack1, n, n1);   //? Function Call... O(n) time...
                break;
                case 5:
                System.out.print("Enter the Node value to be removed : ");
                n = scanner.nextInt();
                doublelist.RemoveNodeByValue(stack, stack1, n);   //? Function Call... O(n) time...
                break;
                case 6:
                System.out.print("Enter Node value: ");
                n = scanner.nextInt();
                doublelist.SearchNode(stack, stack1, n);       //? Function call... O(n) time...
                break;
                default:
                System.out.println("Wrong Choice Entered !!");
            }
        }
        scanner.close();
    }
}

//! Time Complexity - O(n) time...
//! Space Complexity - O(n) space...