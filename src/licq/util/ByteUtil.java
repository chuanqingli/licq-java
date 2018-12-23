package licq.util;

public interface ByteUtil{
    long bytes8ToLong(byte[] mybytes);
    byte[] longToBytes8(long i);
    byte[] intToBytes4(int i);
    int bytes4ToInt(byte[] mybytes);
    byte[] shortToBytes2(short i);
    short bytes2ToShort(byte[] mybytes);
    byte[] longToBytes4(long l);
    long bytes4ToLong(byte[] abyte0);
    byte[] base64ToBytes(String s);
    String bytesToBase64(byte[] b);
    byte[] getMd5(byte[] b);
    void arraycopy(byte[] src, int srcPos,byte[] dest, int destPos, int length);
    String ByteArrayToHexString(byte[] b);
    String ByteArrayToString(byte[] b);
    String ByteToHexString(byte b);
    byte[] hexStringToBytes(String str);
    int hexStringToByte(String str);
    void printBytes(byte[] b);
    String doTrimEnd(String s);
    byte[] getText(int idx, String value);
    byte[] stringToBytes(String inStr,String charsetName);
}
