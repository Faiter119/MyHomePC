package data;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/**
 * Packer that uses the java.util.zip classes
 */
public class ZipPacker {

    private static void compressToStream(byte[] input, ByteArrayOutputStream bos){
        // Create the compressor with highest level of compression
        Deflater compressor = new Deflater();
        compressor.setLevel(Deflater.BEST_COMPRESSION);

        // Give the compressor the data to compress
        compressor.setInput(input);
        compressor.finish();

        // Write the compressed data to the stream
        byte[] buf = new byte[1024];
        while (!compressor.finished()) {
            int count = compressor.deflate(buf);
            bos.write(buf, 0, count);
        }
    }

    private static byte[] unpack(byte[] compressedData, ByteArrayOutputStream bos)
    {
        // Create the decompressor and give it the data to compress
        Inflater decompressor = new Inflater();
        decompressor.setInput(compressedData);

        // Create an expandable byte array to hold the decompressed data

            // Decompress the data
            byte[] buf = new byte[1024];
            while (!decompressor.finished()) {
                int count = 0;
                try {
                    count = decompressor.inflate(buf);
                }
                catch (DataFormatException e) {
                    e.printStackTrace();
                }
                bos.write(buf, 0, count);
            }
        return bos.toByteArray();
    }

    public static byte[] pack(byte[] bytes) {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        compressToStream(bytes, byteArrayOutputStream);

        return byteArrayOutputStream.toByteArray();

    }

    public static byte[] unpack(byte[] packed){

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        return unpack(packed, bos);

    }


    public static void main(String[] args) throws IOException, DataFormatException {

        byte[] bytes = Files.readAllBytes(Paths.get("F:/IntelliJ/IntelliJ IDEA 2016.1/IntelliJ_Workspace/Semester3/Øving12/files/opg12.tex"));
        System.out.println(bytes.length);


        byte[] packed = pack(bytes);

        byte[] unpacked = unpack(packed);

        System.out.println(packed.length +" - "+bytes.length);

        System.out.println(Arrays.equals(bytes, unpacked));

    }

}
