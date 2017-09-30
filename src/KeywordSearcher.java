import java.io.*;
import java.nio.file.*;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

class KeywordSearcher {

    public static void unZipIt(String zipFile, String outputFolder) {

        byte[] buffer = new byte[1024];

        try {
            //create output directory is not exists
            File folder = new File(outputFolder);
            if (!folder.exists()) {
                folder.mkdir();
            }

            //get the zip file content
            ZipInputStream zis =
                    new ZipInputStream(new FileInputStream(zipFile));
            //get the zipped file list entry
            ZipEntry ze = zis.getNextEntry();

            while (ze != null) {

                String fileName = ze.getName();
                File newFile = new File(outputFolder + File.separator + fileName);

                //create all non exists folders
                //else you will hit FileNotFoundException for compressed folder
                new File(newFile.getParent()).mkdirs();

                FileOutputStream fos = new FileOutputStream(newFile);

                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }

                fos.close();

//                System.out.println("file unzip : "+ newFile.getAbsoluteFile());

                ze = zis.getNextEntry();
            }

            zis.closeEntry();
            zis.close();

            System.out.println("Unzipped");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    static void findFiles(String folder) throws IOException {
        //Search by java folder only
        Path path = Paths.get(folder + "//java");
        //Folder to files
        try (Stream<Path> pstream = Files.walk(path)
                .filter(Files::isRegularFile)) {
            pstream.forEach(it -> {
                //Files to lines
                try (Stream<String> sstream = Files.lines(it)) {
                    if (isContain(sstream))
                        System.out.println(it);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private static boolean isContain(Stream<String> sstream) {
        return sstream.anyMatch(its ->
                its.contains("transient") ||
                its.contains("Transient") ||
                its.contains("volatile")  ||
                its.contains("Volatile"));
    }
}