package net.marscraft.general.logging.files;

import com.google.gson.annotations.Since;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/**
 * @deprecated
 * @since 0.1.0-Development
 * */
public class FileHandler {

    private File file;

    public FileHandler(File file) {
        this.file = file;
    }

    public FileHandler(String filePath) {
        this(new File(filePath));
    }

    /**
     * Writes the given fileData to a File
     * @param fileData Data that gets written to File
     * @param append True -> fileData gets added to File<p>
     *               False -> file gets Overwritten
     * */
    public void write(List<String> fileData, boolean append) throws IOException {
        createFileWithDirectorys();
        BufferedWriter bWriter = new BufferedWriter(new FileWriter(file, append));
        for (String data : fileData) bWriter.write(data += "\n");
        bWriter.close();
    }

    /**
     * Reads the Given File and returns its data as List
     * @return FileData as List
     * */
    public List<String> read() throws IOException {
        BufferedReader bReader = new BufferedReader(new FileReader(file));
        List<String> fileData = new ArrayList<>();
        String line;
        while((line = bReader.readLine()) != null) {
            fileData.add(line);
        }
        bReader.close();
        return fileData;
    }

    /**
     * Creates the File with its Directorys
     * @return True if success
     * */
    public boolean createFileWithDirectorys() throws IOException {
        createDirectorys();
        if(file.isDirectory()) return true;
        return file.createNewFile();
    }

    /**
     * Creates Directorys of the File
     * */
    private void createDirectorys() {
        if(file.isDirectory()) file.mkdirs();
        else getDirectory(file).ifPresent(file -> file.mkdirs());
    }

    /**
     * Gets the Directory Path of the File
     * */
    private Optional<File> getDirectory(File target) {
        return Optional.ofNullable(target.getParentFile());
    }

    /**
     * Checks if the file Exists
     * */
    public boolean fileExists() { return file.exists(); }


}
