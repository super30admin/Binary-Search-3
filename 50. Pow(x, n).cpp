class Solution {
public:
    //Time: (log(n))^2
    //Space: log(n) * log(n) = (log(n))^2
    /*
    Approach: Use the exponential property of when 2 numbers with same base get multiplied, their exponet get added
    So count the exponents in 2s powers (x^1, x^2, x^4) - simply by multiplying x^k with x^k = x^2k
    stop when k it exceeds n
    then use previous exponents to sum up to n
    */
    double myPow(double x, int nn) {
        bool positive = x >= 0 || (nn%2==0);
        bool inverse = nn < 0;

        if(nn==0)  return 1;

        double n = nn;
        

        if(x<0)  x *= -1;
        if(n<0)  n *= -1;

        vector<double> pow = {1};
        vector<double> val = {x};
        
        while(1){
            double curr_val = val[val.size()-1];
            double curr_p = pow[pow.size()-1];

            //cout<<curr_p<<" "<<curr_val<<endl;

            if(curr_p == n)  break;
            
            for(int i=pow.size()-1;i>=0;i--){
                double p = pow[i];
                double v = val[i];

                //multiplying numbers with same base but different exp = their exponents get added
                //try from the highest exponent first (that will result in 2x the exponent)
                if(curr_p + p <= n){
                    pow.push_back(curr_p+p);
                    val.push_back(curr_val*v);
                    break;
                }
            }
        }

        double ans = val[val.size()-1];
        ans = inverse ? 1.0/ans : ans;

        if(!positive) ans = -1 * ans;
        return ans;

    }
};
