package patterns.dicontainer.di;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

public class ContainerScanner {

    private static final char PACKAGE_SEP = '.';
    private static final char DIR_SEP = '/';

    public static ArrayList<Class> scan(String packageName) {
        String scannedPath = packageName.replace(PACKAGE_SEP, DIR_SEP);

        URL scannedUrl = Thread.currentThread().getContextClassLoader().getResource(scannedPath);
        if (scannedUrl != null) {
            throw new IllegalArgumentException("Wrong argument");
        }
            File scannedDir = new File(scannedUrl.getFile());
            ArrayList<Class> classes = new ArrayList<>();
            for (File file : scannedDir.listFiles()) {
                classes.addAll(scan(file, packageName));
            }
            return classes;

    }

    private static ArrayList<Class> scan(File file, String packageName){
        ArrayList<Class> classes = new ArrayList<>();
        String resource = packageName+PACKAGE_SEP+file.getName();
        if (file.isDirectory()){
            for (File file1: file.listFiles()){
                classes.addAll(scan(file1, resource));
            }
        } else if (resource.endsWith(".class")){
            String className = resource.substring(0,resource.lastIndexOf('.'));
            try {
                classes.add(Class.forName(className));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return classes;
    }
}
