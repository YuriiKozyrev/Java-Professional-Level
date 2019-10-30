package Java_Prof_Level.Lesson_4;

import java.util.concurrent.TimeUnit;

public class MFU {


    public static void main(String[] args) {

        MFU mfuPrintingDevice = new MFU();
        MFU mfuScanningDevice = new MFU();

        final int usersInPrintingQuery = 1;
        final int usersInScanningQuery = 4;

        for (int i = 0; i < usersInPrintingQuery; i++) {
            int finalI = i;
            Thread printing = new Thread(() -> {
                try {
                    mfuPrintingDevice.printing(finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            printing.start();
        }

        for (int i = 0; i < usersInScanningQuery; i++) {
            int finalI = i;
            Thread scanning = new Thread(() -> {
                try {
                    mfuScanningDevice.scanning(finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            scanning.start();
        }

    }

    public  synchronized void printing(int i) throws InterruptedException {

            int delay = 5;
            System.out.println("Печатаю Документ " + i + " - лист1.......");
            TimeUnit.SECONDS.sleep(delay);
            System.out.println("Печатаю Документ " + i + " - лист2.......");
            TimeUnit.SECONDS.sleep(delay);
            System.out.println("Печатаю Документ " + i + " - лист3.......");
            TimeUnit.SECONDS.sleep(delay);
            System.out.println("Документ " + i +  " напечатан!");

    }

    public  synchronized void scanning(int i) throws InterruptedException {

            int delay = 3;
            System.out.println("Сканирую Документ " + i + " - Рисунок 1.......");
            TimeUnit.SECONDS.sleep(delay);
            System.out.println("Сканирую Документ " + i + " - Рисунок 2.......");
            TimeUnit.SECONDS.sleep(delay);
            System.out.println("Сканирую Документ " + i + " - Рисунок 3.......");
            TimeUnit.SECONDS.sleep(delay);
            System.out.println("Сканирование Документа " + i + " завершено!");

    }
}
