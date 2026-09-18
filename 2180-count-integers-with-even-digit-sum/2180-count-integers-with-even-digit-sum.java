class Solution {
    public int countEven(int num) {
        int sum=0;
        for(int i=1;i<=num;i++){
            int temp=0;
            int tem=i;
            while(tem!=0){
                int t=tem%10;
                temp+=t;
                tem/=10;
            }
            if(temp%2==0){
                sum++;
            }
        }
        return sum;
    }
}