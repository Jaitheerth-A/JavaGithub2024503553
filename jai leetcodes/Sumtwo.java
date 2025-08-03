import java.util.*;
class Sumtwo {
    public int[] twoSum(int[] nums, int target)
    {
        int a=0,ret[]=new int[2];
        for(int i:nums)
        {a=++i;}
        for(int i=0;i<a;i++)
        for(int j=0;j<a;j++)
        {
            if((nums[i]+nums[j]==target) && (i!=j))
            {
                ret[0]=i;ret[1]=j;
            }
        }return ret;
    }
    public static void main(String[] args)
     {
        try(Scanner sc=new Scanner(System.in);){
            int n,t;System.out.println("enter size:");
            n=sc.nextInt();
            int a[]=new int[n];
            System.out.println("enter target:");
            t=sc.nextInt();
            Sumtwo b=new Sumtwo();
            System.out.println(Arrays.toString(b.twoSum(a,t)));
        }
    }
}