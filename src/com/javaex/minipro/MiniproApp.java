package com.javaex.minipro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MiniproApp {

	public static void main(String[] args) throws IOException{
		
		List<Person> pList = new ArrayList<Person>();
		
		Scanner sc = new Scanner(System.in);
		Reader fr = new FileReader("C:\\javastudy\\workspace\\미니프로젝트\\PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);
		
		System.out.println("***************************************");
		System.out.print("*"+"\t");
		System.out.print("   "+"전화번호 관리 프로그램"+"           ");
		System.out.println("*");
		System.out.println("***************************************");
		
		while(true) {
			String line = br.readLine();
			
			if(line==null) {
				break;
			}
			
			String[] pArray = line.split(",");
			
			String name = pArray[0];
			String hp = pArray[1];
			String company = pArray[2];
			
			Person p01 = new Person(name, hp, company);
			pList.add(p01);
			
			while (true) {
				System.out.println("1. 리스트  2. 등록  3. 삭제  4. 검색  5. 종료");
				System.out.println("---------------------------------------");
				System.out.print("메뉴 선택 > ");
				int num = sc.nextInt();
				
				if(num==5) {
					System.out.println("감사합니다.");
					break;
				} 
				
				switch (num) {
				
				case 1 : 
					System.out.println("<1. 리스트>");
					for (int i=0; i<pList.size(); i++) {
						System.out.print(i+1+".  ");
						pList.get(i).showInfo();
					}
					break;
					
				case 2: 
					System.out.println("<2. 등록>");
					Writer fw = new FileWriter("C:\\javastudy\\workspace\\미니프로젝트\\PhoneDB.txt");
					BufferedWriter bw = new BufferedWriter(fw);
					
					System.out.print(">이름 ");
					String newname = sc.nextLine();
					System.out.println(">휴대전화 ");
					String newhp = sc.nextLine();
					System.out.println(">회사전화 ");
					String newcompany = sc.nextLine();
					
					
					
					bw.close();
					break;
					
				case 3:
					System.out.println("<3. 삭제>");
					int delete = sc.nextInt();
					
					
				}
				
			}
		}
		
		
		br.close();
		sc.close();

	}

}
