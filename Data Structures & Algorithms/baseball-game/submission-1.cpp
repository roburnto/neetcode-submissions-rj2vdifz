class Solution {
   public:
    int calPoints(vector<string>& operations) {
        stack<int> s;

        for (string operation : operations) {
            if (operation == "+") {
                int b = s.top();
                s.pop();
                int a = s.top();
                s.pop();
                int sum = a + b;
                s.push(a);
                s.push(b);
                s.push(sum);
            } else if (operation == "C") {
                s.pop();
            } else if (operation == "D") {
                int doub = 2 * s.top();
                s.push(doub);
            } else {
                s.push(stoi(operation));
            }
        }
        int sum = 0;
        while (!s.empty()) {
            sum += s.top();
            s.pop();
        }
        return sum;
    }
};