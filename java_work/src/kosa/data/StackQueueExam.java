package kosa.data;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueueExam {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();	// stack 자료구조
		Queue<Integer> queue = new LinkedList<>();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		
		System.out.println("---stack---");
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		
		System.out.println("---queue---");
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}
}
