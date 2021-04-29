package org.ajrego.util;

public class Calculator {
    // 1 byte = 8 bits
    // 1024 bytes = 1 kilobyte
    // 1024 kilobytes = 1 megabyte
    // 1024 megabytes = 1 gigabyte
    // 1024 gigabyte = 1 terabyte

    double getFileSizeInMB(String unit, double size) {
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

    double getDownloadSpeed(String unit, double speed){
        switch (unit){
            case "Kbps": return speed;
            case "Mbps": return ((speed * 1024) / 8);
            default: return -1;
        }
    }

    public double getDownloadTime(String sizeUnit, double size, String speedUnit, double speed){
        double downloadTime = ((getFileSizeInMB(sizeUnit, size)) * 1000);
        downloadTime = downloadTime / getDownloadSpeed(speedUnit, speed);
        return downloadTime / 60;
    }
}
