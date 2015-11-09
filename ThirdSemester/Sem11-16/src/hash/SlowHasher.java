package hash;

/**
 * Created by Birthright on 18.10.2015.
 */
public class SlowHasher
{
    private final static int BITS_IN_BYTE = 8;

    private static final int[] s_primeIndices = new int[] { 7, 11, 17, 23, 31, 41, 47, 53, 61 };


    public byte[] calculateSlowHash(IDigest digest, String password, byte[] salt)
    {
        final int roundSaltSize = digest.getSize() / BITS_IN_BYTE;
        byte[] bPasswd = password.getBytes();
        byte[] toHash = new byte[bPasswd.length + salt.length];

        System.arraycopy(salt, 0, toHash, 0, salt.length);
        System.arraycopy(bPasswd, 0, toHash, salt.length, bPasswd.length);

        byte[] res = digest.process(toHash);
        byte[] temp = new byte[res.length + roundSaltSize];

        for (int i = 0; i < 0x50000; i++)
        {
            System.arraycopy(res, 0, temp, 0, res.length);

            for (int j = 0; j < roundSaltSize; j++)
            {
                int btmp = res[s_primeIndices[j]] & 0xFF;
                for (int k = 1; k < BITS_IN_BYTE; k++)
                {
                    btmp = ror((btmp + (res[ror(btmp, k) % res.length] & 0xFF)) % 256, BITS_IN_BYTE-k);
                }
                temp[res.length + j] = (byte)btmp;
            }
            res = digest.process(temp);
        }
        return res;
    }

    public static int ror(int value, int n)
    {
        return ((value >> (n % BITS_IN_BYTE)) | ((value << (8 - (n % BITS_IN_BYTE))) & 0xFF));
    }
}