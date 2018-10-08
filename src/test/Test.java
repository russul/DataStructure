package test;

import string.IString;
import string.SXString;

public class Test {
	public static void main(String[] args) {
		IString iString = new SXString();
		char[] chars = {'d','c','e','f','g'};
		IString iString1 = new SXString(chars);
		char[] chars1 ={'c','c'};
		IString iString2 = new SXString(chars1);
		System.out.println(iString.length());
		System.out.println(iString1.length());
		IString iString3 = iString1.subString(0,3);

		System.out.println((SXString)iString3);

		System.out.println(iString1.concat(iString2));

		System.out.println(iString1.index(iString2,0));


		System.out.println(iString1.strInsert(iString2,2));
		System.out.println(((SXString)iString1).strInsert2(iString2,2));
		System.out.println(iString1.strDelete(3,2));

	}
	

}
