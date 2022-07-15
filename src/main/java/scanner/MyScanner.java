package scanner;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Класс ввода данных через консоль
 *
 */
public class MyScanner {
    Scanner read;
    public MyScanner(){
        read = new Scanner(System.in);
    }
    public MyScanner(String nameOfFile) throws FileNotFoundException {

        InputStream myFile = getFileFromResourceAsStream(nameOfFile);
        read= new Scanner(myFile);
    }
    public String readNextLine(){
        try {
            return read.nextLine();
        } catch (NoSuchElementException e){
            return "";
        }

    }
    public boolean hasNext(){
        return read.hasNext();
    }

    /**
     * Открытие файла не по URL-сслыке
     * @param fileName
     * @return
     */
    private InputStream getFileFromResourceAsStream(String fileName) {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(fileName);

            if (inputStream == null) {
                throw new IllegalArgumentException("file not found! " + fileName);
            } else {
                return inputStream;
            }
        }
        catch (IllegalArgumentException e){
            System.out.println("Файл не найден");
            return null;
        }
    }
}
