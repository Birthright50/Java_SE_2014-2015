package ru.kpfu.itis.peter_kozlovsky.hash;

/**
 * Created by Birthright on 18.10.2015.
 */
public interface IDigest
{
    byte[] process(byte[] data);

    int getSize();
}
