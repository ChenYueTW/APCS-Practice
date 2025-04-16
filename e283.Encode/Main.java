import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        byte[] buffer = new byte[16];
        while (true) {
            int len = readLine(in, buffer);
            if (len == -1) break;

            int times = parseInt(buffer, len);
            for (int i = 0; i < times; i++) {
                len = readLine(in, buffer);
                out.write(toChar(buffer));
            }
            out.newLine();
        }

        out.flush();
    }

    private static int readLine(DataInputStream in, byte[] buf) throws IOException {
        int count = 0, b;
        while ((b = in.read()) != -1 && b != '\n') {
            if (b != '\r') buf[count++] = (byte) b;
        }
        return (b == -1 && count == 0) ? -1 : count;
    }

    private static int parseInt(byte[] buf, int len) {
        int num = 0;
        for (int i = 0; i < len; i++) {
            if (buf[i] >= '0' && buf[i] <= '9') {
                num = num * 10 + (buf[i] - '0');
            }
        }
        return num;
    }

    private static char toChar(byte[] buf) {
        int[] val = new int[4];
        int idx = 0;
        for (int i = 0; i < 7; i += 2) {
            val[idx++] = buf[i] - '0';
        }

        int code = (val[0] << 3) | (val[1] << 2) | (val[2] << 1) | val[3];

        switch (code) {
            case 0b0101: return 'A'; // 0 1 0 1
            case 0b0111: return 'B'; // 0 1 1 1
            case 0b0010: return 'C'; // 0 0 1 0
            case 0b1101: return 'D'; // 1 1 0 1
            case 0b1000: return 'E'; // 1 0 0 0
            default:     return 'F';
        }
    }
}
