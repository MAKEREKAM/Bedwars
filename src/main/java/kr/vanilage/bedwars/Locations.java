package kr.vanilage.bedwars;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.SpawnCategory;

import java.util.HashMap;

public class Locations {
    static World world = Bukkit.getWorld("world");

    // 아이템 상점
    static Location Shop1 = new Location(world, -16.5, 65, -88, 90, 0);
    static Location Shop2 = new Location(world, 35.5, 65, -88, 90, 0);
    static Location Shop3 = new Location(world, 92, 65, -19.5, 180, 0);
    static Location Shop4 = new Location(world, 92, 65, 32.5, 180, 0);
    static Location Shop5 = new Location(world, 23.5, 65, 89, -90, 0);
    static Location Shop6 = new Location(world, -28.5, 65, 89, -90, 0);
    static Location Shop7 = new Location(world, -85, 65, 20.5, 0, 0);
    static Location Shop8 = new Location(world, -85, 65, -31.5, 0, 0);

    public static final Location[] SHOPS = {Shop1, Shop2, Shop3, Shop4, Shop5, Shop6, Shop7, Shop8};

    // 스폰 위치
    public static final Location SpawnRed = new Location(world, -23, 65, -87, 0, 0);
    public static final Location SpawnBlue = new Location(world, 29, 65, -87, 0, 0);
    public static final Location SpawnGreen = new Location(world, 90, 65, -26, 90, 0);
    public static final Location SpawnYellow = new Location(world, 90, 65, 26, 90, 0);
    public static final Location SpawnAqua = new Location(world, 29, 65, 87, 180, 0);
    public static final Location SpawnWhite = new Location(world, -23, 65, 87, 180, 0);
    public static final Location SpawnPink = new Location(world, -84, 65, 26, -90, 0);
    public static final Location SpawnGray = new Location(world, -84, 65, -26, -90, 0);

    // 침대 위치
    public static final Location[] BedRed = {new Location(world, -23, 66, -75), new Location(world, -23, 66, -76)};
    public static final Location[] BedBlue = {new Location(world, 29, 66, -75), new Location(world, 29, 66, -76)};
    public static final Location[] BedGreen = {new Location(world, 78, 66, -26), new Location(world, 79, 66, -26)};
    public static final Location[] BedYellow = {new Location(world, 78, 66, 26), new Location(world, 79, 66, 26)};
    public static final Location[] BedAqua = {new Location(world, 29, 66, 75), new Location(world, 29, 66, 76)};
    public static final Location[] BedWhite = {new Location(world, -23, 66, 75), new Location(world, 29, 66, 76)};
    public static final Location[] BedPink = {new Location(world, -72, 66, 26), new Location(world, -73, 66, 26)};
    public static final Location[] BedGray = {new Location(world, -72, 66, -26), new Location(world, -73, 66, -26)};

    // 자원 생성 위치
    public static final Location[] BasicGenerator = {new Location(world, -23, 65, -91), new Location(world, 29, 65, -91), new Location(world, 94, 65, -26), new Location(world, 94, 65, 26), new Location(world, 94, 65, -26), new Location(world, 29, 65, 91), new Location(world, -23, 65, 91), new Location(world, 29, 65, 91), new Location(world, -88, 65, 26), new Location(world, -88, 65, -26)};
    public static final Location[] DiamondGenerator = {new Location(world, 55, 67, -52), new Location(world, 55, 65, 52), new Location(world, -49, 65, 52), new Location(world, -49, 65, -52)};
    public static final Location[] EmeraldGenerator = {new Location(world, -7, 65, 14), new Location(world, 13, 65, -14), new Location(world, 3, 87, 7), new Location(world, 3, 87, -7)};
}
