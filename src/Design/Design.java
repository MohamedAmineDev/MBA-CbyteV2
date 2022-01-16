package Design;

public class Design {
    public static void dessinerLigne(int n) {
        int i = 0;
        do {
            System.out.print("-");
            i++;
        }
        while (i < n);
        System.out.println("");
    }

    public static void dessinerCases(Object[] tab, int longeur) {
        if (longeur > 0) {
            int i = 0;
            while (i < longeur) {
                System.out.print(tab[i]);
                i++;
            }
            System.out.println("");
        }
    }
}
