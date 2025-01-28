import java.io.File;

public class Main {

    public static void main(String[] args) {
        // Verifico si se proporcionó un argumento
        if (args.length == 0) {
            System.out.println("Please provide a directory path as an argument.");
        } else {
            // Obtengo el directorio desde los argumentos
            String directoryPath = args[0];
            // Listo y muestro el contenido del directorio
            listContent(directoryPath);
        }
    }

    public static void listContent(String path) {
        File directory = new File(path);

        // Verifico si la ruta es válida
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Specified directory does not exist or is invalid: " + path);
        } else {

            // Obtengo los archivos y carpetas del directorio
            File[] content = directory.listFiles();

            if (content == null || content.length == 0) {
                System.out.println("Drectory is empty.");
            } else {
                // Ordeno los nombres alfabéticamente
                for (int i = 0; i < content.length - 1; i++) {
                    for (int j = i + 1; j < content.length; j++) {
                        if (content[i].getName().compareToIgnoreCase(content[j].getName()) > 0) {
                            File temp = content[i];
                            content[i] = content[j];
                            content[j] = temp;
                        }
                    }
                }

                // Muestro el contenido del directorio
                System.out.println("Directory Contents (" + directory.getPath() + ") sorted alphabetically: ");
                for (int i = 0; i < content.length; i++) {
                    System.out.println(content[i].getName());
                }
            }
        }
    }
}