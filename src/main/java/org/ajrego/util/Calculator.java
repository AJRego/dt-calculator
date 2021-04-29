package org.ajrego.util;

public class Calculator {
    // 1 byte = 8 bits
    // 1024 bytes = 1 kilobyte
    // 1024 kilobytes = 1 megabyte
    // 1024 megabytes = 1 gigabyte
    // 1024 gigabyte = 1 terabyte

    public static double getFileSizeInMB(String unit, double size) {
        switch (unit) {
            case "MB":
                return size;
            case "GB":
                return size * 1024;
            case "TB":
                return size * 1048576;
            default:
                return -1;
        }
    }

    public static double getDownloadSpeed(String unit, double speed) {
        switch (unit) {
            case "Kbps":
                return speed;
            case "Mbps":
                return ((speed * 1024) / 8);
            default:
                return -1;
        }
    }

    public static double getDownloadTime(String sizeUnit, double size, String speedUnit, double speed) {
        double downloadTime = ((getFileSizeInMB(sizeUnit, size)) * 1000);
        double downloadSpeed = getDownloadSpeed(speedUnit, speed);

        downloadTime = downloadTime / downloadSpeed;
        downloadTime = downloadTime / 60;

        return Math.round(downloadTime * 100.0) / 100.0;
    }

    public static int getMinutes(double downloadSpeed) {
        String str = String.valueOf(downloadSpeed);
        return Integer.parseInt(str.substring(0, str.indexOf('.')));
    }

    public static int getSeconds(double downloadSpeed) {
        String str = String.valueOf(downloadSpeed);
        return Integer.parseInt(str.substring(str.indexOf('.') + 1));
    }
}
