package string;

import java.util.Arrays;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: 采用顺序存储方式的串(为每个串变量分配一个固定长度的存储区)，这里用定长数组模拟
 * @date:2018/9/14
 */
public class SXString implements IString {

    private int curlen;
    private char[] stringElem;

    public SXString() {
        this(100);
    }

    public SXString(int maxSize) {
        curlen = 0;
        stringElem = new char[maxSize];
    }

    public SXString(char[] chars) {

        this(100);
        if (chars.length > 100) {
            throw new RuntimeException();
        }
        for (int i = 0; i < chars.length; i++) {
            this.stringElem[i] = chars[i];
        }

        this.curlen = chars.length;
    }

    @Override
    public IString strCopy() {
        return this;
    }

    @Override
    public void clearStr() {
        curlen = 0;
    }

    @Override
    public boolean isEmpty() {

        return curlen == 0 ? true : false;
    }

    @Override
    public int length() {
        return curlen;
    }

    /*
     *
     *
     * @author kevin
     * @date 2018/10/8 19:28
     * @param [t]
     * @return int
     * @description 如果相等（字符串的内容）返回0.否则返回-1
     */
    @Override
    public int compare(IString t) {

        if (this.length() != t.length()) {
            return -1;
        }
        for (int i = 0; i < this.length(); i++) {
            if (this.get(i) != t.get(i)) {
                return -1;
            }
        }

        return 0;
    }

    @Override
    public IString concat(IString s) {
        IString newIString = new SXString();
        for (int i = 0; i < s.length() + this.length(); i++) {
            if (((SXString) newIString).curlen < this.length()) {
                ((SXString) newIString).stringElem[i] = this.stringElem[i];
            } else {
                ((SXString) newIString).stringElem[i] = ((SXString) s).stringElem[i - this.length()];
            }
            ((SXString) newIString).curlen++;
        }
        return newIString;
    }

    @Override
    public IString subString(int pos, int len) {
        if (pos + len > this.length()) {
            throw new RuntimeException();
        }
        IString string = new SXString();
        for (int i = 0; i < len; i++) {
            ((SXString) string).stringElem[i] = this.stringElem[pos + i];
        }

        ((SXString) string).curlen = len;
        return string;
    }

    /*
     *
     *
     * @author kevin
     * @date 2018/10/8 19:39
     * @param [subStr, pos]
     * @return int
     * @description 返回从pos位置第一次出现subStr的索引,若无返回-1
     */
    @Override
    public int index(IString subStr, int pos) {
        int subLength = subStr.length();
        int length = this.length();
        int i = pos;
        while (i < length - subLength + 1) {
            IString iString = this.subString(i, subLength);
            if (iString.compare(subStr) != 0) {
                i++;
            } else {
                return i;
            }
        }
        return -1;
    }

    /*
     *
     *
     * @author kevin
     * @date 2018/10/8 20:03
     * @param [s1, pos]
     * @return string.IString
     * @description 在pos索引后插入串s1
     */
    @Override
    public IString strInsert(IString s1, int pos) {
        if (pos >= this.length() || pos < 0) {
            throw new RuntimeException("非法插入位置");
        }
        if (this.length() + s1.length() > 100) {
            throw new RuntimeException("存储不足，无法插入");
        }
        for (int i = 0; i < s1.length(); i++) {
            //先从后面往前把该往后挪的数据向后挪动一位，这样写效率很低，每次插入一个字符都要挪动很多原有的字符
            for (int j = this.length() - 1; j > pos; j--) {
                this.stringElem[j + 1] = this.stringElem[j];

            }
            //插入字符
            this.stringElem[pos + i + 1] = s1.get(i);
            this.curlen++;

        }


        return this;
    }



    /*
     *
     *
     * @author kevin
     * @date 2018/10/8 20:03
     * @param [s1, pos]
     * @return string.IString
     * @description 插入的改进版，先一起把该挪动的字符一次进行向后移动，然后在一次插入字符
     */

    public IString strInsert2(IString s1, int pos) {
        if (pos >= this.length() || pos < 0) {
            throw new RuntimeException("非法插入位置");
        }
        if (this.length() + s1.length() > 100) {
            throw new RuntimeException("存储不足，无法插入");
        }

        for (int i = this.length() - 1; i > pos; i--) {
            this.stringElem[i + s1.length()] = this.stringElem[i];

        }

        for (int j = 0; j < s1.length(); j++) {
            this.stringElem[pos + j + 1] = s1.get(j);
            this.curlen++;
        }


        return this;
    }

    /*
     *
     *
     * @author kevin
     * @date 2018/10/8 20:10
     * @param [pos, len]
     * @return string.IString
     * @description 从pos位置删除len个字符
     */
    @Override
    public IString strDelete(int pos, int len) {
        if (len + pos > this.length()) {
            throw new RuntimeException("非法删除");
        }

        for (int i = pos + len; i < this.length(); i++) {
            this.stringElem[i - len] = this.stringElem[i];
        }
        this.curlen -= len;
        return this;
    }

    public char get(int i) {
        return stringElem[i];
    }

    @Override
    public String toString() {

        String s = "";

        for (int i = 0; i < this.curlen; i++) {
            s = s.concat(String.valueOf(this.stringElem[i]));
        }

        return s;
    }


}
