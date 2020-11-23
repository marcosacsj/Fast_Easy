package utilitarios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Arquivo
{	
	public static File CriaIni(String as_nomeArquivo)
	{		
		File arquivo;
		arquivo = new File(as_nomeArquivo);
		if (!arquivo.exists())
		{
			try 
			{
				arquivo.createNewFile();
			} 
			catch (IOException e) 
			{					
				
				
			}
		}
		return arquivo;
	}	
    
    public static String LeIni(File as_arquivo, String as_secao, String as_chave)
    {
    	FileReader reader;
		BufferedReader leitor;		
		String ls_linha = null;
		String ls_resultado = "";		
		String ls_linhatratada = "";
		String ls_sinal = "=";				
		char lc_caracterinicial = '[';
		char lc_caracterfinal = ']';
		
		try 
		{						
			reader = new FileReader(as_arquivo);						
			leitor = new BufferedReader(reader);						
			as_secao = (lc_caracterinicial + as_secao + lc_caracterfinal);			
		
		    ls_linha =  leitor.readLine();		    
			while(ls_linha!= null)			
			{				
				if (ls_linha.equals(as_secao))				
				{			
					ls_linha =  leitor.readLine();					
					
					while (ls_linha != null)
					{											
						if(ls_linha.lastIndexOf(lc_caracterinicial) == -1)
						{						
							if(ls_linha.lastIndexOf(ls_sinal)>0)
							{							
								ls_linhatratada = ls_linha.substring(0, ls_linha.lastIndexOf(ls_sinal));						
								
								if(as_chave.equals(ls_linhatratada))
								{	
									ls_resultado = TrataResultadoChave(ls_linha, as_chave);									
									return ls_resultado;
								}								
								
							}
							ls_linha = leitor.readLine();					
																				
						}else return "";						
					}					
				}
				ls_linha =  leitor.readLine();				
			}
			leitor.close();
			reader.close();
			
		}
		catch (FileNotFoundException e) 
		{	
			InOut.MsgDeErro("TECLADO"  , "Erro ao executar a fun��o LeIni "+ e.toString());
		}
		catch (IOException e) 
		{			
			InOut.MsgDeErro("TECLADO"  , "Erro ao executar a fun��o LeIni "+ e.toString());
		}
		return null;
	}
    
    
       
    public static String TrataResultadoChave(String as_linha, String as_chave) 
	{
		String ls_linha = "";
		String ls_resultado;		
		String ls_sinal = "=";
		int li_sinal = 0;	
		
		//ls_linha = as_linha.substring(0, as_linha.lastIndexOf(ls_sinal));
		ls_linha = as_linha.substring(0, as_linha.indexOf(ls_sinal));		
		//li_sinal = as_linha.lastIndexOf(ls_sinal);
		li_sinal = as_linha.indexOf(ls_sinal);
		
		if(as_chave.equals(ls_linha))
		{			
			ls_resultado = as_linha.substring(li_sinal+1);			
			return ls_resultado;
		}		
		return null;
		
	}    	
}