class MyStack {
   private:
    queue<int> q;

   public:
    MyStack() {}

    void push(int x) { q.push(x); }

    int pop() {
        queue<int> tmp;
        while (q.size() > 1) {
            tmp.push(q.front());
            q.pop();
        }
        int bottom = q.front();
        q.pop();
        while (tmp.size() > 0) {
            q.push(tmp.front());
            tmp.pop();
        }
        return bottom;
    }

    int top() { return q.back(); }

    bool empty() { return q.size() == 0; }
};

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack* obj = new MyStack();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->top();
 * bool param_4 = obj->empty();
 */