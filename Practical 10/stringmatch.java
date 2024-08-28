import java.util.Scanner;
public class stringmatch{
    public static void matchString(String s1,String s2) {
        int n = s1.length();
        int m = s2.length();
        for (int s = 0; s <= n - m; s++) {
            int j;
            for (j = 0; j < m; j++)
                if (s1.charAt(s + j) != s2.charAt(j))
                    break;
            if (j == m)
                System.out.println("Pattern occurs at index " + s);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter a string: ");
        String str = sc.nextLine();
        System.out.print("\nEnter a string to search: ");
        String substr = sc.nextLine();
        System.out.println();
        matchString(str,substr);
    }
}