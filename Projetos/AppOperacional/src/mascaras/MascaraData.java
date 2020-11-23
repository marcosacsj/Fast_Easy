package mascaras;

import java.awt.Toolkit;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;





public class MascaraData extends PlainDocument 
{			
	//private static final long serialVersionUID = -402369279082596511L;
	public static final int NUMERO_DIGITOS_MAXIMO = 2;
	private int li_Dia = 0; 
	private int li_Mes = 0;
	private int li_Ano = 0;
	private StringBuffer s = null;
		
	
	public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException
	{
		///Toolkit.getDefaultToolkit().beep();
				
		//if (str.equals(null))
		//{	
		//	return;
		//}
		
		String texto = getText(0, getLength());     
		for (int i = 0; i < str.length(); i++) 
		{
			char c = str.charAt(i);     
		    if (!Character.isDigit(c)) 
		    {	 
		        return;     
		    }     
		 }
		 if(texto.length() < this.NUMERO_DIGITOS_MAXIMO)
		 {
			 super.remove(0, getLength());	     
		      
			 s = new StringBuffer(texto + str);
		     			 
			 if (s.length() < 4)
			 {
		    	 if (s.length() == 2) 
		    	 {	    		 
		    		 li_Dia = Integer.valueOf(s.toString());
		    		 if (li_Dia > 31)
		    		 {
                                    //  JOptionPane.showMessageDialog(null, "Conectou");
                                    // InOut.MsgDeAviso(Parametros.getCdVersao(), "Dia Inv�lido - Permitido de 01 a 31 - Dia Digitado :"+li_Dia);
		    			 return;
		    		 }
		    		 s.insert(s.length(),"/");
		    	 }	    	 
		    	 else if (s.length() == 3) 
		    	 {   
			    	 //Insere somente a barra se o usuario apagar para o dia/mes
		    		 if (str != "/")
		    		 {
		    			 s.insert(s.length()-1,"/");
		    		 }
		    	 }
			 }
			 
			 			 
		     if(s.length() < 7) 
		     {
		    	 if (s.length() == 5) 
		    	 { 
		    		 s.insert(s.length(),"/");     
		    	 }		    	 
		    	 if (s.length() == 6) 
		    	 { 
		    		 if (!s.toString().substring(5,6).equals("/"))
		    		 {		    			 
			    		 s.insert(s.length()-1,"/");			    		 
		    		 }
		    		 
		    		 li_Mes = Integer.valueOf(s.toString().substring(3, 5));		    		 
		    		 if (li_Mes > 12)
		    		 {
//		    			 InOut.MsgDeAviso(Parametros.getCdVersao(), "M�s Inv�lido - Permitido de 01 a 12 - M�s Digitado :"+li_Mes);		    			 
		    			 return;
		    		 }
		    		 if(li_Dia > 29 )
		    		 {
		    			 if (li_Mes == 2)
		    			 {		  
		    				 super.insertString(0, s.toString().substring(0, 2)+"/", attr);		    				 
		    				 return;
		    			 }
		    		 }
		    		 if(li_Dia > 30 )
		    		 {
		    			 if (li_Mes == 2 || li_Mes == 4 || li_Mes == 6 || li_Mes == 9 || li_Mes == 11 )
		    			 {		  
		    				 super.insertString(0, s.toString().substring(0, 2)+"/", attr);		    				 
		    				 return;
		    			 }
		    		 }
		    	 }		    	 
		     }	     
		     
		     if (s.length() ==10) 
	    	 { 
	    		  li_Ano = Integer.valueOf(s.toString().substring(6, 10));
	    		  if(!AnoBissexto(li_Ano))
	    		  {
	    			  if (li_Mes == 2)
	    			  {	    				  
	    				  s.replace(0, 1, "2");
	    				  s.replace(1, 2, "8");
	    			  }	    			  
	    		  }
	    		  //So teve um forma de fazer funcionar, foi pegando o get do campo
                  //da janela princip�l-provavelmente onde tiver data fou fazer classes de mascara de data para cada tela
	    		  //pra pode pegar cada controle ou criar uma rotina de quem chamou a mascara
	    		  //Cicero Lopes - 04/07/2011	    		  
//	    		  JD_DadosMFDMFiscal.PosicionaCampo();	    		  
	    	 }		    		        
		     
		     super.insertString(0, s.toString(), attr);		    
		    // AppPdv.EscreveCaracterTeclado(2, 1, s.toString());
		     
		  }		
	}
	
	public void remove(int offset, int length) throws BadLocationException
	{	
		//super.remove(getLength()-length, 1); //Apaga campo a campo		
		super.remove(offset, length);
	    super.remove(0, getLength()); 
//	    AppPdv.LimpaLinhaTeclado(2);
	}
	
	public static boolean AnoBissexto(int ai_Ano) 
	{			
        if ( ( ai_Ano % 4 == 0 && ai_Ano % 100 != 0 ) || ( ai_Ano % 400 == 0 ) )
        {	        	
            return true;   
        }   
        else
        {   
            return false;   
        }   
	}

}
