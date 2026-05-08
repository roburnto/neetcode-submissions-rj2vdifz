class MinStack {
public:
    stack<int> min;
    stack<int> s;
    MinStack() {
        
    }
    
    void push(int val) {
        s.push(val);
        if(min.empty() || min.top() >= val){
            min.push(val);
        }
    }
    
    void pop() {
        int val = s.top();
        s.pop();
        if(val == min.top()){
            min.pop();
        }
    }
    
    int top() {
        return s.top();
    }
    
    int getMin() {
        return min.top();
    }
};
