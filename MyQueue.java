import java.util.Queue;
import java.util.LinkedList;

class MyStack 
{
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    
    public MyStack() 
    {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    public void push(int x) 
    {
        this.queue1.add(x);
    }
    
    public int pop() 
    {
        int temp = 0;
        while(!queue1.isEmpty())
        {
            temp = queue1.remove();
            if(!queue1.isEmpty())
            {
                queue2.add(temp);
            }
        }

        int toReturn = temp;
        while(!queue2.isEmpty())
        {
            queue1.add(queue2.remove());
        }        
        
        return toReturn;
    }
    
    public int top()
    {
        int temp = 0;
        while(!queue1.isEmpty())
        {
            temp = queue1.remove();
            queue2.add(temp);
        }

        int toReturn = temp;
        while(!queue2.isEmpty())
        {
            queue1.add(queue2.remove());
        }
        return toReturn;   
    }
    
    public boolean empty()
    {
        return queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */