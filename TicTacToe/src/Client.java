import java.io.IOException;
import java.io.InputStream;

public class Client {

    private byte[] getMessage(InputStream inputStream) throws IOException
    {
        byte[] len = new byte[4];
        if (!tryReadUntilBufferFull(inputStream, len))
            throw new IOException();
        byte[] message = new byte[len[0] << 24 | len[1] << 16 | len[2] << 8 | len[3]];
        if (!tryReadUntilBufferFull(inputStream, message))
            throw new IOException();

        return message;
    }

    private boolean tryReadUntilBufferFull(InputStream inputStream, byte[] buffer)
    {
        if (buffer.length == 0)
            return false;
        try
        {
            int read = 0;
            while (read < buffer.length)
            {
                int readBytes = inputStream.read(buffer, read, buffer.length - read);
                if (readBytes == -1)
                    return false;
                read += readBytes;
            }
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }
}
