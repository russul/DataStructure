package string;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: string
 * @date:2018/9/14
 */
public interface IString {
    IString strCopy();

    void clearStr();

    boolean isEmpty();

    int length();

    int compare(IString t);

    IString concat(IString s);

    IString subString(int pos, int len);

    int index(IString subStr,int pos);

    IString strInsert(IString s1, int pos);

    IString strDelete(int pos, int len);

    char get(int i);
}
