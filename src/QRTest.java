import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;

public class QRTest {

    public static void main(String[] args) {

        try {
            String text = "Student ID: 12345";

            String filePath = "student_qr.png";

            int width = 300;
            int height = 300;

            BitMatrix matrix = new MultiFormatWriter().encode(
                    text,
                    BarcodeFormat.QR_CODE,
                    width,
                    height
            );

            Path path = FileSystems.getDefault().getPath(filePath);

            MatrixToImageWriter.writeToPath(
                    matrix,
                    "PNG",
                    path
            );

            System.out.println("QR Code Generated Successfully!");
            System.out.println("Location: " + new File(filePath).getAbsolutePath());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}