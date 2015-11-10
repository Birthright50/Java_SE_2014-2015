package ru.kpfu.itis.peter_kozlovsky.hash;

import org.bouncycastle.crypto.digests.SHA256Digest;

/**
 * Created by Birthright on 18.10.2015.
 */
public class SHA256 implements IDigest {
    private SHA256Digest m_SHA256 = new SHA256Digest();

    @Override
    public byte[] process(byte[] data)
    {
        m_SHA256.reset();
        m_SHA256.update(data, 0, data.length);
        byte[] result = new byte[m_SHA256.getDigestSize()];
        m_SHA256.doFinal(result, 0);
        return result;
    }

    @Override
    public int getSize()
    {
        return m_SHA256.getDigestSize();
    }
}
