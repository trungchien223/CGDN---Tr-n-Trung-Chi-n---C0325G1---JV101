package ss11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class PrimeNumber {
    public static boolean isPrime(int n){
        if (n < 2){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
    public static Stack<Integer> usingStack(int n){
        Stack<Integer> stack = new Stack<>();
        for (int i = 2; i < n; i++) {
            if (isPrime(i)){
                stack.push(i);
            }
        }
        return stack;
    }
    public static Queue<Integer> usingQueue(int n){
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 2; i < n; i++) {
            if (isPrime(i)){
                queue.add(i);
            }
        }
        return queue;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap n: ");
        int n = scanner.nextInt();
        Stack<Integer> primeStack = usingStack(n);
        System.out.println("Cac so nguyen to Stack");
        System.out.println(primeStack);
        Queue<Integer> primeQueue = usingQueue(n);
        System.out.println("Cac so nnguyen to Queue");
        System.out.println(primeQueue);
    }
}
