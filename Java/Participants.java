import java.util.*;
class register
{
    String[] both(String[] a,String[] b)
    {
        int k=0;
        String c[]= new String[a.length>b.length? a.length: b.length];
        for(int i = 0; i < a.length; i++)
        {
            for(int j = 0; j < b.length; j++)
            {
                if(a[i].equals(b[j]))
                {
                    c[k]= a[i];
                    k++;
                }
            }
        }
        return c;
    }
    void display(String[] a)
    {
    
        System.out.println(Arrays.toString(a));
    }
}
public class Participants {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        register r = new register();
        
        System.out.print("Enter the number of participants in Online Quiz: ");
        int n1 = sc.nextInt();
        String[] teamA = new String[n1];
        sc.nextLine(); // consume newline
        
        System.out.println("Enter the names of participants in Online Quiz:");
        for (int i = 0; i < n1; i++) {
            teamA[i] = sc.nextLine();
        }
        
        System.out.print("Enter the number of participants in Paper Presentation: ");
        int n2 = sc.nextInt();
        String[] teamB = new String[n2];
        sc.nextLine(); // consume newline
        
        System.out.println("Enter the names of participants in Paper Presentation:");
        for (int i = 0; i < n2; i++) {
            teamB[i] = sc.nextLine();
        }
        
        String[] commonParticipants = r.both(teamA, teamB);

        System.out.println("Participants in Online Quiz:");
        r.display(teamA);

        System.out.println("Participants in Paper Presentation:");
        r.display(teamB);
        
        System.out.println("Common participants in both events:");
        r.display(commonParticipants);
        
        sc.close();
    }
}
