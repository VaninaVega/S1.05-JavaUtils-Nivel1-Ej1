import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        // Verifico si se proporcionó un argumento
        if (args.length == 0) {
            System.out.println("Please provide a directory path as an argument.");
        } else {
            // Obtengo el directorio desde los argumentos
            String directoryPath = args[0];
            // Listo y muestro el contenido del directorio
            listContent(new File(directoryPath), " ");
        }
    }

    public static void listContent(File directory, String tabulador) {

        tabulador += "   ";
        // Verifico si la ruta es válida
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Specified directory does not exist or is invalid: ");
            return;
        } else {

            // Obtengo los archivos y carpetas del directorio
            File[] content = directory.listFiles();

            if (content == null || content.length == 0) {
                System.out.println("Drectory is empty." + directory.getAbsolutePath());
            } else {
                // Ordeno los nombres alfabéticamente
                Arrays.sort(content, Comparator.comparing(File::getName));

                for (File f : content) {
                    if (f.isDirectory()) {
                        System.out.println(tabulador + "D " + f.getName());
                        listContent(f, tabulador);
                    } else {
                        System.out.println(tabulador + "F " + f.getName());
                    }
                }
            }
        }
    }
}
