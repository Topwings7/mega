package com.tj.loop;
/*����� �Ʒ��� ���� for���� �ۼ��Ͻÿ�
 *
 **
 ***
 ****
 *****
 */
public class Ex03for {
	public static void main(String[] args) {
		for(int i=0 ; i<5 ; i++) {
			for(int j=0 ; j<=i ; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
	}
}
