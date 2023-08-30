package org.example;

import com.sksamuel.scrimage.ImmutableImage;
import com.sksamuel.scrimage.webp.WebpWriter;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImageProcessor {

    public static byte[] convertBytesToWebp(byte[] imageData) throws IOException {
        ImmutableImage image = ImmutableImage.loader().fromBytes(imageData);
        return image.bytes(WebpWriter.MAX_LOSSLESS_COMPRESSION);
    }

    public static void convertFileToWebp(String fileName) throws IOException {
        File file = new File(fileName);
        ImmutableImage image = ImmutableImage.loader().fromFile(file);
        String webpFileName = fileName.substring(0, fileName.lastIndexOf(".") + 1) + "webp";
        image.output(WebpWriter.DEFAULT, webpFileName);
        // с вариантом
        // image.output(WebpWriter.MAX_LOSSLESS_COMPRESSION, webpFileName);
        // файл потом не читается почему-то.
    }

    public static byte[] scaleBytesToWidth(byte[] imageData, int width) throws IOException {
        ImmutableImage image = ImmutableImage.loader().fromBytes(imageData);
        image.scaleToWidth(width);
        return image.bytes(WebpWriter.MAX_LOSSLESS_COMPRESSION);
    }


    private static Dimension getScaledDimension(Dimension imgSize, Dimension boundary) {

        int original_width = imgSize.width;
        int original_height = imgSize.height;
        int bound_width = boundary.width;
        int bound_height = boundary.height;
        int new_width = original_width;
        int new_height = original_height;

        // first check if we need to scale width
        if (original_width > bound_width) {
            //scale width to fit
            new_width = bound_width;
            //scale height to maintain aspect ratio
            new_height = (new_width * original_height) / original_width;
        }

        // then check if we need to scale even with the new height
        if (new_height > bound_height) {
            //scale height to fit instead
            new_height = bound_height;
            //scale width to maintain aspect ratio
            new_width = (new_height * original_width) / original_height;
        }

        return new Dimension(new_width, new_height);
    }

}
