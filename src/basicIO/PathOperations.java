package basicIO;

import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Bext on 01/02/2017.
 */
public class PathOperations {
    public static void main(String[] args) {

        Path p1 = Paths.get("/temp/foo");
        if (args.length > 1) {
            Path p2 = Paths.get(args[0]);
        }
        Path p3 = Paths.get(URI.create("file:///Users/joe/test.java"));

        Path p4 = FileSystems.getDefault().getPath("/users/sally");
        System.out.println(p4.toString());

        Path p5 = Paths.get(System.getProperty("user.home"),"logs","foo.log");
        System.out.println(p5.toString());
        //regresa C:\Users\Bext\logs\foo.log

        // None of these methods requires that the file corresponding
        // to the Path exists.
        // Microsoft Windows syntax
        //Path path = Paths.get("C:\\home\joe\foo");

        //Solaris syntax
        //Path path2 = Paths.get("/home/joe/foo");

        Path path = p5;

        System.out.format("toString: %s%n", path.toString());
        System.out.format("getFileName: %s%n", path.getFileName());
        System.out.format("getName(0): %s%n", path.getName(0));
        System.out.format("getName(1): %s%n", path.getName(1));
        System.out.format("getNameCount: %d%n", path.getNameCount());
        System.out.format("subpath(0,2): %s%n", path.subpath(0,2));
        System.out.format("path.subpath().toAbsolutePath: %s%n", path.subpath(0,2).toAbsolutePath());
        System.out.format("getParent: %s%n", path.getParent());
        System.out.format("getRoot: %s%n", path.getRoot());

        //get a relative path
        path = path.subpath(0,2);
        System.out.format("get a relative path subpath(0,2): %s%n", path.subpath(0,2));
        System.out.format("toString: %s%n", path.toString());
        System.out.format("getFileName: %s%n", path.getFileName());
        System.out.format("getName(0): %s%n", path.getName(0));
        System.out.format("getName(1): %s%n", path.getName(1));
        System.out.format("getNameCount: %d%n", path.getNameCount());
        System.out.format("subpath(0,2): %s%n", path.subpath(0,2));
        System.out.format("getParent: %s%n", path.getParent());
        System.out.format("getRoot: %s%n", path.getRoot());

        path = FileSystems.getDefault().getPath("/home/./joe/foo");
        System.out.format("toString : %s%n", path.toString());
        System.out.format("normalize().toString: %s%n",path.normalize().toString());

        path = FileSystems.getDefault().getPath("/home/sally/../joe/foo");
        System.out.format("toString : %s%n", path.toString());
        System.out.format("normalize().toString: %s%n",path.normalize().toString());

        path = Paths.get(System.getProperty("user.dir"));
        System.out.format("toString : %s%n", path.toString());


    }
}
