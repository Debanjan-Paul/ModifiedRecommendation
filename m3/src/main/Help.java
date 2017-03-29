package main;

import java.io.*;

public class Help {
public static void main(String args[])throws IOException{
String str="E:\\work\\predictionArray.txt";  
	
	BufferedReader in= new BufferedReader(new FileReader(str));
		String sCurrentLine;
		int len=0;
		while((sCurrentLine = in.readLine()) != null){
			len++;
		}
		int arr[]=new int[len];
		in= new BufferedReader(new FileReader(str));
		int ptr=0;
		while((sCurrentLine = in.readLine()) != null){
			int score=Integer.parseInt(sCurrentLine);
			arr[ptr++]=score;
		}
		System.out.println(ptr);
		str="E:\\work\\xyz.txt"; 
		in= new BufferedReader(new FileReader(str));
		sCurrentLine = in.readLine();
		String temp[]=sCurrentLine.split(" ");
		int mat[][]=new int[ptr][temp.length+2];
		int i=0;
		in= new BufferedReader(new FileReader(str));
		while((sCurrentLine = in.readLine()) != null){
			int j=0;
			 temp=sCurrentLine.split(" ");
			 for( j=0;j<temp.length;j++)
			mat[i][j]=Integer.parseInt(temp[j]);
			 mat[i][j++]=arr[i];
			 mat[i++][j]=i;
			
		}
		for(int x=0;x<mat.length;x++){
			for(int y=0;y<mat[0].length;y++)
				System.out.print(mat[x][y]+" ");
		System.out.println();
		}
		
		for (int x1 = 0; x1 < mat.length - 1; x1++) {
			for (int x2 = x1 + 1; x2 < mat.length; x2++) {
				if (mat[x1][mat[0].length - 2] < mat[x2][mat[0].length - 2]) {
					// swap all elem of row
					for (int y = 0; y < mat[0].length; y++) {
						int temp2 = mat[x1][y];
						mat[x1][y] = mat[x2][y];
						mat[x2][y] = temp2;
					}
				}
			}
		}
		
		System.out.println("Sorted:");
		for(int x=0;x<mat.length;x++){
			for(int y=0;y<mat[0].length;y++)
				System.out.print(mat[x][y]+" ");
		System.out.println();
		}
		
		
		File file = new File("E:\\work\\prediction1.txt");
		// if file doesnt exists, then create it
		if (!file.exists()) {
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		for( i=0;i<mat.length;i++){
			   for(int j=0;j<mat[0].length-2;j++)
				   bw.write(mat[i][j]+" ");
			   bw.write("\r\n");
		}	   
		
		
		
			   bw.close();
			   
			   
}
}
