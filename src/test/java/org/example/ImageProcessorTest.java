package org.example;

import com.sksamuel.scrimage.ImmutableImage;
import com.sksamuel.scrimage.nio.JpegWriter;
import com.sksamuel.scrimage.webp.WebpWriter;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ImageProcessorTest {

    @Test
    void convertFileToWebp() {
    }

    @Test
    void generateWebpFiles() throws IOException {
        generateWebpImageBytes(1000, 2000);
//        generateWebpImageBytes(1000, 2000);
//        generateWebpImageBytes(1000, 2000);
//        generateWebpImageBytes(1000, 2000);
//        generateWebpImageBytes(1000, 2000);
    }

    @Test
    void generateJpgFiles() throws IOException {
        generateJpgImageBytes(1000, 2000);
//        generateJpgImageBytes(1000, 2000);
//        generateJpgImageBytes(1000, 2000);
//        generateJpgImageBytes(1000, 2000);
//        generateJpgImageBytes(1000, 2000);
//        generateJpgImageBytes(1000, 2000);

    }

    @Test
    void resizeWebp() throws IOException {
//        byte[] webpImageBytes = generateWebpImageBytes(1000, 1000);
        ImmutableImage image = ImmutableImage.create(1000, 2000);
        image.resize(0.5);
    }

    private byte[] generateJpgImageBytes(int width, int height) throws IOException {
        ImmutableImage image = ImmutableImage.create(width, height);
        return image.bytes(JpegWriter.Default);
    }

    private byte[] generateWebpImageBytes(int width, int height) throws IOException {
        ImmutableImage image = ImmutableImage.create(width, height);
        return image.bytes(WebpWriter.DEFAULT);
    }
}