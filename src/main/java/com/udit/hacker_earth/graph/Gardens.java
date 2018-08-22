package com.udit.hacker_earth.graph;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.BitSet;
import java.util.InputMismatchException;

/**
 * @author Udit Sharma.
 * @since 06 Apr, 2018 4:05 PM
 */
public class Gardens {
    private static InputReader in;
    private static PrintWriter out;

    static class InputReader {

        private InputStream stream;
        private byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int snext() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nextLong() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int[] nextIntArray(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        public String readString() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }

    public static void main(String[] args) throws Throwable {

        InputReader sc = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = sc.nextInt();
        BitSet[] set = new BitSet[n];
        for (int i = 0; i < n; i++)
            set[i] = new BitSet();
        int val = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                val = sc.nextInt();
                if (val == 1) {
                    set[i].set(j);
                }
            }
        }
        int count = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                BitSet neighbours1 = (BitSet) set[i].clone();
                BitSet neighours2 = set[j];
                neighbours1.and(neighours2);
                count = neighbours1.cardinality();
                ans += count * (count - 1) / 2;
            }
        }
        out.println(ans / 2);
        out.close();

    }

}
