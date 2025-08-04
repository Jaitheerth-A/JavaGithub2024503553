import java.util.*;
class purchase
{
    purchase(){
    int team[][]={{11,14},{35,45},{12,18}};
        int price[]={2000,100,1000}; 
        int total[][]=new int[2][3];
        for(int i=0;i<team.length;i++)
        for(int j=0;j<2;j++)
        {
                total[j][i]=team[i][j]*price[i];
        }
        System.out.println("Men:");
        for(int i=0;i<total.length;i++)
        {
            for(int j=0;j<total[i].length;j++)
            {
                System.out.println(total[i][j]);
                if(j==total[i].length)break;
            }
            System.out.println("Woman:");
        }
        System.out.println("Total price of each team:");
        System.out.println(Arrays.toString(total[0]));
    }   
}
public class equipment {
    public static void main(String[] args) {
    purchase p1 = new purchase();
}
}
