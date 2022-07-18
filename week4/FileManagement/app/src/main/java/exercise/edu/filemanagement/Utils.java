package exercise.edu.filemanagement;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {

    public static List<File> getListFiles(File file) {
        File[] files = file.listFiles();
        if (files != null) {
            return new ArrayList<>(Arrays.asList(files));
        }
        return null;
    }

    public static FileModel fromFileToFileModel(File file) {
        return new FileModel(file.getName(), file.getAbsolutePath(), getFileType(file));
    }

    public static FileType getFileType(File file) {
        if (file.isDirectory()) {
            return FileType.DIRECTORY;
        }
        String extension;
        int index = file.getName().lastIndexOf(".");
        if (index > 0) {
            extension = file.getName().substring(index + 1);
        } else {
            return null;
        }

        if (extension.equals("jpg")
                || extension.equals("webp")
                || extension.equals("png")
                || extension.equals("bmp")
                || extension.equals("tiff")
                || extension.equals("jpeg")
        ) {
            return FileType.IMAGE;
        }

        if (extension.equals("txt")) {
            return FileType.TEXT;
        }

        return null;

    }
}
