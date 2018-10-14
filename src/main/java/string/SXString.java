package string;

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


        this.curlen = chars.length;
//        this.stringElem[0] = (char) curlen;
        for (int i = 0; i < chars.length; i++) {

            this.stringElem[i] = chars[i];
        }
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
     * @date 2018/10/11 15:18
     * @param [sub, pos]
     * @return int
     * @description 朴素模式匹配算法，位置pos取值从1开始，匹配到返回位置，否则返回0
     */
    public int index_traditional(SXString sub, int pos) {

        int i = pos - 1;//i:标记主串的下标
        int j = 0;  //j：标记子串的下标
        while (i < this.length() && j < sub.length()) {
            if (this.get(i) == sub.get(j)) {              /*两个字母相等则继续*/
                ++i;
                ++j;

            } else {
                i = i - j + 1;                            /*主串不相等就退回至上次匹配的首位的下一个*/
                j = 0;                           /*子串从头开始*/
            }
        }

        if (j >= sub.length()) {
            return i - sub.length() + 1;
        } else {
            return 0;
        }

    }


    /*
     *
     *
     * @author kevin
     * @date 2018/10/14 17:03
     * @param [sub, pos]
     * @return int
     * @description KMP算法
     */
    public int index_KMP(SXString sub, int pos) {
        int[] next = SXString.getNext(sub);
        int i = pos - 1;//i:标记主串的下标
        int j = 0;  //j：标记子串的下标
        while (i < this.length() && j < sub.length()) {
            if (j == -1 || this.get(i) == sub.get(j)) {              /*两个字母相等则继续*/
                ++i;
                ++j;

            } else {
                j = next[j];                        /*子串从头开始*/
            }
        }

        if (j >= sub.length()) {
            return i - sub.length() + 1;
        } else {
            return 0;
        }

    }


    /*
     *
     *
     * @author kevin
     * @date 2018/10/14 17:03
     * @param
     * @return
     * @description KMP改进
     */

    public int index_KMP_Val(SXString sub, int pos) {
        int[] nextVal = SXString.getNextVal(sub);
        int i = pos - 1;//i:标记主串的下标
        int j = 0;  //j：标记子串的下标
        while (i < this.length() && j < sub.length()) {
            if (j == -1 || this.get(i) == sub.get(j)) {              /*两个字母相等则继续*/
                ++i;
                ++j;

            } else {
                j = nextVal[j];                        /*子串从头开始*/
            }
        }

        if (j >= sub.length()) {
            return i - sub.length() + 1;
        } else {
            return 0;
        }

    }

    /*
     *
     *
     * @author kevin
     * @date 2018/10/14 16:54
     * @param [s]
     * @return int[]
     * @description KMP的next数组算法
     */
    public static int[] getNext(SXString s) {
        int i = 0;  /*后缀的单个字符*/
        int j = -1; /*前缀的单个字符*/
        int[] next = new int[s.length()];
        next[0] = -1;

        while (i < next.length - 1) {
            if (j == -1 || s.get(i) == s.get(j)) {/*后缀和前缀相等就向后移动一位，将此时的前缀的索引+1给next*/
                ++i;
                ++j;
                next[i] = j;
            } else {    /*否则，j就回溯到上一次相同的位置*/
                j = next[j];
            }
        }

        return next;

    }

    /*
     *
     *
     * @author kevin
     * @date 2018/10/14 16:54
     * @param [s]
     * @return int[]
     * @description KMPnext数组改进方法
     */
    public static int[] getNextVal(SXString s) {
        int i = 0;  /*后缀的单个字符*/
        int j = -1; /*前缀的单个字符*/
        int[] nextVal = new int[s.length()];
        nextVal[0] = -1;

        while (i < nextVal.length - 1) {
            if (j == -1 || s.get(i) == s.get(j)) {/*后缀和前缀相等就向后移动一位，将此时的前缀的索引+1给next*/
                ++i;
                ++j;
//                next[i] = j;

                if (s.get(i) != s.get(j)) {
                    nextVal[i] = j;                          /*当前字符和前缀字符不同，依旧是把之前为改良算法的next值原封不动的给nextVal*/
                } else {
                    nextVal[i] = nextVal[j];               /*若相等，则用和它相等的前缀j的next（nextVal）值赋值给当前的nextVal*/
                }
            } else {    /*否则，j就回溯到上一次相同的位置*/
                j = nextVal[j];
            }
        }

        return nextVal;

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

    /*
     *
     *
     * @author kevin
     * @date 2018/10/11 15:24
     * @param [i]
     * @return char
     * @description 获取第i的索引的字符
     */
    public char get(int i) {
        if (i >= length() || i < 0) {
            throw new RuntimeException();
        }
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
