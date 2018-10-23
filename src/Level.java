import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.awt.Rectangle;

public class Level {
    private GameWorld world;
    public static ArrayList<Platform> platforms = new ArrayList<>();
    public static ArrayList<Monster> monsters = new ArrayList<>();
    public Level(GameWorld world,int level) {
        this.world = world;
        String file = "level" +level+ ".txt";
        readFile(file);
        for(Platform p:platforms)
        {
            world.addPlatform(p);
        }

    }

    public void readFile(String file)
    {
        Scanner scanner;
        try{
            scanner = new Scanner(new File((file)));

        } catch (FileNotFoundException e) {
            System.out.println(file+" not found");
            return;
        }
        int numMonster = Integer.parseInt(scanner.nextLine());
        int numShooter = Integer.parseInt(scanner.nextLine());
        while (scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            Scanner lineScanner = new Scanner(line);
            ArrayList<Integer> rectData = new ArrayList<>();
            while (lineScanner.hasNext())
            {
                rectData.add(lineScanner.nextInt());
            }
            System.out.println(rectData);
            Platform r = new Platform(rectData.get(0),rectData.get(1),rectData.get(2),rectData.get((3)));
            System.out.println(r.toString());
            platforms.add(r);
            lineScanner.close();
        }
        scanner.close();
    }
}
