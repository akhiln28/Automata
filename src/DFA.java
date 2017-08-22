import java.util.Arrays;
import java.util.Scanner;

public class DFA {
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        //no. of states in the automata
        int n = input.nextInt();
        /*now i have no idea how to make the 2d table which takes current state and input symbol
          and output the next state next_state = f(current_state,input);
          since there are only 26 alphabets creating a 2d array of size n x 26 is good*/
        int dfa[][] = new int[n][26];
        //no. of alphabets in the automata
        int m = input.nextInt();
        for(int i = 0;i < n;i++)
        {
            for(int j = 0;j < m;j++)
                dfa[i][j] = input.nextInt();
        }
        //no. of final states
        int f = input.nextInt();
        int final_states[] = new int[f];
        for(int i = 0;i < f;i++)
            final_states[i] = input.nextInt();
        //dfa is taken
        while(input.hasNextLine())
        {
            String str = input.nextLine();
            check(dfa,str,final_states);
        }

    }

    private static void check(int[][] dfa, String str,int[] final_states) {
        int state = 0;
        for (int i = 0;i < str.length();i++)
        {
            state = dfa[state][str.charAt(i)];
        }
        //if state is present in the final states
        if(Arrays.asList(final_states).contains(state))
            System.out.println("Accepted");
        else System.out.println("Rejected");
    }

}
