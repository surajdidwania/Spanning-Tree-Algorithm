import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Input {
	Scanner sc;
	public Input()
	{
		FileInputStream inputstream = null;
		BufferedReader br = null;
		try{
		inputstream = new FileInputStream("/tinyEWG.txt");
		br = new BufferedReader(new InputStreamReader(inputstream));
		StringBuilder sb =  new StringBuilder();
		String line;
		while((line= br.readLine())!= null)
		{
			sb.append(line);
		}
		}catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputstream != null) {
				try {
					inputstream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	    
	}

	public int readInt() {
		// TODO Auto-generated method stub
		return sc.nextInt();
	}

	public double readDouble() {
		// TODO Auto-generated method stub
		 return sc.nextDouble();
	}


	}

