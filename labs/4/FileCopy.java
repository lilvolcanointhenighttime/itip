import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        String sourceFilePath = "file.txt";
        String destinationFilePath = "file2.txt";

        try {
            copyFile(sourceFilePath, destinationFilePath);
            System.out.println("File copy successful!");
        } catch (IOException e) {
            System.err.println("Error during file copy: " + e.getMessage());
        }
    }

    public static void copyFile(String sourceFilePath, String destinationFilePath) throws IOException {
        // Открываем потоки для чтения и записи файлов
        try (InputStream inputStream = new FileInputStream(sourceFilePath);
             OutputStream outputStream = new FileOutputStream(destinationFilePath)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            inputStream.close();
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        } catch (FileNotFoundException e) {
            throw new IOException("File not found: " + e.getMessage());
        } catch (IOException e) {
            throw new IOException("Error during file copy: " + e.getMessage());
        }
    }
}
