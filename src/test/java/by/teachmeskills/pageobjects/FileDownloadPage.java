package by.teachmeskills.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;

/*
    File Download (с зорачкай)
      - Изучить https://www.swtestacademy.com/download-file-in-selenium/ ;
      - Скачать файл;
      - Проверить наличие файла на файловой системе.
    http://the-internet.herokuapp.com/download
 */
public class FileDownloadPage extends BasePage {
    @FindBy(xpath = "//div[@class='example']/a")
    private List<WebElement> linksDownload;

    final String USER_HOME = System.getProperty("user.home");
    final String PATH_FILE = USER_HOME + "/Downloads";

    public FileDownloadPage() {
        driver.get(baseUrl + "/download");
        PageFactory.initElements(driver, this);
    }

    public boolean checkDownloadFile(int downloadNumber) throws InterruptedException, IOException {
        String fileName = downloadFile(downloadNumber);
        waitForFile(Path.of(PATH_FILE), fileName);
        boolean checkFile = checkIfFileExistsInDirectory(fileName, PATH_FILE);
        if (checkFile) {
            File file = new File(PATH_FILE + File.separator + fileName);
            file.delete();
        }
        return checkFile;
    }

    private String downloadFile(int downloadNumber) {
        WebElement el = linksDownload.get(downloadNumber);
        el.click();
        return el.getText();
    }

    private static void waitForFile(Path directory, String fileName) throws IOException, InterruptedException {
        WatchService watchService = FileSystems.getDefault().newWatchService();
        directory.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
        boolean fileFound = false;
        while (!fileFound) {
            WatchKey key = watchService.take();
            for (WatchEvent<?> event : key.pollEvents()) {
                if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                    Path filePath = ((WatchEvent<Path>) event).context();
                    if (filePath.getFileName().toString().equals(fileName)) {
                        fileFound = true;
                        break;
                    }
                }
            }
            key.reset();
        }
    }

    public static boolean checkIfFileExistsInDirectory(String fileName, String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            return false;
        }
        File[] files = directory.listFiles();
        if (files == null) {
            return false;
        }
        return Arrays.stream(files)
                .filter(File::isFile)
                .anyMatch(file -> file.getName().equals(fileName));
    }
}





