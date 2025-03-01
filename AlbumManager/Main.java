import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        String Title;
        String Artist;
        String Genre;
        int Songs;

        System.out.println("Enter Album name: ");
        Title = user.nextLine();

        System.out.println("Enter Artist name: ");
        Artist = user.nextLine();

        System.out.println("Enter genre: ");
        Genre = user.nextLine();

        System.out.println("Enter number of songs: ");
        Songs = user.nextInt();

        Album album1 = new Album(Title, Artist, Genre, Songs);
        System.out.println(album1.toString());
    }
}