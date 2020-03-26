package com.company;

/*
1808 file splitting
Read three file names from the console: file1, file2, file3.
Divide file1 by the following criteria:
Write the first half of bytes to file2, the second half of bytes to write to file3.
If the number of bytes in file1 is odd, then file2 should contain most.
Close streams.

Requirements:
1. The program should read the file names from the console three times.
2. Use FileInputStream to read from a file; FileOutputStream to write to files
3. The first half of the bytes from the first file must be written to the second file.
4. The second half of the bytes from the first file must be written to the third file.
5. The streams FileInputStream and FileOutputStream must be closed.
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;



public class Solution {
    public static void main(String[] args) throws IOException {
      Scanner scan = new Scanner(System.in);
      String fileName1 = scan.nextLine();
        String fileName2 = scan.nextLine();
        String fileName3 = scan.nextLine();

        FileInputStream f1 = new FileInputStream(fileName1);
        FileOutputStream f2 = new FileOutputStream(fileName2);
        FileOutputStream f3 = new FileOutputStream(fileName3);

        int fileSize = f1.available();
        int part1Size = fileSize % 2 == 0 ? fileSize / 2 : fileSize / 2 + 1;

        while (f1.available() > 0) {
            byte[] buf1 = new byte [part1Size];
            byte[] buf2 = new byte [fileSize - part1Size];

            f1.read(buf1);
            f1.read(buf2);
            f2.write(buf1);
            f3.write(buf2);
        }
        f1.close();
        f2.close();
        f3.close();
    }
}
